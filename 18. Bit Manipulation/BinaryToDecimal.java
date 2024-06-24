public class BinaryToDecimal {
    public static void binToDecimal(String binNun){
        int power = 0;
        int dec = 0;
        int digit;
        for(int i =binNun.length()-1; i>=0; i--){
            if( binNun.charAt(i)=='0'){
                digit=0;
            }
            else{
                digit=1;
            }
            dec= dec + digit * (int)Math.pow(2,power);
            power++;
        }
        System.out.println("Decimal of binary no: "+binNun+" is = "+dec);
    }
    public static void binToDecimal(int binNo){
        int digit;
        int dec=0;
        int pow=0;
        int n=binNo;
        while (n>0) {
            digit=n%10;
            dec= dec+digit*(int)Math.pow(2, pow);
            pow++;
            n=n/10;
        }
        System.out.println("Decimal of "+binNo+" is "+dec);
    }
    public static void decimalToBinary(int decNo){
        int n=decNo;
        int pow=0,rem;
        long binNo=0; 

        while(n>0){
            rem=n%2;
            binNo= binNo+rem*(long)Math.pow(10,pow);
            pow++;
            n=n/2;
        }
        System.out.println("Binari of " +decNo+ " is " + binNo);
    }
    public static void main(String[] args) {
        binToDecimal("1111110111101000000");
        decimalToBinary(520000);
        binToDecimal(11110010);
    }
}
