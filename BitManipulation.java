public class BitManipulation {

    public static void oddOrEven(int num){
       int res=num&1;
       if(res==1){
        System.out.println("Odd");
       }else{
        System.out.println("Even");
       }
    }

    public static int getbit(int number,int i){
        int bitMask=1<<i;
        return (number & bitMask)>>i;
    }

    public static int setbit(int number,int i){
        if(getbit(number, i)==1){
            System.out.println("bit is already set");
            return number;
        }else{
            int bitMask=1<<i;
            return number | bitMask;
        }
    }

    public static int cleraBit(int number, int i){
        if(getbit(number, i)==0){
            System.out.println("bit is already clear");
            return number;
        }else{
            int bitMask= ~(1<<i);
            return number&bitMask;
        }
    }

    public static int update(int num, int pos, int newBit){
        if(newBit==0){
            return cleraBit(num, pos);
        }else{
            return setbit(num, pos);
        }
    }

    // 2nd way to update 
    public static int cleraBit2(int number, int i){
        int bitMask= ~(1<<i);
        return number&bitMask;
    }
    public static int update2ndway(int num, int i, int newBit){
        int number =cleraBit2(num, i);

        int bitMask = newBit<<i;
        return  number | bitMask;  
    }
    // .

    public static int clearLastIBits(int number,int i){
        int bitMask = -1 << i;
        return number & bitMask;
    }

    public static int clearRangeOfBits(int number, int start, int end){
        int a = (~0)<<(end+1);
        int b = (1<<start)-1;
        int bitMask = a|b ;
        return number & bitMask ;
    }

    public static boolean isPowerOfTwo(int n){
        return (n&(n-1))==0;
    }

    // way 1
    public static int countSetBits_1(int num){
        String n=Integer.toBinaryString(num);
        int count =0;
        for(int i=0;i<n.length();i++){
            if(n.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }

    //way 2
    public static int countSetBits_2(int num){
        int count=0;
        while(num>0){
            if((num&1)!=0){
                count++;
            }
            num=num>>1;
        }
        return count;
    }

    public static int fastExpo(int a, int n){
        int ans=1;

        while(n>0){
            if((n&1) !=0 ){
                ans=ans*a;
            }
            a=a*a;
            n=n>>1;
        }
        return ans;
    }

    public static void main(String[] args) {
        oddOrEven(10);
        oddOrEven(19);
        System.out.println(getbit(10, 1));
        System.out.println(setbit(10, 2));
        System.out.println(setbit(10, 1));
        System.out.println(cleraBit(10, 1));
        System.out.println(cleraBit(10, 2));
        System.out.println(update(10, 1, 0));
        System.out.println(update(10, 2, 1));
        System.out.println(update2ndway(10, 1, 0));
        System.out.println(update2ndway(10, 2, 1));

        System.out.println(clearLastIBits(15, 2));
        System.out.println(clearRangeOfBits(15, 1, 2));

        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(129));
        System.out.println(countSetBits_1(10));
        System.out.println(countSetBits_2(10));

        System.out.println(fastExpo(3, 5));
        System.out.println(fastExpo(5, 3));
    }
}