package com.example.palindrome;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
public class PalindromeWithStackQueue {

    /**
     * Implement a method that uses a Stack and a Queue
     * to determine whether the input string is a palindrome.
     * Palindromes read the same forwards and backwards,
     * ignoring case and non-alphanumeric characters.
     * Use Stack and Queue provided by Java's standard library.
     */
    public static boolean isPalindrome(String s) {
        if (s == null) throw new IllegalArgumentException("Input cannot be null");
        if (s.length() <= 1) return true;
       s= normalize(s);
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++){
            stack.push(s.charAt(i));
            queue.add(s.charAt(i));
        }
            while (!stack.isEmpty() && !queue.isEmpty()) {
               char last =stack.pop();
               char first= queue.remove();

               if (last != first) {
                   return false;
               }
            }
            return true;
    }
    // Optional helper method for normalization
    public static String normalize(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
}
