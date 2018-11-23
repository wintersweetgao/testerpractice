package chaper5;

import org.apache.log4j.Logger;
import org.testng.Assert;

import java.util.Scanner;

/**
 * @author dongmei.gao
 * @date 2018/10/31 10:04 三角性main函数
 */
public class TriangleMain {
    /**日志*/
    private static final Logger logger = Logger.getLogger(TriangleMain.class);

    /**
     * 主程序
     * @param args
     */
    public static void main(String[] args) {
        Boolean isQuit = false;
        //1、扫描输入
        Scanner scanner = new Scanner(System.in);
        TriangleInterface triangleImpl = new TriangleInterfaceImpl();

        try {
            while (!isQuit) {
                logger.info("请输入三角性三边（整数以逗号分隔，退出请输入q）：");
                String edges = scanner.nextLine();
                if (edges.startsWith("q")) {
                    isQuit = true;
                    break;
                }
                //2、输入拆分
                String[] edgeArray = edges.split(",");
                Assert.assertTrue(edgeArray.length == 3);
                // 3、调用方法
                Triangle triangle = new Triangle(Integer.parseInt(edgeArray[0]),
                        Integer.parseInt(edgeArray[1]), Integer.parseInt(edgeArray[2]));

                BaseResult result = triangleImpl.type(triangle);
                logger.info(result);
            }
        } catch (Exception e) {
            logger.error("捕获异常",e);
        }
    }
}