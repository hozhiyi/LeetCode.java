package _202108_AugustLeetCodingChallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1_TwoSum {
    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {3, 2, 4};
        int[] nums3 = {3, 3};
        System.out.println(Arrays.toString(twoSum(nums1, 9)));
        System.out.println(Arrays.toString(twoSum(nums2, 6)));
        System.out.println(Arrays.toString(twoSum(nums3, 6)));

    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> table = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (table.containsKey(target - nums[i])) {
                return new int[]{table.get(target - nums[i]), i};
            }
            table.put(nums[i], i);
        }
        return new int[0];
    }
}
