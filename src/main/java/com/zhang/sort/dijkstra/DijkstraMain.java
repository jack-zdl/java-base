package com.zhang.sort.dijkstra;

public class DijkstraMain {

    public static void main(String[] args) {
        graph g=new graph(5);
        g.initVertext();
        g.addEdge(0,1,2);
        g.addEdge(0,2,2);
        g.addEdge(1,4,1);
        g.addEdge(1,3,3);
        g.addEdge(2,3,3);
        g.addEdge(4,3,1);
        DijkstraSort dj=new DijkstraSort(g);
        dj.Dijkstra(1,3);
    }
}
