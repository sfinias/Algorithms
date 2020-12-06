package org.example.algorithms.hackerrank.library;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//https://www.hackerrank.com/challenges/torque-and-development/problem

public class RoadsAndLibraries {

    // Complete the roadsAndLibraries function below.

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            Map<Integer, List<Integer>> cityMap = new HashMap<>();
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int libraryCost = scanner.nextInt();
            int roadCost = scanner.nextInt();
            for (int i = 1; i <= n; i++) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                cityMap.put(i, list);
            }

            for (int a1 = 0; a1 < m; a1++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                List<Integer> list1 = cityMap.get(x);
                List<Integer> list2 = cityMap.get(y);
                if (list1 != list2) {
                    list1.addAll(list2);
                    list2.forEach(i -> cityMap.put(i, list1));
                }
            }
            if (libraryCost < roadCost)
                System.out.println((long) n * libraryCost);
            else {
                long cost = 0;
                for (List<Integer> list : cityMap.values()) {
                    int size = list.size();
                    if (size > 0) {
                        cost += libraryCost;
                        cost += (long) (size - 1) * roadCost;
                        list.removeIf(i -> true);
                    }
                }
                System.out.println(cost);
            }
        }
    }
}

class Node {

    private Set<Node> adjacentNodes = new HashSet<>();
    private int distance = Integer.MAX_VALUE;

    public Set<Node> getAdjacentNodes() {

        return adjacentNodes;
    }




    public void addAdjacent(Node node) {

        this.adjacentNodes.add(node);
    }

    public int getDistance() {

        return distance;
    }

    public void setDistance(int distance) {

        this.distance = distance;
    }
}