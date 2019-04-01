package com.zhang.sort.dijkstra;

public class graph {

    //存放点的集合
    public Vertex[] vertexList; //线程安全

    //点个数
    public int vertexNum;

    //边个数
    public int edgeLength;

    public graph(int vertexNum){
        this.vertexNum=vertexNum;
        vertexList=new Vertex[vertexNum];
    }

    public void initVertext(){
        for(int i=0;i<vertexNum;i++){
            Vertex vertext=new Vertex();
            vertext.firstEdge=null;
            vertexList[i]=vertext;
            //System.out.println("i"+vertexList[i]);
        }
    }

    //针对x节点添加边节点y
    public void addEdge(int x,int y,int weight) {
        Edge edge = new Edge();
        edge.setVertexId(y);
        edge.setWeight(weight);
        //第一个边节点
        if (null == vertexList[x].firstEdge) {
            vertexList[x].firstEdge = edge;
            edge.setNext(null);
        }
        //不是第一个边节点,则采用头插法
        else {
            edge.next = vertexList[x].firstEdge;
            vertexList[x].firstEdge = edge;
        }
    }

    }
