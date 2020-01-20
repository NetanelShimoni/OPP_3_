package dataStructure;

import javax.swing.*;

/**
 * this class represent a edge on the graph
 */
public class Edge extends JFrame implements edge_data {

    private double weight;
    private int src;
    private  int dest;
    private String info;
    private int tag;


    /**
     * empty constructor for edge
     */
    public Edge()
    {
        this.info="";
        this.weight=0;
        this.dest=0;
        this.src=0;
    }

    /**
     * constructor for edge on the graph
     * @param sr
     * @param des
     * @param w
     */
    public Edge(int sr, int des, double w ){
        this.src=sr;
        this.dest=des;
        this.weight=w;

    }
    /**
     *getter for the src vertex of the edge
     */
    @Override
    public int getSrc() {
        return this.src;
    }

    /**
     *getter for the dest vertex of the edge
     */
    @Override
    public int getDest() {
        return this.dest;
    }
    /**
     *getter for the weight of the edge
     */
    @Override
    public double getWeight() {
        return this.weight;
    }
    /**
     *getter for the info of the edge
     */
    @Override
    public String getInfo() {
        return this.info;
    }
    /**
     *setter for the info of the edge
     */
    @Override
    public void setInfo(String s) {
    this.info=s;
    }
    /**
     *getter for the tag of the edge
     */
    @Override
    public int getTag() {
        return this.tag;
    }
    /**
     *setter for the tag of the edge
     */
    @Override
    public void setTag(int t) {
    this.tag=t;
    }
}
