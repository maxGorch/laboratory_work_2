import org.example.FinanceReport;
import org.example.FinanceReportProcessor;
import org.example.Payment;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestFinanceReportProcessor {
    Payment user_1 = new Payment("Илья",12,2,2000,15345);
    Payment user_2 = new Payment("Максим",25,4,2014,352345);
    Payment user_3 = new Payment("Иван",5,6,2020,5435);

    Payment[] payments = {user_1, user_2, user_3};
    FinanceReport new_report = new FinanceReport(payments,"Максим Юрьевич", 8,12,2024);

    List<Payment> expected = new ArrayList<>();

    @Test
    public void TestGetPaymentsChar() {

       expected.add(user_2);

        assertEquals(
                FinanceReportProcessor.getPaymentsChar(new_report,'М'),
                expected,
                "Должно быть выведены Платежи у которых ФИО начинается с конкретной буквы"
                );

        assertThrows(IllegalArgumentException.class, () ->
                //Проверка на значение объекта null

                FinanceReportProcessor.getPaymentsChar(null,'И'), "Expected: что передаваемый объект не null!");
        assertThrows(IllegalArgumentException.class, () ->
                //Проверка на значение символа isEmpty
                FinanceReportProcessor.getPaymentsChar(new_report,'\u0000'), "Expected: что передаваемый символ пуст!");
    }

    @Test
    public void TestGetPaymentsOnMinPayment() {

        expected.add(user_1);
        expected.add(user_3);

        assertEquals(
                FinanceReportProcessor.getPaymentsOnMinPayment(new_report,100000),
                expected,
                "Должно быть выведены Платежи у которых задолженность меньше указанной суммы"
                );

        assertThrows(IllegalArgumentException.class, () ->
                //Проверка на значение объекта null
                FinanceReportProcessor.getPaymentsOnMinPayment(null,'И'), "Expected: что передаваемый объект не null!");
        assertThrows(IllegalArgumentException.class, () ->
                //Проверка на значение символа isEmpty
                FinanceReportProcessor.getPaymentsOnMinPayment(new_report,-10000), "Expected: что передаваемый символ пуст!");
    }

}
