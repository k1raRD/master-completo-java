package com.acollado.poosobrecarga;

import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static String[] strArrayCleaner(String[] sA){
        String[] strCleanedArray = new String[sA.length];
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        for(int i = 0; i < sA.length; i++){
            Matcher m = p.matcher(sA[i]);
            boolean b = m.find();
            if(!b){
                strCleanedArray[i] = sA[i];
            }
        }
        return strCleanedArray;
    }

    public static String LongestWord(String sen) {
        // code goes here
        String longesString = "";
        if(sen.length() != 0){
            String[] srtArray = sen.split(" ");
            String[] cleanArray = strArrayCleaner(srtArray);
            for(int i = 0; i < cleanArray.length; i++){
                if( cleanArray[i] != null && cleanArray[i].length() != 0){
                    if(cleanArray[i].length() == longesString.length()){
                        longesString = longesString;
                    }else if(cleanArray[i].length() > longesString.length()){
                        longesString = cleanArray[i];
                    }
                }
            }
        }
        sen = longesString;
        return sen;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(LongestWord(s.nextLine()));
    }

}

