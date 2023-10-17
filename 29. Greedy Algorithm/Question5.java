// Indian Coins
import java.util.*;

public class Question5 {
    public static void main(String[] args) {
        Integer coins[]={1,2,5,10,20,50,100,500,2000};
        int amount=590;

        Arrays.sort(coins, Comparator.reverseOrder());

        int count=0;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0;i<coins.length;i++){
            if(coins[i]<=amount){
                while(coins[i]<=amount){
                    count++;
                    amount=amount-coins[i];
                    ans.add(coins[i]);
                }
            }
            if(amount==0){
                break;
            }
        }

        System.out.println(count);
        System.out.println(ans);
    }
}
