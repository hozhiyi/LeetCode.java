package _202107_JulyLeetCodingChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18_4Sum {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        //System.out.println(fourSum1(nums, target));
        System.out.println(fourSum2(nums, target));
    }

    // 38700 KB Solution
    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public static List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k)
            return res;
        if (k == 2)
            return twoSum(nums, target, start);
        for (int i = start; i < nums.length; ++i)
            if (i == start || nums[i - 1] != nums[i])
                for (List<Integer> set : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(set);
                }
        return res;
    }

    public static List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum < target || (lo > start && nums[lo] == nums[lo - 1]))
                ++lo;
            else if (sum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1]))
                --hi;
            else
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
        }
        return res;
    }

    // 2 ms solution
    public static List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> sol = new ArrayList<>();
        if (nums.length <= 3) return sol;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] * 4 > target) break;
            for (int j = i + 1; j < n; j++) {
                int sum = target - nums[i] - nums[j];
                int front = j + 1;
                int back = n - 1;
                if ((nums[i] + nums[j] + nums[back] * 2) < target) continue;
                if (nums[j] * 2 > sum) break;
                while (front < back) {
                    int currSum = nums[front] + nums[back];
                    if (currSum < sum) front++;
                    else if (currSum > sum) back--;
                    else {
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[front]);
                        quad.add(nums[back]);
                        sol.add(quad);

                        while (front < back && nums[front] == quad.get(2)) ++front;
                        while (back > front && nums[back] == quad.get(3)) --back;
                    }
                }
                while (j + 1 < n && nums[j + 1] == nums[j]) ++j;
            }
            while (i + 1 < n && nums[i + 1] == nums[i]) ++i;
        }
        return sol;
    }
}
