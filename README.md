# Para Bank automation-test

## Project Overview:
* This automation framework utilizes Playwright and Java to automate test cases for [Para bank web application]. It aims to provide comprehensive test coverage for the main features of the application. This README file serves as a guide for setting up and using the framework effectively.

## Features Covered:
### * User should be able to login with correct user id and password and perform the below actions:
1. Create 3 accounts having
   their total amount =
   3,500,000.
2. Check the total balance and
   make sure it is correct.
3. Try to transfer from - to same
   account.
4. Try to transfer amount more
   than the balance in account
### * Request a loan from the selected account.
1. Add Loan amount 5000 and
   down payment 1000 and
   apply.
2. Add Loan amount 1000 and
   down payment 7000 and
   apply.
### * Pay the bill from the selected account and check the balance before and after.
1. Pay the bill less than
   3,500,000
2. Pay the bill more than
   3,500,000

## Getting Started

To use this automation framework, ensure that you have the following prerequisites:

- Java Development Kit (JDK) installed (version 17 or higher)
- Docker installed
- Allure Report Commands

To set up the framework locally, follow these steps:

1. Clone the repository: `git clone https://github.com/abdulrahmanMohamed2020/parabank`
2. Install the required dependencies: `mvn install`

## Usage
To execute the test cases, use the following command:

1. Open the project using any IDE
    - in case you don't have an IDE you can open a command-line terminal on the project root path and paste the following command
      ```
       mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/testng.xml
      ```
2. Wait till all dependencies are resolved
3. Run the testing.xml file
4. After executing, you can easily generate the **Allure Report** by opening a command-line terminal on the project
   root path and paste the following command
      ```
        allure serve "allure-result" path
      ```

## Structure Explanation

- `src/main/java/com/com/qa/parabank`: This directory contains the main Java source code files for the project.
    - `factory`: This package contains The PlaywrightFactory class which contains configuration methods and class for browser configurations.
    - `listeners`: This package contains classes responsible for attaching the screenshot to Allure Report and Soft Assert.
    - `pages`: This package contains the pages elements and locators.
    - `util`: This package contains classes responsible for test data and expected results.
- `src/test/resources`: This directory includes the test runner file and config.properties .
    - `config`: This file contains the configuration and test user.
    - `test runner`: This file contains the test runner, so we can run the all test cases in parallel mode.

## The main Frameworks included in the project:
* Playwright
* TestNG
* Allure Report
* Commons IO
## Project Design:
* Page Object Model (POM) design pattern
* Fluent design approach (method chaining)
* Have a supporting factory package in src/main/java/com/qa/parabank file path, named **"factory"** that includes Capabilities classes which serve as a core engine for the project
