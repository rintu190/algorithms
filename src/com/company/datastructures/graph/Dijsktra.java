package com.company.datastructures.graph;

public class Dijsktra {
    static final int V =9;
    public static void main(String[] args){
        int graph[][] = new int[][]{
                { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
        };
        Dijsktra path = new Dijsktra();
        path.DijsktraImpl(graph,0);
    }

    private void DijsktraImpl(int[][] graph, int src) {
        int dist[] = new int[V];                //distance array
        Boolean sptSet[] = new Boolean[V];      //visited vertex array

        for(int i=0; i<V; i++){                 // all distance as infinite and visited vertex as false
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[src] =0;

        for(int count =0; count < V-1; count++){         // update dist of adjacent vertices of the picked vertex
            int u = minimumDistance(dist,sptSet);       //find min distance vertex

            sptSet[u]=true;                             // make the vertex as visited

            for(int v=0; v < V; v++){
                if(!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]){
                    dist[v] = dist[u]+ graph[u][v];
                }
            }
        }
        printSolution(dist);
    }

    int minimumDistance(int dist[], Boolean sptSet[]){
        int min = Integer.MAX_VALUE, min_index =-1;
        for(int v=0 ; v<V; v++){
            if(sptSet[v] == false && dist[v] <= min){
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }
    void printSolution(int dist[]){
        System.out.println("vertex \t\t distance" );
        for(int i=0;i<V;i++){
            System.out.println(i + "\t\t" + dist[i]);
        }
    }
}
