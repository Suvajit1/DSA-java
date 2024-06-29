public class Permutation {
    public static void permutation(String str, String ans){     // O(n.n!)

        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        for(int i=0; i<str.length(); i++){
            char curr = str.charAt(i);
            
            String rest = str.substring(0, i)+str.substring(i+1);
            permutation(rest, ans+curr);
        }
    }
    public static void main(String[] args) {
        String str = new String("abc");
        permutation(str, "");
    }
}
