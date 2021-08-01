package _202107_JulyLeetCodingChallenge;

import java.util.Arrays;

public class MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 3, 2, 1};
//        int[] nums2 = {3, 2, 1, 4, 7};
//        System.out.println(findLength(nums1, nums2));
//        int[] nums3 = {0, 0, 0, 0, 0};
//        int[] nums4 = {0, 0, 0, 0, 0};
//        System.out.println(findLength(nums3, nums4));
        int[] nums5 = {0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
        int[] nums6 = {0, 0, 0, 0, 0, 0, 0, 1, 0, 0};
        System.out.println(findLength(nums5, nums6));
    }

    public static int findLength(int[] A, int[] B) {
        if (A == null || B == null) {
            return 0;
        }
        int maxCommonLenth = 0;
        int[][] common = new int[A.length][B.length];
        // Initialize the first row and the first column
        for (int i = 0; i < A.length; i++) {
            if (B[0] == A[i]) {
                common[i][0] = 1;
            }
        }
        for (int i = 0; i < B.length; i++) {
            if (B[i] == A[0]) {
                common[0][i] = 1;
            }
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j < B.length; j++) {
                if (A[i] == B[j]) {
                    common[i][j] = common[i - 1][j - 1] + 1;
                    maxCommonLenth = Math.max(maxCommonLenth, common[i][j]);
                }
            }
        }
        return maxCommonLenth;
//        int[] counter = new int[nums1.length * nums2.length];
//        int index = 0;
//
//        for (int i = 0; i < nums1.length; i++) {
//            for (int j = 0; j < nums2.length; j++) {
//                if (nums1[i] == nums2[j]) {
//                    counter[index]++;
//
//                    int tempi = i;
//                    int tempj = j;
//
//                    if (tempi + 1 < nums1.length) {
//                        tempi++;
//                    }
//                    if (tempj + 1 < nums1.length) {
//                        tempj++;
//                    }
//                    while (nums1[tempi] == nums2[tempj]) {
//                        counter[index]++;
//                        if (tempi + 1 < nums1.length) {
//                            tempi++;
//                        } else {
//                            break;
//                        }
//                        if (tempj + 1 < nums1.length) {
//                            tempj++;
//                        } else {
//                            break;
//                        }
//                    }
//
//                    index++;
//                }
//            }
//        }
//        Arrays.sort(counter);
//        return counter[counter.length - 1];
    }
}
