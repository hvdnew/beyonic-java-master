# Beyonic Java Liberary

##### Installing dependencies
Please run following command:
```
import the project as maven project into eclipse all the depencies will be downloaded using POM.XML.
```

##### Adding new api model
To create new api model you should perform below mentioned steps:
- Create a file under beyonic/apis folder containing a class for newly added model. See other file there for your reference.
- add import statement in ```beyonic/__init__.py``` file. E.g. ```from beyonic.apis.collection import CollectionRequest```


#### Testing:
jUnit test cases are implemented under beyonic-java-master/src/test/java/com/beyonic/test/

##### Test execution
Test Suite :  beyonic-java-master/src/test/java/com/beyonic/test/BeyonicTest.java
1. Set API version and key in public static void setUp().
2. Specify test classes in @SuiteClasses (eg - src/test/java/com/beyonic/test/payment/PaymentsMethodsImplTest.java)
3. Run as jUnit test.
4. this will record test request and response as YAML file using Betamax API under (src/test/resources/betamax/tapes/)
5. Whenever you want new tapes, delete existing and run the tests again.


##### API Mocking
For mocks Betamax API is used.
All recorded API interactions tapes located on src/test/resources/betamax/tapes/ folder.
They can be deleted, in this case on next tests run specs will access to real API and cassettes will be recorded again.
