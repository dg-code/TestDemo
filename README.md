# TestDemo

Sample project containing several api and selenium tests...

### Prerequisites

For the moment it is possible to run the tests only via Eclipse IDE. For this to work you will need:

* [Eclipse](https://www.eclipse.org/downloads/eclipse-packages/) - Java IDE
* [TestNG](https://github.com/cbeust/testng-eclipse) - TestNG Eclipse plug-in used for running the tests
* Windows OS with Java (version 8, or above), Chrome and Firefox browsers installed

## Running the tests

* Download a zip of the project 
* Import the Project in Eclipse as an 'Existing Maven Projects'
* Right click on one of the TestNG test suits (.xml files) located under '/src/test/resources/', right click and 'Run as -> TestNG Suite'

## Test Suites

Currently under '/src/test/resources/' there are three test suits one for each browser 'Chrome' or 'Firefox' and one suite for the api tests

## Test Reports

After running the tests a 'test-output' folder is created where simple html report is auto-generated from the TestNG framework
Can be accessed via double click on the index file.

## Project content

* [Api tests](https://github.com/dg-code/TestDemo/tree/master/src/test/java/demo/example/SimpleTestProject/apitests)
* [Web UI tests](https://github.com/dg-code/TestDemo/tree/master/src/test/java/demo/example/SimpleTestProject/seleniumtests)
* [Page Object Model of the UI](https://github.com/dg-code/TestDemo/tree/master/src/test/java/demo/example/SimpleTestProject/UIObj)
* [Helper classes](https://github.com/dg-code/TestDemo/tree/master/src/test/java/demo/example/SimpleTestProject/Utils)
