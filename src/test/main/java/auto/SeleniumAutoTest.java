package auto;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

/**
 * 打开百度页面输入关键字selenium自动查询
 * @author dongmei.gao
 * @date 2018/12/4 15:37
 */
public class SeleniumAutoTest {
    private WebDriver driver;
    /**日志*/
    private static final Logger logger = Logger.getLogger(SeleniumAutoTest.class);

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.gecko.driver", "D:\\prd\\geckodriver.exe");
        driver = new FirefoxDriver();
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("Page title is: " + driver.getTitle());
        driver.close();
    }

    /**
     * fixfox驱动下载地址  https://github.com/mozilla/geckodriver/releases/tag/v0.23.0
     */
    @Test
    public void test_find() {
        String url ="http://www.baidu.com";
        String key = "selenium";
        //1、在firefox浏览器中打开百度主页
        driver.get(url);

        //2、找到百度输入框
        WebElement element = driver.findElement(By.name("wd"));

        //3、输入值
        element.sendKeys(key);
        //4、使用于form页面元素，提交form到web服务器端
        element.submit();
        //5、超时时间10秒，让百度页面加载成功
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //6、断言页面部分文本信息中有关键字；
        Assert.assertTrue(driver.findElement(By.partialLinkText(key)).isDisplayed());
    }
}
