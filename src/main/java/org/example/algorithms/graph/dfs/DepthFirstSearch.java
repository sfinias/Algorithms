package org.example.algorithms.graph.dfs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class DepthFirstSearch {

    private Deque<Vertex> stack = new LinkedList<>();

    public void traverse(List<Vertex> vertexList) {

        for (Vertex v : vertexList) {
            if (v.isVisited()) {
                continue;
            }
            v.setVisited(true);
            traverseWithStack(v);
        }
    }

    private void traverseWithStack(Vertex root) {

        stack.push(root);
        root.setVisited(true);

        while (!stack.isEmpty()) {
            Vertex actualVertex = this.stack.pop();
            System.out.println("Actual vertex: " + actualVertex);
            for (Vertex v : actualVertex.getAdjacentList()) {
                if (v.isVisited()) {
                    continue;
                }
                v.setVisited(true);
                stack.push(v);
            }
        }
    }

    private void traverseRecursively(Vertex v) {

        System.out.println(v + "");
        for (Vertex vertex : v.getAdjacentList()) {
            if (vertex.isVisited()) {
                continue;
            }
            vertex.setVisited(true);
            traverseRecursively(vertex);
        }
    }
}
