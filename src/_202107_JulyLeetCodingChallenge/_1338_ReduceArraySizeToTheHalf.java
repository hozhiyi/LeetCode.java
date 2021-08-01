package _202107_JulyLeetCodingChallenge;

import java.util.*;

public class _1338_ReduceArraySizeToTheHalf {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 1, 7, 9, 8, 10, 11, 12, 10, 13, 14, 12};
        System.out.println(minSetSize(arr));
    }

    public static int minSetSize(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int[] nums = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            nums[arr[i]]++;
        }
        Arrays.sort(nums);
        int j = 0;
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] >= arr.length / 2) {
                return 1;
            }
            sum += nums[i];
            j++;
            if (sum >= arr.length / 2) {
                return j;
            }
        }
        return -1;
    }
//        Map<Integer, Integer> map = new HashMap();
//        for (int i : arr) map.put(i, map.getOrDefault(i, 0) + 1);
//        List<Integer>[] bucket = new ArrayList[arr.length + 1];
//        for (int i = 0; i <= arr.length; i++) bucket[i] = new ArrayList();
//        for (int k : map.keySet()) {
//            int f = map.get(k);
//            bucket[f].add(k);
//        }
//        int n = arr.length;
//        int res = 0, tmp = 0;
//        for (int i = n; i >= 1; i--) {
//            int cursize = bucket[i].size();
//            if (cursize == 0) continue;
//            while (cursize > 0) {
//                tmp += i;
//                res++;
//                if (tmp >= n / 2) return res;
//                cursize--;
//            }
//
//        }
//        return res;

}

