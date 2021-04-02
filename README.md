## How to set environment on Windows
1. Download java https://www.oracle.com/pl/java/technologies/javase-downloads.html
2. Instruction how to set java home how to set https://mkyong.com/java/how-to-set-java_home-on-windows-10/
3. After java, install maven https://mkyong.com/maven/how-to-install-maven-in-windows/

## How to set environment on Linux
1. Download java -> open terminal and set `sudo apt install default-jdk`
2. Check if everything is good open terminal and set `java –version`
3. Install maven https://www.baeldung.com/install-maven-on-windows-linux-mac

## How to set environment on mac
1. Install brew by terminal `/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"`
2. Install java by brew `brew cask install java`
3. Install maven by brew `brew install maven`

# Run project in all systems:

4. Add right driver to src/main/resources/drivers
   * https://github.com/mozilla/geckodriver/releases for mozilla
   * https://chromedriver.chromium.org/downloads for chrome
   * https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/#downloads for Microsoft Edge

5. Set right value of KEY_DRIVER in src/test/java/cucumber/steps/PickupSteps.java
   *  `KEY_DRIVER = "webdriver.chrome.driver"` for chrome
   * ` KEY_DRIVER = "webdriver.gecko.driver"` for mozilla
   *  `KEY_DRIVER = "webdriver.edge.driver"` for Microsoft Edge

6. Set right value of PATH_DRIVER in src/test/java/cucumber/steps/PickupSteps.java
   *  `PATH_DRIVER = "src/main/resources/drivers/chromedriver.exe"` for chrome
   * ` PATH_DRIVER = "src/main/resources/drivers/geckodriver.exe"` for mozilla
   *  `PATH_DRIVER = "src/main/resources/drivers/EdgeDriver.exe"` for Microsoft Edge

7. Open terminal and run command `mvn clean install` after this command all dependencies should be installed and test will be run.
8. Report should be available in main folder in `report.html` file
