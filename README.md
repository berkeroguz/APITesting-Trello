# API Automation Project

API Testing

# Tools & Technologies

RestAssured, Maven, JUnit, Java, Log4j, Allure Reporting, Apacje Poi, Json

# Prerequests

* Maven apache must be installed
* Scoop must be installed (For take report of allure)

# How to Execute Test

You are able to execute test on runner class, and alo using with @tag

You can also set your own apikey and token in "configuration properties" files.

# Reporting

Firstly you need to install Scoop,
* Open a PowerShell terminal (version 5.1 or later) and run:

~ Set-ExecutionPolicy RemoteSigned -Scope CurrentUser
~ irm get.scoop.sh | iex

* After you need to install allure
For this run

~ scoop install allure

* After when you want to create report, firstly you need to execute tests
after that run this code

~ allure generate --clean

Afther that You can open the index.html file inside the "allure-report" folder with any browser.


# Patterns

OOP and POM pattern were used