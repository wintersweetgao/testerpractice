package chapter7;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author dongmei.gao
 * @date 2018/11/20 11:11
 */
public class MockCifTest {
    /**引入支付实现类*/
   private PayImpl payImpl = new PayImpl();
   /**0、创建mock对象*/
   private CifClient cifClientMock = mock(CifClient.class);
   /**用户id*/
   public String userID = "2055XXXXX";
    /**
     * 正常用例
     */
    @Test
    public void payNorTest(){
        //1、生成mock结果对象
        UserInf userInfMock = new UserInf();
        userInfMock.setUserId(userID);
        userInfMock.setAge(10);
        userInfMock.setName("LiLei");
        //2、set mock
        payImpl.setCifClient(cifClientMock);
        //3、mock
        when(cifClientMock.userQuery(anyString())).thenReturn(userInfMock);
        //4、test
        boolean result =  payImpl.pay(userID);
        //5、验证
        Assert.assertEquals(result,true);
    }

    /**
     * 异常用例
     */
    @Test
    public void payExTest(){
        //1、set mock
        payImpl.setCifClient(cifClientMock);
        //2、mock RuntimeException,两种方法都可以
        //doThrow(new RuntimeException()).when(cifClientMock).userQuery(anyString());
        when(cifClientMock.userQuery(anyString())).thenThrow(new RuntimeException());

        //3、test
        boolean result =  payImpl.pay(userID);
        //4、验证
        Assert.assertEquals(result,false);
    }
}

