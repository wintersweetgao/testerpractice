package chaper5;

import java.io.Serializable;

/**
 * @author dongmei.gao
 * @date 2018/10/30 13:28 结果类
 */
public class BaseResult {

    /**
     * 是否成功
     */
    public Boolean isSuccess;
    /**
     * 消息字符串
     */
    public String msg;
    /**
     * 类型返回：等腰三角性，等边三角形，一般三角性，不能构成三角性，无效输入
     */
    public String content;

    @Override
    public String toString() {
        return "BaseResult{" +
                "isSuccess=" + isSuccess +
                ", content='" + content + '\'' +
                '}';
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {//NOPMD
        this.msg = msg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {//NOPMD
        this.content = content;
    }
}
