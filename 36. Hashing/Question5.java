// Find Itinerary of Tickets

import java.util.HashMap;

public class Question5 {
    public static void main(String[] args) {
        String tickets [][] = {{"Chennai", "Bengaluru"},
                                {"Mumbai", "Delhi"},
                                {"Goa", "Chennai"},
                                {"Delhi", "Goa"} 
                            };

        HashMap<String,String> fromTo = new HashMap<>();
        for(int i=0; i<tickets.length;i++){
            fromTo.put(tickets[i][0], tickets[i][1]);
        }

        HashMap<String,String> toFrom = new HashMap<>();
        for(int i=0; i<tickets.length;i++){
            toFrom.put(tickets[i][1], tickets[i][0]);
        }

        String start=null;
        for (String key : fromTo.keySet()) {
            if(!toFrom.containsKey(key)){
                start=key;
            }
        }

        //journey
        System.out.print(start);

        for(int i=0; i<fromTo.size(); i++){
            System.out.print(" -> "+fromTo.get(start));
            start=fromTo.get(start);
        }
        System.out.println();
    }
}
