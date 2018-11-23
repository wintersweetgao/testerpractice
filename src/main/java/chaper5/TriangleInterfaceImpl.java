package chaper5;

import org.apache.log4j.Logger;

/**
 * @author dongmei.gao
 * @date 2018/10/30 13:31
 */
public class TriangleInterfaceImpl implements TriangleInterface {
    /**日志*/
    private static final Logger logger = Logger.getLogger(TriangleInterfaceImpl.class);

    /**
     * 判定三角形类型
     * @param triangle 输入
     * @return 结果
     */
    public BaseResult type(Triangle triangle) {
        try {
            if (triangle.edgeA < 1 || triangle.edgeA > 100 ||
                    triangle.edgeB < 1 || triangle.edgeB > 100 ||
                    triangle.edgeC < 1 || triangle.edgeC > 100) {
                logger.warn("输入参数无效");
                return buildResult(true, "无效输入", triangle);
            }


            if (triangle.edgeA + triangle.edgeB <= triangle.edgeC ||
                    triangle.edgeB + triangle.edgeC <= triangle.edgeA ||
                    triangle.edgeA + triangle.edgeC <= triangle.edgeB) {
                logger.warn("输入不构成三角性");
                return buildResult(true, "不能构成三角性", triangle);
            }

            if (triangle.edgeA == triangle.edgeB &&
                    triangle.edgeB == triangle.edgeC) {
                return buildResult(true, "等边三角性", triangle);
            }

            if (triangle.edgeA == triangle.edgeB ||
                    triangle.edgeA == triangle.edgeC ||
                    triangle.edgeB == triangle.edgeC) {
                return buildResult(true, "等腰三角性", triangle);
            }
            return buildResult(true, "一般三角性", triangle);
        } catch (Exception e) {
            return buildResult(false, "程序捕获异常", triangle);
        }

    }

    /**
     * 构建结果
     * @param isSuccess 是否成功
     * @param str       信息字符串
     * @param triangle  三角形对象
     * @return
     */
    public BaseResult buildResult(Boolean isSuccess, String str, Triangle triangle) {
        BaseResult result = new BaseResult();
        result.setSuccess(isSuccess);
        result.setContent(str);
        result.setMsg(String.format(str + " a=%3d,b=%3d,c=%3d",
                triangle.edgeA, triangle.edgeB, triangle.edgeC));
        return result;
    }
}
