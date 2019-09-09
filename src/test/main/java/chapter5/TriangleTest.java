package chapter5;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import chaper5.BaseResult;
import chaper5.Triangle;
import chaper5.TriangleInterface;
import chaper5.TriangleInterfaceImpl;

/**
 * 三角性测试类
 */
public class TriangleTest {
   /**日志*/
    private static final Logger logger = Logger.getLogger(TriangleTest.class);

    /**
     * 测试方法
     *
     * @param caseId    用例id
     * @param edgeA     三角性边a
     * @param edgeB     三角性边b
     * @param edgeC     三角性边c
     * @param expResult 期望结果
     */
    @Test(dataProvider = "triangle_test_data")
    public void test(final String caseId, final int edgeA, final int edgeB, final int edgeC, final String expResult) {
       logger.info("==========用例开始执行caseId：==========" + caseId);

        Triangle triangle = new Triangle(edgeA, edgeB, edgeC);
        TriangleInterface triangleImpl = new TriangleInterfaceImpl();

        BaseResult result = triangleImpl.type(triangle);
        Assert.assertEquals(result.content, expResult);
        Assert.assertTrue(result.isSuccess);
        logger.info("==========用例执行结束caseId：==========" + caseId);
    }

    /**
     * 测试数据，格式如下 用例id  a    b   c  期望输出
     */
    @DataProvider(name = "triangle_test_data")
    public static Object[][] data() {
        return new Object[][]{
                {"case01", 3, 4, 5, "一般三角性"},
                {"case02", 0, 1, 2, "无效输入"},
                {"case03", 101, 99, 98, "无效输入"},
                {"case04", 1, 0, 2, "无效输入"},
                {"case05", 99, 101, 98, "无效输入"},
                {"case06", 1, 2, 0, "无效输入"},
                {"case07", 99, 98, 101, "无效输入"},
                {"case08", 1, 2, 3, "不能构成三角性"},
                {"case09", 1, 3, 2, "不能构成三角性"},
                {"case10", 3, 1, 2, "不能构成三角性"},
                {"case11", 3, 3, 4, "等腰三角性"},
                {"case12", 4, 3, 3, "等腰三角性"},
                {"case13", 3, 4, 3, "等腰三角性"},
                {"case12", 4, 5, 6, "一般三角性"},
                {"case12", 3, 3, 3, "等边三角性"}};
    }
}
