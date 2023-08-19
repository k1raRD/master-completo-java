package com.k1rard.codewars;

import java.util.Arrays;

public class DoubleSum {
    public static void main(String[] args) {

        System.out.println(sum(new double[] {3.4, 54.6, 42.4, 43.3}));
    }

    public static double sum(double[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
