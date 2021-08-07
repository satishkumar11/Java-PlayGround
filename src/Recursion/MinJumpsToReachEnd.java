package Recursion;

public class MinJumpsToReachEnd {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 0, 1, 4, 1,6};
        int n = arr.length;
        System.out.println("Recursive : "+minStepsRecursion(arr, n, 0));
        System.out.println("DP : "+minStepsDP(arr));
        System.out.println("Greedy : "+minStepGreedy(arr));
    }

    public static int minStepsRecursion(int[] arr, int n, int pos) {
        if (pos >= n - 1) return 0;
        int minJump = 1000;
        int maxStep = arr[pos];
        int babyStep = 1;
        while (babyStep <= maxStep) {
            minJump = Math.min(minJump, minStepsRecursion(arr, n, pos + babyStep) + 1);
            babyStep += 1;
        }
        return minJump;
    }

    public static int minStepsDP(int []arr){
        int n = arr.length;
        int DP [] = new int[n];
        for(int i=0; i<n; i++) DP[i] = 1000;
        DP[0] = 0;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(j+arr[j] >= i && DP[j] != 1000){
                    DP[i] = Math.min(DP[i], DP[j]+1);
                }
            }
        }
        return DP[n-1];
    }

    public static  int minStepGreedy(int []arr){

        int jumps = 0;
        int currentEnd = 0;
        int currentFarthest = 0;
        for(int i=0; i<arr.length-1; i++){
            currentFarthest = Math.max(currentFarthest, i+arr[i]);
            if(i==currentEnd){
                jumps+=1;
                currentEnd = currentFarthest;
            }
        }
        return jumps;
    }
}
