# Beyonic Python Library

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

##### Test execution


```sh
$ nosetests --with-coverage  --cover-html --cover-package=beyonic
...............................................................................
```

You can get detailed coverage report at cover/index.html, after tests has been ran.

##### API Mocking
For mocks [vcrpy](https://github.com/kevin1024/vcrpy) is used.
All recorded API interactions cassettes located on vcr_cassettes/ folder.
They can be deleted, in this case on next tests run specs will access to real API and cassettes will be recorded again.
