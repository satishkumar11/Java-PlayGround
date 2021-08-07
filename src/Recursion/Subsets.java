package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> out = new ArrayList<>();

        /* using backtracking */
        calculateSubsetsUsingBacktracking(ans, out, arr, 0);
        System.out.println(ans);

        /* using binary */
        ans = new ArrayList<>();
        calculateSubsetsUsingBinary(ans, arr, arr.length);
        System.out.println(ans);


    }

    public static void calculateSubsetsUsingBacktracking(List<List<Integer>> ans, List<Integer> out, int[] arr, int start) {
        ans.add(new ArrayList<>(out));
        for (int i = start; i < arr.length; i++) {
            out.add(arr[i]);
            calculateSubsetsUsingBacktracking(ans, out, arr, i + 1);
            out.remove(out.size() - 1);
        }
    }

    public static void print(int i, List<List<Integer>> ans){
        System.out.println(i);
        System.out.println(ans);
    }

    public static void calculateSubsetsUsingBinary(List<List<Integer>> ans, int[] arr, int n) {
        int totalSubsets = (int) Math.pow(2, n);
        for (int i = 0; i < totalSubsets; i++) {
            StringBuffer sb = new StringBuffer(Integer.toBinaryString(i));
            String binary = sb.reverse().toString();
            List<Integer> out = new ArrayList<>();
            for (int j = 0; j < binary.length(); j++) {
                if (binary.charAt(j) == '1') {
                    out.add(arr[j]);
                }
            }
            ans.add(out);
        }
    }
}
