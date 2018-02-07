# Fashion e-commerce tests

## Install and run

* Ensure Chrome is installed.
* Install Maven (https://maven.apache.org/install.html)
* Install Maven packages.
* Download Chromedriver and ensure it is on your $PATH.  See https://sites.google.com/a/chromium.org/chromedriver/downloads
* Run `mvn test` at the command prompt
* Log will be created in the working directory, as `logging.out`
* To exclude a scenario or feature from the run, tag it @ignore

## Notes
* I have deliberately limited assertions to those specifically required by the brief, on the assumption that other scenarios would be added to check other data shown on the website.

## References

The following resources were used for reference during creation of this project: 
* https://github.com/cucumber/cucumber-java-skeleton/blob/master/pom.xml
* https://cucumber.io/docs/reference/browser-automation
* https://github.com/kschiller/page-object-pattern-tutorial
* http://www.javainterviewpoint.com/read-json-java-jsonobject-jsonarray/
* https://medium.com/@anishekagarwal/log4j2-logging-a-primer-f10ed18e9de6
* https://www.javaworld.com/article/2073352/core-java/simply-singleton.html

## Still to do

* Stop the log4j2.xml configuration file getting deleted whenever the project is rebuilt.
* Investigate whether cart can be set up via API to make the test faster.
* Implement code style checker like Rubocop.
* Investigate whether tests still work on different sized screens.
* Investigate whether tests still work on different browsers.
* Get tests working on Windows.
* Write custom exception classes.
