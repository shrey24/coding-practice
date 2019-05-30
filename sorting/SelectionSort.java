class SelectionSort{

    public static void selectsort(int[] arr, int len){
      for(int i=0; i<len-1; i++){
        int minIndex = i;
        for(int j = i+1; j<len; j++){
            if(arr[j] < arr[minIndex]){
                minIndex = j;
            }
        }
        
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
      }
    }

    public static void print(int[] arr, int len){
        for(int i=0; i < len; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int [] a  = { 5, 4, 3, 2, 1};
        selectsort(a, 5);   // arrays are objects in java so there
        print(a, 5);
    }
}