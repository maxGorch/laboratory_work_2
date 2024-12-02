package org.example;

public class FinanceReport
//TODO: Задача №8
// 1. Создайте класс FinanceReport, содержащий массив платежей,
//  ФИО составителя  отчета,
//  дату создания отчета.
// 2. Методы:
// получение количества платежей,
// доступ к i му платежу (на чтение и запись).
{
    Payment[] payments;
    String SNM_creator_payments;
    int date_created_payments;
    FinanceReport(Payment[] payments,String SNM_creator_payments,int date_created_payments)
    {
        this.payments = payments;
        this.SNM_creator_payments = SNM_creator_payments;
        this.date_created_payments = date_created_payments;
    }
    public int getLengthPayments()
    {
        return payments.length;
    }
    public Payment getIndexPayments(int index)
    {
        return payments[index];
    }
    public void setIndexPayments(int index, Payment newPayment)
    {
        payments[index]=newPayment;
    }
}
