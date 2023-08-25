import java.util.ArrayList;
import java.util.Collections;

public class Day24_ArrayList {

    public static void swap(ArrayList<Integer> list,int i, int j){
        int temp= list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void main(String[] args) {

        ArrayList<Integer> list =new ArrayList<>();

        // Add Elements
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(8);
        list.add(10);

        System.out.println(list);

        // Get elements
        System.out.println(list.get(1));

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();

        // Remove Elements
        list.remove(2);
        System.out.println(list);   // list --> [2, 4, 8, 10]

        // Set elements
        list.set(2, 5);
        System.out.println(list);   //  list --> [2, 4, 5, 10]

        // Contains elements
        System.out.println(list.contains(5));   // true
        System.out.println(list.contains(13));  // false

        // add elements at index
        list.add(1, 20);
        System.out.println(list);   // [2, 20, 4, 5, 10]


        // Print in reverse order
        for(int i =list.size()-1;i>=0;i--){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();


        // find Maximum no. in an ArrayList
        int max=Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){
            max=Math.max(max, list.get(i));
        }
        System.out.println(max);    // 20


        // Swap two index value
        System.out.println(list);   // [2, 20, 4, 5, 10]
        swap(list, 0, 3);
        System.out.println(list);   // [5, 20, 4, 2, 10]


        // Sorting in Ascending order
        Collections.sort(list);
        System.out.println(list);   // [2, 4, 5, 10, 20]

        // Sorting in descending order
        Collections.sort(list, Collections.reverseOrder(null));
        System.out.println(list);   // [20, 10, 5, 4, 2]

        // reverse using Collections class 
        Collections.reverse(list);
        System.out.println(list);   // [2, 4, 5, 10, 20]


        // Multi-dimentional ArrayList
        ArrayList<ArrayList<Integer>>mList=new ArrayList<>();
        ArrayList<Integer> list1= new ArrayList<>();
        ArrayList<Integer> list2= new ArrayList<>();
        ArrayList<Integer> list3= new ArrayList<>();

        for(int i=0;i<5;i++){
            list1.add((i+1)*1);
            list2.add((i+1)*2);
            list3.add((i+1)*3);
        }

        mList.add(list1);
        mList.add(list2);
        mList.add(list3);

        System.out.println(mList);

        // print
        for(int i=0;i<mList.size();i++){
            for(int j=0;j<mList.get(i).size();j++){
                System.out.print(mList.get(i).get(j)+" ");
            }
            System.out.println();
        }
        System.out.println();

        list2.add(12);

        // print
        for(int i=0;i<mList.size();i++){
            System.out.println(mList.get(i));
        }
        System.out.println();
    }
}
