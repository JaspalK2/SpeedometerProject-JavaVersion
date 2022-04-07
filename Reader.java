


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.Scanner;
import java.io.File;
import java.util.Scanner;

import java.io.IOException;
import java.util.*;  
 

public class Reader {
      public ArrayList<String> myNumbers_Percent_State_names() {
      BufferedReader reader;
		  try {
        reader = new BufferedReader(new FileReader("/Users/jaspalkhanuja/Downloads/Year_data.txt"));
        reader = new BufferedReader(new FileReader("/Users/jaspalkhanuja/Downloads/jaspal"));
        String line = reader.readLine();
        String s ="";
      int arrCounter = 0;
      ArrayList<Double> gfg = new ArrayList<Double>();
      ArrayList<String> gfg1 = new ArrayList<String>();
			while (line != null) {
				if(line.contains("Percent"))
        { 
            s = line.substring(line.indexOf("."), line.length());
            gfg.add(Double.parseDouble(s));
            int n = line.indexOf("Percent");
            String g = "";
            for(int i = 0; i < n; i++){
              g+=line.substring(i,i+1);
            }
            gfg1.add(g);
            //System.out.println(s);

        }
            

				line = reader.readLine();
			}
     // System.out.println(arrCounter);
			reader.close();
      for(int i = 0; i < gfg.size(); i++){
        if(i == 0){
          System.out.println("Arraylist Data values: ");
        }
        //System.out.println(gfg.get(i));
      }
      for(int i = 0; i < gfg1.size();i++){
        // System.out.println(gfg1.get(i));
      }
      return gfg1;
		} catch (IOException e) {
			e.printStackTrace();
		}
    ArrayList<String> gfg1 = new ArrayList<String>();
    return gfg1;
    }


    public ArrayList<Double> myNumbers2_Percent_State_numbers() {
      BufferedReader reader;
		  try {
        reader = new BufferedReader(new FileReader("/Users/jaspalkhanuja/Downloads/Year_data.txt"));
        reader = new BufferedReader(new FileReader("/Users/jaspalkhanuja/Downloads/jaspal"));
        String line = reader.readLine();
        String s ="";
      int arrCounter = 0;
      ArrayList<Double> gfg = new ArrayList<Double>();
      ArrayList<String> gfg1 = new ArrayList<String>();
			while (line != null) {
				if(line.contains("Percent"))
        { 
            s = line.substring(line.indexOf("."), line.length());
            gfg.add(Double.parseDouble(s));
            int n = line.indexOf("Percent");
            String g = "";
            for(int i = 0; i < n; i++){
              g+=line.substring(i,i+1);
            }
            gfg1.add(g);
            //System.out.println(s);

        }
            

				line = reader.readLine();
			}
      System.out.println(arrCounter);
			reader.close();
      for(int i = 0; i < gfg.size(); i++){
        if(i == 0){
          System.out.println("Arraylist Data values: ");
        }
        System.out.println(gfg.get(i));
      }
      for(int i = 0; i < gfg1.size();i++){
         System.out.println(gfg1.get(i));
      }
      return gfg;
		} catch (IOException e) {
			e.printStackTrace();
		}
    ArrayList<Double> gfg1 = new ArrayList<Double>();
    return gfg1;
    }

/*
    public static void main(String[] args) throws IOException{
     
      BufferedReader reader;
		  try {
        reader = new BufferedReader(new FileReader("/Users/jaspalkhanuja/Downloads/Year_data.txt"));
        reader = new BufferedReader(new FileReader("/Users/jaspalkhanuja/Downloads/jaspal"));
        String line = reader.readLine();
        String s ="";
      int arrCounter = 0;
      ArrayList<Double> gfg = new ArrayList<Double>();
      ArrayList<String> gfg1 = new ArrayList<String>();
			while (line != null) {
				if(line.contains("Percent"))
        { 
            s = line.substring(line.indexOf("."), line.length());
            gfg.add(Double.parseDouble(s));
            int n = line.indexOf("Percent");
            String g = "";
            for(int i = 0; i < n; i++){
              g+=line.substring(i,i+1);
            }
            gfg1.add(g);
            //System.out.println(s);

        }
            

				line = reader.readLine();
			}
      System.out.println(arrCounter);
			reader.close();
      for(int i = 0; i < gfg.size(); i++){
        if(i == 0){
          System.out.println("Arraylist Data values: ");
        }
        System.out.println(gfg.get(i));
      }
      for(int i = 0; i < gfg1.size();i++){
         System.out.println(gfg1.get(i));
      }
		} catch (IOException e) {
			e.printStackTrace();
		}

    
    }*/
}
