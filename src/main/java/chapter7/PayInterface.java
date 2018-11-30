package chapter7;

/**
 * @author dongmei.gao
 * @date 2018/11/20 10:54
 */
public interface PayInterface {
    /**
     * 支付
     * @param userId 用户id
     * @return  返回是否支付成功
     */
    public boolean pay(String userId);
}
