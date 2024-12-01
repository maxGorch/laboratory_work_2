import org.example.StringProcessor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTask {

    @Test
    public void TestMultiplyString()
    {
       StringProcessor test = new StringProcessor();
       assertEquals("Строчка должна повториться N кол-во раз",test.multiplyString("A",5),"AAAAA");
        assertEquals("Строчка должна быть пустой",test.multiplyString("A",0),"");
    }
}
