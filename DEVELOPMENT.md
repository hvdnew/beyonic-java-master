# Beyonic Java Liberary

##### Installing dependencies
```
import the project as maven project into eclipse all the depencies will be downloaded using POM.XML.
```

##### Adding new api model
To create new api model you should perform below mentioned steps:
- Create a sample entity file under src/main/java/com/beyonic/model. See other file there for your reference.
- add a client interface and implementation in respective package under  ```com.beyonic.client``` file. E.g. ```PaymentsMethodsImpl implements PaymentsMethods```
- specify API end point in interface in any different.
- call ```ConnectionUtil.request(ConnectionUtil.RequestMethod.GET, url, options);``` this will return response.

#### Testing:
jUnit test cases are implemented under beyonic-java-master/src/test/java/com/beyonic/test/

##### Test execution
Test Suite :  beyonic-java-master/src/test/java/com/beyonic/test/BeyonicTest.java
- Set API version and key in public static void setUp().
- Specify test classes in @SuiteClasses (eg - src/test/java/com/beyonic/test/payment/PaymentsMethodsImplTest.java)
- Run as jUnit test.
- this will record test request and response as YAML file using Betamax API under (src/test/resources/betamax/tapes/)
- Whenever you want new tapes, delete existing and run the tests again.


##### API Mocking
For mocks Betamax API is used.
- All recorded API interactions tapes located on src/test/resources/betamax/tapes/ folder.
- They can be deleted, in this case on next tests run specs will access to real API and cassettes will be recorded again.
