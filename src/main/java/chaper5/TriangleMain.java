package chaper5;

import org.testng.Assert;

import java.util.Scanner;

/**
 * @author dongmei.gao
 * @date 2018/10/31 10:04 三角性main函数
 */
public class TriangleMain {

    public static void main(String[] args) {
        try {
            Boolean isQuit = false;
            while (!isQuit) {
                System.out.println("请输入三角性三边（整数以逗号分隔，退出请输入q）：");
                //1、扫描输入
                Scanner scanner = new Scanner(System.in);
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
                TriangleInterface triangleImpl = new TriangleInterfaceImpl();
                BaseResult result = triangleImpl.type(triangle);
                System.out.println(result);
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}