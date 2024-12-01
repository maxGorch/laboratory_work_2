import org.example.StringProcessor;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertEquals;

public class TestTask {

        @Test
    public void TestMultiplyString()
            // Для задачи №1
    {
       StringProcessor test = new StringProcessor();
       assertEquals(
               "Строчка должна повториться N кол-во раз",
               test.multiplyString("A",5),
               "AAAAA"
       );
        assertEquals(
                "Строчка должна быть пустой",
                test.multiplyString("A",0),
                ""
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> {
            test.multiplyString("AAAA", -1);
        }
        );
    }
@Test
    public void TestAmountString2intoString1()
    {
        StringProcessor test = new StringProcessor();
        assertEquals(
                "В строчке должно быть заданое кол-во подстрок",
                test.amountString2intoString1("hellohello","hello"),
                2
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    // Код, который должен выбросить исключение
                    test.amountString2intoString1("hello", null);
                }
        );
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    // Код, который должен выбросить исключение
                    test.amountString2intoString1("hello", "");
                }
        );
    }
}
