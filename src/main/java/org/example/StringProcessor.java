package org.example;


public class StringProcessor {
    public String multiplyString(String s, int n)
    //TODO: Задача №1
    // На входе строка s и целое число N.
    // Выход — строка, состоящая из N копий строки s, записанных подряд.
    // При N = 0 результат — пустая строка.
    // При N < 0 выбрасывается  исключение.
    {
        if (n < 0) {
            throw new IllegalArgumentException("Exception: N < 0 ");
        }
        else
        {
            String result = "";
            for (int i = 0; i < n; i++) {
                result = result.concat(s);
            }
            return result;
        }
    }

    public int amountString2intoString1(String s1, String s2)
    //TODO: Задача №2
    // На входе две строки. Результат — количество вхождений второй строки в первую.
    // Если вторая строка пустая или null, выбросить исключение.
    {
        if (s2 == null || s2.isEmpty()) {
            throw new IllegalArgumentException("Exception: s2 = null");
        }
        else{
            int count = 0;
            int index = 0;
            while ((index = s1.indexOf(s2, index)) != -1) {
                count++;
                index++;
            }
            return count;
        }
    }

    public String newStringFromOldString(String s1)
    //TODO:Задача №3
    // Постройте по строке новую строку, которая получена из исходной заменой
    // каждого  символа '1' на подстроку "один”,
    // символа ‘2’ на подстроку “два” и
    // символа ‘3’ на  подстроку “три”.
    {
        if (s1 == null || s1.isEmpty()) {
            throw new IllegalArgumentException("Строка s - не задана!");
        } else {
            String result = s1.replace("1", "один")
                    .replace("2", "два")
                    .replace("3", "три");
            return result;
        }
    }

    public void modificationStringBuilder(StringBuilder s1)
    //TODO:Задача №4
    // В строке типа StringBuilder удалите каждый второй по счету символ.
    // Должна быть  модифицирована входная строка, а не порождена новая.
    {
        if (s1 == null || s1.isEmpty()) {
            throw new IllegalArgumentException("Ожидалось что строка будет не пуста!");
        } else {
            for (int i = 1; i < s1.length(); i++) {
                s1.delete(i, i + 1);
            }
        }
    }
}




















