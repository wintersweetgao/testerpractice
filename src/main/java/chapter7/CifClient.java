package chapter7;

/**
 * @author dongmei.gao
 * @date 2018/11/20 10:55
 */
public interface CifClient {
    /**
     * 查询用户
     * @param userId
     * @return 用户信息
     */
     UserInf userQuery(String userId);
}
