import org.example.Payment;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertEquals;

public class TestPayment {
@Test
    public void testPayment()
    {
        Payment new_payment = new Payment("ГМЮ", 1, 12,2024,1500);
        assertEquals(
                "Нужно задать имя и все основные цифры для подачи документа",
                new_payment.toString(),
                "[ Плательщик: ГМЮ" +
                ", дата: 1.12.2024" +
                ", сумма: 15руб." + "0коп."+"]"
        );

        assertThrows(IllegalArgumentException.class, () -> {
            new Payment("ГМЮ", -1, 12, 2024, 1500); // дата < 1
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Payment("ГМЮ", 1, 13, 2024, 1500); // месяц > 12
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Payment("ГМЮ", 1, 12, -2024, 1500); // год < 1
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Payment("ГМЮ", 1, 12, 2024, -1500); // сумма < 1
        });


        assertThrows(IllegalArgumentException.class,()->{
            new_payment.setSNM("");
        },"IllegalArgumentException при передаче empty строки");

        assertThrows(IllegalArgumentException.class,()->{
            new_payment.setSNM(null);
        },"IllegalArgumentException при передаче null строки");

        assertThrows(IllegalArgumentException.class,()->{
            new_payment.setPayment_date(-1);
        },"IllegalArgumentException при передаче в Дату значения меньше 1 ");
        assertThrows(IllegalArgumentException.class,()->{
            new_payment.setPayment_date(32);
        },"IllegalArgumentException при передаче в Дату значения больше 31 ");

        assertThrows(IllegalArgumentException.class,()->{
            new_payment.setMonth(-1);
        },"IllegalArgumentException при передаче в Месяц значения меньше 1 ");
        assertThrows(IllegalArgumentException.class,()->{
            new_payment.setPayment_date(32);
        },"IllegalArgumentException при передаче в Месяц значения больше 12 ");

        assertThrows(IllegalArgumentException.class,()->{
            new_payment.setPayment_amount(-1);
        },"IllegalArgumentException при передаче в Сумму платежа значения меньше 1 ");

        assertThrows(IllegalArgumentException.class,()->{
            new_payment.setYear(-1);
        },"IllegalArgumentException при передаче в Год значения меньше 1 ");
    }

}
