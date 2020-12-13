# naptdemo

NAPT Demo

mvn test
-Dcucumber.options="--tags @checkout"
-Dcucumber.options="--glue com.napt.ui.gap.steps"
-DimplicitWaitSeconds=5
-DtestType="pc"
-Dcap.browserName="chrome"
-DdriverPath="/Users/nisum/Documents/workspace/napt_automation/Central/drivers/chromedriver_mac"
-Dfeatures="/Users/nisum/Documents/workspace/naptdemo/features/GapBrowse.feature"
-Dexperience="desktop"
-DwebURL="https://www.gap.com"
 
mvn test -Dcucumber.options="--tags @checkout" -Dcucumber.options="--glue com.napt.ui.gap.steps" -DimplicitWaitSeconds=5 -DtestType="pc" -Dcap.browserName="chrome" -DdriverPath="/Users/nisum/Documents/workspace/napt_automation/Central/drivers/chromedriver_mac" -Dfeatures="/Users/nisum/Documents/workspace/naptdemo/features/GapBrowse.feature" -Dexperience="desktop" -DwebURL="https://www.gap.com"
 
 
Appium - Local Android
mvn test
-Dcucumber.options="--tags @checkout"
-Dcucumber.options="--glue com.napt.ui.gap.steps"
-DimplicitWaitSeconds=5
-DtestType="mew"
-Dcap.browserName="chrome"
-Dcap.deviceName="am10"
-Dcap.platformVersion=10
-Dcap.platformName=android
-Dcap.newCommandTimeout=5
-DappiumURL=http://localhost:4723/wd/hub
-Dfeatures="/Users/nisum/Documents/workspace/naptdemo/features/GapBrowse.feature"
-Dexperience="mobile"
-DwebURL="https://www.gap.com"
 
mvn test -Dcucumber.options="--tags @checkout" -Dcucumber.options="--glue com.napt.ui.gap.steps" -DimplicitWaitSeconds=5 -DtestType="mew" -Dcap.browserName="chrome" -Dcap.deviceName="am10" -Dcap.platformVersion=10 -Dcap.platformName=android -Dcap.newCommandTimeout=5 -DappiumURL=http://localhost:4723/wd/hub -Dfeatures="/Users/nisum/Documents/workspace/naptdemo/features/GapBrowse.feature" -Dexperience="mobile" -DwebURL="https://www.gap.com"
 
 
Browserstack - ios - safari
mvn test
-Dcucumber.options="--tags @checkout"
-Dcucumber.options="--glue com.napt.ui.gap.steps"
-DimplicitWaitSeconds=5 -DtestType="iaas"
-Dcap.os_version="13"
-Dcap.browserName="safari"
-Dcap.deviceName="iPhone 8"
-Dcap.device="iPhone 8"
-Dcap.browsersstack.debug=true
-Dcap.device="iPhone 8"
-Dcap.real_mobile=true
-Dfeatures="/Users/nisum/Documents/workspace/naptdemo/features/GapBrowse.feature"
-Dexperience="mobile"
-DwebURL="https://www.gap.com"
-DremoteURL="https://pradeepkhanna1:gx252qa5gfwkgC4ajSn5@hub-cloud.browserstack.com/wd/hub"
 
mvn test -Dcucumber.options="--tags @checkout" -Dcucumber.options="--glue com.napt.ui.gap.steps" -DimplicitWaitSeconds=5 -DtestType="iaas" -Dcap.os_version="13" -Dcap.browserName="safari" -Dcap.deviceName="iPhone 8" -Dcap.device="iPhone 8" -Dcap.browsersstack.debug=true -Dcap.device="iPhone 8" -Dcap.real_mobile=true -Dfeatures="/Users/nisum/Documents/workspace/naptdemo/features/GapBrowse.feature" -Dexperience="mobile" -DwebURL="https://www.gap.com" -DremoteURL="https://pradeepkhanna1:gx252qa5gfwkgC4ajSn5@hub-cloud.browserstack.com/wd/hub"
               