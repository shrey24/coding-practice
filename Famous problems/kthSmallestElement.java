import java.util.Collections;
import java.util.PriorityQueue;

/*
    Ref: https://www.ics.uci.edu/~eppstein/161/960125.html
         https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time/
    find K’th Smallest/Largest Element in Unsorted Array 
    Input: arr[] = {7, 10, 4, 3, 20, 15}
           k = 3
    Output: 7
*/

class kthSmallestElement{

    
    // method1 - using heaps
    // O(k + (n-k)*Logk)
    public static int kthSmallest_heap(int[] arr, int len, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        // Make heap: O(k)
        for(int i=0; i<k; i++){
            heap.add(arr[i]);
        }

        for(int i=k; i<len; i++){   
            if(heap.peek() > arr[i]){
                // replace root by adding arr[i]: O(logk)
                heap.add(arr[i]);
                heap.poll();                
            }
        }
        return heap.peek();        
    }

    // method2 - partial quick sort
    // O(n^2): worst case | O(n) average case
    public static int kthSmallest_quick(int[] arr, int start, int end, int k){
        // Guard cond.: If k is smaller than number of elements in array
        if (k > 0 && k <= end - start + 1) { 
            // Partition the array around last  
            // element and get position of pivot  
            // element in sorted array 
            int pos = partition(arr, start, end); 

            // If position is same as k
            if (pos-start == k-1) // k-1 as arr starts with 0
                return arr[pos];

            if (k-1 < pos-start)
                return kthSmallest_quick(arr, start, pos-1, k);
            else
                return kthSmallest_quick(arr, pos+1, end, start-pos+(k-1)); 
                                                    // [start...pos..k...end]
        }
        else // k is out of [0....end-start]
            return Integer.MAX_VALUE;
    }

    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
        int i=start;
        for(int j=start; j<=end-1; j++){
            if(arr[j] < pivot) {
                int t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
                i++;
            }
        }
        int t = arr[i];
        arr[i] = arr[end];
        arr[end] = t;
        
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 1, 9, 2, 7};
        int k = 3;
        System.out.println(kthSmallest_heap(arr, arr.length, k));
        System.out.println(kthSmallest_quick(arr, 0, arr.length-1, k));        
    }
}