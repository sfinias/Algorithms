package org.example.algorithms.graph.dfs;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");

        List<Vertex> list = Arrays.asList(v1, v2, v3, v4, v5);

        v1.addNeighbor(v2);
        v1.addNeighbor(v3);
        v3.addNeighbor(v4);
        v1.addNeighbor(v5);

        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.traverse(list);

    }
}
