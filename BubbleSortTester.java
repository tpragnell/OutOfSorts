import java.util.*;

public class BubbleSortTester extends Sorts{
  public static void main(String[] args){

    /*
    CUSTOM TESTING PARAMETRES
    Play around with these as much as you feel you need to.
    I set the cases very low by default.
    */

    int len = 10; // lengths of random data arrays, min 0
    int range = 1; // range of random lengths for random arrays, min 1
    int cases = 10; // amount of repetitions for random, min 0

    int lenF = 10; // lengths of forwards data arrays, min 0
    int rangeF = 1; // range of random lengths for forwards arrays, min 1
    int casesF = 10; // amount of repetitions for forwards arrays, min 0

    int lenB = 10; // lengths of backwards data arrays, min 0
    int rangeB = 1; // range of random lengths for backwards arrays, min 1
    int casesB = 10; // amount of repetitions for backwards arrays, min 0

    /*
    If range = 1, all array lengths are uniform (same for F and B counterparts)
    If range > 1, len acts as minimum (same for F and B counterparts)
    For example, if range = 3 and len = 5, the lengths of the arrays will range from 5 to 7
    */

    paramChecker(len, range, cases, lenF, rangeF, casesF, lenB, rangeB, casesB);
    Random nums;
    int[] original;
    int error = 0;
    System.out.println("\n--RANDOM TESTING--------------------------------------\n");
    for(int i = 0; i < cases; i ++){
      nums = new Random();
      int[] data = dataMaker(nums, len, range);
      original = originalMaker(data);
      bubbleSort(data);
      error = checker(data, error, original);
    }

    System.out.println("\n--FORWARDS TESTING------------------------------------\n");
    for(int i = 0; i < casesF; i ++){
      nums = new Random();
      int[] data = dataMakerF(nums, lenF, rangeF);
      original = originalMaker(data);
      bubbleSort(data);
      error = checker(data, error, original);
    }

    System.out.println("\n--BACKWARDS TESTING-----------------------------------\n");
    for(int i = 0; i < casesB; i ++){
      nums = new Random();
      int[] data = dataMakerB(nums, lenB, rangeB);
      original = originalMaker(data);
      bubbleSort(data);
      error = checker(data, error, original);
    }
    if (error == 0) System.out.println("\nNo errors, but it wouldn't hurt to keep testing!");
    else System.out.println("Whatever you do, don't submit this :P");
  }

  public static int[] dataMaker(Random nums, int len, int range){
    double myLen;
    if (range > 0) myLen = len + Math.random()*range;
    else myLen = len;
    int[] data = new int[(int) myLen];
    for (int j = 0; j < data.length; j ++){
      data[j] = nums.nextInt() % 1000;
    }
    return data;
  }

  public static int[] dataMakerF(Random nums, int lenF, int rangeF){
    double myLen;
    if (rangeF > 0) myLen = lenF + Math.random()*rangeF;
    else myLen = lenF;
    int[] data = new int[(int) myLen];
    for (int j = 0; j < data.length; j ++){
      data[j] = nums.nextInt() % 1000;
    }
    Arrays.sort(data);
    return data;
  }

  public static int[] dataMakerB(Random nums, int lenB, int rangeB){
    double myLen;
    if (rangeB > 0) myLen = lenB + Math.random()*rangeB;
    else myLen = lenB;
    int[] data = new int[(int) myLen];
    for (int j = 0; j < data.length; j ++){
      data[j] = nums.nextInt() % 1000;
    }
    Arrays.sort(data);
    for (int i = 0; i < data.length; i ++){
      if (i >= (data.length-1) - i) break;
      else{
        int temp = data[i];
        data[i] = data[(data.length-1) - i];
        data[(data.length-1) - i] = temp;
      }
    }
    return data;
  }

  public static int[] originalMaker(int[] data){
    int[] original = new int[data.length];
    for (int i = 0; i < original.length; i ++){
      original[i] = data[i];
    }
    return original;
  }

  public static int checker(int[] data, int error, int[] original){
    for(int j =  0; j < data.length - 1; j++ ){
      if(data[j] > data[j+1]){
        System.out.print("ERROR:    {");
        printlnArray(data);
        System.out.print("ORIGINAL: {");
        printlnArray(original);
        System.out.println("");
        return 1;
      }
    }
    if (error == 1) return 1;
    else return 0;
  }

  public static void printlnArray(int[] data){
    for (int k = 0; k < data.length; k ++){
      System.out.print(data[k]);
      if (!(k == data.length - 1)) System.out.print(", ");
    }
    System.out.println("}");
  }

  public static void paramChecker(int len, int range, int cases,
                                  int lenF, int rangeF, int casesF,
                                  int lenB, int rangeB, int casesB){
    if (len < 0) throw new IndexOutOfBoundsException("len must be >= 0");
    if (range < 1) throw new IndexOutOfBoundsException("range must be > 0");
    if (cases < 0) throw new IndexOutOfBoundsException("cases must be >= 0");
    if (lenB < 0) throw new IndexOutOfBoundsException("lenB must be >= 0");
    if (rangeB < 1) throw new IndexOutOfBoundsException("rangeB must be > 0");
    if (casesB < 0) throw new IndexOutOfBoundsException("casesB must be >= 0");
    if (lenF < 0) throw new IndexOutOfBoundsException("lenF must be >= 0");
    if (rangeF < 1) throw new IndexOutOfBoundsException("rangeF must be > 0");
    if (casesF < 0) throw new IndexOutOfBoundsException("casesF must be >= 0");
  }
}
