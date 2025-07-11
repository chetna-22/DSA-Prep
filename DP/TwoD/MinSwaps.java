package DP.TwoD;

public class MinSwaps {
    public static int recurr(int[] num1,int[] num2,int index,boolean swapped){
        if(index == num1.length){
            return 0;
        }

        int prev1 = num1[index-1];
        int prev2 = num2[index-1];
        int ans = Integer.MAX_VALUE;

        if(swapped = true){
            swap(prev1,prev2);
        }

        //no swap
        if(num1[index] > prev1 &&  num2[index] > prev2){
            ans = recurr(num1, num2, index+1, false);
        }
        if(num1[index] > prev2 &&  num2[index] > prev1){
            ans = Math.min(ans,1+ recurr(num1, num2, index+1, true));
        }

        return ans;

    }
    public static void swap(int a ,int b){
        int temp = a;
        a = b;
        b = temp;
    }
    public static void main(String[] args) {
        
    }
}
