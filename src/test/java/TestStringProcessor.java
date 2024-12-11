import org.example.StringProcessor;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertEquals;

public class TestStringProcessor {

    @Test
    public void TestMultiplyString()
    {
        StringProcessor test = new StringProcessor();
        assertEquals(
                "Строчка должна повториться N кол-во раз",
                test.multiplyString("A", 5),
                "AAAAA"
        );
        assertEquals(
                "Строчка должна быть пустой",
                test.multiplyString("A", 0),
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
                test.amountString2intoString1("hellohello", "hello"),
                2
        );
        assertEquals(
                "В строчке должно быть заданое кол-во подстрок",
                test.amountString2intoString1("ababababa", "aba"),
                //Доделать пересечение в подстроках +
                4
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
    @Test
    public void TestNewStringFromOldString()
    {
        StringProcessor test = new StringProcessor();
        assertEquals(
                "В строке должна быть строчка состоящая из 1 || 2 || 3",
                test.newStringFromOldString("123 123"),
                "одиндватри одиндватри"
        );

        assertThrows(IllegalArgumentException.class, () -> {
            test.newStringFromOldString(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            test.newStringFromOldString("");
        });
    }
    @Test
    public void TestModificationStringBuilder()
    {
        StringProcessor test = new StringProcessor();
        StringBuilder sb_test_1 = new StringBuilder("abc defg");
        StringBuilder sb_test_2 = new StringBuilder("abcde");
        StringBuilder sb_test_3 = new StringBuilder("a");
        test.modificationStringBuilder(sb_test_1);
        assertEquals(
                sb_test_1.toString(),
                "acdf"
        );
        test.modificationStringBuilder(sb_test_2);
        assertEquals(
                sb_test_2.toString(),
                "ace"
        );
        test.modificationStringBuilder(sb_test_3);
        assertEquals(
                sb_test_3.toString(),
                "a"
        );
        assertThrows(IllegalArgumentException.class, () -> {
            test.modificationStringBuilder(null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            test.modificationStringBuilder(new StringBuilder());
        });
    }
}
