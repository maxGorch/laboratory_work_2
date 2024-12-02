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
    public FinanceReport(Payment[] payments,String SNM_creator_payments,int date_created_payments)
    {
        if(payments == null || payments.length ==0)
        {
            throw new IllegalArgumentException("Массив не может быть не инициализирован и его длина должна быть больше 0!");
        }else this.payments = payments;
        if(SNM_creator_payments == null || SNM_creator_payments.isEmpty())
        {
            throw new IllegalArgumentException("Строчка должна быть не null и не быть пустой!");
        }else this.SNM_creator_payments = SNM_creator_payments;
        this.date_created_payments = date_created_payments;
    }
    public int getLengthPayments()
    {
        return payments.length;
    }
    public Payment getIndexPayments(int index)
    {
        if(index < 0 || index > payments.length)
        {
            throw new IndexOutOfBoundsException("i-элемент должен быть больше нуля и не превышать значения основного массива!");
        }else return payments[index];
    }
    public void setIndexPayments(int index, Payment newPayment)
    {
        if(index < 0 || index > payments.length)
        {
            throw new IndexOutOfBoundsException("i-элемент должен быть больше нуля и не превышать значения основного массива!");
        }else payments[index]=newPayment;
    }
}
