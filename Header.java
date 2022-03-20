import java.util.*;  
import edu.princeton.cs.algs4.LinearRegression;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Header {
    private boolean mIsFast = false;
    private int mNumValues = 0;
    private Double mTotal = 0.0;
    private Double mAverage = 0.0;
    private Double mDifference = 0.0;
    private Double mPercent = 0.0;
    private Double mIdealSpeed = 0.0;
    private Double mNumberOfTime;
    private Double x;
    private int driveDuration;
    private int[] speedIntervals;
    
    Header(){
        mNumValues = 0;
        mTotal = 0.0;
        mAverage = 0.0;
    }
    public void setDriveDuration(int n){
        driveDuration = n;
    }
    public int getDriveDuration(){
        return driveDuration;
    }
    public void setNumValues(int x){
        mNumValues = x;
    }
    public int getNumValues(){
        return mNumValues;
    }
    public double return_amount(){
        return x;
    }
    
    public void setIdealSpeed(double n){
        mIdealSpeed = n;
    }
    
    public void setGasStation(double n){
        mNumberOfTime = n;
    }
    public double getGasStation(){
        return mNumberOfTime;
    }
    public double return_percent(){
        return mPercent;
    }
    public int[] getSpeedData(){
        return speedIntervals;
    }

    public void arrayMaker(){
        MemoryGameGUI x = new MemoryGameGUI();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
/*
        System.out.println("                                     CATEGORY: DATA VALUES                       ");
        System.out.println(" --------------------------------------------------------------------------------------------");
        System.out.println(" --------------------------------------------------------------------------------------------");*/
        x.stateCat();

        int z = mNumValues ;
       // calculator x = new calculator();
        Double[] speed = new Double[z];
        boolean left = true;
        int i = 0;
        z--;
        for(int index = 0; index <= z; index ++){
            speed[index] = 0.0;
        }
        int number_counter = 1;
        while(left == true){
           
            if(i == mNumValues){
                break;
            }
            
            int value = 0;
            Scanner sc= new Scanner(System.in);
            
          /*System.out.println("                                    enter data value [" + number_counter + "]");
            
            number_counter+=1;
            value = sc.nextInt();
            System.out.println(" --------------------------------------------------------------------------------------------");
            */
           
            value = x.dataVal(number_counter);
            number_counter+=1;
            speed[i] += value;
            i++;
            value++;
            
        }
        //System.out.println(" --------------------------------------------------------------------------------------------");
        for(int total = 0; total <= z; total++){
            mTotal += speed[total];
        }
         int[] speedinterval2 = new int[speed.length];
        for(int p = 0;  p < speed.length;p++){
            speedinterval2[p] =  (int) Math.round(speed[p]);
        }
        speedIntervals = speedinterval2;
        
        String p;
        //cout<<"Where there different speed limits?: ";
        p = "yes";
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");/*
        System.out.println("                                     CATEGORY: SPEED LIMITS                     ");
        System.out.println(" --------------------------------------------------------------------------------------------");
        System.out.println(" --------------------------------------------------------------------------------------------");*/
        x.stateCat2();
        int counter = 0;
        if (p == "yes"){
    
            /*System.out.println("                       How many speed limit changes where there?:");
          
            Scanner sc= new Scanner(System.in);
            int n;
            n = sc.nextInt();
            System.out.println(" --------------------------------------------------------------------------------------------");*/
            int n = x.dataValSpeedAmount();

            Double[] array = new Double[n];
            boolean b = true;
            int count = 0;
            Double[] durationarray = new Double[n];
            for(int o = 0; o < n; o++){
                durationarray[o] = 0.0;
                array[o] = 0.0;
            }
                    while(b == true){
                Double speed_limit;
                Double duration;
                /*
                System.out.println("                       What was the speed limit:");
                Scanner sc2= new Scanner(System.in);
                
                speed_limit = (double) sc2.nextInt();
                        //cout<<"  -------------------------------------------------------------------------------------------"<<endl;
                        System.out.println("                      How long was this limit for?:");
                //cout<<"how long it last roughly(multiples of 5 minutes please)";
                Scanner sc3= new Scanner(System.in);
                
                duration = (double) sc3.nextInt();
                     System.out.println(" --------------------------------------------------------------------------------------------");
                     */

                speed_limit =(double) x.dataValSpeed();
                duration = (double) x.dataValSpeedDuration();
                durationarray[count] = duration;
                count++;
                array[counter] = speed_limit;
                counter++;
                if(counter == n){
                    b =false;
                }
                
                
            }
            int total_duration = 0;
            for(int index = 0; index < n; index++){
                total_duration+=durationarray[index];
            }
    
            int total_duration2 = 0;
            for ( int checker = 0; checker < n; checker++){
                total_duration2 +=durationarray[checker];
            }
            if(total_duration != total_duration2){
                System.out.println("invalid data input, the connclusion for thi data will be off");
               
            }
            for(int poop= 0; poop < n; poop++){
                Double variable = durationarray[poop];
                double current = array[poop];
                array[poop] = current * variable/total_duration;
                
            }
            
            int counter2  = 0;
            double idealSpeed = 0;
            for (int i2 = 0; i2 <= n-1; i2++){
                idealSpeed+=array[counter2];
                counter2 ++;
            }
            
            
            mIdealSpeed  = idealSpeed;/*
            System.out.println(" --------------------------------------------------------------------------------------------");
            System.out.println(" --------------------------------------------------------------------------------------------");*/
        }
    }
    public void AverageEvaluator(){
        Double average = 0.0;
        average = mTotal/mNumValues;
        Double average_speed= average;
        mAverage = average_speed;
        
        double idea_speed  = mIdealSpeed;
        
        String s;
        double differece = Math.abs(average_speed - idea_speed);
        mDifference = differece;
        double percent;
        if(average_speed > idea_speed){
            percent = 100*(idea_speed/average_speed);
        }
        else{
         percent = 100*(average_speed/idea_speed);
        }
        mPercent = percent;
        boolean b = true;
        while (b == true){
        if(mPercent > 100){
            mIsFast = true;
            mPercent -=100;
        }
        else{
            b= false;
        }
        }
        
        
    }

    public void EndResult(){
        MemoryGameGUI y = new MemoryGameGUI();
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        y.stateCat3();
        /*
        System.out.println("                                     CATEGORY: END RESULT                    ");
        System.out.println(" --------------------------------------------------------------------------------------------");
        System.out.println(" --------------------------------------------------------------------------------------------");*/
        double percent = mPercent;
        if (percent  > 100){
            double c = percent -100;
            double d = 100 - c;
            percent = d;
            mPercent = percent;
            
        }
        Double difference = mDifference;
        Double average_speed = mAverage;
        String s;
        if(mIsFast == true){
            s = "slow down";
        }
        else{
            s = "speed up";
        }
        boolean c = false;
        if(percent == 100){
            c = true;
        }
        else{
            c = false;
        }
        String end_result = "";
        double station_visits = 0;
        station_visits  = getGasStation();
        x = difference * 0.17*station_visits;
        
        if (c == true){
            end_result = "";
        }
        else{
            end_result = "You could actually end up saving almost $";
        }
        String endResult = "The end result is that you had an average speed of "+average_speed+" MPH, and the recommended speed for ideal \n"+
        "gas mileage is about "+mIdealSpeed+"MPH. This leaves you with an overall fuel efficiency of about "+percent+"%. \n"
        +end_result+" "+x;
        y.stateEndResult(endResult);
        
    }
}

