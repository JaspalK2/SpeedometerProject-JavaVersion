public class tester {
    public static void main(String[] args) {
        ReadFromFileUsingScanner x = new ReadFromFileUsingScanner();
       String temp = "X: 60, Y: 30,";
       int j = 0;
      System.out.println(x.isolateNum(temp, j));
      j++;
      System.out.println(x.isolateNum(temp, j));
    }
}
