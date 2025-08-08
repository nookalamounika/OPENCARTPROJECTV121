######   Hybrid driven Automation Framework:          ##################
This project is a Hybrid driven Automation Framework, combining both Data-Driven Testing and the Page Object Model (POM) design pattern.
It is built using Java, Selenium WebDriver, TestNG, and Maven, and is fully integrated with Git, GitHub, and Jenkins for source control and CI/CD pipeline automation.

Tech Stack:
Language: Java
Automation Tool: Selenium WebDriver
Build Tool: Maven
Test Framework: TestNG
Reporting Tool: ExtentReports
Version Control: Git & GitHub
CI/CD: Jenkins

Project Structure:
HybridFramework/
├── src/
│   ├── test/
│   │   └── java/
│   │       ├── pageobjects/         # Page Object classes
            ├──utilities/           # Utility classes (e.g., waits, config)
│   │       ├── dataproviders/       # DataProvider classes for Excel-based testing
│   │       └── reportmanager/       # ExtentReportManager class
|
│   └── test/
│       └── java/
│           └── testcases/           # Test case classes:
├── test-data/
│   └── Open_Cart_loginData.xlsx                # Excel sheet for test data
├── reports/
│   └── extentreport.html           # HTML test execution reports
├── screenshots/
│   └── .png                        # Screenshots captured on test failure
├── pom.xml                          # Maven configuration file
|__CrossBrowserTesting.xml
|__grouping.xml
|__master.xml
|__run.bat





##  How to Run

###  Locally (Windows)

1. Clone the repository:
   ```bash
   git clone https://github.com/nookalamounika/OPENCARTPROJECTV121.git
   cd OPENCARTPROJECTV121

2.Execute tests using the batch script:
  run.bat











