This readme file provides instructions on how to run the automated tests for the project "sauceLabs_selenium" using Selenium for UI automation
Swag Labs is a fictional e-commerce platform used for testing and educational purposes. It simulates typical online shopping experiences, 
allowing users to browse products, add items to their cart, and complete purchases, making it an invaluable tool for hands-on software testing training.
The tests are organized using Maven as a build automation tool. The project structure includes a Test folder that contains Java and 
Resources directories. The Java directory consists of the "swaglabs" package, which contains UI sub-package with tests. The UI tests utilize 
Selenium and are organized into different classes for each page. The Resources directory includes the necessary XML file used UI testing.

###Setup Instructions
Ensure that Maven is installed on your machine.
Install the required dependencies and plugins defined in the pom.xml file.

Set the system environment variables for the project:
Set the ´SWAG_LABS_LOGIN_URL´ variable with the url for authentication.
Set the ´SWAG_LABS_USERNAME´ variable with the username for authentication.
Set the ´SWAG_LABS_PASSWORD´ variable with the password for authentication.
Set the ´SWAG_LABS_NAME´ variable with the name for shippment information.
Set the ´SWAG_LABS_LASTNAME´ variable with the last name for shippment information.
Set the ´SWAG_LABS_POSTAL_CODE´ variable with the postal code for shippment information.
In the project they are set in the placelab.ui.utils.GlobalValues

###Executing tests
To run the UI tests, follow these steps:
Open the terminal and navigate to the project root directory.
Execute the following command in the terminal to run the UI tests.
´mvn clean test -Dtest="SmokeTest"´
This command will execute the UI tests using the testng.xml configuration file.

###Test Reports
After running the tests, the test reports will be generated in the "target/surefire-reports" directory. 
You can access the HTML reports to view the test results and any failures or errors encountered during the execution.

###Cleaning Up
To clean the project and remove any generated files, execute the following command:
´mvn clean´
