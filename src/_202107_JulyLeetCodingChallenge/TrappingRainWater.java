package _202107_JulyLeetCodingChallenge;

import java.util.Deque;
import java.util.LinkedList;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {

        // Stack
        int ans = 0, current = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        while (current < height.length) {
            while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty())
                    break;
                int distance = current - stack.peek() - 1;
                int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            stack.push(current++);
        }
        return ans;

        // Dynamic programming
//        if (height == null || height.length == 0)
//            return 0;
//        int ans = 0;
//        int size = height.length;
//        int[] left_max = new int[size];
//        int[] right_max = new int[size];
//        left_max[0] = height[0];
//        for (int i = 1; i < size; i++) {
//            left_max[i] = Math.max(height[i], left_max[i - 1]);
//        }
//        right_max[size - 1] = height[size - 1];
//        for (int i = size - 2; i >= 0; i--) {
//            right_max[i] = Math.max(height[i], right_max[i + 1]);
//        }
//        for (int i = 1; i < size - 1; i++) {
//            ans += Math.min(left_max[i], right_max[i]) - height[i];
//        }
//        return ans;

        // Two pointers
//        int ans = 0;
//        int left = 0, right = height.length - 1;
//        int leftMax = 0, rightMax = 0;
//        while (left < right) {
//            leftMax = Math.max(leftMax, height[left]);
//            rightMax = Math.max(rightMax, height[right]);
//            if (height[left] < height[right]) {
//                ans += leftMax - height[left];
//                ++left;
//            } else {
//                ans += rightMax - height[right];
//                --right;
//            }
//        }
//        return ans;
    }
}
