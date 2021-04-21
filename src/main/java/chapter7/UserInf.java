package chapter7;

import java.io.Serializable;

/**
 * @author dongmei.gao
 * @date 2018/11/20 10:57
 */
public class UserInf implements Serializable{

    private static final long serialVersionUID = 185894756693583992L;
    /**用户id*/
    private String userId ;
    /**用户名字*/
    private String name ;
    /**用户年龄*/
    private int age ;


    @Override
    public String toString() {
        return "UserInf{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    /**
     * 构造体
     * @param userId 用户id
     * @param name  姓名
     * @param age 年龄
     */
    public UserInf(final String userId, final String name, final int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
    }
}
