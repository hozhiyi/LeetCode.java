package _202108_AugustLeetCodingChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _90_SubsetsII {
    private static List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    private static LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
    private static boolean[] used;

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0) {
            result.add(path);
            return result;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        subsetsWithDupHelper(nums, 0);
        return result;
    }

    private static void subsetsWithDupHelper(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            subsetsWithDupHelper(nums, i + 1);
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        int[] nums1 = {0};
        int[] nums2 = {9, 4, 3, 3};
        System.out.println(subsetsWithDup(nums));
        System.out.println(subsetsWithDup(nums1));
        System.out.println(subsetsWithDup(nums2));
    }
}
