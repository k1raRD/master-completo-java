package com.k1rard.codewars;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidBraces {

    public static void main(String[] args) {
        System.out.println(isValid("[(])" ));
    }

    private static boolean isValid(String braces) {

        int lengthOfBraces = braces.length();
        for(int i = 0; i < lengthOfBraces; i++){
            braces = braces.replace("{}", "").replace("[]", "").replace("()", "");
        }
        return braces.isEmpty();
    }
}
