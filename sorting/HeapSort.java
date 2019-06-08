import java.util.*;

class HeapSort{

    private static int getParentIndex(int index){
        return (index-1)/2;
    }

    private static int getLeftChildIndex(int index){
        return 2*index+1;
    }

    private static int getRightChildIndex(int index){
        return 2*index+2;
    }

    //for max heap
    // assumes all child nodes from root parent are already having heap property
    // O(log n)
    private static void heapifyDownFromIndex(int[] arr, int index, int len){
        int i = index;
        while( getLeftChildIndex(i) < len){ // while entire arr traversed
            int biggerChildIndex = getLeftChildIndex(i);
            if(getRightChildIndex(i) < len && 
                arr[getRightChildIndex(i)] > arr[getLeftChildIndex(i)]){
                    biggerChildIndex = getRightChildIndex(i);
            }
            if(arr[biggerChildIndex] > arr[i]){
                int t = arr[i];
                arr[i] = arr[biggerChildIndex];
                arr[biggerChildIndex] = t;
                i = biggerChildIndex;
            }
            else{   // all elements from index...len satisfy heap property
                break; 
            }
        }
    }
    // O(nlogn) ==> tight upper bound O(n)
    public static void buildMaxHeap(int[] arr, int len){
        int firstNonLeafNodeIndex = getParentIndex(arr[len-1]);
        for(int i=firstNonLeafNodeIndex; i>=0; i--){
            heapifyDownFromIndex(arr, i, len);
        }
    }
    // O(nlogn)
    public static void heapSort(int[] arr, int len){
        buildMaxHeap(arr, len); // O(nlogn)
        int heapSize = len;
       
        while(heapSize>1){  // O(nlogn)
            int t = arr[0];
            arr[0] = arr[heapSize-1];
            arr[heapSize-1] = t;
            heapSize--;
            heapifyDownFromIndex(arr, 0, heapSize);
            
            
        }
    }

    public static void heapSortBuiltin(int[] arr, int len){
        //build-in max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : arr) {
            maxHeap.add(i);
        }
        for(int i=len-1; i>=0; i--){
            arr[i] = maxHeap.poll();
        }
    }

    public static void print(int[] arr, int len){
        for(int i=0; i < len; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int [] a  = {5, 4, 3, 2, 1};
        heapSort(a, a.length);   // arrays are objects in java so there
        print(a, a.length);
    }
}