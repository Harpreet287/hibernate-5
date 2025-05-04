/**
 * Custom implementation of Hibernate's PhysicalNamingStrategy interface.
 * This class provides rules for converting JPA entity/field names to database table/column names.
 * It transforms camelCase entity names to UPPER_CASE_WITH_UNDERSCORES format for database tables and columns.
 * For example: "firstName" entity field would be converted to "FIRST_NAME" column in database.
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
     * This implementation returns the name unchanged.
     * 
     * @param name The logical name
     * @param jdbcEnvironment The JDBC environment in which the conversion occurs
     * @return The physical name
     */
    @Override
    public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return name;
    }

    /**
     * Converts the logical schema name to its physical equivalent.
     * This implementation returns the name unchanged.
     * 
     * @param name The logical name
     * @param jdbcEnvironment The JDBC environment in which the conversion occurs
     * @return The physical name
     */
    @Override
    public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return name;
    }

    /**
     * Converts the logical table name to its physical equivalent.
     * Applies the transformation rules to convert camelCase to UPPER_CASE_WITH_UNDERSCORES.
     * 
     * @param name The logical name
     * @param jdbcEnvironment The JDBC environment in which the conversion occurs
     * @return The physical name
     */
    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        final List<String> parts = splitAndReplace(name.getText());
        return jdbcEnvironment.getIdentifierHelper().toIdentifier(
                join(parts),
                name.isQuoted()
        );
    }

    /**
     * Converts the logical sequence name to its physical equivalent.
     * This implementation returns the name unchanged.
     * 
     * @param name The logical name
     * @param jdbcEnvironment The JDBC environment in which the conversion occurs
     * @return The physical name
     */
    @Override
    public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return name;
    }

    /**
     * Converts the logical column name to its physical equivalent.
     * Applies the transformation rules to convert camelCase to UPPER_CASE_WITH_UNDERSCORES.
     * 
     * @param name The logical name
     * @param jdbcEnvironment The JDBC environment in which the conversion occurs
     * @return The physical name
     */
    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        final List<String> parts = splitAndReplace(name.getText());
        return jdbcEnvironment.getIdentifierHelper().toIdentifier(
                join(parts),
                name.isQuoted()
        );
    }

    /**
     * Splits a camelCase string into its constituent words and converts each word to uppercase.
     * For example, "firstName" becomes ["FIRST", "NAME"]
     * 
     * @param name The camelCase string to split
     * @return A LinkedList containing the uppercase parts of the original string
     */
    private LinkedList<String> splitAndReplace(String name) {
        LinkedList<String> result = new LinkedList<>();
        // Split the string by character type changes (e.g., camelCase becomes ["camel", "Case"])
        for (String part : StringUtils.splitByCharacterTypeCamelCase(name)) {
            if (part == null || part.trim().isEmpty()) {
                continue;
            }
            // Convert each part to uppercase using the ROOT locale to ensure consistent behavior
            result.add(part.toUpperCase(Locale.ROOT));
        }
        return result;
    }

    /**
     * Joins a list of strings with underscore separators.
     * For example, ["FIRST", "NAME"] becomes "FIRST_NAME"
     * 
     * @param parts The list of strings to join
     * @return A string with the parts joined by underscores
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