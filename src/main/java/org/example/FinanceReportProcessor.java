package org.example;


import java.util.ArrayList;
import java.util.List;

public class FinanceReportProcessor
// TODO: Задание №11
//  Создайте новый класс FinanceReportProcessor, в котором реализуйте статические  методы,
//  все методы возвращают объект класса FinanceReport:
//  1) получение платежей всех людей, чья фамилия начинается на указанный символ  (символ — входной параметр),
//  2) получение всех платежей, размер которых меньше заданной величины.
{
    public static void main(String[] args) {
        FinanceReport new_report;
        Payment user_1 = new Payment("Илья",12,2,2000,15345);
        Payment user_2 = new Payment("Максим",25,4,2014,352345);
        Payment user_3 = new Payment("Иван",5,6,2020,5435);

        Payment[] payments = {user_1, user_2, user_3};
        new_report = new FinanceReport(payments,"Максим Юрьевич", 8,12,2024);


        String old_str_report = new_report.toString();
        System.out.println(old_str_report);

        List<Payment> valuePayments = FinanceReportProcessor.getPaymentsChar(new_report,'м');
        int id1 = 1;
        for (Payment i : valuePayments)
        {
            System.out.println("№"+ id1++ +" Начинается следующий плательщик: \t"+i);
        }
        System.out.println();
        List<Payment> minPayments = FinanceReportProcessor.getPaymentsOnMinPayment(new_report,100000);
        int id2 = 1;
        for (Payment i : minPayments)
        {
            System.out.println("№"+ id2++ +" Начинается следующий плательщик: \t"+i);
        }
    }


    public static List<Payment> getPaymentsChar(FinanceReport obj, char user_char)
    {

        List <Payment> paymentStartChar = new ArrayList<>();

        Payment old_payment;
        String str_forPaymentChar = "";
        for (int i = 0; i < obj.getLengthPayments(); i++)
        {
            old_payment = obj.getIndexPayments(i);
            str_forPaymentChar = old_payment.getSNM();
            if(str_forPaymentChar.startsWith(String.valueOf(user_char).toUpperCase()))
            {
                paymentStartChar.add(old_payment);
            }

        }
        return paymentStartChar;
    }
    public static List<Payment> getPaymentsOnMinPayment(FinanceReport obj, int user_payment)
    {
        Payment old_payment;
        int int_forMinPayment;
        List <Payment> paymentsOnMinPayment = new  ArrayList<>();
        for (int i = 0; i < obj.getLengthPayments(); i++)
        {
            old_payment = obj.getIndexPayments(i);
            int_forMinPayment = old_payment.getPayment_amount();
            if(int_forMinPayment<user_payment)
            {
                paymentsOnMinPayment.add(obj.getIndexPayments(i));
            }

        }
        return paymentsOnMinPayment;
    }
}
