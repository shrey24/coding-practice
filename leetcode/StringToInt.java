class StringToInt{

    public static int myAtoi(String str) {
        if(str == null || str.length() == 0) 
            return 0;

        str = str.trim();
        long res=0;
        int neg = 1, start=0;
        if (str.charAt(0) == '-'){
            neg = -1; start=1;
        }
        else if(str.charAt(0) != '+' ){
            start=1;
        }
        
        for(int i=start; i<str.length(); i++){
            if(Character.is)
        }


        return Integer.parseInt(str);

    }


    public static void main(String[] args) {
        String s = "    hi    ";
        String max = String.valueOf(Integer.MAX_VALUE);
        System.out.println("max int:"+max);
        StringBuilder sb = new StringBuilder(max);
        
        int lastIndex = sb.length()-1;
        int n = Integer.parseInt(sb.substring(lastIndex));
        sb.replace(sb.length()-1, sb.length(), Integer.toString(n+1) );
        String x = sb.toString();
        System.out.println(sb.toString());
        int i = Integer.MAX_VALUE ;
        i++;
        System.out.println(i);
    }
}