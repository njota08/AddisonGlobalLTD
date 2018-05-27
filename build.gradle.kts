/* Imports ********************************************************************/
import com.energizedwork.gradle.webdriver.WebDriverBinariesPluginExtension
/* ****************************************************************************/

/* Properties *****************************************************************/
val chromeDriverVersion: String by project
val geckoDriverVersion: String by project
val projectGroup: String by project
val projectVersion: String by project
val seleniumVersion: String by project
val testNgVersion: String by project
/* ****************************************************************************/

/* Project's information ******************************************************/
group = "$projectGroup"
version = "$projectVersion"
/* ****************************************************************************/

/* Plugins ********************************************************************/
plugins {
    java
    id("com.energizedwork.webdriver-binaries") version "1.4"
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

configure<WebDriverBinariesPluginExtension> {
    chromedriver = "$chromeDriverVersion"
    geckodriver = "$geckoDriverVersion"
}
/* ****************************************************************************/

/* Dependencies ***************************************************************/
dependencies {
    compile("org.seleniumhq.selenium:selenium-chrome-driver:$seleniumVersion")
    compile("org.seleniumhq.selenium:selenium-firefox-driver:$seleniumVersion")
    compile("org.seleniumhq.selenium:selenium-support:$seleniumVersion")

    testCompile("org.testng:testng:$testNgVersion")
}

repositories {
    jcenter()
}
/* ****************************************************************************/

/* Tasks' setup ***************************************************************/
tasks.withType(Test::class.java).all {
    ignoreFailures = true

    useTestNG()
}
/* ****************************************************************************/
