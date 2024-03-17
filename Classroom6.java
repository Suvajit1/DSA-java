// Sorting and reverse sorting
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Classroom6 {
    public static void printList(int arr[]){
        for(int x: arr){
            System.out.print(x+" ");
        }
        System.out.println();
    }

    public static void printList(Integer arr[]){
        for(int x: arr){
            System.out.print(x+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] ={9,5,7,2,6};
        printList(arr);

        Arrays.sort(arr);
        printList(arr);

        Integer brr[] = {11,2,5,1,15};
        printList(brr);
        // Arrays.sort(brr, Collections.reverseOrder());
        // printList(brr);
        Arrays.sort(brr, Comparator.reverseOrder());
        printList(brr);


        ArrayList<Integer> al = new ArrayList<>();
        al.add(5);
        al.add(2);
        al.add(9);
        al.add(7);
        al.add(1);
        System.out.println(al);
        Collections.sort(al);
        System.out.println(al);

        // Collections.sort(al, Collections.reverseOrder());
        // System.out.println(al);

        Collections.sort(al, Comparator.reverseOrder());
        System.out.println(al);
    }
}
