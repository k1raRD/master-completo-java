package com.k1rard.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class StringLastWar {
    public static void main(String[] args) {
//        System.out.println(solution("samurai", "ai"));
//        System.out.println(disemvowel("This website is for losers LOL!"));
//        System.out.println(points(new String[] {"1:0","2:0","3:0","4:0","2:1","3:1","4:1","3:2","4:2","4:3"}));
        System.out.println(jadenChallenge("How can mirrors be real if our eyes aren't real"));

    }

    public static boolean solution(String str, String ending) {
        return str.endsWith(ending);
    }

    public static String disemvowel(String str) {
        // Code away...
        return  str.replaceAll("[aeiouAEIOU]", "");
    }

    public static String convert(boolean b) {
        return String.valueOf(b);
    }

    public static int summation(int n) {
        return IntStream.rangeClosed(1, n).sum();
    }

    public static int points(String[] games) {
        //implement me
        int result = 0;
        for(String s : games){
            int x = Integer.parseInt(s.substring(0, 1));
            int y = Integer.parseInt(s.substring(2));
            result += x > y ? 3 : x == y ? 1 : 0;
        }
        return result;
    }

    public static String jadenChallenge(String phrase){
        if(phrase != null && !phrase.isEmpty()){
            String[] palabras = phrase.split(" ");
            StringBuilder sb = new StringBuilder();
            for(String p : palabras){
                Character b = p.toLowerCase().charAt(0);
                sb.append(b.toString().toUpperCase() + p.toLowerCase().substring(1))
                        .append(" ");
            }
            return sb.toString().trim();
        }
        return phrase;
    }
}
