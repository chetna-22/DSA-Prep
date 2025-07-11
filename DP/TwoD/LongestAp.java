package DP.TwoD;

public class LongestAp {
    public static int recurr(int[] arr,int index,int diff){
        if(index < 0){
            return 0;
        }

        int ans = 0;
        for(int j=index-1;j>=0;j--){
            if(arr[index]-arr[j] == diff){
                ans = Math.max(ans,1+recurr(arr, j, diff));
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,7,10,13,14,19};
        int n = arr.length;

        if(n<=2){
            System.out.println(n);
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                ans = Math.max(ans,2+recurr(arr,i,arr[j]-arr[i]));
            }
        }
        System.out.println(ans);
    }
}
