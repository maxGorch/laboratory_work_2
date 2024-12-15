import org.example.FinanceReport;
import org.example.FinanceReportProcessor;
import org.example.Payment;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertEquals;

public class TestFinanceReportProcessor {
    Payment user_1 = new Payment("Илья", 12, 2, 2000, 15345);
    Payment user_2 = new Payment("Максим", 25, 4, 2014, 352345);
    Payment user_3 = new Payment("Иван", 5, 6, 2020, 5435);

    Payment[] payments = {user_1, user_2, user_3};
    FinanceReport new_report = new FinanceReport(payments, "Максим Юрьевич",8,12,2024);

    @Test
    public void TestGetPaymentsChar() {

        Payment[] expected = {user_2};

        assertEquals(
                "Должно быть выведены Платежи у которых ФИО начинается с конкретной буквы",
                FinanceReportProcessor.getPaymentsChar(new_report,'М'),
                expected
        );

        assertThrows(IllegalArgumentException.class, () ->
                //Проверка на значание объекта null

            FinanceReportProcessor.getPaymentsChar(null,'И'), "Expected: что передаваемый объект не null!");
        assertThrows(IllegalArgumentException.class, () ->
                //Проверка на значание символа isEmpty
                FinanceReportProcessor.getPaymentsChar(new_report,'\u0000'), "Expected: что передаваемый символ пуст!");
    }

    @Test
    public void TestGetPaymentsOnMinPayment() {

        Payment[] expected = {user_1,user_3};

        assertEquals(
                "Должно быть выведены Платежи у которых задолженность меньше указанной суммы",
                FinanceReportProcessor.getPaymentsOnMinPayment(new_report,100000),
                expected
        );

        assertThrows(IllegalArgumentException.class, () ->
                //Проверка на значание объекта null
                FinanceReportProcessor.getPaymentsOnMinPayment(null,'И'), "Expected: что передаваемый объект не null!");
        assertThrows(IllegalArgumentException.class, () ->
                //Проверка на значание символа isEmpty
                FinanceReportProcessor.getPaymentsOnMinPayment(new_report,-10000), "Expected: что передаваемый символ пуст!");
    }
}
