package auto;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * @author dongmei.gao
 * @date 2020/12/24 17:10
 */
public class AutoBaseTest {
    public WebDriver driver;
    /**日志*/
    private static final Logger logger = Logger.getLogger(AutoBaseTest.class);

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.gecko.driver", "D:\\prd\\geckodriver.exe");
        driver = new FirefoxDriver();
    }
    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}
