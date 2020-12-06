package org.example.algorithms.hackerrank.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/tree-level-order-traversal/problem

class LevelOrderTraversal {


    /*

    class Node
        int data;
        Node left;
        Node right;
    */
    public static void levelOrder(Node root) {
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            Node node = stack.pop();
            sb.append(node.data);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
            if(!stack.isEmpty()){
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
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
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
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
