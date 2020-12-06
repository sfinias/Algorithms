package org.example.algorithms.hackerrank.calendar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//https://www.hackerrank.com/challenges/contacts/problem

public class Calendar {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numQueries = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < numQueries; i++){
            String[] data = br.readLine().split(" ");

            if (data[0].equals("add")){
                for (int j = 1; j <= data[1].length(); j++){
                    String sub = data[1].substring(0, j);
                    int count = map.getOrDefault(sub, 0);
                    map.put(sub, count + 1);
                }
            } else {
                System.out.println(map.getOrDefault(data[1], 0));
            }
        }
    }
}