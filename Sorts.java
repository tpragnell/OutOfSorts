public class Sorts{
  /**Bubble sort of an int array.
  postcondition The array will be modified such that the elements will be in increasing order.
  param data  the elements to be sorted.
  */
  public static void bubbleSort(int[] _data){
    for(int i=0; i<_data.length; i++){
      for(int k=i+1; k<_data.length; k++){
        if(_data[i]>_data[k]){
          int t = _data[i];
          _data[i] = _data[k];
          _data[k] = t;
        }
      }
    }
  }

}
