package chapter7;

import org.apache.log4j.Logger;


/**
 * @author dongmei.gao
 * @date 2018/11/20 11:03
 */
public class PayImpl implements PayInterface {
    /**日志*/
    private static final Logger logger = Logger.getLogger(PayImpl.class);
    /**引入外部客户端*/
    public CifClient cifClient = new CifClientImpl();

    /**
     * 支付
     * @param userId 用户id
     * @return  返回是否支付成功
     */
    public boolean pay(String userId) {
        try {
            UserInf userInf = cifClient.userQuery(userId);
            //do some biz
            logger.info(userInf);
            return true;
        } catch (Exception e) {
            logger.error("捕获异常！",e);
        }
        return false;
    }

    public void setCifClient(CifClient cifClient) {
        this.cifClient = cifClient;
    }
}
