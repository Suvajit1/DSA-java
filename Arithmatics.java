public class Arithmatics {
    public static void main(String[] args) {
        int a=14,b=5;

        int c=a/b;
        int r=a%b;

        System.out.println(c);
        System.out.println(r);

        float d= a/b;
        System.out.println(d);

        float e = (float)a/b;   // type casting
        System.out.println(e);

        float p=14.3f,q=3.2f;

        float s=p/q;
        float t=p%q;
        System.out.println(s);
        System.out.println(t);

        byte x=10;
        short y=15;

        int z=x+y;  // short z or byte z will give error
        long z1=x+y;
        System.out.println(z+"  "+z1);

        float f=2/3;    // try f = 2/3f
        System.out.println(f);

        long r1= 15;
        float a1= p*r1;
        System.out.println(a1);

        float f1=10.2f;
        double d1=23.59;
         
        double d2= f1*d1;
        System.out.println(d2);

        
    }
}
