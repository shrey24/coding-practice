class StringPermutation{

    public static void permutation(String str, String prefix){
        if(str.length() == 0){
            System.out.println(prefix);
        }
        else{
            for(int i=0; i<str.length(); i++){
                String rem = str.substring(0, i) + str.substring(i+1);
                permutation(rem, prefix+str.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        String s = "abc" , prefix="";
        // for(int i =0 ; i<s.length(); i++){
        //     System.out.println(s.substring(0, i) + "  "+ s.substring(i+1));
        //     prefix += s.charAt(i);
        //     System.out.println("prefix: "+prefix);
        // }

        permutation(s, "");
        
    }
}