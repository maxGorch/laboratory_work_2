package org.example;


import com.sun.nio.sctp.IllegalReceiveException;

public class FinanceReport
//TODO: Задача №8
// 1. Создайте класс FinanceReport, содержащий массив платежей,
//  ФИО составителя  отчета,
//  дату создания отчета.
// 2. Методы:
// получение количества платежей,
// доступ к i му платежу (на чтение и запись).
{
    public static void main(String[] args) {
        FinanceReport new_report;
        Payment user_1 = new Payment("Не изменялось",12,2,2000,15345);
        Payment user_2 = new Payment("Не изменялось",25,4,2014,352345);
        Payment user_3 = new Payment("Не изменялось",5,6,2020,5435);

        Payment[] payments = {user_1, user_2, user_3};
        new_report = new FinanceReport(payments,"Максим Юрьевич", 8,12,2024);

        FinanceReport COPY_new_report = new FinanceReport(new_report);

        user_1.setSNM("Изменение");

        String old_str_report = new_report.toString();
        String new_str_report = COPY_new_report.toString();
        System.out.println(old_str_report);
        System.out.println(new_str_report);

    }
    Payment[] payments;
    String SNM_creator_payments;
    int payment_date;//  дата  платежа — число,
    int month;//месяц (целые числа)
    int year;// год (целые числа),
    public FinanceReport(Payment[] payments,String SNM_creator_payments,int payment_date,int month,int year)
    {
        if(payments == null || payments.length ==0)
        {
            throw new IllegalArgumentException("Массив не может быть не инициализирован и его длина должна быть больше 0!");
        }else this.payments = payments;
        if(SNM_creator_payments == null || SNM_creator_payments.isEmpty())
        {
            throw new IllegalArgumentException("Строчка должна быть не null и не быть пустой!");
        }else this.SNM_creator_payments = SNM_creator_payments;
        if(payment_date <1 || payment_date >31)
        {
            throw new IllegalArgumentException("Дата не должна выходить за пределы 31 или быть меньше 1!");
        }
        else this.payment_date = payment_date;
        if(month <1 || month >12)
        {
            throw new IllegalArgumentException("Месяц не должен выходить за пределы 12 или быть меньше 1!");
        }
        else this.month=month;
        if(year <1)
        {
            throw new IllegalArgumentException("Год не может быть отрицательным!");
        }
        else this.year=year;
    }
    public FinanceReport (FinanceReport obj)
    //TODO: Задание №10
    // Добавьте конструктор копирования (после создания копии массива при изменении
    // данных в объектах исходного массива
    // копия изменяться не должна).
    {
        if(obj == null)
        {
            throw new NullPointerException("Должен был передаться массив платежей!");
        }
        else{
            Payment[] new_payments = new Payment[obj.getLengthPayments()];
            Payment old_payment;
            for (int i = 0; i < new_payments.length; i++) {
                old_payment = obj.getIndexPayments(i);
                new_payments[i] = new Payment(
                        old_payment.getSNM(),
                        old_payment.getPayment_date(),
                        old_payment.getMonth(),
                        old_payment.getYear(),
                        old_payment.getPayment_amount()
                );

            }
            if(obj.getLengthPayments() <=-1)
            {
                throw new IllegalReceiveException("Ожидалось что длина массива будет полоительна!");
            }else this.payments = new_payments;
            if(obj.getSNM_creator_payments() == null || obj.getSNM_creator_payments().isEmpty())
            {
                throw new IllegalArgumentException("Строчка должна быть не null и не быть пустой!");
            }else this.SNM_creator_payments = obj.getSNM_creator_payments();
            if(obj.getPayment_date() <1 || obj.getPayment_date() >31)
            {
                throw new IllegalArgumentException("Дата не должна выходить за пределы 31 или быть меньше 1!");
            }
            else this.payment_date = obj.getPayment_date();
            if(obj.getMonth() <1 || obj.getMonth() >12)
            {
                throw new IllegalArgumentException("Месяц не должен выходить за пределы 12 или быть меньше 1!");
            }
            else this.month=obj.getMonth();
            if(obj.getYear() <1)
            {
                throw new IllegalArgumentException("Год не может быть отрицательным!");
            }
            else this.year = obj.getYear();
        }
    }

    public void setIndexPayments(int index, Payment newPayment)
    {
        if(index < 0)
        {
            throw new IndexOutOfBoundsException("i-элемент должен быть больше нуля и не превышать значения основного массива!");
        }else payments[index]=newPayment;
    }

    public void setSNM_creator_payments(String SNM_creator_payments) {
        this.SNM_creator_payments = SNM_creator_payments;
    }

    public void setPayment_date(int payment_date) {
        this.payment_date = payment_date;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getLengthPayments()
    {
        return payments.length;
    }
    public Payment getIndexPayments(int index)
    {
        if(index < 0)
        {
            throw new IndexOutOfBoundsException("i-элемент должен быть больше нуля и не превышать значения основного массива!");
        }else return payments[index];
    }

    public String getSNM_creator_payments() {
        return SNM_creator_payments;
    }

    public int getPayment_date() {
        return payment_date;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
@Override
    public String toString()
    //TODO: Задача №9
    // Добавьте в FinanceReport метод toString,
    // который преобразует отчет в набор строк  формата (используйте String.format):
    // [Автор: ФИО составителя, дата: дата.создания, Платежи: [
    // Плательщик: ФИО, дата: день.месяц.год сумма: *** руб. ** коп.\n,
    // Плательщик: ФИО, дата: день.месяц.год сумма: *** руб. ** коп.\n,… ]]
    {
        StringBuilder str_payments = new StringBuilder();
        for(Payment i: payments)
        {
            if(i == null)
            {
                throw new NullPointerException("Массив не может быть не инициализирован и его длина должна быть больше 0!");
            }else str_payments.append(i);
        }
        return "[Автор: ФИО составителя " + this.SNM_creator_payments + '\'' +
                ", дата: " + this.payment_date +'.' + this.month +'.' + this.year +
                ", Платежи: [ \n" + str_payments +
                "]";
    }
}
