package chapter7;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;


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
    public boolean pay(final String userId) {
        try {
            UserInf userInf = cifClient.userQuery(userId);
            //do some biz
            logger.info(userInf);
            return true;
        } catch (Exception e) {
            //包含案发现场信息+异常堆栈信息
            if(logger.isEnabledFor(Priority.ERROR)){
                logger.error("捕获异常！"+e.getMessage(),e);
            }
        }
        return false;
    }

    public void setCifClient(CifClient cifClient) {
        this.cifClient = cifClient;
    }
}
