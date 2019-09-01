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
        
    }

}