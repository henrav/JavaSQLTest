package org.example.MainCode.SQLIntepreter;

import java.util.*;

    public enum SqlKeyword {

        SELECT, INSERT, UPDATE, DELETE, REPLACE, WITH, VALUES, CREATE, ALTER, DROP, TRUNCATE, RENAME, USE, SHOW, DESCRIBE, EXPLAIN, SET, START, BEGIN, COMMIT,
        ROLLBACK, SAVEPOINT, RELEASE, LOCK, UNLOCK, GRANT, REVOKE, CALL, PREPARE, EXECUTE;
        private static final Map<String, SqlKeyword> LOOKUP;
        static {
            Map<String, SqlKeyword> m = new HashMap<>();
            for (SqlKeyword k : values()) m.put(k.name(), k);
            LOOKUP = Collections.unmodifiableMap(m);
        }

        public static boolean isKeyword(String text) {
            return text != null && LOOKUP.containsKey(text.toUpperCase(Locale.ROOT));
        }
    }

