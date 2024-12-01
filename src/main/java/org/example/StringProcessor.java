package org.example;


public class StringProcessor {

    public String multiplyString(String s, int n) {
        String result = "";
        if (n < 0) {
            throw new IllegalArgumentException("Exception: N < 0 ");
        }
        for (int i = 0; i < n; i++) {
            result = result.concat(s);
        }
        return result;
    }
}
