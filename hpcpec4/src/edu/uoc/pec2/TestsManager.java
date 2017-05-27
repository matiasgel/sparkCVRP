package edu.uoc.pec2;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class TestsManager{
	

    
	public static ArrayList<Test> getTestsList(String testsFilePath){   
	ArrayList<Test> list = new ArrayList<Test>();
        try{   
		 FileReader reader = new FileReader(testsFilePath);
            Scanner in = new Scanner(reader);
            in.useLocale(Locale.US);
            while(in.hasNextLine()){   
			String s = in.next();
                if(s.charAt(0) == '#') // Comentario
                    in.nextLine(); 
                else{   
                	String instanceName = s;
                    float maxRouteCosts = in.nextFloat();
                    Test aTest = new Test(instanceName, maxRouteCosts);
                    list.add(aTest);}}
            in.close();}
        catch (IOException exception){   
        	System.out.println("Error processing tests file: " + exception);}
        return list;}
}