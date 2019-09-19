import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        int i=0;
        if(strs == null || strs.length == 0){
            return "";
        }
        while(true){
            int k;
            for(k=0 ; k<strs.length; k++){
                if(strs[0].length()<=i || strs[k].length()<=i || 
                   strs[0].charAt(i) != strs[k].charAt(i)){
                    break;
                }
            }
            if(k == strs.length){
                i++;
                System.out.println(i);   
            }
            else{
                break;
            }
        }
        
        return strs[0].substring(0, i);
    }

    public static void main(String[] args) {
        String[] s = {"flower","flow","flight"};
        String  r =longestCommonPrefix(s);
        System.out.println(r);
        String a = "asdf", b = "asx";
        System.out.println(a.indexOf(b));
        // a.startsWith(prefix);

        char ch = 'a';
        System.out.println((int)ch);
        Set<Character> set = new HashSet<>();
        set.add('e');
        set.add('f');
        System.out.println(set);
        set.removeAll(set);
        HashMap<Integer, Integer> h = new HashMap<>();
        h.put(1, 1);
        h.put(2, 2);

        h.remove(1);
        
        System.out.println(h);

        
    }

}