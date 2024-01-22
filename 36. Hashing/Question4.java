// union and intersection of two arrays

import java.util.ArrayList;
import java.util.HashSet;

public class Question4 {
    public static void main(String[] args) {
        int arr1[]={7,3,9};
        int arr2[]={6,3,9,2,9,4};

        HashSet<Integer> hs = new HashSet<>();  // O(n+m)
        for(int i=0; i<arr1.length; i++){
            hs.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++){
            hs.add(arr2[i]);
        }

        // union
        System.out.println("Union : "+hs);
        System.out.println("Cardinallity : "+hs.size());

        // intersection
        hs.clear();
        for(int i=0; i<arr2.length; i++){
            hs.add(arr2[i]);
        }
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0; i<arr1.length; i++){
            if(hs.contains(arr1[i])){
                al.add(arr1[i]);
                hs.remove(arr1[i]);
            }
        }

        System.out.println("Intersection : "+al);
        System.out.println("Cardinallity : "+al.size());
    }
}
