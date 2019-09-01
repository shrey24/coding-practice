import java.util.HashMap;
import java.util.Map;

class MoveZeros{

    /**
     * Given an array nums, write a function to move all 0's to the end of it 
     * while maintaining the relative order of the non-zero elements.
        
    Example:
        Input: [0,1,0,3,12]
        Output: [1,3,12,0,0]
     
    Note:
        You must do this in-place without making a copy of the array.
        Minimize the total number of operations.
     */

     // try only 1 for loop - Time: O(n) Space: O(1)
    public static void moveZeros(int[] nums) {
        int nonZeroPtr = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[nonZeroPtr] = nums[i];
                nonZeroPtr++;
            }
        }
        for(int i=nonZeroPtr; i<nums.length; i++){
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        moveZeros(arr);
        for(int i=0;i<arr.length; i++){
            System.out.print(" "+arr[i]);
        }

        HashMap <Integer, Integer> hm = new HashMap<>();
  
        
        

    }
}