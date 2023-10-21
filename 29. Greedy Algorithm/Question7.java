// Chocola Problems
// min. cost to cut board into squares

import java.util.*;

public class Question7 {
    public static void main(String[] args) {
        Integer costVer[]={2, 1, 3, 1, 4};
        Integer costHor[]={4, 1, 2};

        // desending order
        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h=0, v=0;
        int hp=1, vp=1;
        int cost=0;

        while(h<costHor.length && v<costVer.length ){
            if(costVer[v]>=costHor[h]){ // vertical cut
                cost=cost+ hp*costVer[v];
                vp++;
                v++;
            }else{
                // horizontal cut
                cost=cost+ vp*costHor[h];
                hp++;
                h++;
            }
        }

        while(h<costHor.length){    // rest horizontal cuts
            cost=cost+ vp*costHor[h];
            hp++;
            h++;
        }

        while(v<costVer.length){    // rest vertical cuts
            cost+=hp*costVer[v];
            vp++;
            v++;
        }

        System.out.println("Min. cost to cut chocolate is "+cost);
    }
}
