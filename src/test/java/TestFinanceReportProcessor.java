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
    public void TestGetPaymentsChar()
    {
        expected.add(user_2);
        assertEquals(
                FinanceReportProcessor.getPaymentsChar(new_report,'м'),
                expected,
                "Ожидалось что будет плетельщики начинающиеся с определенной буквы"
                );
        assertThrows()
    }

}
