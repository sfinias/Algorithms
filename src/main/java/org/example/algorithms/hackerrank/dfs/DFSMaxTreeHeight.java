package org.example.algorithms.hackerrank.dfs;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;


//	https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree

class DFSMaxTreeHeight {

	/*
    class Node
    	int data;
    	Node left;
    	Node right;
	*/

    public static int height(Node root) {
        // Write your code here.

        Map<Node, Integer> levels = new HashMap<>();
        int height = 0;
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        levels.put(root, 0);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            int level = levels.get(node);
            if (node.left == null && node.right == null) {
                if (level > height) {
                    height = level;
                    continue;
                }
            }
            if (node.left != null) {
                stack.push(node.left);
                levels.put(node.left, level + 1);
            }
            if (node.right != null) {
                stack.push(node.right);
                levels.put(node.right, level + 1);
            }
        }
        return height;
    }

    public static Node insert(Node root, int data) {

        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}
class Node {

    Node left;
    Node right;
    int data;

    Node(int data) {

        this.data = data;
        left = null;
        right = null;
    }
}