# README #


## Test Automation >> Automate ROZETKA UI tests

### Requirements:
- [Done] selenium webdriver
- [Done] page object pattern
- [Future] c# is preferable
- [Future] coverage and checks define by yourself

### Use case:
1) Open https://rozetka.com.ua
2) Search "iphone"
3) Choose "iphone se" from dropdown list and go to category page
4) Choose any phone with "Rose" color and go to product page
5) Change color to "Space Gray"
6) Add product to the basket

### Test plan:
- Create regression end2end test

### How to run test suite:
1) macOS_Chrome:
    > **~./java-rozetka/gradlew localMacChrome**
2) macOS_Safari:
    > **~./java-rozetka/gradlew localMacSafari**
3) macOS_Firefox:
    > **~./java-rozetka/gradlew localMacFirefox**
4) win_Chrome:
    > **~./java-rozetka/gradlew localWinChrome**
5) lin_Chrome:
    > **~./java-rozetka/gradlew localLinChrome**

### How to serve results;
1) Generate Allure report:
    > **~./java-rozetka/tools/allure-2.10.0/bin/allure serve ~./java-rozetka/build/allure-results**

### Improvements:
* [Out of scope] Add data driven functionality by DataProvider functionality
* [Out of scope] Apply test design approaches to improve coverage    

### Restrictions:
* Browsers should be installed, eg Chrome, Safari or Firefox
* Test runs has been verified just at macOS Mojave 10.14.3
* Jira software integration not included
* Appium server integration not included
* Remote runs at CI not included