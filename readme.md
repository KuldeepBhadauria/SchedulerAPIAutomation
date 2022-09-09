###This Project is a cucumber based project for POC on API Test Automation

**To Run through command line:**<br>
mvn clean verify -Dcucumber.filter.tags="@api or  @Regression" -Denv=dev<br>

**Documentation to set up the project**<br>
Documentation to set up the project for first time can be found at link:<br>

**Key Highlights of the framework**<br>

1. Framework can be used to automate any rest api with jsut little bit of configuration changes<br>
2. Changes that would  be required are:<br>
2.1: Changing the base url of the apis - This is passed in env specific property file (just change the value of the property "api.base.uri"<br>
     in properties file under path src/test/resources/config/<br>
2.2. Request method that needs to be invoked (GET/POST/PUT/DELETE) can be dynamically passed through the feature file.<br>
2.3  All the request payloads and reponse objects are externalized and stored under path<br>
     request payloads: src/test/resources/requestObjects<br>
     response objects: src/test/resources/responseObjects<br>
     and can be reffered directly from the feature file by passing the file name in the generic BDD steps<br>
2.4 Provision of validating the key value pairs in response apart form direct comparison with expected file stored in response objects folder is also provided  through the generic BDD steps and can be directly validated through feature file as well.<br>
2.5 For demonstration purpose in all the feature files validation is done through the expected response stored in json file under response object folder as well as directly through feature files also.<br>


