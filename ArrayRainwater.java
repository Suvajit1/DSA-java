public class ArrayRainwater {

    public static void print(int arr[]) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static int trappedRainWater(int height[]) {
        int n = height.length;

        if (n > 2) {

            int t=0;
            //desc
            if(height[0]>=height[1]){
                int temp=height[0];
                for(int i=2;i<n;i++){
                    if(temp<height[i]){
                        t=1;
                    }
                }
            }
            //asc
            if(height[0]<=height[1]){
                int temp=height[0];
                for(int i=2;i<n;i++){
                    if(temp>height[i]){
                        t=1;
                    }
                }
            }
            if(t==0){
                return 0;
            }
            // calculate max left boundary - array
            int maxLeftBoundary[] = new int[n];
            maxLeftBoundary[0] = height[0];
            for (int i = 1; i < n; i++) {
                // maxLeftBoundary[i]=height[i]>maxLeftBoundary[i-1] ? height[i]
                // :maxLeftBoundary[i-1];
                maxLeftBoundary[i] = Math.max(height[i], maxLeftBoundary[i - 1]);
            }
            print(maxLeftBoundary); // for check

            // calculate max right boundary - array
            int maxRightBoundary[] = new int[n];
            maxRightBoundary[n - 1] = height[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                // maxRightBoundary[i]=height[i]>maxRightBoundary[i+1] ? height[i]
                // :maxRightBoundary[i+1];
                maxRightBoundary[i] = Math.max(height[i], maxRightBoundary[i + 1]);
            }
            print(maxRightBoundary); // for check

            int waterLevel, trappedWater = 0;

            for (int i = 0; i < n; i++) {
                // calculate water leve
                waterLevel = Math.min(maxLeftBoundary[i], maxRightBoundary[i]);

                // calculate trapped water
                trappedWater += waterLevel - height[i];
            }

            return trappedWater;
        }

        else{
            return 0;
        }
    
    }

    public static void main(String[] args) {
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };
        System.out.println(trappedRainWater(height));

        int height1[] = { 5 };
        System.out.println(trappedRainWater(height1));

        int height2[] = { 5, 3 };
        System.out.println(trappedRainWater(height2));

        int height3[] = { 10, 8, 6, 4, 2 };
        System.out.println(trappedRainWater(height3));
         
        int height4[]={4,4,4,4};
        System.out.println(trappedRainWater(height4));

    }
}
