import java.util.*;

class parentheses{

    public static boolean isValid(String s) {
        HashMap<Character, Character> hm = new HashMap<>();
        hm.put(')', '(');
        hm.put('}', '{');
        hm.put(']', '[');
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if( hm.containsKey(ch) ){   // if ch is closing bracket
                char top = st.empty() ? '#' : st.pop();
                if(top != hm.get(ch)){
                    return false;
                }
            }
            else{                
                st.push(ch);
            }
        }
        
        return st.isEmpty();
    }


    public static void main(String[] args) {
        String s = "()()({{[])}}";
        System.out.println(isValid(s));
    }
}