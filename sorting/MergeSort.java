class MergeSort{

    // 2 sorted arrays arr[start:mid] and arr[mid+1, end] are merged back into arr
    public static void merge(int[] arr, int start, int mid, int end){
        int[] sortedArray = new int[end-start+1];
        int i = start; //ptr to array arr[start:mid]
        int j = mid+1; //ptr to array arr[mid+1, end]
        int k = 0;

        for(int x=0; x<end-start+1; x++){   // OR while(True){ ..
            if(i > mid){ // left arr completed
                sortedArray[k++] = arr[j++];
            }
            else if(j > end){ // right arr completed
                sortedArray[k++] = arr[i++];
            }
            else if(arr[i] < arr[j]){
                sortedArray[k++] = arr[i++];
            }
            else{   // arr[i] >= arr[j]
                sortedArray[k++] = arr[j++];
            }
        }

        // copy back
        for(int x=0; x<end-start+1; x++){
            arr[start+x] = sortedArray[x];
        }
    }

    public static void mergeSort(int[] arr, int start, int end){
        if(start < end){
            int mid = (end+start)/2;
            //split in 2 parts
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            //merge
            merge(arr, start, mid, end);   
        }
    }

    public static void print(int[] arr, int len){
        for(int i=0; i < len; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int [] a = {5, 4, 3, 2, 1};
        
        mergeSort(a, 0, a.length-1);  // arrays are objects in java so their ref is passed
        print(a, a.length);
    }
}