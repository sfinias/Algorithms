package org.example.algorithms.hackerrank.moon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Journey {

    static int value;

    static long journeyToMoon(int n, int[][] astronaut) {

        long answer= 0;
        int p=astronaut.length;
        int number_countries=100000;
        List<Integer> graph[]=new ArrayList[number_countries];

        for(int i=0;i<number_countries;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<p;i++) {
            int b=astronaut[i][0];
            int a=astronaut[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }
        boolean[] visited=new boolean[n];
        long prev_value = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(graph, i , visited);
                answer+=prev_value*value;
                prev_value+=value;
                value=0;
            }
        }
        return answer;
    }

    private static void dfs(List<Integer>[] graph, int i, boolean[] visited){
        visited[i]=true;
        for(int adj: graph[i] ){
            if(!visited[adj]){
                dfs(graph, adj, visited);
            }

        }
        value++;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        String[] np = scanner.nextLine().split(" ");

        int n = Integer.parseInt(np[0]);

        int p = Integer.parseInt(np[1]);

        int[][] astronaut = new int[p][2];

        for (int i = 0; i < p; i++) {
            String[] astronautRowItems = scanner.nextLine().split(" ");

            for (int j = 0; j < 2; j++) {
                int astronautItem = Integer.parseInt(astronautRowItems[j]);
                astronaut[i][j] = astronautItem;
            }
        }

        long result = journeyToMoon(n, astronaut);

        System.out.println(result);

        scanner.close();
    }

}
