public class SortedMatrix {

    public static void print(int mtx[][]){
        for(int i=0;i<mtx.length;i++){
            for(int j=0;j<mtx[i].length;j++){
                System.out.print(mtx[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void search(int arr[][], int key){
        int row=arr.length;
        int col=arr[0].length;

        int i=0,j=col-1;

        while(i <= row-1 && j >= 0){
            if(arr[i][j]>key){
                j--;
            }
            else if(arr[i][j]<key){
                i++;
            }
            else{
                System.out.println("Key found at ("+i+", "+j+")");
                return;
            }
        }
        System.out.println("Key not found ");
        
    }
    public static void main(String[] args) {
        int m[][]= {{10,20,30,40},
                    {15,25,35,45},
                    {27,29,37,48},
                    {32,33,39,50}};

        print(m);
        search(m, 31);
    }
}