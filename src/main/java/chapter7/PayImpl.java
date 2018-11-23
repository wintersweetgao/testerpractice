package chapter7;

/**
 * @author dongmei.gao
 * @date 2018/11/20 11:03
 */
public class PayImpl implements PayInterface{
   public CifClient cifClient = new CifClientImpl();
    public boolean pay(String userId) {
        try {
            UserInf userInf = cifClient.userQuery(userId);
            //do some biz
            System.out.println(userInf);
            return  true;
        }catch (Exception e){
            System.out.println("捕获异常！"+e.getMessage());
        }
        return false;
    }

    public void setCifClient(CifClient cifClient) {
        this.cifClient = cifClient;
    }
}
