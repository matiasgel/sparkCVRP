package edu.uoc.pec2;

import java.io.Serializable;

public class Test implements Serializable{
	
    /*******************************************************************************
    * Variables de instancia 
    ******************************************************************************/
	
    private String instanceName; 
    private float maxRouteCosts;
    

    public Test(String name, float rCosts){
        instanceName = name; 
        maxRouteCosts = rCosts;}

    /*******************************************************************************
     * Getters y Setters 
     ******************************************************************************/
    
    public String getInstanceName(){return instanceName;}    
    public float getMaxRouteCosts(){return maxRouteCosts;}

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

    public void setMaxRouteCosts(float maxRouteCosts) {
        this.maxRouteCosts = maxRouteCosts;
    }
}