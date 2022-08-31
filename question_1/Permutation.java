package question_1;


import java.util.*;

public class Permutation extends Thread {

    public static HashMap<String, String> permutation(String input) {
        HashMap<String, String> hashMap = new HashMap<>();

        Character first = input.charAt(0);
        if (input.length() > 1) {
            input = input.substring(1);
            HashMap<String, String> temp = permutation(input);
            for (String word : temp.keySet())
                for (int i = 0; i <= word.length(); i++) {
                    hashMap.put(word.substring(0, i) + first + word.substring(i), null);
                }
        } else
            hashMap.put(String.valueOf(first), null);
        return hashMap;
    }

    public static String checkTwoStringPermutation(String wordOne, String wordTwo) {
        HashMap<Character, Integer> hashMapOne = new HashMap<>();
        HashMap<Character, Integer> hashMapTwo = new HashMap<>();
        if (wordOne.length() != wordTwo.length())
            return "Fail";
        for (Character character : wordOne.toCharArray()) {
            if (hashMapOne.containsKey(character)) {
                hashMapOne.replace(character, hashMapOne.get(character) + 1);
            } else{
                hashMapOne.put(character,1);
            }
        }
        for (Character character : wordTwo.toCharArray()) {
            if (hashMapTwo.containsKey(character)) {
                hashMapTwo.replace(character, hashMapTwo.get(character) + 1);
            } else{
                hashMapTwo.put(character,1);
            }
        }
        for(Character character : wordOne.toCharArray()){
            if(!Objects.equals(hashMapOne.get(character), hashMapTwo.get(character)))
                return "Fail";
        }
        return "Pass";
    }

    public static void main(String[] args) {
        HashMap<String, String> result = permutation("CAT");
        for (String res : result.keySet())
            System.out.println(res);
        System.out.println(checkTwoStringPermutation("CAT","ACT"));
    }

}
