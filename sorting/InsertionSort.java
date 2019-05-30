class InsertionSort{

    public static void insertionSort(int[] arr, int len){
      for(int i=0; i<len-1; i++){ // i is pivot
        int j = i;
        int temp = arr[j+1];
        
        while(j>=0 && arr[j] > temp){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = temp;
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
        insertionSort(a, a.length);   // arrays are objects in java so there
        print(a, a.length);
    }
}