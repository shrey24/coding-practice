class LongestCommonSubsequence{
    // article lick: https://www.ics.uci.edu/~eppstein/161/960229.html

    /**
     * Find the length of Longest Common Subsequence (Dynamic Programming)
     * Ex:
     * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
     * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
     * 
     * Note that:
     * if last characters of both sequences match (or X[m-1] == Y[n-1]) 
     * then L(X[0..m-1], Y[0..n-1]) = 1 + L(X[0..m-2], Y[0..n-2])
     * If last characters of both sequences do not match 
     * if (or X[m-1] != Y[n-1]) 
     * then  L(X[0..m-1], Y[0..n-1]) = MAX ( L(X[0..m-2], Y[0..n-1]), L(X[0..m-1], Y[0..n-2]) )
     * 
     * Thus, we can use Dynamic Programming to solve this problem.
     * 
     * And, we can use a table to store LCS matches in L[m+1][n+1].
     * Also note that L[i][j] contains the max length of LCS checked
     * upto substrings s1[0..i-1] & s2[0..j-1].
     * We also need to store the base value.. i.e. for null string
     * ex: L[null][q] = 0 where q can be 0...n-1
     * Therefore, we take the array L with dims [m+1][n+1]
     * 
     * 
     * Complexity: O(m*n) 
     * @return: length of LCS
     */
    public static int getLengthOfLCS(String s1, String s2, int m, int n){
        // Dynamic Programming Tabulation
        // strings scanned from left to right
        int L[][] = new int[m+1][n+1];
        // L[i][j] coutains LCS checked for s1[0..i-1] & s2[0..j-1]
        // where i <= [0, m] and j <= [0, n]
        // ex: i == 0 implies s1 = null
        //  i == 1 implies s1 = s1.substring(0, 1) ..

        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0){ // if s1[0..0] or s2[0..0] (Null string)
                    L[i][j] = 0;
                }
                else if(s1.charAt(i-1) == s2.charAt(j-1)){
                    L[i][j] = 1 + L[i-1][j-1];
                }
                else{ // if mismatch between s1[i-1] and s2[j-1], check for the second last index
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
                }
            }
        }
        
        return L[m][n];
    }


    public static int getLCS(String s1, String s2, int m, int n){
        // Dynamic Programming Tabulation
        // strings scanned from right to left

        int T[][] = new int[m+1][n+1];  // i == m is the end of string ('\0')

        for(int i=m; i>=0; i--){
            for(int j=n; j>=0; j--){
                if(i == m || j == n){
                    T[i][j] = 0;
                }
                else if(s1.charAt(i) == s2.charAt(j)){
                    T[i][j] = 1 + T[i+1][j+1];
                }
                else{
                    T[i][j] = Math.max(T[i+1][j], T[i][j+1]);
                }
            }
        }

        return T[0][0];
    }


    public static void main(String[] args) {
        String s1 = "AGGTAB", s2 = "GXTXAYB";
        //System.out.println(getLengthOfLCS(s1, s2, s1.length(), s2.length()) );
        System.out.println(getLCS(s1, s2, s1.length(), s2.length()) );
    }
}