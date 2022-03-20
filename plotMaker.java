import edu.princeton.cs.algs4.LinearRegression;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.io.File;
import java.util.Scanner;

import java.io.IOException;
import java.util.*;  
 
 
public class plotMaker extends Application {
    public static int[][] speedDuration;
    public static int[][] textArr;
    public static int[][] Percent;
    public static int[][] finalArr; 
    public static int num;

    public static Double num2;
    public static double intercept;
    public static double slope;
    public static int isolateNum(String s, int j){
        String total = "";
        boolean case2 = false;
        if(j ==0){
          case2 = true;
        }
        int index;
        if(case2){
      
          
          
           
              index = 0;
              while(!s.substring(index,index+1).equals(",")){
                   if(Character.isDigit(s.charAt(index))){
                      total+=s.substring(index, index+1);
                   }
                   index++;
    
              }
              
            
         
        
      }
      if(!case2){
       
          
          
         
            index = 7;
            while(!s.substring(index,index+1).equals(",")){
                 if(Character.isDigit(s.charAt(index))){
                    total+=s.substring(index, index+1);
                 }
                 index++;
    
            }
      
      }
    
       int num = Integer.parseInt(total);
        return num;
      }
    /**
   * takes in two lists to determine the overall correlation that the player had throughout the rounds based on their score vs rounds
   * @param xs will store the x array of values
   * @param ys will store the y array of values
   */
    public static double Correlation(int[] xs, int[] ys) {
        //TODO: check here that arrays are not null, of the same length etc
    
        double sx = 0.0;
        double sy = 0.0;
        double sxx = 0.0;
        double syy = 0.0;
        double sxy = 0.0;
    
        int n = xs.length;
    
        for(int i = 0; i < n; ++i) {
          double x = xs[i];
          double y = ys[i];
    
          sx += x;
          sy += y;
          sxx += x * x;
          syy += y * y;
          sxy += x * y;
        }
    
        // covariation
        double cov = sxy / n - sx * sy / n / n;
        // standard error of x
        double sigmax = Math.sqrt(sxx / n -  sx * sx / n / n);
        // standard error of y
        double sigmay = Math.sqrt(syy / n -  sy * sy / n / n);
    
        // correlation is just a normalized covariation
        return cov / sigmax / sigmay;
      }
    /**
   * This method will start the prodcution of the data using series for the scatter graph, it will use an Axis naming mechanisim, a series adding forloop with the data lists, and finally at the end it will save this all and display a plot when the "launch(args) command is played in the main function"
   */
      @Override public void start(Stage stage) {
        
        stage.setTitle("Scatter Chart Sample");
        final NumberAxis xAxis = new NumberAxis(0, 10, 1);
        final NumberAxis yAxis = new NumberAxis(0, 100, 1);        
        final ScatterChart<Number,Number> sc = new
            ScatterChart<Number,Number>(xAxis,yAxis);
            final LineChart<Number,Number> lc = new
        LineChart<Number,Number>(xAxis,yAxis);
        xAxis.setLabel("Score");                
        yAxis.setLabel("Rounds");
        sc.setTitle("Drive  Vs. Percent Efficiency, Correlation(R): "+ String.format("%.2f", num2)+", Linear Regression Line: "+ String.format("%.2f", slope)+"X +  "+String.format("%.2f", intercept));
       
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Duration of Different Drives Vs. Percent Accuracy");
        for(int i = 0; i<finalArr.length; i++){
            series1.getData().add(new XYChart.Data(finalArr[i][0], finalArr[i][1]));
            
        
        }
        //series1.getData().add(new XYChart.Data(4.2, 193.2));
       
        
        int index = 0;
        XYChart.Series series2 = new XYChart.Series();
        
        series2.setName("Scatter points on recorded speeds from the recently added data sets");
        int index2 =1;
        for(int i = 0; i<speedDuration.length; i++){
            for(int p = 0; p < speedDuration[i].length;p++){
                  series2.getData().add(new XYChart.Data((index2), speedDuration[i][p]));
                  index2++;
            }
        
        }
 
        sc.getData().addAll(series1, series2);
        
        Scene scene  = new Scene(sc, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
   
 /**
   * This function will run the entire program, here it will run through all prefeerences that the user may want to select such as the easy or hard game mode, or the randomized words game mode, it will finally take all this, store it in a 2d array with the score and the rounds, and run the plot graph function along with the correaltion function to label the plot
 * @throws IOException
   * 
   */
    public static void main(String[] args) throws IOException {
        MemoryGameGUI GUI = new MemoryGameGUI();
        GUI.SpeedmeterProject();
        
        
        Header miles = new Header();
        //
        int n;
        int lenght;
        
        lenght =  GUI.DriveDuration();

        
         
         
       
        n = lenght;
        
        Double x;
        x = (double) GUI.GasStationVists();
       
       
        x= x*52.0;
        miles.setGasStation(x/5);
        miles.setDriveDuration(lenght);
        miles.setNumValues(n);
        miles.arrayMaker();
        miles.AverageEvaluator();
        miles.EndResult();
        
        double current_percent;
        current_percent = miles.return_percent();
        double current_amount = miles.return_amount();
        int currentDuration = miles.getDriveDuration();
        int[] currentSpeedVal = miles.getSpeedData();
        
        boolean condition = true;
        
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        
        String response = GUI.additionalSet();
        /* 
        System.out.println(" --------------------------------------------------------------------------------------------");
        System.out.println("                       Do you have an additional data set?(y/n): \n"+
        "                                                   ");*/

     
      
                
       
       
       
        if (response.equals( "y")){
            condition  =true;
        }
        else{
            condition = false;
        }
        Double[] data = new Double[100];
        Double[] data1 = new Double[100];
        int[] data2 = new int[100];
        int[][] data3 = new int[100][];
        data[0] = current_percent;
        data1[0] = current_amount;
        data2[0] = currentDuration;
        data3[0] = currentSpeedVal; 
        int  counter   =1;
        
        while(condition == true){
            
            Header miles2 = new Header();
            //
            int n2;
            int lenght2;
            System.out.println("");
           lenght2 =  GUI.DriveDuration();
            miles2.setDriveDuration(lenght2);
          
           
           
            n2 = lenght2;
            Double x2;
            //cout+"  -------------------------------------------------------------------------------------------"+endl;
           x2 = (double) GUI.GasStationVists();
          
                    
            
    
            miles2.setGasStation(x2/5);
            
            miles2.setNumValues(n2);
            miles2.arrayMaker();
            miles2.AverageEvaluator();
            miles2.EndResult();
            double new_data  =  miles2.return_percent();
            double new_data1= miles2.return_amount();
            int new_data2 = miles2.getDriveDuration();
            int[] speed = miles2.getSpeedData();
            data[counter] = new_data;
            data1[counter] = new_data1;
            data2[counter] = new_data2;
            data3[counter] =speed;
            counter++;
            String response2 = GUI.additionalSet();
            
           
            if (response2.equals("y")){
                condition  =true;
            }
            else{
                break;
            }
            
            
        }
        /**
         Up to this point, the varaible "counter" is the amount of data values for percent accuracy
         
           
         */
        if(condition == true){
        int total = 0;
        Double[]  newarray=  new Double[counter];
        for(int i = 0; i < counter; i++){
            newarray[i] = data[i];
        }
        Double[] newarray1 = new Double[counter];
        for(int i = 0; i < counter; i++){
                newarray1[i] = data1[i];
        }
        int[] newArray2 = new int[counter];
        for(int i = 0; i < counter; i++){
            newArray2[i] = data2[i];
       } 
       int[][] NewSpeed = new int[counter][];
       for(int i = 0; i < counter;i++){
           NewSpeed[i] = data3[i];
       }

        /**(
           HERE IS WHERE THE ARRAY "newarray" contains both the exact size and the data values
         */
        int data_set = 0;
        double current  = data[0];
      int  total_amount = 0;
        for(int i = 0; i < counter; i++){
            total_amount += data[i];
            //total amount just adds up all the percentages toghether for a average calculation
           
            
        }
            int  total_amount1 = 0;
              for(int i = 0; i < counter; i++){
                  total_amount1 += data1[i];
                  //total amount just adds up all the percentages toghether for a average calculation
                 
                  
              }
    
        for(int i = 1; i < counter; i++){
           
            if (current < data[i]){
                data_set = i+1;
                current = data[i];
            }
            // current holds the highest data value you have
        }
            
         // newarray will be the input for y;
        // x will be inpput for x
          
            int n3 = newarray.length;
            int[] x1 = new int[n3];
            x1[0] = 0;// if counter  = 2, x[counter] = {0,0}
            for(int i = 1; i <= n3-1; i++){ // counter would be 1, so 0, 1 positions
                x1[i] += (1 + x1[i-1]); // first one would be x[0] = 0+1, and next one would be x[1]  = 1+1
            }
            int[] newintarray= new int[counter];
            
            for(int i = 0; i <= counter-1; i++){
                newintarray[i] = (int) Math.round(data[i]);
            }
            CorrelationCalculator trial = new CorrelationCalculator();
            String choice;
           
            choice = GUI.seeData();
            speedDuration = NewSpeed;
            if(choice.equals("y")){
             
                
                int[][] mutliArr = new int [counter][2];
                // { , }, { , }
                int yiteration = 0;
                for(int i = 0; i < counter; i++){
                    mutliArr[i][yiteration]= newArray2[i];
                    yiteration ++;
                    mutliArr[i][yiteration] = newintarray[i];
                    yiteration = 0;

                }
                Percent = mutliArr;
                
               // x.addData()

                for(int i = 0; i < counter; i++){
                    GUI.DataDisplay(i+1, mutliArr[i][0], mutliArr[i][1]);
                    
                }

            }
           
            double z = trial.Correlation(x1, newintarray);
            String end_result;
            num2 = z;
            if(z < 0 && Math.abs(z) > 0.75){
                end_result = "There was a significant decrease in your driving performance, it is suggested to drive more carefully next time";
            }
            else if(z < 0 && Math.abs(z) > 0.5 && Math.abs(z) < 0.75){
                end_result = "There was a slight decrease in your driving performance over the data sets given, try and focus hard on the nexy drive!";
            }
            else if(z > 0 && Math.abs(z) > 0.75){
                end_result = "There was an increase in your driving performance over the data sets given, keep it up!";
            }
            else if(z > 0 && Math.abs(z) > 0.5 && Math.abs(z) < 0.75){
                end_result = "There was a slight increase in your driving performance over the data sets given, although you can definetly do a little better";
            }
            else{
                end_result = "The difference between each of the data sets are two minimal to be either a increase in performance or decrease in performance, It is recomended to try and drive more for more data.";
            }
         
            System.out.println(" --------------------------------------------------------------------------------------------");
            System.out.println(" --------------------------------------------------------------------------------------------");
           String end =("Total amount of money that could have been saved: $"+total_amount1+". You had an average percent accuraccy of "+    total_amount / counter+"%, your highest percent \n"+
            "accuracy was drive #"+(data_set)+", and the value was  "+current+"%"+
            ". Additionally, the correlation of the data for the data sets came out to be: "+z+". This would suggest that "+end_result);
            GUI.finalResult(end);
            num = counter;
        }
       
       
        int xnum;
        int ynum;
       
        for(int  i = 0; i < Percent.length;i++){
            xnum = Percent[i][0];
            ynum = Percent[i][1];
           
		// http://textfiles.com/100/captmidn.txt

		File file = new File("/Users/jaspalkhanuja/Desktop/text/Cplus.txt");
		Scanner scan = new Scanner(file);
        
		String fileContent = "X: "+xnum+", Y: "+ynum+",";
		while (scan.hasNextLine()) {
			fileContent = fileContent.concat(scan.nextLine() + "\n");
		}
        
		FileWriter writer = new FileWriter("/Users/jaspalkhanuja/Desktop/text/Cplus.txt");
        BufferedWriter writer2 = new BufferedWriter(writer);
		writer2.newLine();
        writer2.write(fileContent);
		writer2.close();
        File file2 = new File("/Users/jaspalkhanuja/Desktop/text/Cplus.txt");
        Scanner sc = new Scanner(file2);
        int arrsize = 0;
        while (sc.hasNextLine()){
            arrsize++;
          System.out.println(sc.nextLine());
        }
        
       
        System.out.println(arrsize);
        sc.close();

        //int[][] arr = new int[arrsize][2];
       
        Scanner sc2 = new Scanner(file2);
        int[][] arr2 = new int[arrsize][2];
        String temp;
        int i2 =0;
        int ix = 0;
        int j = 0;
        while(sc2.hasNextLine()){
          
          temp = sc2.nextLine();
          if((i2!=0)){
            arr2[ix][j] = isolateNum(temp, j);
            j++;
            arr2[ix][j] = isolateNum(temp, j);
          j--;
          ix++;
          }

          i2++;
          //arr[i][j] = 
          //System.out.println(sc2.nextLine());
        }
        textArr = arr2;
        sc2.close();
        
        /*
        for(int z = 0; z < arr.length;z++){
          for(int p = 0; p < arr[0].length;p++){
             System.out.println(arr[z][p]);
          }
        }*/
        }
        
        int totalLen = textArr.length;
        int finalArray[][] = new int[totalLen][2];
        finalArray = textArr;
        double[] xAxis2 = new double[finalArray.length];
        double[] yAxis2 = new double[finalArray.length];
        for(int  i =0;i < finalArray.length; i++){
            xAxis2[i] = (double) Math.round(finalArray[i][0]);
            yAxis2[i] = (double) Math.round(finalArray[i][0]);

        }
        finalArr = finalArray;
        
        LinearRegression line  = new LinearRegression(xAxis2, yAxis2);
        slope = line.slope();
        intercept = line.intercept();
        launch(args);
        //ReadFromFileUsingScanner adder = new ReadFromFileUsingScanner();
        
       
    }
       
       


    
}
