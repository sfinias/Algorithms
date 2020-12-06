package org.example.algorithms.hackerrank.nodeswap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

// https://www.hackerrank.com/challenges/swap-nodes-algo/problem?isFullScreen=false

public class NodeSwap {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(scanner.nextLine().trim());

        Node[] nodes = new Node[n];
        Map<Integer, List<Node>> map = new HashMap<>();
        Map<Node,Integer> levels = new HashMap<>();
        Node root = new Node(1);
        nodes[0] = root;
        map.put(1, Arrays.asList(root));
        levels.put(root, 1);
        for (int i = 0; i < n; i++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");
            Node node = nodes[i];
            int level = levels.get(node) + 1;
            List<Node> list = map.getOrDefault(level, new ArrayList<>());
            int left = Integer.parseInt(indexesRowItems[0]);
            int right = Integer.parseInt(indexesRowItems[1]);
            if (left > 0) {
                Node leftNode = nodes[left - 1] != null ? nodes[left - 1] : new Node(left);
                node.left = leftNode;
                list.add(leftNode);
                map.put(level, list);
                levels.put(leftNode, level);
                nodes[left - 1] = leftNode;
            }
            if (right > 0) {
                Node rightNode = nodes[right - 1] != null ? nodes[left - 1] : new Node(right);
                node.right = rightNode;
                list.add(rightNode);
                map.put(level, list);
                levels.put(rightNode, level);
                nodes[right - 1] = rightNode;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());


        for (int i = 0; i < queriesCount; i++) {
            int swapLevel = Integer.parseInt(scanner.nextLine().trim());
            for (int j = swapLevel; map.containsKey(j); j += swapLevel) {
                map.get(j).forEach(Node::swap);
            }
            System.out.println(new DepthFirstSearch().traverse(nodes[0]));
        }

    }
}

class DepthFirstSearch{

    public String traverse(Node root){

        Deque<Node> stack = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        stack.push(root);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Node node = stack.peek();
            visited.add(node);
            if (node.left != null && !visited.contains(node.left)) {
                stack.push(node.left);
                continue;
            }
            sb.append(node.data);
            stack.pop();
            if (node.right != null && !visited.contains(node.right)){
                stack.push(node.right);
            }
            if (!stack.isEmpty()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data) {

        this.data = data;
    }

    void swap(){
        Node temp = left;
        left = right;
        right = temp;
    }
}
