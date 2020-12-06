package org.example.algorithms.stackschallenge;

import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String string) {

        string = string.toLowerCase();
        Deque<Character> que1 = new LinkedList<>();
        Deque<Character> que2 = new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c >= 'a' && c <= 'z') {
                que1.push(c);
            }
            c = string.charAt(string.length() - 1 - i);
            if (c >= 'a' && c <= 'z') {
                que2.push(c);
            }
        }
        return que1.equals(que2);
    }
}
