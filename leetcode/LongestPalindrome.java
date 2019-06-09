class LongestPalindrome{



    // expand from center 
    // O(n^2) Time : O(1) Space
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1){
            return "";
        }
        int i=0, j=0;
        for(int k=0; k<s.length(); k++){
            int[] odd = expand(s, k, k);
            int[] even = expand(s, k, k+1);
            int[] max = (odd[1] - odd[0])>(even[1]-even[0]) ? odd : even;
            int len = max[1] - max[0];
            if(j-i < len){
                j = max[1];
                i = max[0];
            }
        }
        
        return s.substring(i, j+1);
    }
    
    public int[] expand(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        int[] res = new int[2];
        res[0] = ++left;
        res[1] = --right;
        return res;
    }


    // Dynamic programming
    public String longestPalindromeDP(String s) {
        if(s == null || s.length()<1){
            return "";
        }
        
        // -1:absent 0:false 1:true
        int[][] table = new int[s.length()][s.length()];
        for(int i=0; i<s.length();i++){
            for(int j=0; j<s.length();j++){
                table[i][j] = -1;
            
            }
        }

        int maxlen = 0;
        int[] max_index = new int[2];
        for(int i=1; i<=s.length(); i++){ // i is the length of substring
            for(int j=0; j<=s.length()-i; j++){ // j is start point
                if(isPalindrome(s, j, j+i-1, table) == 1 && i > maxlen){
                    maxlen = i;
                    max_index = new int[]{j, j+i-1};
                }
            }
        }
        return s.substring(max_index[0], max_index[1]+1);
    }
    
    public int isPalindrome(String s, int start, int end, int[][] table){
        if(end == start){
            table[start][end] = 1;
            return 1;
        }
        else if(start+1 == end){ // 2 consicutive chars
            int x = (s.charAt(start) == s.charAt(end))?1:0;
            table[start][end] = x;
            return x;
        }
        else{
            if(s.charAt(start) != s.charAt(end)){
                table[start][end] = 0;
                return 0;
            }
            else{
                if(table[start+1][end-1] != -1){ // contains key
                    table[start][end] = table[start+1][end-1];
                    return table[start][end];
                }
                else{
                    return isPalindrome(s, start+1, end-1, table);
                }
            }
        }
    }

    public static void main(String[] args) {
        String s = "abddgsdg";
        System.out.println(s.substring(0, 2));
        int a[][] = new int [2][2];
        a[0][0] = 1;
        if((boolean)1)
        System.out.println(true );
        else
        System.out.println(false );

    }
}