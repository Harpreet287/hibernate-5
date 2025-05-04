/**
 * Custom implementation of Hibernate's PhysicalNamingStrategy interface for Hibernate 6.
 * This class provides rules for converting JPA entity/field names to database table/column names.
 * It transforms camelCase entity names to UPPER_CASE_WITH_UNDERSCORES format for database tables and columns.
 */
package com.devglan;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

import org.apache.commons.lang3.StringUtils;

public class CustomPhysicalNamingStrategy implements PhysicalNamingStrategy {

    /**
     * Converts the logical catalog name to its physical equivalent.
     */
    @Override
    public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return name;
    }

    /**
     * Converts the logical schema name to its physical equivalent.
     */
    @Override
    public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return name;
    }

    /**
     * Converts the logical table name to its physical equivalent.
     * Applies the transformation rules to convert camelCase to UPPER_CASE_WITH_UNDERSCORES.
     */
    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        if (name == null) {
            return null;
        }
        final List<String> parts = splitAndReplace(name.getText());
        return jdbcEnvironment.getIdentifierHelper().toIdentifier(
                join(parts),
                name.isQuoted()
        );
    }

    /**
     * Converts the logical sequence name to its physical equivalent.
     */
    @Override
    public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return name;
    }

    /**
     * Converts the logical column name to its physical equivalent.
     * Applies the transformation rules to convert camelCase to UPPER_CASE_WITH_UNDERSCORES.
     */
    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        if (name == null) {
            return null;
        }
        final List<String> parts = splitAndReplace(name.getText());
        return jdbcEnvironment.getIdentifierHelper().toIdentifier(
                join(parts),
                name.isQuoted()
        );
    }

    /**
     * Splits a camelCase string into its constituent words and converts each word to uppercase.
     */
    private LinkedList<String> splitAndReplace(String name) {
        LinkedList<String> result = new LinkedList<>();
        for (String part : StringUtils.splitByCharacterTypeCamelCase(name)) {
            if (part == null || part.trim().isEmpty()) {
                continue;
            }
            result.add(part.toUpperCase(Locale.ROOT));
        }
        return result;
    }

    /**
     * Joins a list of strings with underscore separators.
     */
    private String join(List<String> parts) {
        boolean firstPass = true;
        String separator = "";
        StringBuilder joined = new StringBuilder();
        for (String part : parts) {
            joined.append(separator).append(part);
            if (firstPass) {
                firstPass = false;
                separator = "_";
            }
        }
        return joined.toString();
    }
}