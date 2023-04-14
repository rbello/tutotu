# Unit Testing Tutorial
**With Spring 6 and JUnit 5**  ----
Edition 2023

## 1. Configure MAVEN for testing with Spring

With dependency `spring-boot-starter-test` and conventional file organization:
- Sources: `src/main/java/...`
- Tests: `src/test/java/...`

## 2. First test class creation : **Class1**

1. `@Test` annotation
2. Test functions `assert*`
3. Positive nominal cases
4. Negative nominal cases
5. Non-nominal cases, exceptions, ...
6. Run with MAVEN and you IDE (debug mode)

## 3. Lifecycle testing : **Class2**

1. Hook binding with `@BeforeEach` and `@BeforeAll`
2. Round-trip testing

## 4. Bad testing : **ZombieSimulatorTest**

1. Parametric tests
2. Bad practices

## 5. Integration testing

#### 🌐 With Database layer mocking

```
1. Configure H2 in-memory database
2. Configure application.properties
3. Initialize data: spring.jpa.defer-datasource-initialization and data.sql
4. Repository testing with @DataJpaTest
```

#### 🌐 With Controller layer mocking

```
1. Using component injection: @SpringBootTest
2. Using HTTP router: @WebMvcTest
```

#### 🌐 With remote WebService mocking

```
1. Using Mockito and @MockBean annotation
2. Using Wiremock library (spring-cloud-contract-wiremock)
```

## 6. Other usefully tricks

#### 🌐 Test your logs

```
1. Using a custom logback appender
2. And a logback-test.xml configuration
```

#### 🌐 Randomized testing

Generation of data to test the limits of the system on unplanned situations.

#### 🌐 Sampling testing

Selecting a portion of data to test to optimize execution duration.
See: [Randomized Testing - What, Why, When?](http://qala.io/blog/randomized-testing.html)
and [Generation library](https://github.com/qala-io/datagen).

## 7. Code quality audit with SonarQube

1. Using plugin: `jacoco-maven-plugin`
2. *Exclusions* configuration: focus on the code with business value
3. Setting `projectKey`: support branches / versions with Sonar community edition

## 7. TDD: Test Driven Development

1. Read specifications
2. Create structure (services, controllers, DTO, etc...)
3. Write a test that **fails**
4. Write only enough code to make the test **succeeds**
5. Improve the code without changing its behavior (refactoring)

## 8. Advanced configuration

1. Test execution using multithreading : `maven-surefire-plugin`
2. Dependencies analysis: `dependency-check-maven`
