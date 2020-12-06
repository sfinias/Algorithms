package org.example.algorithms.hackerrank.median;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/find-the-running-median/problem?isFullScreen=true

public class RunningMedian {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int aCount = Integer.parseInt(scanner.nextLine().trim());
        List<Integer> list = new ArrayList<>(aCount);
        for (int i = 0; i < aCount; i++) {
            int a = Integer.parseInt(scanner.nextLine().trim());
            int start = 0;
            int end = list.size();
            while (end - start >= 2){
                double m = (end - start) % 2 == 0 ?
                        (list.get((end - start) / 2 + start - 1) + list.get((end - start) / 2 + start)) / 2.0
                        : list.get((end - start) / 2 + start);
                if (a <= m){
                    end = (end - start) / 2 + start;
                } else {
                    start = (end - start) / 2 + start;
                }
            }
            if (list.isEmpty()){
                list.add(a);
            } else {
                int index = list.get(start) > a ? start : start + 1;
                if (index < list.size()) {
                    list.add(index, a);
                } else {
                    list.add(a);
                }
            }
            double median = list.size() % 2 == 0 ?
                    (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2.0
                    : list.get(list.size() / 2);
            System.out.println(median);
        }


    }
}
