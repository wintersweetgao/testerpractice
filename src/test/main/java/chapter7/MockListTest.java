package chapter7;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import java.util.LinkedList;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author dongmei.gao
 * @date 2018/11/20 9:33
 * @link https://site.mockito.org/
 */
public class MockListTest {
   /**日志*/
    private static final Logger logger = Logger.getLogger(MockListTest.class);
    /**
     * 目的是验证交互，添加和清理过list
     */
    @Test
    public void listMockTest() {
        // mock creation
        List mockedList = mock(List.class);
        // using mock object - it does not throw any "unexpected interaction" exception
        mockedList.add("one");
        mockedList.clear();

        // selective, explicit, highly readable verification
        //选择的，明确，高可读形验证
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    /**
     * 插桩测试
     */
    @Test
    public void stubMockTest(){
        // you can mock concrete classes, not only interfaces
        LinkedList mockedList = mock(LinkedList.class);

        // stubbing appears before the actual execution
        when(mockedList.get(0)).thenReturn("first");

        // the following prints "first"
        logger.info(mockedList.get(0));

        // the following prints "null" because get(999) was not stubbed
        logger.info(mockedList.get(999));
    }
}
