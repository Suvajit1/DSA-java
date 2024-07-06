import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Classroom {

    public static void print(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void print1(Integer[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.add(5, 11);
        list.add(2, 15);
        
        System.out.println(list);
        System.out.println(list.contains(5));

        list.remove(1);
        System.out.println(list);

        int arr[] = {10,3,5,9,6};
        Arrays.sort(arr);
        print(arr);

        Integer brr[] = {1,4,2,7,0,9};
        Arrays.sort(brr, Comparator.reverseOrder());
        print1(brr);

        Integer crr[] = {1,4,2,7,0,9};
        Arrays.sort(crr, Collections.reverseOrder());
        print1(crr);

        Collections.reverse(list);
        System.out.println(list);

        // Collections.sort(list);
        // System.out.println(list);

        // Collections.sort(list, Collections.reverseOrder());
        // System.out.println(list);

        Collections.sort(list, Comparator.reverseOrder());
        System.out.println(list);

        // multidimentional Arraylist

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        for(int i=0; i<5; i++){
            list1.add(i+1);
            list2.add(2*(i+1));
            list3.add(3*(i+1));
        }

        ArrayList<ArrayList<Integer>> mList = new ArrayList<>();

        mList.add(list1);
        mList.add(list2);
        mList.add(list3);

        for(int i=0; i<mList.size(); i++){
            System.out.println(mList.get(i));
        }

    }
}