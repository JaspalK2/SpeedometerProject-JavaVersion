import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.io.File;
import java.util.Scanner;

public class ReadFromFileUsingScanner {
  public int[][] arr;
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
  public void addData(int xnum, int ynum) throws IOException{
    
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
        int i =0;
        int ix = 0;
        int j = 0;
        while(sc2.hasNextLine()){
          
          temp = sc2.nextLine();
          if((i!=0)){
            arr[ix][j] = isolateNum(temp, j);
            j++;
            arr[ix][j] = isolateNum(temp, j);
          j--;
          ix++;
          }

          i++;
          //arr[i][j] = 
          //System.out.println(sc2.nextLine());
        }
        sc2.close();
        arr = arr2;
        /*
        for(int z = 0; z < arr.length;z++){
          for(int p = 0; p < arr[0].length;p++){
             System.out.println(arr[z][p]);
          }
        }*/
  }
  
  

}
