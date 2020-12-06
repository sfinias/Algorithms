package org.example.algorithms.graph.dijkstra;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class Graph {

    private Set<Node> settledNodes;


    public Set<Node> getNodes() {
        return settledNodes;
    }

    public void calculateShortestPathFromSource(Node source) {

        long start = System.currentTimeMillis();
        source.setDistance(0);

        settledNodes = new HashSet<>();
        NavigableSet<Node> unsettledNodes = new TreeSet<>(Comparator.comparingInt(Node::getDistance));
        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            Node currentNode = unsettledNodes.pollFirst();
            for (Entry<Node, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeigh = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    int sourceDistance = currentNode.getDistance();
                    if (sourceDistance + edgeWeigh < adjacentNode.getDistance()) {
                        adjacentNode.setDistance(sourceDistance + edgeWeigh);
                        LinkedList<Node> shortestPath = new LinkedList<>(currentNode.getShortestPath());
                        shortestPath.add(currentNode);
                        adjacentNode.setShortestPath(shortestPath);
                    }
                    unsettledNodes.remove(adjacentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}