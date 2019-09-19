import java.util.*;
/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/solution/
 * 
 * Given a string, find the length of the longest substring 
 * without repeating characters.
 * 
    Input: "abcabcbb"
    Output: 3 
    Explanation: The answer is "abc", with the length of 3. 
 * 
 */

class LongestSubstringWithUniqueChar{

    // sliding window
    //using sets T: O(2n) = O(n)  Space: O(min(26[chars], n[len of input]))
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i=0, j=0;
        int ans=0;
        while(i < s.length() && j < s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans, j - i);
            }
            else{
                set.remove(s.charAt(i));
                i++;
            }
        }

        return ans;
    }

    // Optimization of previous method - use HashMap<char, index>
    // Time: O(n) Space O(min(charSet(26), inp_len))
    public int lenSubStrUsingHashMap(String s){
        int i=0, j=0; // window ptrs [i, j) i=first, j=last
        Map<Character, Integer> hm = new HashMap<>();
        int ans = 0;

        for(j=0; j<s.length(); j++){
            if(hm.containsKey(s.charAt(j))){
                // set start index to repeatChar+1 if it is after i
                i = Math.max(i, hm.get(s.charAt(j))+1); 
            }
            ans = Math.max(ans, j - i + 1);
            //put new char or replace existing with new index
            hm.put(s.charAt(j), j); 
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestSubstringWithUniqueChar o = new LongestSubstringWithUniqueChar();

        System.out.println(o.lenSubStrUsingHashMap("pwwkew"));
    }
}