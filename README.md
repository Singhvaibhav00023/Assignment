# Selenium Assignment

**Run the Project using Commandline:**

1. In order to Run the project using cmd 
2. Open the command prompt
3. Go to the specific path where you will clone the code
cd "projectpath"
Ex - cd C:\Users\VAIBHAVSINGH\Assignment
4. Run the below command
mvn test -D suite=testng.xml
5. Results will be displayed

**Note:**
Used TestNG with Parametrization created two tests for two movies "Pushpa: The Rise - Part 1" and "Krrish 3"

**Integrated Project with Jenkins**

1) Go to jenkins.war path
2) java –jar jenkins.war
3) Display message Jenkins in fully up and running
4) open localhost:8080 in browser
5) Login Jenkins using username and password
6) Click on New Item
7) Enter the Project Name and Select Freestyle Project
8) Select Source code management as GIT
9) Enter Repository URL 
10) Select any other options as per requirement and Select build steps as "Invoke Top level Maven Targets"
11) Select postbuild as Publish TestNG results (TestNG plugin should be installed in Jenkins)
12) Save & Apply Changes
13) Open the build and Click on build now trigger will complete and will get results in TestNG format or we can see logs in Console Output

