import java.util.ArrayList;

public class Day24_ContainerWithMostWater {

    // Brute forse method - O(n^2)
    public static int mostWater(ArrayList<Integer> height){
        int h;
        int w;
        int maxWater=0;

        for(int i=0;i<height.size()-1;i++){
            for(int j=1;j<height.size();j++){
                h=Math.min(height.get(i), height.get(j));
                w=j-i;
                int currentWatter=h*w;
                maxWater=Math.max(maxWater, currentWatter);
            }
        }

        return maxWater;
    }

    // linear time O(n)
    public static int storeWater(ArrayList<Integer> height){
        int maxWater=0;
        int ht, width;

        int lp=0;
        int rp=height.size()-1;
        while(lp<rp){
            ht=Math.min(height.get(lp), height.get(rp));
            width=rp-lp;
            int currentWatter=ht*width;

            maxWater=Math.max(maxWater, currentWatter);

            if(height.get(lp)<height.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }
        
        return maxWater;
    }
    public static void main(String[] args) {
        ArrayList<Integer> height =new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(height);

        System.out.println("Maximum Water contains O(n^2) : "+mostWater(height));
        System.out.println("Maximum Water contains O(n) : "+storeWater(height));

    }
}
