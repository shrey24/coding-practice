class QuickSort{

    public static void quickSort(int[] arr, int low, int high){
        if(low<high){   // base case: exit if low >= high
            int partition_index = partition(arr, low, high);
            //arr[partition_index] is at proper place, so now 
            // recursively sort left subarray and right subarray
            quickSort(arr, low, partition_index-1);
            quickSort(arr, partition_index+1, high);
        }
    }

    /**
     * @param arr: input array
     * @param low - lower bound
     * @param high - upper bound
     * @return partition index
     * method partition() picks an element [high] as pivot element,
     * and finds its appropriate poistion by swaping all elements which are
     * less then pivot to the left of partition_index. 
     * partition_index is the real position of pivot after sorting.
     */
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high]; // pivot the last element, and find its proper index
        int partition_index = low;
        for(int i=low; i<high; i++){
            // all elements left of partition_index are < pivot
            if(arr[i] <= pivot){    // ptr i checks for elements from low to high
                swap(arr, i, partition_index);  // put arr[i] on partition_index and 
                partition_index++;              // increment partition_index
            }
        }
        swap(arr, partition_index, high); // place pivot to partition_index
        return partition_index;
    }

    public static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void print(int[] arr, int len){
        for(int i=0; i < len; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int [] a = {5, 4, 3, 2, 1};

        quickSort(a, 0, a.length-1);  // arrays are objects in java so their ref is passed
        print(a, a.length);   
    }
}