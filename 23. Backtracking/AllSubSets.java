public class AllSubSets {

    public static void findSubsets(String set, String sub, int i){  // O(n.2^n)
        // base
        if(i==set.length()){
            System.out.println(sub);
            return;
        }
        
        // yes
        findSubsets(set, sub+set.charAt(i), i+1);
        // no
        findSubsets(set, sub, i+1);
    }

    public static void main(String[] args) {
        String set = "abc";
        findSubsets(set, "", 0);
    }
}
