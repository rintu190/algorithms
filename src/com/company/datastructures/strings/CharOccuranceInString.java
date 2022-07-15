package com.company.datastructures.strings;

import java.util.HashMap;
import java.util.Map;

public class CharOccuranceInString {
    public static void main(String args[]){
        String input ="GGaaaJendddRa";
        countChar(input);
    }

    private static void countChar(String input) {
        HashMap<Character,Integer> charMap = new HashMap<Character, Integer>();
        char[] inputArray = input.toCharArray();

        for(char c : inputArray){
            if(charMap.containsKey(c)){
                charMap.put(c, charMap.get(c)+1);
            }else{
                charMap.put(c,1);
            }
        }
        for(Map.Entry entry : charMap.entrySet()){
            System.out.println(entry.getKey() + " "+ entry.getValue());
        }
    }
}
