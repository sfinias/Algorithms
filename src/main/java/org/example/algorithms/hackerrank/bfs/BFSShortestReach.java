package org.example.algorithms.hackerrank.bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;


// 	https://www.hackerrank.com/challenges/ctci-bfs-shortest-reach/problem

public class BFSShortestReach {

    public static void main(String[] args) {

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        int queries = 0;
        int nodes = 0;
        int edges = 0;
        Node[] tree = null;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }
            if (queries == 0) {
                queries = Integer.parseInt(input);
            } else if (nodes == 0) {
                String[] array = input.split(" ");
                nodes = Integer.parseInt(array[0]);
                edges = Integer.parseInt(array[1]);
                tree = new Node[nodes];
            } else if (edges == 0) {
                int start = Integer.parseInt(input) - 1;
                StringBuilder sb = new StringBuilder();
                Node root = tree[start];
                Map<Node, Integer> distances = bfs.traverse(root);
                for (int i = 0; i < tree.length; i++) {
                    if (i == start) {
                        continue;
                    }
                    sb.append(distances.getOrDefault(tree[i], -1));
                    if (i < tree.length - 1) {
                        sb.append(" ");
                    }
                }
                System.out.println(sb);
                nodes = 0;
            } else {
                String[] array = input.split(" ");
                int index1 = Integer.parseInt(array[0]) - 1;
                int index2 = Integer.parseInt(array[1]) - 1;
                Node node1 = tree[index1] != null ? tree[index1] : new Node();
                Node node2 = tree[index2] != null ? tree[index2] : new Node();
                node1.addNeighbor(node2);
                node2.addNeighbor(node1);
                tree[index1] = node1;
                tree[index2] = node2;
                edges--;
            }
        }
    }

    public static class BreadthFirstSearch {



        public  Map<Node, Integer> traverse(Node root) {

            Map<Node, Integer> distances = new HashMap<>();
            Queue<Node> queue = new LinkedList<>();
            root.setVisited(true);
            queue.add(root);
            distances.put(root, 0);
            while (!queue.isEmpty()) {
                Node actualNode = queue.remove();
                List<Node> adjacentList = actualNode.getAdjacentList();
                for (int i = 0; i < adjacentList.size(); i++) {
                    Node v = adjacentList.get(i);
                    if (v.isVisited()) {
                        continue;
                    }
                    v.setVisited(true);
                    queue.add(v);
                    distances.put(v, distances.get(actualNode) + 6);
                }
            }
            return distances;
        }

    }

    public static class Node {

        private boolean visited;
        private final List<Node> adjacentList = new ArrayList<>();

        public boolean isVisited() {

            return visited;
        }

        public void setVisited(boolean visited) {

            this.visited = visited;
        }

        public List<Node> getAdjacentList() {

            return adjacentList;
        }

        public void addNeighbor(Node node) {

            this.adjacentList.add(node);
        }

    }

}

