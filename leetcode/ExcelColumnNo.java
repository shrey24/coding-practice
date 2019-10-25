class ExcelColumnNo{
    public int titleToNumber(String s) {
        int res = 0;
        for(int i=s.length()-1; i>=0; i--){
            int pos = s.length()-i-1; //CA / AAA - BA A
            res += (s.charAt(i)-64) * Math.pow(26, pos);
        }
        
        return res;
    }
    public static void main(String[] args) {
        System.out.println((int)'A');
    }
}