package _202107_JulyLeetCodingChallenge;

import java.util.*;

public class _658_FindKClosestElements {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5};
//        int[] arr1 = {1};
//        int[] arr2 = {1, 2};
        int[] arr3 = {1, 5, 10};
        //findClosestElements(arr, 4, 3);
//        System.out.println(findClosestElements(arr, 4, 3));
//        System.out.println(findClosestElements(arr, 4, -1));
//        System.out.println(findClosestElements(arr1, 1, 1));
//        System.out.println(findClosestElements(arr2, 1, 1));
        System.out.println(findClosestElements(arr3, 1, 4));

    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        int lo = 0;
        int hi = arr.length - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (arr[mid] == x) {
                break;
            } else if (arr[mid] < x) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        int l = Math.max(0, mid - 1);
        int r = l + 1;
        ArrayList<Integer> list = new ArrayList<>();

        while (l >= 0 && r < arr.length && k > 0) {
            if (Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                list.add(arr[l]);
                l--;
            } else {
                list.add(arr[r]);
                r++;
            }
            k--;
        }
        while (k > 0 && l >= 0) {
            list.add(arr[l]);
            l--;
            k--;

        }
        while (k > 0 && r < arr.length) {
            list.add(arr[r]);
            r++;
            k--;
        }
        Collections.sort(list);
        return list;
    }
}
