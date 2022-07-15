package com.company.datastructures.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class GraphRepresentation {
    public static void main(String[] args){
        int vertices =5;
        boolean[] BFVisited = new boolean[vertices];
        boolean[] DFVisited = new boolean[vertices];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(vertices);
        for(int i = 0; i < vertices; i++){
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        printGraph(adj);
        BFS(adj, 0, BFVisited);
        DFS(adj, 0, DFVisited);

    }

    static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for(int i=0; i < adj.size(); i++){
            System.out.println("\n Adjacency list of vertex " + i);
            System.out.println(" head");
            for(int j=0; j < adj.get(i).size();j++){
                System.out.println("->"+adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void BFS(ArrayList<ArrayList<Integer>> adj, int source, boolean visited[]) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[source] = true;
        queue.add(source);

        while(queue.size() != 0){
            source = queue.poll();
            System.out.println(source + " ");
            Iterator<Integer> i = adj.get(source).listIterator();
            while (i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n] =true;
                    queue.add(n);
                }
            }
        }
    }

    static void DFS(ArrayList<ArrayList<Integer>> adj, int source, boolean visited[]){
        visited[source] =true;
        System.out.println(source + " ");
        Iterator<Integer> i = adj.get(source).listIterator();
        while (i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                DFS(adj, n, visited);
            }
        }

    }
}
