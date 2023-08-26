import java.util.ArrayList;

public class Day24_PairSum {

    // Sorted array
    public static void pairSum1(ArrayList<Integer> list, int targer){
        int lp=0;
        int rp=list.size()-1;
        int flag=0;

        while(lp<rp){
            int sum=list.get(lp)+list.get(rp);

            if(sum==targer){
                flag=1;
                break;
            }
            else if(sum<targer){
                lp++;
            }else{
                rp--;
            }
        }
        if(flag==1){
            System.out.println("["+list.get(lp)+" ,"+list.get(rp)+"]");
        }else{
            System.out.println("No pair exist");
        }
    }

    // sorted and rotated array
    public static void pairSum2(ArrayList<Integer> list, int targer){
        int lp=0;
        int rp=list.size()-1;
        int flag=0;

        for(int i=0; i<list.size()-1;i++){
            if(list.get(i)>list.get(i+1)){
                lp=i+1;
                rp=i;
                break;
            }
        }

        while(lp != rp){
            int sum= list.get(lp)+list.get(rp);

            if(sum==targer){
                flag=1;
                break;
            }
            else if(sum<targer){
                // lp++;
                // if(lp==list.size()){
                //     lp=0;
                // }

                lp=( lp+1 )%list.size();
            }
            else{
                // rp--;
                // if(rp == -1){
                //     rp=list.size()-1;
                // }

                rp=( list.size() + rp-1 )%list.size();
            }
        }

        if(flag==1){
            System.out.println("["+list.get(lp)+" ,"+list.get(rp)+"]");
        }else{
            System.out.println("No pair exist");
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        pairSum1(list, 9);

        ArrayList<Integer> list1=new ArrayList<>();
        list1.add(11);
        list1.add(15);
        list1.add(6);
        list1.add(8);
        list1.add(9);
        list1.add(10);

        pairSum2(list1, 18);
        pairSum2(list, 5);
    }
}