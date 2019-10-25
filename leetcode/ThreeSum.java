import java.util.*;

class ThreeSum{

    //Approach 1 2 ptr (best)
    // O(n^2) time and O(1) Space
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result;
        result = new ArrayList<List<Integer>>();
        
        //Array must be sorted for 2 ptr method to work
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length; i++){
            //avoid duplicate
            if(i!=0 && nums[i] == nums[i-1]) continue;
            
            int j = i+1;
            int k = nums.length-1;
            
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == 0){
                    ArrayList<Integer> row = new ArrayList<>();
                    row.add(nums[i]);
                    row.add(nums[j]);
                    row.add(nums[k]);
                    result.add(row);
                    j++;
                    k--;
                    //IMPORTANT: to avoid duplicates
                    while(j<k && nums[j] == nums[j-1]) j++;
                }
                else if(sum < 0){
                    j++;
                }
                else{
                    k--;
                }                                
            }
        }
        
        return result;        
    }

    // approach 2: using hashset
    // O(n^2) Time and O(n) Space
    public static List<List<Integer>> threeSumH(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums); // sorting for checking duplicates later
        // {-4, -1,-1,0,1,2,};
        for(int i=0; i<nums.length-1; i++) {
            if(i != 0 && nums[i] == nums[i-1]) continue; // check dublicates
            HashSet<Integer> s = new HashSet<Integer>();
            for (int j = i + 1; j < nums.length; j++) {
                
                int x = -(nums[i] + nums[j]);
                if (s.contains(x)) { 
                    List<Integer> row = Arrays.asList(x, nums[i], nums[j]);
                    result.add(row);
                    //put deplicate check here only for j!!
                    while(j+1<nums.length && nums[j+1] == nums[j]) j++;
                    
                }  
                else { 
                    s.add(nums[j]); 
                } 
            } 
        }

        return result;
    }


    public static void main(String[] args) {
        

        List<List<Integer>> result;
        // result = new ArrayList<List<Integer> >();
        // ArrayList<Integer> row = Arrays.asList(new Integer[]{1 ,2, 3});
        // result.add(row);
        // System.out.println(result);
        int[] arr = new int[]{-1,0,1,2,-1,-4};
        // List<Integer> l = Arrays.asList(arr);
        // System.out.println(l.getClass());
        List<List<Integer>> res = threeSumH(arr);
        System.out.println(res);

// 1 1 2 2 3 3 4 4 5 5 6 6 7 7 8 8 8
    }
}