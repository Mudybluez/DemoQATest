# Assignment 3 – Selenium Automation Testing (SQAT)

## 📌 Description

This project is created as part of **Assignment 3** for the course  
**Software Quality Assurance and Testing (SQAT)**.

The goal of the assignment is to demonstrate:
- usage of different Selenium waits,
- advanced user interactions,
- dropdown handling,
- automated test report generation.

The automated test is implemented using **Selenium WebDriver with Java** and executed on a demo web application.

---

## 🌐 Tested Web Application

- Website: https://demoqa.com
- Pages used:
  - Buttons page (Actions class)
  - Select Menu page (Select class)

---

## 🛠 Technologies Used

- **Java:** 21 (LTS)
- **Build Tool:** Maven
- **Automation Framework:** Selenium WebDriver
- **Test Framework:** TestNG
- **Driver Management:** WebDriverManager
- **Reporting Tool:** ExtentReports
- **IDE:** Visual Studio Code
- **Browser:** Google Chrome

---

## ⚙️ Prerequisites

Before running the project, make sure the following software is installed:

1. **Java JDK 21**
   ```bash
   java -version

Expected output should contain Java 21.

2. **Apache Maven**
    ```bash
    mvn -version


3. **Google Chrome browser**

4. **Visual Studio Code with extensions:**

    - Extension Pack for Java

    - Maven for Java

    - Test Runner for Java

---

## 📂 Project Structure
    ``` 
    Assignment_3_SQAT
    │
    ├── pom.xml
    ├── README.md
    ├── ExtentReport.html   (generated after test execution)
    │
    └── src
        └── test
            └── java
                └── com
                    └── sqat
                        └── assignment3
                            └── DemoQATest.java
