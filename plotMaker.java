import edu.princeton.cs.algs4.LinearRegression;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.util.*;  
 
 
public class plotMaker extends Application {
   
    public static int[][] Percent;
    public static int num;

    public static Double num2;
    public static double intercept;
    public static double slope;

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
        final NumberAxis xAxis = new NumberAxis(0, num*2, 1);
        final NumberAxis yAxis = new NumberAxis(0, 100, 1);        
        final ScatterChart<Number,Number> sc = new
            ScatterChart<Number,Number>(xAxis,yAxis);
            final LineChart<Number,Number> lc = new
        LineChart<Number,Number>(xAxis,yAxis);
        xAxis.setLabel("Score");                
        yAxis.setLabel("Rounds");
        sc.setTitle("Drive  Vs. Percent Efficiency, Correlation(R): "+ String.format("%.2f", num2)+", Linear Regression Line: "+ String.format("%.2f", slope)+"X +  "+String.format("%.2f", intercept));
       
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Total Score Vs. Total Round Points");
        for(int i = 0; i<num; i++){
            series1.getData().add(new XYChart.Data(Percent[i][0], Percent[i][1]));
        
        }
        series1.getData().add(new XYChart.Data(4.2, 193.2));
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("line");
        for(int i = 0; i<num; i++){
            series2.getData().add(new XYChart.Data(Percent[i][0], Percent[i][1]));
        
        }
 
        sc.getData().addAll(series1);
        
        Scene scene  = new Scene(sc, 800, 600);
        stage.setScene(scene);
        stage.show();
    }
   
 /**
   * This function will run the entire program, here it will run through all prefeerences that the user may want to select such as the easy or hard game mode, or the randomized words game mode, it will finally take all this, store it in a 2d array with the score and the rounds, and run the plot graph function along with the correaltion function to label the plot
   * 
   */
    public static void main(String[] args) {
        System.out.println("  //=======================================================================================\\");
        System.out.println("  ||                                      Speedomter Project                               || ");
        System.out.println("  //=======================================================================================\\");
        
        Header miles = new Header();
        //
        int n;
        int lenght;
        System.out.println("");
        System.out.println("");
        System.out.println(" --------------------------------------------------------------------------------------------");
    
        System.out.println("                        How long was your drive?(in minutes):\n"+
        "                                                   ");
        
        Scanner sc2= new Scanner(System.in);
                
        lenght =  sc2.nextInt();
       
        System.out.println(" --------------------------------------------------------------------------------------------");
        n = lenght;
        //cout+"  -------------------------------------------------------------------------------------------"+endl;
       
        System.out.println("                        How many times do you think you visit a gas station per week?\n"+
        "                                                   ");
        
        Double x;
        Scanner sc3= new Scanner(System.in);
                
        x =  (double) sc3.nextInt();
        System.out.println(" --------------------------------------------------------------------------------------------");
        x= x*52.0;
     
        System.out.println(" --------------------------------------------------------------------------------------------");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        miles.setGasStation(x/5);
        
        miles.setNumValues(n);
        miles.arrayMaker();
        miles.AverageEvaluator();
        miles.EndResult();
        
        double current_percent;
        current_percent = miles.return_percent();
        double current_amount = miles.return_amount();
        
        boolean condition = true;
        
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println(" --------------------------------------------------------------------------------------------");
        System.out.println("                       Do you have an additional data set?(y/n): \n"+
        "                                                   ");

        String s;
        Scanner sc4= new Scanner(System.in);
                
        s =   sc4.nextLine();
       
        System.out.println(" --------------------------------------------------------------------------------------------");
        if (s.equals( "y")){
            condition  =true;
        }
        else{
            condition = false;
        }
        Double[] data = new Double[100];
        Double[] data1 = new Double[100];
        data[0] = current_percent;
        data1[0] = current_amount;
        int  counter   =1;
        
        while(condition == true){
            
            Header miles2 = new Header();
            //
            int n2;
            int lenght2;
            System.out.println("");
            System.out.println("");
            System.out.println(" --------------------------------------------------------------------------------------------");
        
            System.out.println("                        How long was your drive?(in minutes):\n"+
            "                                                   ");
            
            Scanner sc5= new Scanner(System.in);
                    
            lenght2 =  sc5.nextInt();
           
            System.out.println(" --------------------------------------------------------------------------------------------");
            n2 = lenght2;
            //cout+"  -------------------------------------------------------------------------------------------"+endl;
           
            System.out.println("                        How many times do you think you visit a gas station per week?\n"+
            "                                                   ");
            
            Double x2;
            Scanner sc6= new Scanner(System.in);
                    
            x2 =  (double) sc6.nextInt();
            System.out.println(" --------------------------------------------------------------------------------------------");
            x2= x2*52.0;
         
            System.out.println(" --------------------------------------------------------------------------------------------");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
    
            miles2.setGasStation(x2/5);
            
            miles2.setNumValues(n2);
            miles2.arrayMaker();
            miles2.AverageEvaluator();
            miles2.EndResult();
            double new_data  =  miles2.return_percent();
            double new_data1= miles2.return_amount();
            data[counter] = new_data;
            data1[counter] = new_data1;
            counter++;
            System.out.println("                        Do you have an Additional Data Set?(y/n): :\n"+
            "                                                   ");
            String s2;
            Scanner sc7= new Scanner(System.in);
                    
            s2 =  sc7.nextLine();
           
            if (s2== "y"){
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
            System.out.println("                       See Data Points before conclusion(y/n): \n"+
            "                                                   ");
            Scanner sc8= new Scanner(System.in);
                
            choice =  sc8.nextLine();
           
            if(choice.equals("y")){
                System.out.println(" ----------------------------");
                    System.out.println("            x     ,     y");
                int[][] mutliArr = new int [counter][2];
                // { , }, { , }
                int yiteration = 0;
                for(int i = 0; i < counter; i++){
                    mutliArr[i][yiteration]= x1[i];
                    yiteration ++;
                    mutliArr[i][yiteration] = newintarray[i];
                    yiteration = 0;

                }
                Percent = mutliArr;
                for(int i = 0; i < counter; i++){
                    
                    System.out.println(" Data value #"+(i+1)+": "+"["+ mutliArr[i][0] +","+ mutliArr[i][1] +"]");
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
            System.out.println("Total amount of money that could have been saved: "+total_amount1+". You had an average percent accuraccy of "+    total_amount / counter+", your highest percent \n"+
            "accuracy was drive #"+data_set+1+", and the value was  "+current+"%"+
            ". Additionally, the correlation of the data for the data sets came out to be: "+z+". This would suggest that "+end_result);
            num = counter;
        }
        double[] xAxis = new double[counter];
        double[] yAxis = new double[counter];
        for(int i = 0; i < counter;i++){
             Double  X =  (double) Math.round(Percent[i][0]);
            xAxis[i] = X;
            Double  Y =  (double) Math.round(Percent[i][1]);
            yAxis[i] = Y;

        }
        
        
        LinearRegression line  = new LinearRegression(xAxis, yAxis);
        slope = line.slope();
        intercept = line.intercept();
        launch(args);
    }
       
       


    
}
