class BubbleSort{

    public static void bubblesort(int[] arr, int len){
        for(int i=0; i<len-1; i++){
            for(int j=0; j<len-1-i; j++){
                if( arr[j+1] < arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
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
        bubblesort(a, 5);   // arrays are objects in java so there
        print(a, 5);
    }
}