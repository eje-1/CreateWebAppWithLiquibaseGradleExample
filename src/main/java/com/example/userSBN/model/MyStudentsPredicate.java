package com.example.userSBN.model;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.core.types.dsl.StringPath;

/**
 * Jetzt erstellen wir ein benutzerdefiniertes Predicate basierend auf einigen willkürlichen Einschränkungen.
 * <p>
 * Wir verwenden hier PathBuilder anstelle der automatisch generierten Q-Typen, da für eine abstraktere Verwendung Pfade dynamisch erstellt werden müssen:
 */
public class MyStudentsPredicate {

    private SearchCriteria criteria;

    public MyStudentsPredicate(final SearchCriteria criteria) {
        this.criteria = criteria;
    }

    public BooleanExpression getPredicate() {
        PathBuilder<User> entityPath = new PathBuilder<>(User.class, "users");

        if (isNumeric(criteria.getValue().toString())) {
           final NumberPath<Integer> path = entityPath.getNumber(criteria.getKey(), Integer.class);
            int value = Integer.parseInt(criteria.getValue().toString());
            switch (criteria.getOperation()) {
                case ":":
                    return path.eq(value);
                case ">":
                    return path.goe(value);
                case "<":
                    return path.loe(value);
            }
        } else {
            StringPath path = entityPath.getString(criteria.getKey());
            if (criteria.getOperation().equalsIgnoreCase(":")) {
                return path.containsIgnoreCase(criteria.getValue().toString());
            }
        }
        return null;
    }

    public SearchCriteria getCriteria() {
        return criteria;
    }

    public void setCriteria(final SearchCriteria criteria) {
        this.criteria = criteria;
    }

    public static boolean isNumeric(final String str) {
        try {
            Integer.parseInt(str);
        } catch (final NumberFormatException e) {
            return false;
        }
        return true;
    }

}
