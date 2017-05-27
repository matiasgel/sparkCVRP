package edu.uoc.pec2;


public class ElapsedTime{

	/*******************************************************************************
     * Constructor
     ******************************************************************************/

    public ElapsedTime(){}

	/*******************************************************************************
     * M?TODO P?BLICO systemTime()
     * Devuelve el tiempo en nanosegundos
     ******************************************************************************/

    public static long systemTime(){
	   long time = System.nanoTime();
       return time;}

	/*******************************************************************************
     * M?TODO P?BLICO calcElapsed()
     * Devuelve el tiempo entre dos valores
     ******************************************************************************/
    
    public static double calcElapsed(long start, long end){   		   
    	double elapsed = (end - start) / 1.0e+9;
        return elapsed;}
}