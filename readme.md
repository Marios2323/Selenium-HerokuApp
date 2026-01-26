# Selenium Login Automation Project

## Overview

This project demonstrates **automated testing of a login page** using **Selenium WebDriver** and **TestNG** in Java. It follows the **Page Object Model (POM)** design pattern for maintainable and scalable test automation.

The target page for automation is: [The Internet – Login Page](https://the-internet.herokuapp.com/login)

## Features

- Automates **happy path login** scenario:
    - Enter username
    - Enter password
    - Click login button
    - Verify login success message
    - Verify secure page URL
- Implements **Page Object Model** for clean separation of test logic and page interactions
- Uses **TestNG** for assertions and test structure
- WebDriver managed with **WebDriverManager** for automatic driver setup

## Project Structure

src
  main > java > pages > LoginPage.java      

# Page Object class for login page
test > java > tests >  LoginTest.java     

# Test class for login scenarios

## Technologies

* Java 17+

* Selenium WebDriver

* TestNG

* WebDriverManager

* Maven (pom.xml)

## How to Run
1. Clone the repository:

````
git clone https://github.com/Marios2323/Selenium-HerokuApp.git
cd Selenium-HerokuApp
````
2. Install dependencies with Maven:

``
mvn clean install
``
Run the tests:

``mvn test``

## Page Object Model (POM)
#### LoginPage.java encapsulates page interactions:

* Locators for username, password, and login button

* Methods for actions:

* typeUsername(String username) – enters the username

* typePassword(String password) – enters the password

* pressLoginButton() – clicks the login button

### LoginTest.java:

* Initializes the WebDriver

* Calls Page Object methods

* Performs assertions to validate login success

Note: The Page Object only handles interactions; assertions remain in the test class.

## Contributing
1. Fork the repository
2. Create a new branch: git checkout -b feature/new-test
3. Commit your changes: git commit -m "Add new test"
4. Push to your branch: git push origin feature/new-test
5. Open a Pull Request

## License
This project is licensed under the ##MIT License.