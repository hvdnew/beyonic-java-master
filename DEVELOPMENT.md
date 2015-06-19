# Beyonic Java Liberary

##### Installing dependencies
```
import the project as maven project into eclipse all the depencies will be downloaded using POM.XML.
```

### Maven users

Take a note of the external dependencies:

```xml
    <dependency>
			<groupId>com.google.code.gson</groupId>
			<artifactId>gson</artifactId>
			<version>2.2.4</version>
		</dependency>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
		</dependency>
		<dependency>
			<groupId>com.sun.jersey</groupId>
			<artifactId>jersey-client</artifactId>
			<version>1.8</version>
		</dependency>
		<dependency>
			<scope>test</scope>
			<groupId>co.freeside</groupId>
			<artifactId>betamax</artifactId>
			<version>1.1.2</version>
		</dependency>
		<dependency>
			<groupId>org.codehaus.groovy</groupId>
			<artifactId>groovy-all</artifactId>
			<version>2.2.0</version>
		</dependency>
		<dependency>
			<groupId>org.apache.httpcomponents</groupId>
			<artifactId>httpclient</artifactId>
			<version>4.2.1</version>
		</dependency>
		<dependency>
			<groupId>org.yaml</groupId>
			<artifactId>snakeyaml</artifactId>
			<version>1.15</version>
		</dependency>
```

After clean and build the project is ready to use.


##### Adding new api model
To create new api model you should perform below mentioned steps:
- Create a sample entity file under src/main/java/com/beyonic/model. See other file there for your reference.
- add a client interface and implementation in respective package under  ```com.beyonic.model``` file. E.g. ```Payment```
- Add all params needed for req and response, and implement all the operations on that model.
- specify API end point in interface in any different.
- call ```ConnectionUtil.request(ConnectionUtil.RequestMethod.GET, url, options);``` this will return response.

#### Testing:
jUnit test cases are implemented under beyonic-java-master/src/test/java/com/beyonic/test/

##### Test execution
Test Suite :  ```beyonic-java-master/src/test/java/com/beyonic/test/BeyonicTestSuite.java```
- Set API version and key in ```public static void setUp().```
- Specify test classes in ```@SuiteClasses (eg - src/test/java/com/beyonic/test/payment/PaymentTest.java)```
- Run as jUnit test.
- this will record test request and response as YAML file using Betamax API under (src/test/resources/betamax/tapes/)
- Whenever you want new tapes, delete existing and run the tests again.


##### API Mocking
For mocks Betamax API is used.
- All recorded API interactions tapes located on src/test/resources/betamax/tapes/ folder.
- They can be deleted, in this case on next tests run specs will access to real API and cassettes will be recorded again.


#### Exporting as a Library
- Right click on the eclipse - project and click on 'export'.
- Select 'JAR' as exporting option.
- You may optionally include source in export liberary.


##### Usage
- Make a new maven project.
- Add all the dependencies mentioned above.
- import beyonic jar and add it to class path of the project.

=====

BeyonicImpl.java

```java
import java.util.List;

import com.beyonic.model.Payment;
import com.beyonic.util.BeyonicConstants;


public class BeyonicImpl {

	public static void main(String[] arg){

		//BeyonicConstants.CLIENT_API_VERSION = "v1";//"v1"; // setting api version
		BeyonicConstants.CLIENT_API_KEY = "YOUR-KEY";// ""; // beyonic test key
		
		
		List<Payment> paymentList = Payment.list();
		System.out.println(paymentList.size());
		
	}
	
}
```








