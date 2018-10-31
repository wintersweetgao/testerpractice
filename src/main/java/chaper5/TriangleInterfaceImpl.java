package chaper5;

/**
 * @author dongmei.gao
 * @date 2018/10/30 13:31
 */
public class TriangleInterfaceImpl implements TriangleInterface {

    public BaseResult type(Triangle triangle) {
        try {
            if (triangle.edge_a < 1 || triangle.edge_a > 100 ||
                    triangle.edge_b < 1 || triangle.edge_b > 100 ||
                    triangle.edge_c < 1 || triangle.edge_c > 100) {
                System.out.println("输入参数无效");
                return buildResult(true, "无效输入", triangle);
            }


            if (triangle.edge_a + triangle.edge_b <= triangle.edge_c ||
                    triangle.edge_b + triangle.edge_c <= triangle.edge_a ||
                    triangle.edge_a + triangle.edge_c <= triangle.edge_b) {
                System.out.println("输入不构成三角性");
                return buildResult(true, "不能构成三角性", triangle);
            }

            if (triangle.edge_a == triangle.edge_b &&
                    triangle.edge_b == triangle.edge_c) {
                return buildResult(true, "等边三角性", triangle);
            }

            if (triangle.edge_a == triangle.edge_b ||
                    triangle.edge_a == triangle.edge_c ||
                    triangle.edge_b == triangle.edge_c) {
                return buildResult(true, "等腰三角性", triangle);
            }
            return buildResult(true, "一般三角性", triangle);
        } catch (Exception e) {
            return buildResult(false, "程序捕获异常", triangle);
        }

    }

    public BaseResult buildResult(Boolean isSuccess, String str, Triangle triangle) {
        BaseResult result = new BaseResult();
        result.setSuccess(isSuccess);
        result.setContent(str);
        result.setMsg(String.format(str + " a=%3d,b=%3d,c=%3d",
                triangle.edge_a, triangle.edge_b, triangle.edge_c));
        return result;
    }
}
