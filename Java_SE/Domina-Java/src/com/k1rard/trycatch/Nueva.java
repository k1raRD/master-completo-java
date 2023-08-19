package com.k1rard.trycatch;
import java.util.Scanner;

public class Nueva {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.nextLine();
            System.out.println(s);
        }
    }
}
