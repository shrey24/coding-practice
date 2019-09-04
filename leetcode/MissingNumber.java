class MissingNumber {
    /*
    Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
    Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
    */
    
    // using XOR  T: O(n) S: O(1)
    // 1^1 = 0, 2^2 = 0, ...
    //  0^Anything = Anything
    public int missingNumberUsingBitManip(int[] nums){
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;

    }

    // T: O(n) S: O(1)
    public int missingNumber(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        
        int total = ((nums.length+1)*(nums.length))/2;
        
        return total-sum;    
    }

    public static void main(String[] args) {
        System.out.println(0^2);
        char r = 0;
        char a = 'a';
        System.out.println(r^a);
    }
}