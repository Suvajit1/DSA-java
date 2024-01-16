// Implementation

import java.util.ArrayList;
import java.util.LinkedList;

public class topic3 {
    static class HashMap<K,V> { // generic class
        private class Node {
            K key;
            V value;

            public Node(K key, V value){
                this.key=key;
                this.value=value;
            }
        }
        
        private int n;   // n
        private int N;
        private LinkedList<Node> buckets[]; // N

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.n=0;
            this.N=4;
            this.buckets = new LinkedList[N];
            for(int i=0;i<4;i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int hc = key.hashCode();
            hc = Math.abs(hc) % N;
            return hc;
        }

        private int searchInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            int di=0;

            for(int i=0; i<ll.size(); i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return di;
                }
                di++;
            }

            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBuck[]=buckets;
            buckets = new LinkedList[2*N];
            N=2*N;
            for(int i=0; i<buckets.length; i++){
                buckets[i] = new LinkedList<>();
            }

            // nodes -> add in new bucket
            for(int i=0; i<oldBuck.length; i++){
                LinkedList<Node> ll = oldBuck[i];
                for(int j=0; j<ll.size();j++){
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value){
            int bi = hashFunction(key); // 0 to N-1
            int di = searchInLL(key,bi); // valid, -1

            if(di != -1){
                // update
                Node node = buckets[bi].get(di);
                node.value=value;
            }else{
                // add new node
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lamda = (double)n/N;
            if(lamda > 2.0){
                rehash();
            }
        }

        public boolean containsKey(K key){
            int bi = hashFunction(key); // 0 to N-1
            int di = searchInLL(key,bi); // valid, -1

            if(di != -1){
                return true;
            }else{
                return false;
            }
        }

        public V get(K key){
            int bi = hashFunction(key); // 0 to N-1
            int di = searchInLL(key,bi); // valid, -1

            if(di != -1){
                Node node = buckets[bi].get(di);
                return node.value;
            }else{
                return null;
            }
        }

        public V remove(K key){
            int bi = hashFunction(key); // 0 to N-1
            int di = searchInLL(key,bi); // valid, -1

            if(di != -1){
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }else{
                return null;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0; i<N; i++){
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }

            return keys;
        }

        public boolean isEmpty(){
            return n==0;
        }
    }

    public static void main(String[] args) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("Nepal", 5);
        hm.put("US", 50);

        ArrayList<String> keys = hm.keySet();
        for (String k : keys) {
            System.out.println("key = "+k+", value = "+hm.get(k));
        }

        hm.remove("China");
        System.out.println(hm.keySet());
        System.out.println(hm.get("China"));

        System.out.println(hm.containsKey("UK"));
    }
}
