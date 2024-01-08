// min Heap

import java.util.ArrayList;

public class topic3Heap {
    
    static class Heap {
        ArrayList <Integer> arr = new ArrayList<>();
        
        public void add(int data){
            // add at lat idx
            arr.add(data);  // O(1)

            // fix heap
            int c = arr.size()-1;   // child index
            int p = (c-1)/2;    // parent index

            while (arr.get(c) < arr.get(p)) {   // O(logn) or O(h)
                // swap
                int temp =arr.get(p);
                arr.set(p, arr.get(c));
                arr.set(c, temp);

                c=p;
                p=(c-1)/2;
            }
        }

        public int peak(){
            return arr.get(0);
        }

        private void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;

            int minIdx= i;

            if(left<arr.size() && arr.get(minIdx)>arr.get(left)){
                minIdx = left;
            }

            if(right<arr.size() && arr.get(minIdx)>arr.get(right)){
                minIdx = right;
            }

            if(minIdx != i){
                //swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                // recursive call
                heapify(minIdx);
            }
        }

        public int remove(){
            int data = arr.get(0);  // 1st data

            // swap 1st and last 
            int temp = arr.get(arr.size()-1);   // last data
            arr.set(arr.size()-1, data);
            arr.set(0, temp);

            // delete last
            arr.remove(arr.size()-1);

            // fix heap
            heapify(0);

            return data;
        }

        public boolean isEmpty(){
            return arr.isEmpty();
        }
    }
    public static void main(String[] args) {
        Heap h = new Heap();

        h.add(3);
        h.add(5);
        h.add(10);
        h.add(2);
        h.add(4);
        h.add(6);


        while (!h.isEmpty()) {
            System.out.println(h.peak());
            h.remove();
        }

        // System.out.println(h.peak());
    }
}
