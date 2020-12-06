package org.example.algorithms.hackerrank.synchronousshopping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] firstMultipleInput = scanner.nextLine().split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int k = Integer.parseInt(firstMultipleInput[2]);

        List<Center> centers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] centerInput = scanner.nextLine().split(" ");
            Center center = new Center(i);
            int fishCount = Integer.parseInt(centerInput[0]);
            for (int j = 0; j < fishCount; j++) {
                center.getFishes().add(Integer.valueOf(centerInput[j + 1]));
            }
            centers.add(center);
        }
        for (int i = 0; i < m; i++) {
            String[] input = scanner.nextLine().split(" ");
            Center centerA = centers.get(Integer.parseInt(input[0]) - 1);
            Center centerB = centers.get(Integer.parseInt(input[1]) - 1);
            int distance = Integer.parseInt(input[2]);
            centerA.getConnected().put(centerB, distance);
            centerB.getConnected().put(centerA, distance);
        }
        Graph graph = new Graph();
        Set<Integer> fishCollected = graph.traverse(centers);
        if (fishCollected.size() == k) {
            System.out.println(centers.get(centers.size() - 1).getDistance());
        }

    }

}

class Graph{

    public Set<Integer> traverse(List<Center> centers) {

        Center root = centers.get(0);
        Set<Center> settled = new HashSet<>();
        NavigableSet<Center> unsettled = new TreeSet<>(Comparator.comparingInt(Center::getDistance));
        root.setDistance(0);
        unsettled.add(root);
        while (!unsettled.isEmpty()) {
            Center center = unsettled.pollFirst();
            for (Entry<Center, Integer> entry : center.getConnected().entrySet()) {
                Center adjCenter = entry.getKey();
                int distance = entry.getValue();
                if (settled.contains(adjCenter)) {
                    continue;
                }
                if (center.getDistance() + distance < adjCenter.getDistance()) {
                    adjCenter.setDistance(center.getDistance() + distance);
                    List<Center> path = new ArrayList<>(center.getShortestPath());
                    path.add(center);
                    adjCenter.setShortestPath(path);
                    unsettled.remove(adjCenter);
                    unsettled.add(adjCenter);
                }
                settled.add(center);
            }
        }
        Set<Integer> fishCollected = new HashSet<>();
        for (Center center : centers.get(centers.size() - 1).getShortestPath()) {
            fishCollected.addAll(center.getFishes());
        }
        return fishCollected;
    }
}

class Center {

    private int name;
    private int distance = Integer.MAX_VALUE;
    private List<Integer> fishes = new ArrayList<>();
    private Map<Center, Integer> connected = new HashMap<>();
    private List<Center> shortestPath = new ArrayList<>();

    public Center(int name) {

        this.name = name;
    }

    public List<Integer> getFishes() {

        return fishes;
    }

    public Map<Center, Integer> getConnected() {

        return connected;
    }

    public int getDistance() {

        return distance;
    }

    public void setDistance(int distance) {

        this.distance = distance;
    }

    public List<Center> getShortestPath() {

        return shortestPath;
    }

    public void setShortestPath(List<Center> shortestPath) {

        this.shortestPath = shortestPath;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Center center = (Center) o;
        return name == center.name;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
