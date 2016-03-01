Account Management System 
This project provides functionality for management accounts. Every user has scope of roles, which include scope of permission groups with permission�s scope. User admin must has all exist roles, permission groups and permissions. 
App implements Rest API and provides security for every rest end point via spring security oauth2. All rest end points are securing by checking users Granted Authorities scope via @RolesAllowed annotation. Users Granted Authorities scope include permissions scope. 


Getting Started
Clone from�GIT�and then use Gradle (2.11 or better) and Java (1.8 or better):
$ git clone ...

To edit source code import source and build.gradle into your Gradle eclipce project.
To build .war after clone launch -gradle clean assemble.

Additional Resources
* Spring Security OAuth User Guide
* Spring Security OAuth Source
* Spring JDBC Template
* Gradle

Overview
Dao layer 
Interfaces - src\main\java\com\epam\rudoi\accountManagementSystem\dao
Implementation -  src\main\java\com\epam\rudoi\accountManagementSystem\dao\impl
Service layer 
Interfaces - src\main\java\com\epam\rudoi\accountManagementSystem\service
Implementation - src\main\java\com\epam\rudoi\accountManagementSystem\service\impl
Entity - src\main\java\com\epam\rudoi\accountManagementSystem\entity
Exceptions - src\main\java\com\epam\rudoi\accountManagementSystem\exceptions
Restful 
Interfaces - src\main\java\com\epam\rudoi\accountManagementSystem\rest
Implementation - src\main\java\com\epam\rudoi\accountManagementSystem\rest\impl

Configuration xml - src\main\webapp\WEB-INF
Context xml, logger configuration, db create-insert - src\main\resources


Dao unit tests - src\test\java\com\epam\rudoi\accountManagementSystem\dao
Service unit tests - src\test\java\com\epam\rudoi\accountManagementSystem\service
Test context xml, test db create-insert - src\test\resources