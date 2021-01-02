package auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * 主页page：所有元素和方法，都封装在page对象中
 * @author dongmei.gao
 * @date 2020/12/26 10:31
 */
public class MainPage {
    WebDriver driver;

    @FindBy(how = How.ID, id = "txt_userName")
    WebElement userName;
    @FindBy(how = How.ID, id = "txt_userPass")
    WebElement passWord;
    @FindBy(how = How.ID, id = "btn_login")
    WebElement loginButton;
    @FindBy(how = How.LINK_TEXT, linkText = "用户注册")
    WebElement userRegisterLink;

    public MainPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    /**
     * 登录
     * @param userName
     * @param passWord
     */
    public void login(String userName, String passWord){
        this.userName.sendKeys(userName);
        this.passWord.sendKeys(passWord);
        this.loginButton.click();
        //隐式等待，第一次登录经常超时
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
    }

    /**
     * 打开主页
     * @param url
     */
    public void openMainPage(String url){
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
    }

    public void clickRegister(){
        userRegisterLink.click();
        //显式等待
        WebDriverWait wait = new WebDriverWait(driver, 300);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("")));
    }
}
