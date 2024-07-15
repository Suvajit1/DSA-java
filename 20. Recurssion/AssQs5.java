// Tower of Hanoi

public class AssQs5 {

    public static void towerOfhanoi(int n, String src, String helper, String dest){
        if(n==1){
            System.out.println("disk "+n+" is transfer from "+src+" to "+dest);
            return;
        }

        towerOfhanoi(n-1, src, dest, helper);
        System.out.println("disk "+n+" is transfer from "+src+" to "+dest);
        towerOfhanoi(n-1, helper, src, dest);
    }

    public static void main(String[] args) {
        int n = 2; 
        towerOfhanoi(n, "A", "B", "C");
    }
}