package chapter7;

/**
 * @author dongmei.gao
 * @date 2018/11/20 10:57
 */
public class UserInf {
    /**用户id*/
    public String userId ;
    /**用户名字*/
    public String name ;
    /**用户年龄*/
    public int age ;


    @Override
    public String toString() {
        return "UserInf{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
