import com.beto.test.json.Data;
import com.beto.test.json.parserJsonParserFromUrl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by energetic on 22.07.2016.
 */
public class TestJson {

    @Test
    public void test1() throws Exception {
        System.out.println("*****************************\n" +
                "URL: https://jsonplaceholder.typicode.com/posts/1");
        Data data = parserJsonParserFromUrl.getData("https://jsonplaceholder.typicode.com/posts/1");

        System.out.println("result: \n" + data);
//        System.out.println("*****************************");
//        String s = data.toString();
//        String[] s1 = s.split(",");
//        List<String> s2 = new ArrayList<String>();
//        for (String a : s1){
//            String b = a + "\n";
//            s2.add(b);
//        }
//        System.out.println(s2);
    }
    @Test
    public void testList() throws Exception {
        System.out.println("*****************************\n" +
                "URL: https://jsonplaceholder.typicode.com/posts");
        List<Data> dataList = parserJsonParserFromUrl.getDataList("https://jsonplaceholder.typicode.com/posts");

        System.out.println("result: \n" + dataList);
        String s = "Hel,lo";
        String[] s1 = s.split(",");
        System.out.println(Arrays.toString(s1));
    }
}
