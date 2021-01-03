import java.util.*;

public class Sorts{
  /**Bubble sort of an int array.
  postcondition The array will be modified such that the elements will be in increasing order.
  param data  the elements to be sorted.
  */
  public static void bubbleSort(int[] _data){
    boolean sorted = false;
    while(!sorted){
      sorted = true;
      for(int i = 0; i<_data.length-1; i++){
        if(_data[i] > _data[i+1]){
          int temp = _data[i];
          _data[i] = _data[i+1];
          _data[i+1] = temp;
          sorted = false;
        }
      }
    }
  }

  /**selection sort of an int array.
  *@postcondition The array will be modified such that the elements will be in increasing order.
  *param data - the elements to be sorted.
  */
   public static void selectionSort(int[] _data){
     for(int i=0; i<_data.length; i++){
       int index = i;
       int temp = _data[i];
       for(int k=i+1; k<_data.length; k++){
         if(temp>_data[k]){
           temp = _data[k];
           index = k;
         }
       }
       if(index != i){
         _data[index] = _data[i];
         _data[i] = temp;
       }
     }
   }

  /**insertion sort of an int array.
  *@postcondition The array will be modified such that the elements will be in increasing order.
  *param data - the elements to be sorted.
  */
   public static void insertionSort(int[] _data){
     for(int i = 1; i<_data.length; i++){
       if(_data[i] < _data[i-1]){
         int temp = _data[i];
         boolean stopped = false;
         for(int k = i-1; k>=0; k--){
           if(_data[k] > temp){
             _data[k+1] = _data[k];
           } else{
             _data[k+1] = temp;
             stopped = true;
             break;
           }
         }
         if (!stopped)
         {
           _data[0] = temp;
         }
       }
     }
   }

}
