package org.example;


public class StringProcessor {
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
        while ((index = s1.indexOf(s2,index)) != -1) {
            count++;
            index += s2.length();
        }
        return count;
    }
}
