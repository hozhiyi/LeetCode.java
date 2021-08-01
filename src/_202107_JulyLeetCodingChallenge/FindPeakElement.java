package _202107_JulyLeetCodingChallenge;

public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2};
        System.out.println(findPeakElement((nums)));
    }

    // iterative binary search
    public static int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - 1) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}
