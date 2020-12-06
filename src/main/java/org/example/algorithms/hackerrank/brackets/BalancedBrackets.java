package org.example.algorithms.hackerrank.brackets;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/balanced-brackets/problem

public class BalancedBrackets {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch(c){
                case '{':
                case '[':
                case '(':
                    stack.push(c);
                    break;
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{') {
                        return "NO";

                    }
                    stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return "NO";

                    }
                    stack.pop();
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return "NO";

                    }
                    stack.pop();
                    break;
            }
        }
        return stack.isEmpty() ? "YES" : "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
