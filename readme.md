# Fashion e-commerce tests

## Install and run

* Ensure Chrome is installed and on the $PATH.
* Ensure JDK 1.8 is installed and on the $PATH.
* Install Maven (https://maven.apache.org/install.html)
* Install Maven packages.
* Download Chromedriver and ensure it is on your $PATH.  See https://sites.google.com/a/chromium.org/chromedriver/downloads
* Run `mvn test` at the command prompt.  It should be run in the root directory of the project.
* Log will be created in the working directory, as `logging.out`.
* To exclude a scenario or feature from the run, tag it `@ignore`.  Remember to rebuild after doing this.

## Notes
* The tests are known to work on MacOS 10.12 and Windows 7 x86.  Compatibility with other OS vesions is not guaranteed.
* Development was done at a screen resolution of 1366x768.  Because the site under test is responsive, there is a possibility of problems at other screen resolutions.
* For the purpose of this exercise, I have treated the site under test as a black box, and not attempted to intercept and manipulate any API calls.
* I have deliberately limited assertions to those specifically required by the brief, on the assumption that other scenarios would be added to check other data shown on the website.

## References

The following resources were used for reference during creation of this project: 
* https://github.com/cucumber/cucumber-java-skeleton/blob/master/pom.xml
* https://cucumber.io/docs/reference/browser-automation
* https://github.com/kschiller/page-object-pattern-tutorial
* http://www.javainterviewpoint.com/read-json-java-jsonobject-jsonarray/
* https://medium.com/@anishekagarwal/log4j2-logging-a-primer-f10ed18e9de6
* https://www.javaworld.com/article/2073352/core-java/simply-singleton.html

## Next steps

* Improve logging.
* Improve the configuration reader so it only reads the config file once per test run.
* Refactor code to make certain methods reusable across multiple page classes.
* Investigate whether cart can be set up via API to make the test faster.
* Implement code style checker like Rubocop.
* Change to use a headless browser to increase speed.
* Investigate whether tests still work on different sized screens.
* Investigate whether tests still work on different browsers.
* Write custom exception classes.
