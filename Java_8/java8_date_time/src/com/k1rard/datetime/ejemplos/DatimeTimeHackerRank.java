package com.k1rard.datetime.ejemplos;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class DatimeTimeHackerRank {

    static String[] palabras = {"hello", "world", "this", "is", "great"};
    public static void main(String[] args) throws ParseException {

        String s = "07:05:45PM";
        DateFormat inputFormat = new SimpleDateFormat("hh:mm:ssa");
        DateFormat outputFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = inputFormat.parse(s);
        System.out.println(outputFormat.format(date));

        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(7);
        arr.add(9);

        Double total = 0.0;

        for(int num : arr){
            total += num;
        }

        System.out.println("The median is: " + (total / arr.size()));

        List<Integer> arrNums = new ArrayList<>();
        arrNums.add(1);
        arrNums.add(2);
        arrNums.add(3);
        arrNums.add(4);
        arrNums.add(3);
        arrNums.add(2);
        arrNums.add(1);


        List<Integer> arrNums1 = new ArrayList<>();
        arrNums1.add(1);
        arrNums1.add(2);
        arrNums1.add(3);
        List<Integer> arrNums2 = new ArrayList<>();
        arrNums2.add(4);
        arrNums2.add(5);
        arrNums2.add(6);
        List<Integer> arrNums3 = new ArrayList<>();
        arrNums3.add(9);
        arrNums3.add(8);
        arrNums3.add(9);

        List<List<Integer>> arrList = new ArrayList<>();
        arrList.add(arrNums1);
        arrList.add(arrNums2);
        arrList.add(arrNums3);

        System.out.println(lonelyinteger(arrNums));
        diagonalDifference(arrList);
        smash(palabras);
    }

    public static List<Integer> lonelyinteger(List<Integer> a) {
        // Write your code here
        int[] nums = new int[a.size()];
        for (int i = 0; i < a.size() ; i++) {
            nums[i] = a.get(i);
        }

        int times;
        int lonelyNum = 0;
        for(int i = 0; i < nums.length; i++){
            times = 0;
            for(int j = 0; j < nums.length ; j++) {
                if(nums[i] == nums[j]){
                    times++;
                }
            }
            if(times == 1){
                lonelyNum = nums[i];
                break;
            }
        }
         Collections.sort(a);
        return a;
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here

        int total = 0;

        for(int i = 0; i < arr.size(); i++){
            total += arr.get(i).get(i);
            total -= arr.get(i).get(arr.size() -1 -i);
        }
        return Math.abs(total);
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        int max = greatestNum(arr);
        List<Integer> orderedList = new ArrayList<>();
        int times;
        for (int i = 0; i <= max ; i++){
            times = 0;
            for(int num : arr){
                if(i == arr.get(i)){
                    times++;
                }
            }
            orderedList.add(times);
        }
        return orderedList;
    }

    private static int greatestNum(List<Integer> arr){
        int max = 0;
        for(int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private static void plusMinus(List<Integer> arr){
        DecimalFormat df = new DecimalFormat("0.000000");
        double positives = 0.0;
        double negatives = 0.0;
        double zeros = 0.0;
        for(int i : arr){
            if(i > 0){
                positives++;
            } else if(i < 0){
                negatives++;
            } else{
                zeros++;
            }
        }

        System.out.println(df.format(positives / arr.size()));
        System.out.println(df.format(negatives / arr.size()));
        System.out.println(df.format(zeros / arr.size()));
    }



    private static void smash(String... words){
        StringBuilder sentece = new StringBuilder();
        Arrays.stream(words).spliterator();
        for (int i = 0; i < words.length; i++) {
            sentece.append(words[i]).append(" ");
        }
        System.out.println(sentece.toString().trim());
    }

    public static String repeatStr(final int repeat, final String string) {
        return "".repeat(repeat);
    }

    public static String encrypt(String s, int k) {
        StringBuilder encryptedMessage = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (Character.isLetter(currentChar)) {
                boolean isUpperCase = Character.isUpperCase(currentChar);

                int shiftedChar = (currentChar - (isUpperCase ? 'A' : 'a') + k) % 26;

                if (shiftedChar < 0) {
                    shiftedChar += 26;
                }

                char encryptedChar = (char) (shiftedChar + (isUpperCase ? 'A' : 'a'));

                encryptedMessage.append(encryptedChar);
            } else {
                encryptedMessage.append(currentChar);
            }
        }

        return encryptedMessage.toString();
    }

    private static int getInt(){
        int a  = 315;
        int b;
        return a;
    }

}
