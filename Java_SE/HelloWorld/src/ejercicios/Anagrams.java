package ejercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagrams {
    public static void main(String[] args) {
        System.out.println(anagrams("cde", "abc"));
    }

    public static int anagrams(String s1, String s2) {

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (char c : s1.toCharArray()) {
            count1[c - 'a']++;
        }

        for (char c : s2.toCharArray()) {
            count2[c - 'a']++;
        }

        int deletions = 0;
        for (int i = 0; i < 26; i++) {
            deletions += Math.abs(count1[i] - count2[i]);
        }

        return deletions;
    }
}
