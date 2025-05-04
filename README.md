# EPIC: Enhanced PIpeline for migrating legacy Code
## DocGen: Generating the documentation
First we Leverage Claude 3.7 Sonnet to generate the documentation of each and every line of code. The prompt used for the task: "You are now a documentation generator. Your sole task is to produce precise and comprehensive documentation for every single file in the codebase. Ensure that every line of code, method, and class is meticulously documented to perfectly capture the code's behavior."

## CodeGen: Migrating the core logic
### Migrating from javax to jakarta
Hibernate upgraded to Jakarta Persistence 3.0, which uses `jakarta.persistence.*` instead of `javax.persistence.*`.
Mixing `javax.persistence.*` (from Java EE / Hibernate 5) with `jakarta.persistence.*` (from Jakarta EE / Hibernate 6) will cause:
- ClassNotFoundException
- NoSuchMethodError
- Incompatible APIs - because they are not binary-compatible even if they look the same.

Migration Steps:
- Updating the Imports: `javax.persistence.*` -> `jakarta.persistence.*`
- Replace `javax.persistence-api` library with Jakarta EE 9+ Equivalents i.e. `jakarta.persistence-api`
- Spring Boot 3.0+ is the first major version to fully support Jakarta EE 9 and beyond


### Hibernate 5 to Hibernate 6 with Java 23
Here is the summary of second iteration of CodeGen. 

- Hibernate 6.x must be explicitly versioned.
- EntityManagerFactory.unwrap(Session.class) is discouraged in Hibernate 6.
- Replaced deprecated `Session.getCriteriaBuilder()` with `EntityManager.getCriteriaBuilder()`
- Replaced all usages of `Session` and `SessionFactory` with JPA-standard `EntityManager` injection.

Note: See the commit for DocGen, CodeGen (both Iterations) to see the sequential migration.