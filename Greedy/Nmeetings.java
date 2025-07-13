package Greedy;

import java.util.*;

class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n) {
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = i;
            arr[i][1] = start[i];
            arr[i][2] = end[i];
        }

        Arrays.sort(arr, Comparator.comparingDouble(o -> o[2]));

        int maxCount = 1;
        int lastEnd = arr[0][2];

        for (int i = 1; i < n; i++) {
            if (arr[i][1] > lastEnd) {
                maxCount++;
                lastEnd = arr[i][2];
            }
        }

        return maxCount;
    }
}