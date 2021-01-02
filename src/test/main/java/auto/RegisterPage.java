package auto;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.concurrent.TimeUnit;

/**
 * 1、注册
 * https://zhuanlan.zhihu.com/p/128521874 xpath定位
 * https://zhuanlan.zhihu.com/p/128521404
 * http://www.selenium.org.cn/1374.html
 * https://www.cnblogs.com/wanghaihong200/p/8466958.html
 *
 * 2、下拉框处理:
 *(1)正常的Select下拉框 new Select(this.posts).selectByIndex(43);
 *(2)用的是假的input框实现的下拉框,清空内容填入值,虽然填上去了，前端验证不通过
 *(3)系部处，科室，前端代码中是根据 选择了“系部处”，后查询“科室”的，所以直接填入也不行；
 * 下拉框、日期框都用正常的click事件OK
 *
 * 3、元素定位：因用easyui前端框架包装过，有些ID会变化，使xpath定位不到
 * 4、显示等待、隐式等待，xpath路径
 *
 * @author dongmei.gao
 * @date 2020/12/26 13:44
 */
public class RegisterPage {
    WebDriver driver;

    @FindBy(how = How.XPATH, xpath = "//*[@id=\"_easyui_textbox_input1\"]")
    WebElement userCode;
    @FindBy(how = How.XPATH, xpath = "//*[@id=\"_easyui_textbox_input6\"]")
    WebElement passWord;
    @FindBy(how = How.XPATH, xpath = "//*[@id=\"_easyui_textbox_input2\"]")
    WebElement userName;

    @FindBy(how = How.XPATH, xpath = "//*[@id=\"_easyui_textbox_input13\"]")
    WebElement birthDayInput;
    @FindBy(how = How.XPATH, xpath = "/html/body/div[9]/div/div[1]/div/div[2]/table/tbody/tr[4]/td[4]")
    WebElement birthDayDate;
    @FindBy(how = How.XPATH, xpath = "//*[@id=\"_easyui_textbox_input10\"]")
    WebElement userNationalInput;
    @FindBy(how = How.XPATH, xpath = "//*[@id=\"txt_staffNational_easyui_combobox_i2_1\"]")
    WebElement userNational;

    @FindBy(how = How.XPATH, xpath = "//*[@id=\"_easyui_textbox_input7\"]")
    WebElement userEducationInput;
    @FindBy(how = How.XPATH, xpath = "//*[@id=\"txt_staffEducation_easyui_combobox_i1_5\"]")
    WebElement userEducation;

    @FindBy(how = How.XPATH, xpath = "//*[@id=\"_easyui_textbox_input4\"]")
    WebElement userPhone;

    /**用css路径定位，和posts的ID总是变化，一会15，一会16*/
    @FindBy(how = How.CSS, css = "html.panel-fit body.easyui-layout.layout.panel-noscroll div.panel.layout-panel.layout-panel-center.panel-htop div.panel-body.panel-body-noheader.layout-body div form#saveStaff table tbody tr td div span.textbox.textbox-invalid.combo input#_easyui_textbox_input16.textbox-text.validatebox-text.validatebox-readonly.validatebox-invalid.textbox-prompt")
    WebElement departInput;
   @FindBy(how = How.XPATH, xpath = "/html/body/div[4]/div/div[13]")
   // @FindBy(how = How.XPATH, xpath = "//div[text()=\"财经信息工程系\"]"),could not be scrolled into view,有滚动条的定位不到
    WebElement depart;
    /**edge 浏览器中的Full xpath**/
    @FindBy(how = How.XPATH, xpath = "/html/body/div[2]/div/div/form/table/tbody/tr[1]/td/div[2]/span[5]/input[1]")
    WebElement subDepartInput;
    @FindBy(how = How.XPATH, xpath = "//div[text()=\"计算机科学与技术教研室\"]")
    WebElement subDepart;
    /**职称*/
    @FindBy(how = How.XPATH, xpath = "//*[@id=\"_easyui_textbox_input12\"]")
    WebElement userTitleInput;
    @FindBy(how = How.XPATH, xpath = "/html/body/div[8]/div/div[3]")
    //@FindBy(how = How.XPATH, xpath = "//div[text()=\"副教授(副高)级\"]"),卡死不动这个
    WebElement userTitle;
    /**职务，根据属性定位*/
    @FindBy(how = How.XPATH, xpath = "//input[@placeholder=\"请选择职务\"]")
    WebElement postsInput ;
    @FindBy(how = How.XPATH, xpath = "/html/body/div[5]/div/div[44]")
    WebElement posts ;

    @FindBy(how = How.XPATH, xpath = "//*[@id=\"_easyui_textbox_input14\"]")
    WebElement entryDateInput;
    @FindBy(how = How.XPATH, xpath = "/html/body/div[10]/div/div[1]/div/div[2]/table/tbody/tr[3]/td[6]")
    WebElement entryDateDate;

    @FindBy(how = How.XPATH, xpath = "//*[@id=\"saveStaff\"]/table/tbody/tr[1]/td/div[2]/div[2]/span[1]/span")
    WebElement userSexMale;
    @FindBy(how = How.XPATH, xpath = "/html/body/div[2]/div/div/form/table/tbody/tr[1]/td/div[2]/div[2]/span[2]/span")
    WebElement userSexFemale;
    @FindBy(how = How.XPATH, xpath = "//*[@id=\"_easyui_textbox_input5\"]")
    WebElement userAddr;

    @FindBy(how = How.XPATH, xpath = "//*[@id=\"btn_save\"]/span/span[1]")
    WebElement registerButton;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * 注册页面
     * @param userCode
     * @param passWord
     * @param userName
     * @param userPhone
     * @param userAddr
     */
    public void RegisterPage(String userCode, String passWord, String userName,
                             String userPhone, String userAddr) {
        this.userCode.sendKeys(userCode);
        this.userName.sendKeys(userName);
        this.passWord.sendKeys(passWord);

        this.birthDayInput.click();
        this.birthDayDate.click();
        this.entryDateInput.click();
        this.entryDateDate.click();

        this.userNationalInput.click();
        this.userNational.click();

        this.userEducationInput.click();
        this.userEducation.click();

        //财信，计算机科学
        this.departInput.click();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        this.depart.click();

        //等待加载内容
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        this.subDepartInput.click();
        this.subDepart.click();

        this.postsInput.click();
        this.posts.click();

        this.userTitleInput.click();
        this.userTitle.click();

        this.userPhone.sendKeys(userPhone);
        this.userAddr.sendKeys(userAddr);

        this.registerButton.click();
    }

    /**
     * 执行js脚本,移除所有input的readonly属性
     */
    public void executeJs(){
        /*
        这种方式不行，前端验证不通过
        this.birthDay.clear();
        this.birthDay.sendKeys(birthDay);
        this.entryDate.clear();
        this.entryDate.sendKeys(entryDate);
        */

        ((JavascriptExecutor)driver).executeScript(
                "var inputs = document.getElementsByTagName('input'); "+
                        "for(var i = 0; i< inputs.length; i ++)"+
                        "inputs[i].removeAttribute('readonly','readonly'); "
        );
    }

}
