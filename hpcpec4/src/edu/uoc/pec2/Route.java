package edu.uoc.pec2;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Route implements Serializable{
	

    private double costs = 0.0;
    private float demand = 0.0F;
    private LinkedList<CEdge> CEdges;



    public Route(){   
	   CEdges = new LinkedList<CEdge>();}
    

    public double getCosts(){return costs;}
    
    public float getDemand(){return demand;}
    
    public List<CEdge> getCEdges(){return CEdges;}

    public void setCEdges(LinkedList<CEdge> CEdges) {
        this.CEdges = CEdges;
    }

    public void setCosts(double c){costs = c;}
    
    public void setDemand(float d){demand = d;}


    public void reverse(){   
        for(int i = 0; i < CEdges.size(); i++){
        	CEdge e = CEdges.get(i);
            CEdge invE = e.getInverseCEdge();
            CEdges.remove(e);
            CEdges.add(0, invE);}}


    @Override
    public String toString(){   
	   String s = "\nRute costs: " + this.costs;
       s += "\nRuta demand:" + this.demand;
       s += "\nRuta edges: " + this.CEdges;
       return s;}

    public Route copy() {
        Route copyR=new Route();
        copyR.setCosts(this.getCosts());
        copyR.setDemand(this.getDemand());
        LinkedList<CEdge> copyEdges=new LinkedList<>();
        for (CEdge edge:this.getCEdges())
            copyEdges.add(new CEdge(edge.getOrigin(),edge.getEnd()));
        copyR.setCEdges(copyEdges);
        return copyR;
    }


}