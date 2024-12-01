package org.example;

import java.util.Scanner;

public class StringProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringProcessor test = new StringProcessor();
        String s = "a";
        int n = 5;
        System.out.println(test.multiplayString(s,n));

        scanner.close();
    }
    public String multiplayString(String s, int n) {
        String result = "";
        if (s == null || n < 0) {
            throw new NullPointerException("Exception: s = null");
        }
        for (int i = 0; i < n; i++) {
            result = result.concat(s);
        }
        return result;
    }
}
