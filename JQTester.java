import java.util.Random;
import java.util.Arrays;

public class JQTester {
  public static boolean DEBUG = true;

  public static void dprint(String s){
    if(DEBUG){
      System.out.println("" + s);
    }
  }

  public static void dprint(boolean b){
    if(DEBUG){
      System.out.println("" + b);
    }
  }
  public static int[] revArray(int[] arr) {
    int[] ttt = new int[arr.length];
    for (int i = 0; i<arr.length; i++) {
      ttt[i] = arr[arr.length-i-1];
    }
    return ttt;
  }

  public static void reshuffle(int n, Random rng, int[] nums, int[] numsT) {
    for(int i = 0; i < n; i++) {
      int x = (rng.nextInt() % 1000);
      nums[i] = x;
      numsT[i] = x;
    }
  }

  public static void reshuffle2(int n, Random rng, int[] nums, int[] numsT) {
    for(int i = 0; i < n/2; i++) {
      int x = (rng.nextInt() % 1000);
      nums[2*i+1] = x;
      nums[2*i] = x;
      numsT[2*i+1] = x;
      numsT[2*i] = x;
    }
  }

  public static void reshuffle3(int n, Random rng, int[] nums, int[] numsT) {
    int x = (rng.nextInt() % 1000);
    for(int i = 0; i < n; i++) {
      nums[i] = x;
      numsT[i] = x;
    }
  }

  public static void main(String[] args) {
    int[] nums = new int[10];
    int[] numsT = new int[10];
    Random rng = new Random(100);
    for(int i =  0; i < 10; i++) {
      int n = (rng.nextInt() % 1000);
      nums[i] = n;
      numsT[i] = n;
    }
    int n = 0;

    dprint("General Testing for all sorts");
    rng = new Random();
    n = 100;
    boolean allTrue = true;
    if (args.length>0) {
      n = Integer.parseInt(args[0]);
    }
    nums = new int[n];
    numsT = new int[n];
    for(int i =  0; i < n; i++) {
      int x = (rng.nextInt() % 1000);
      nums[i] = x;
      numsT[i] = x;
    }
    dprint("---Random Numbers tester---");
    dprint("bubbleSort() ");
    Arrays.sort(numsT);
    Sorts.bubbleSort(nums);
    dprint(Arrays.equals(nums, numsT));
    if (!Arrays.equals(nums, numsT)) {
      allTrue = false;
    }
    dprint("..");
    dprint("selectionSort() ");
    reshuffle(n, rng, nums, numsT);
    Arrays.sort(numsT);
    Sorts.selectionSort(nums);
    dprint(Arrays.equals(nums, numsT));
    if (!Arrays.equals(nums, numsT)) {
      allTrue = false;
    }
    dprint("...");
    dprint("insertionSort() ");
    reshuffle(n, rng, nums, numsT);
    Arrays.sort(numsT);
    Sorts.insertionSort(nums);
    dprint(Arrays.equals(nums, numsT));
    if (!Arrays.equals(nums, numsT)) {
      allTrue = false;
    }
    reshuffle(n, rng, nums, numsT);

    dprint("");
    dprint("---Reverse Sorted Arrays---");

    dprint("bubbleSort() ");
    Arrays.sort(numsT);
    nums = revArray(Arrays.copyOf(numsT, numsT.length));
    Sorts.bubbleSort(nums);
    dprint(Arrays.equals(nums, numsT));
    if (!Arrays.equals(nums, numsT)) {
      allTrue = false;
    }
    dprint("..");
    dprint("selectionSort() ");

    reshuffle(n, rng, nums, numsT);

    Arrays.sort(numsT);
    nums = revArray(Arrays.copyOf(numsT, numsT.length));
    Sorts.selectionSort(nums);
    dprint(Arrays.equals(nums, numsT));
    if (!Arrays.equals(nums, numsT)) {
      allTrue = false;
    }
    dprint("...");
    dprint("insertionSort() ");

    reshuffle(n, rng, nums, numsT);

    Arrays.sort(numsT);
    nums = revArray(Arrays.copyOf(numsT, numsT.length));
    Sorts.insertionSort(nums);

    dprint(Arrays.equals(nums, numsT));
    if (!Arrays.equals(nums, numsT)) {
      allTrue = false;
    }
    dprint("");

    reshuffle2(n, rng, nums, numsT);
    dprint("---Half Duplicates Tester---");
    dprint("bubbleSort() ");
    Arrays.sort(numsT);
    Sorts.bubbleSort(nums);
    dprint(Arrays.equals(nums, numsT));
    if (!Arrays.equals(nums, numsT)) {
      allTrue = false;
    }
    dprint("..");
    dprint("selectionSort() ");
    reshuffle2(n, rng, nums, numsT);
    Arrays.sort(numsT);
    Sorts.selectionSort(nums);
    dprint(Arrays.equals(nums, numsT));
    if (!Arrays.equals(nums, numsT)) {
      allTrue = false;
    }
    dprint("...");
    dprint("insertionSort() ");
    reshuffle2(n, rng, nums, numsT);
    Arrays.sort(numsT);
    Sorts.insertionSort(nums);
    dprint(Arrays.equals(nums, numsT));
    if (!Arrays.equals(nums, numsT)) {
      allTrue = false;
    }
    dprint("");

    reshuffle3(n, rng, nums, numsT);
    dprint("---All Duplicates Tester---");
    dprint("bubbleSort() ");
    Arrays.sort(numsT);
    Sorts.bubbleSort(nums);
    dprint(Arrays.equals(nums, numsT));
    if (!Arrays.equals(nums, numsT)) {
      allTrue = false;
    }
    dprint("..");
    dprint("selectionSort() ");
    reshuffle3(n, rng, nums, numsT);
    Arrays.sort(numsT);
    Sorts.selectionSort(nums);
    dprint(Arrays.equals(nums, numsT));
    if (!Arrays.equals(nums, numsT)) {
      allTrue = false;
    }
    dprint("...");
    dprint("insertionSort() ");
    reshuffle3(n, rng, nums, numsT);
    Arrays.sort(numsT);
    Sorts.insertionSort(nums);
    dprint(Arrays.equals(nums, numsT));
    if (!Arrays.equals(nums, numsT)) {
      allTrue = false;
    }

    dprint("");
    dprint("Overall Status:");
    if (allTrue) {

      dprint("all True");
    } else {
      dprint("false");
    }
    if (args.length==0) {
      dprint("spam args[0] to change datasize");
    }

  }
}
