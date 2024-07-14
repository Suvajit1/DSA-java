// Question 4 : We are given a string S, we need to find the count of all contiguous substrings
// starting and ending with the same character.

// Sample Input 1 : S = "abcab"
// Sample Output 1 : 7

// There are 15 substrings of "abcab" : a, ab, abc, abca, abcab, b, bc, bca, bcab, c, ca, cab, a, ab, b
// Out of the above substrings, there are 7 substrings : a, abca, b, bcab, c, a and b. So, only 7
// contiguous substrings start and end with the same character.

// Sample Input 2 : S = "aba"
// Sample Output 2 : 4
// The substrings are a, b, a and aba.

public class AssQs4 {

    public static int countSubstrings(String str){
        int count = 0;

        for(int i=0; i<str.length(); i++){
            for(int j=i; j<str.length(); j++){
                if(str.charAt(i) == str.charAt(j)){
                    count++;
                }
            }
        }

        return count;
    }
    public static void main(String[] args) {
        String str = "abcab";
        System.out.println(countSubstrings(str));
    }
}
