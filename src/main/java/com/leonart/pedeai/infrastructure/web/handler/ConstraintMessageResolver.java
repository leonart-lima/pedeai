package com.leonart.pedeai.infrastructure.web.handler;

import org.hibernate.exception.ConstraintViolationException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

final class ConstraintMessageResolver {

    private static final Map<String, String> CONSTRAINT_MESSAGES = new HashMap<>();

    static {
        CONSTRAINT_MESSAGES.put("uk_usuario_uuid", "Usuário com UUID já cadastrado.");
        CONSTRAINT_MESSAGES.put("usuario_uuid_key", "Usuário com UUID já cadastrado.");
    }

    private ConstraintMessageResolver() {}

    static String resolve(Throwable ex) {
        Throwable cause = ex;
        while (cause != null) {
            if (cause instanceof ConstraintViolationException h) {
                String name = h.getConstraintName();
                String byName = messageByConstraint(name);
                if (byName != null) return byName;
            }
            if (cause instanceof SQLIntegrityConstraintViolationException sql) {
                String byName = messageByConstraint(sql.getMessage());
                if (byName != null) return byName;
            }
            if (cause instanceof SQLException sql) {
                if ("23505".equals(sql.getSQLState())) {
                    String byName = messageByConstraint(extractConstraintFromDetail(sql.getMessage()));
                    if (byName != null) return byName;
                }
            }
            cause = cause.getCause();
        }
        return "Registro já existente para os dados informados.";
    }

    private static String messageByConstraint(String constraintName) {
        if (constraintName == null) return null;
        String key = constraintName.toLowerCase(Locale.ROOT);
        return CONSTRAINT_MESSAGES.getOrDefault(key, null);
    }

    private static String extractConstraintFromDetail(String msg) {
        if (msg == null) return null;
        int i = msg.indexOf("constraint");
        if (i >= 0) {
            int start = msg.indexOf('"', i);
            int end = msg.indexOf('"', start + 1);
            if (start >= 0 && end > start) {
                return msg.substring(start + 1, end);
            }
        }
        return null;
    }
}