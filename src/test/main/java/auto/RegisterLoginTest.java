package auto;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author dongmei.gao
 * @date 2020/12/26 11:12
 */
public class RegisterLoginTest extends AutoBaseTest {

    private  String username ="2019190036";
    private  String password ="admin";
    private  String url = "http://localhost:9090/scre/";
    private  String url2 = "http://127.0.0.1:8080/auth/userregistration";
    private String titile = "科研管理系统" ;

    @Test
    public void loginTest(){
        //1、创建对象用Page工厂
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        //2、打开主页
        mainPage.openMainPage(url);
        //3、登录
        mainPage.login(username, password);
        //4、验证登录后的标题
        Assert.assertEquals(driver.getTitle(), titile);
    }

    @Test
    public void register(){
        RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        //TODO ，换成主页连接
        mainPage.openMainPage(url2);
        String userCode = "ui" +System.currentTimeMillis();
        registerPage.RegisterPage(userCode, "admin", "UiTester",
                                  "15088741256", "哈尔滨市学院路");
    }
}
