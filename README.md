# Mobile Testing Challenge

The project started from a classic maven archetype or template. This archetype is called "Maven Quickstart Archetype" which helps to build pom.xml file with useful apache libraries.

After this, all the dependencies with which the project works were introduced, these are: TestNg, Gson, appium java-client, tinylog, slf4j in its api and simple version, and allure-testng for reports.

## Folders

The test code is located inside the src/test folder, inside this folder are the tests and test resources.

### Resources folder

Within this folder are the desired capabilities in form of Json files. Right now I have one to connect to an emulated device and one to connect to a real device.

### Java/core folder

The "ConfigCapabilities" file is first found in this folder, which has a constructor which receives the path where the capabilities Json files are, reads the files and loads them into a capabilities-type object.
The second file is used to create and obtain the driver. An object of type "AndroidDriver<MobileElement> " is instantiated, which creates an object to handle Android which is created from the capabilities file.

### Java/basetest folder

Here are the 2 base files from which other classes are extended, firstly there is the base screen which contains the override of all the methods used by selenium and appium and that can be used by the child screens. The other file called Hooks has TestNg notation for starting and ending tests. Before the tests begin, the AndroidDriver is created using the MobileDrivarManager class, which is passed as a parameter to initialize all screens.

### Java/screens folder

This folder follows the POM design pattern, and contains all the screens that were accessed for the challenge. Each screen has variables of type By which have the locators of the objects, and also has the methods that represent the possible actions inside the page.

### Java/tests folder

This class inherits from Hooks and has all the necessary tests and assertions to verify all the scenarios proposed in the challenge. uses the screen instances and the driver created in the parent (BaseScreen) to call the screen methods and test correctly.
