package org.example.algorithms.graph.bfs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private final String name;
    private boolean visited;
    private final List<Vertex> adjacentList;

    public Vertex(String name) {

        this.name = name;
        this.adjacentList = new ArrayList<>();
    }

    public boolean isVisited() {

        return visited;
    }

    public void setVisited(boolean visited) {

        this.visited = visited;
    }

    public List<Vertex> getAdjacentList() {

        return adjacentList;
    }

    public void addNeighbor(Vertex vertex) {

        this.adjacentList.add(vertex);
    }

    @Override
    public String toString() {

        return this.name;
    }
}
