package org.example;

import java.util.Objects;

public class Payment
//TODO: Задача №7
// 1. Создайте класс Payment (платеж) с полями:
//  ФИО человека (одна строка),
//  дата  платежа — число,
//  месяц и год (целые числа),
//  сумма платежа (целое число — сумма  в копейках).
// 2. Напишите необходимые
// конструкторы, геттеры/сеттеры, методы  equals, hashCode, toString.
{
    String  SNM;//  ФИО человека (одна строка),
    int payment_date;//  дата  платежа — число,
    int month;//месяц (целые числа)
    int year;// год (целые числа),
    int payment_amount;//  сумма платежа (целое число — сумма  в копейках).

    public Payment(String SNM,int payment_date,int month,int year,int payment_amount) {
        if(SNM == null || SNM.isEmpty())
        {
            throw new IllegalArgumentException("Ожидалось передача значения для SNM!");
        }
        else this.SNM = SNM;
        if(payment_date <1 || payment_date >31)
        {
            throw new IllegalArgumentException("Дата не должна выходить за пределы 31 или быть меньше 1!");
        }
        else this.payment_date = payment_date;
        if(payment_amount <1)
        {
            throw new IllegalArgumentException("Платеж не может быть отрицательным!");
        }
        else this.payment_amount=payment_amount;
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
    //============Геттеры============
    public String getSNM(){return SNM;}
    public int getPayment_date(){return payment_date;}
    public int getMonth(){return month;}
    public int getYear(){return year;}
    public int getPayment_amount(){return payment_amount;}
    //============Сеттер============
    public void setSNM(String SNM){
        if(SNM == null || SNM.isEmpty())
        {
            throw new IllegalArgumentException("Ожидалось передача значения для SNM!");
        }
        else this.SNM = SNM;
    }
    public void setPayment_date(int payment_date){
        if(payment_date <1 || payment_date >31)
        {
            throw new IllegalArgumentException("Дата не должна выходить за пределы 31 или быть меньше 1!");
        }
        this.payment_date=payment_date;
    }
    public void setYear(int year){
        if(year <1)
        {
            throw new IllegalArgumentException("Год не может быть отрицательным!");
        }
        else this.year=year;
    }
    public void setMonth(int month){
        if(month <1 || month >12)
        {
            throw new IllegalArgumentException("Месяц не должен выходить за пределы 12 или быть меньше 1!");
        }
        else this.month=month;
    }
    public void setPayment_amount(int payment_amount){

        if(payment_amount <1)
        {
            throw new IllegalArgumentException("Платеж не может быть отрицательным!");
        }
        else this.payment_amount=payment_amount;
    }
    //============Метод Equals============

    @Override
    public boolean equals(Object obj) {
        if (obj == this) { // проверка на идентичность
            return true;
        }
        if (!(obj instanceof Payment other)) { // проверка типа объекта
            return false;
        }
        return this.SNM.equals(other.SNM) &&
                this.payment_date == other.payment_date &&
                this.payment_amount == other.payment_amount &&
                this.month == other.month &&
                this.year == other.year; // сравнение содержимого
    }

    //============Метод hashCode============
    //используется для быстрого сравнения.

    @Override
    public int hashCode() {
        return Objects.hash(SNM, payment_date, month,year, payment_amount);
    }

    //============Метод toString============

    @Override
    public String toString() {
        return "[ Плательщик: " + SNM +
                ", дата: " + payment_date +'.' + month +'.' + year +
                ", сумма: " + payment_amount/100 + "руб." + payment_amount%100 +"коп."+"]\n";
    }
}
