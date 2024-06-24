public class BitwiseDemo {
    public static void main(String[] args) {
        byte x=10;     //  posible if z is int type data
        int z;
        z=x>>1;

        System.out.println(z);

        int a=10, b=6, c1,c2,c3,c4,c5,c6,c7;
        c1=a&b;
        c2=a|b;
        c3=a^b;
        c4=a<<1;
        c5=a>>1;
        c6=a>>>1;   //unsign right shift of possitive no
        c7=~a;

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);

    
        int p=-10,q1,q2,q3;
        q1=p>>1;
        q2=p>>>1;
        q3=~p;

        System.out.println(q1);
        System.out.println(q2);
        System.out.println(q3);

        System.out.println(String.format("%s", Integer.toBinaryString(p)));
        System.out.println(Integer.toBinaryString(q1));
        System.out.println(String.format("%s", Integer.toBinaryString(q2)));
        System.out.println(Integer.toBinaryString(10));
        System.out.println(String.format("%32s", Integer.toBinaryString(10)));

        int t=-10;

        System.out.println(t>>1);
        System.out.println(t>>>1);
        


    }
}
