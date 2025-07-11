package DP.TwoD;

import java.util.Arrays;

public class ReducingDishes {
    public static int recurr(int[] arr,int index,int time){
        if(index == arr.length){
            return 0;
        }

        int include = arr[index]*(time+1) + recurr(arr, index+1, time+1);
        int exclude = 0+recurr(arr, index+1, time);

        return Math.max(include,exclude);
    }
    public static void main(String[] args) {
        int[] arr = {4,3,2};
        Arrays.sort(arr);

        int ans = recurr(arr,0,0);
        System.out.println(ans);
    }
}
