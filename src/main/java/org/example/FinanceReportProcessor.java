package org.example;


public class FinanceReportProcessor
// TODO: Задание №11
//  Создайте новый класс FinanceReportProcessor, в котором реализуйте статические  методы,
//  все методы возвращают объект класса FinanceReport:
{
    public static void main(String[] args) {
        FinanceReport new_report;
        Payment user_1 = new Payment("Илья", 12, 2, 2000, 15345);
        Payment user_2 = new Payment("Максим", 25, 4, 2014, 352345);
        Payment user_3 = new Payment("Иван", 5, 6, 2020, 5435);

        Payment[] payments = {user_1, user_2, user_3};
        new_report = new FinanceReport(payments, "Максим Юрьевич", 8, 12, 2024);


        String old_str_report = new_report.toString();
        System.out.println(old_str_report);

        Payment[] valuePayments = null,
                minPayments = null;
        try {
            valuePayments = FinanceReportProcessor.getPaymentsChar(new_report,'И');
            minPayments = FinanceReportProcessor.getPaymentsOnMinPayment(new_report, 100000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            int id1 = 1;
            assert valuePayments != null;
            System.out.println("Метод getPaymentsChar:");
            for (Payment i : valuePayments) {
                System.out.println("№" + id1++ + " Начинается следующий плательщик: \t" + i);
            }
            int id2 = 1;
            assert minPayments != null;
            System.out.println("Метод getPaymentsOnMinPayment:");
            for (Payment i : minPayments) {
                System.out.println("№" + id2++ + " Начинается следующий плательщик: \t" + i);
            }
        }
    }


    public static Payment[] getPaymentsChar(FinanceReport obj, char user_char)
    //TODO:1) получение платежей всех людей, чья фамилия начинается на указанный символ  (символ — входной параметр),
    {
        if (obj == null || user_char == '\u0000') {
            throw new IllegalArgumentException("Expected: obj == null" +
                    " or user_char is Empty");
        } else {
            Payment old_payment;
            String str_forPaymentChar;
            int counter1 = 0;
            for (int i = 0; i < obj.getLengthPayments(); i++) {
                if (i > obj.getLengthPayments()) {
                    throw new ArrayIndexOutOfBoundsException("Index in obj.length() вышел за пределы!");
                } else {
                    old_payment = obj.getIndexPayments(i);
                    str_forPaymentChar = old_payment.getSNM();
                    if (str_forPaymentChar.startsWith(String.valueOf(user_char).toUpperCase())) {
                        counter1++;
                    }
                }
            }
            Payment[] paymentStartChar = new Payment[counter1];
            int counter2 = 0;
            for (int i = 0; i < obj.getLengthPayments(); i++) {
                if (i > obj.getLengthPayments()) {
                    throw new ArrayIndexOutOfBoundsException("Index in obj.length() вышел за пределы!");
                } else {
                    old_payment = obj.getIndexPayments(i);
                    str_forPaymentChar = old_payment.getSNM();
                    if (str_forPaymentChar.toUpperCase().startsWith(String.valueOf(user_char).toUpperCase())) {
                        paymentStartChar[counter2++] = obj.getIndexPayments(i);
                    }
                }
            }
            return paymentStartChar;
        }
    }

    public static Payment[] getPaymentsOnMinPayment(FinanceReport obj, int user_payment)
    //TODO:2) получение всех платежей, размер которых меньше заданной величины.
    {
        if (obj == null || user_payment < 0) {
            throw new IllegalArgumentException("Expected: obj == null" +
                    " or user_payment <0");
        } else {
            Payment old_payment;
            int int_forMinPayment;
            int counter1 = 0;
            for (int i = 0; i < obj.getLengthPayments(); i++) {
                if (i > obj.getLengthPayments()) {
                    throw new ArrayIndexOutOfBoundsException("Index in obj.length() вышел за пределы!");
                } else {
                    old_payment = obj.getIndexPayments(i);
                    int_forMinPayment = old_payment.getPayment_amount();
                    if (int_forMinPayment < user_payment) {
                        counter1++;
                    }
                }
            }
            Payment[] paymentsOnMinPayment = new Payment[counter1];
            int counter2 = 0;
            for (int i = 0; i < obj.getLengthPayments(); i++) {
                if (i > obj.getLengthPayments()) {
                    throw new ArrayIndexOutOfBoundsException("Index in obj.length() вышел за пределы!");
                } else {
                    old_payment = obj.getIndexPayments(i);
                    int_forMinPayment = old_payment.getPayment_amount();
                    if (int_forMinPayment < user_payment) {
                        paymentsOnMinPayment[counter2++] = obj.getIndexPayments(i);
                    }
                }
            }
            return paymentsOnMinPayment;
        }
    }
}
