package org.example;


public class StringProcessor {
    public static void main(String[] args) {
        StringProcessor test = new StringProcessor();
        System.out.println(test.newStringFromOldString("12312"));
    }

    public String multiplyString(String s, int n)
    //Задача №1
    {
        String result = "";
        if (n < 0) {
            throw new IllegalArgumentException("Exception: N < 0 ");
        }
        for (int i = 0; i < n; i++) {
            result = result.concat(s);
        }
        return result;
    }

    public int amountString2intoString1(String s1, String s2)
    //Задача №2
    {
        if (s2 == null || s2.isEmpty()) {
            throw new IllegalArgumentException("Exception: s2 = null");
        }
        int count = 0;
        int index = 0;
        while ((index = s1.indexOf(s2, index)) != -1) {
            count++;
            index += s2.length();
        }
        return count;
    }

    public String newStringFromOldString(String s1)
    //TODO:Задача №3
    // Постройте по строке новую строку, которая получена из исходной заменой
    // каждого  символа '1' на подстроку "один”,
    // символа ‘2’ на подстроку “два” и
    // символа ‘3’ на  подстроку “три”.
    {
        if(s1 == null || s1.isEmpty())
        {
            throw new IllegalArgumentException("Строка s - не задана!");
        }
        else{
            String result = s1.replace("1","один")
                    .replace("2","два")
                    .replace("3","три");
            return result;
        }
    }

}




















