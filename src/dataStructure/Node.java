package dataStructure;

import utils.Point3D;

import javax.swing.*;
import java.io.Serializable;
import java.util.HashMap;
/**
 *this class represent a Node (vertex) on the graph
 */
public class Node  implements node_data, Serializable {
    HashMap<Integer,edge_data> edegesmap =new HashMap<Integer, edge_data>();
    //HashMap<Integer,edge_data> edgesdest =new HashMap<Integer, edge_data>();
    public static int mark=1;
    private Point3D location;
    private double weight;
    private String info="";
    private int key,tag;
    /**
     *empty constructor for the Node
     */
    public Node(){
    this.key=mark;
    this.weight=0;
    this.info="";
    this.tag=0;
    mark++;

    }

    /**
     * constructor of vertix
     * @param p
     * @param w
     * @param in
     * @param t
     */
    public Node( Point3D p , double w, String in, int t){

    this.location=p;
    this.weight=w;
    this.tag=t;
    this.key=mark;
    this.info=in;
    mark++;
    }
    /**
     *consrtuctor for the Node
     */
    public Node(Point3D p) {
        this.setLocation(p);
        this.key=mark;
        mark++;
    }
    /**
     *consrtuctor for the Node
     */
    public Node(int id, Point3D location) {
        this.key=id;
        this.location=location;
        this.weight=0;
        this.info="";
        this.tag=0;
        mark++;
    }
    /**
     *getter for the key of the Node
     */
    @Override
    public int getKey() {
        return this.key;
    }
    /**
     *getter for the location of the Node
     */
    @Override
    public Point3D getLocation() {
        return this.location;
    }
    /**
     *getter for the weight of the Node
     */
    @Override
    public double getWeight() {
        return this.weight;
    }
    /**
     *setter for the weight of the Node
     */
    @Override
    public void setWeight(double w) {
    this.weight=w;
    }
    /**
     *getter for the info of the Node
     */
    @Override
    public String getInfo() {
        return this.info;
    }
    /**
     *setter for the info of the Node
     */
    @Override
    public void setInfo(String s) {
    this.info=s;
    }

    /**
     *getter for the tag of the Node
     */
    @Override
    public int getTag() {
        return this.tag;
    }
    /**
     *setter for the tag of the Node
     */
    @Override
    public void setTag(int t) {
    this.tag=t;
    }
    /**
     *setter for the location of the Node
     */
    @Override
    public void setLocation(Point3D p) {
    this.location=p;
    }
}
