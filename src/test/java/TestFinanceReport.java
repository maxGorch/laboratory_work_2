import org.example.FinanceReport;
import org.example.Payment;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestFinanceReport {

@Test
    public void testFinanceReport()
{
    Payment[] arr_payment_zero = new Payment[0];
    Payment[] arr_payment_other = new Payment[1];
    arr_payment_other[0] = new Payment("ГМЮ", 1, 12, 2024, 1500);
    FinanceReport report = new FinanceReport(arr_payment_other,"ГМЮ",15);

    assertThrows(IllegalArgumentException.class, () -> {
        new FinanceReport(arr_payment_zero,null,12);}
    );

    assertThrows(IndexOutOfBoundsException.class, () ->
            {report.setIndexPayments(-1,arr_payment_other[0]);},
            "IndexOutOfBoundsException - Ожидалось что будет положительный индекс"
    );
    assertThrows(IndexOutOfBoundsException.class, () ->
            {report.setIndexPayments(15,arr_payment_zero[0]);},
            "IndexOutOfBoundsException - Ожидалось что будет не превышающий размер индекс"
    );
    assertThrows(IndexOutOfBoundsException.class, () ->
            {report.getIndexPayments(-1);},
            "IndexOutOfBoundsException - Ожидалось что будет положительный индекс"
    );
    assertThrows(IndexOutOfBoundsException.class, () ->
            {report.getIndexPayments(15);},
            "IndexOutOfBoundsException - Ожидалось что будет не превышающий размер индекс"
    );
}
}
