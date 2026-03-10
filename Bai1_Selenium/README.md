# Bai1_Selenium - Automation Testing Project

This project is a complete Maven Selenium TestNG project for automation testing of [SauceDemo](https://www.saucedemo.com).

## Project Structure
- **Part 1 & 2**: Selenium automation testing.
- **Part 3**: CFG & Branch Coverage.
- **Part 4**: Basis Path Testing.
- **Part 5.2**: MC/DC Testing for loan approval logic.

## Technology Stack
- **Java 17**
- **Selenium WebDriver 4.18.1**
- **TestNG 7.9.0**
- **WebDriverManager 5.7.0**
- **Chrome browser**

## Prerequisites
- **JDK 17** installed and configured in `JAVA_HOME`.
- **Maven** installed and configured.
- **Chrome browser** installed.

## How to Run Tests
1. Run all tests including coverage tests:
   ```bash
   mvn clean test
   ```

## Coverage Reports (Part 3)
Detailed coverage analysis and test tables:
- [Bai 3.1 Coverage](file:///c:/NAMCUOI/PROJECTTESTLAB8/Bai1_Selenium/bai3/bai3_1/coverage_table.md)
- [Bai 3.2 Coverage](file:///c:/NAMCUOI/PROJECTTESTLAB8/Bai1_Selenium/bai3/bai3_2/coverage_table.md)

## Reports
- After running the tests, the TestNG HTML report will be generated at:
  `test-output/index.html` (or `target/surefire-reports/index.html`)

## Failed Test Screenshots
- If any test fails, a screenshot will be automatically captured and saved in the `/screenshots` folder.
