# UI tests for miro web pages
> <a target="_blank" href="https://miro.com/">Link to miro web page</a>
 
![This is an image](images/picture/miro.jpg)

## :page_with_curl: Table of contents:
- [Technology stack](#Technology-stack)
- [Test cases](#Test-cases)
- [Deploy in Jenkins](#Deploy-in-Jenkins)
- [Run test using terminal](#Run-tests-using-terminal)
- [Reports in Allure](#Reports-in-Allure)
- [Reports in Allure TestOps](#Reports-in-Allure-TestOps)
- [Test video](#Test-video)
- [Jira synchronization](#Jira-synchronization)
- [Notification in telegram](#Notification-in-telegram)

## Technology stack
<p align="center">
<a href="https://www.java.com/"><img src="images/logo/java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="images/logo/github.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/idea.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://gradle.org/"><img src="images/logo/gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="images/logo/selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://junit.org/junit5/"><img src="images/logo/junit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://aerokube.com/selenoid/"><img src="images/logo/selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://www.jenkins.io/"><img src="images/logo/jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logo/allureReport.svg" width="50" height="50"  alt="Allure Reports"/></a>
<a href="https://qameta.io/"><img src="images/logo/allureTestOps.svg" width="50" height="50"  alt="Allure TestOps"/></a>
<a href="https://www.atlassian.com/software/jira"><img src="images/logo/jira.svg" width="50" height="50"  alt="Jira"/></a>
<a href="https://telegram.org/"><img src="images/logo/telegram.svg" width="50" height="50"  alt="Telegram"/></a>
</p>

## Test cases
- :heavy_check_mark: Open a main page of Miro
- :white_circle: Open a signup page of Miro
- :heavy_check_mark: Fill in a signup form without password and check validation error "Enter your password"
- :heavy_check_mark: Open a careers page of Miro
- :heavy_check_mark: Search a vacancy on careers page
- :heavy_check_mark: Open a vacancy page
- :x: Fill in a vacancy form without CV and check validation error "resume/CV is required"

## Deploy in Jenkins
> <a target="_blank" href="https://jenkins.autotests.cloud/job/14-malyginms-unit14_miro-tests/">Build in Jenkins</a>

![This is an image](images/picture/build_jenkins.jpg)

#### Build parameters
- Selenoid stand (remote stand which is used for test runs)
- browser (browser in which tests run, by default chrome)
- browserVersion (browser version in which tests run, by default 100.0)
- browserSize (browser window size in which tests run, by default 1920)

![This is an image](images/picture/build_parameters_jenkins.jpg)

## Run tests using terminal

#### Command for local run:
```bash
gradle clean test
```

#### Command for remote run:
```bash
clean test
-DselenoidStand=${SELENOID_STAND}
-DbrowserSize=${BROWSER_SIZE}
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
```

## Reports in Allure
> <a target="_blank" href="https://jenkins.autotests.cloud/job/14-malyginms-unit14_miro-tests/18/allure/#">Link to Allure reports</a>

![This is an image](images/picture/allure_reports_jenkins.jpg)

#### Overview dashboard

<p align="center">
<img title="Allure Overview Dashboard" src="images/picture/allure_reports_overview.jpg">
</p>

## Reports in Allure TestOps

## Test video

## Jira synchronization

## Notification in telegram