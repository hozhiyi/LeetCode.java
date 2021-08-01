package _202107_JulyLeetCodingChallenge;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder2 {
    // 42 ms solution
    PriorityQueue<Integer> leftArr; //max heap
    PriorityQueue<Integer> rightArr; //min heap

    public MedianFinder2() {

        leftArr = new PriorityQueue<Integer>((Integer a, Integer b) -> b - a);
        rightArr = new PriorityQueue<Integer>(Comparator.comparingInt((Integer a) -> a));
    }

    public void addNum2(int num) {

        if (rightArr.isEmpty()) {
            rightArr.add(num);//first time insert in right
        } else if (leftArr.isEmpty()) {

            if (num <= rightArr.peek()) { //insert in left as element lies in left side
                leftArr.add(num);
            } else {
                //right side has less element so we take it out and insert in left and put greater in right
                int rightMaxNum = rightArr.poll();
                rightArr.add(num);
                leftArr.add(rightMaxNum);
            }


        } else {

            int rightSize = rightArr.size();
            int leftSize = leftArr.size();
            //in this since size was equal/even, the new element will sum of subrray arr or right and left becomes odd, so we right subrray has a extra element than left
            if (rightSize == leftSize) {

                //take out max from left and insert into right and insert small one left
                if (num <= leftArr.peek()) {

                    int leftMaxNum = leftArr.poll();
                    leftArr.add(num);
                    rightArr.add(leftMaxNum);

                } else { //element is large, so directly insert in right arr
                    rightArr.add(num); //insert in right as it lies in right
                }

            } else {

                //we insert at left array as we know element lies of left hand side and if we insert in right then right side size becomes greater by 2
                if (num <= rightArr.peek()) {
                    leftArr.add(num);
                } else { //element from right min is taken and insert to left, as we have to make size equal between left and right

                    int rightMaxNum = rightArr.poll();
                    rightArr.add(num);
                    leftArr.add(rightMaxNum);
                }
            }
        }

    }

    public double findMedian2() {

        int rightSize = rightArr.size();
        int leftSize = leftArr.size();

        if (rightSize == leftSize) {

            int sum = rightArr.peek() + leftArr.peek();
            double median = (double) sum / 2;
            return median;
        } else {
            return (double) rightArr.peek();
        }

    }
}
