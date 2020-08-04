package com.po.quiz.design;

import java.util.*;

/***
 * solution 1) insertion sort; 2) two heaps
 */
public class MedianFinder {
    PriorityQueue<Integer> minHeap, maxHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((i1,i2) -> Integer.compare(i2, i1));
    }

    public void addNum(int num) {
        minHeap.add(num);
        maxHeap.add(minHeap.poll());
        if(getTotal() % 2 != 0)
            minHeap.add(maxHeap.poll());
    }

    public double findMedian() {
        int total = getTotal();
        if(total == 0) return 0;
        if(total % 2 == 0){
            double sum = (double)(minHeap.peek() + maxHeap.peek());
            return sum / 2;
        } else {
            return minHeap.peek();
        }
    }

    public int getTotal(){
        return minHeap.size() + maxHeap.size();
    }
}
/***
 //get index with binary search for the location that it should insert into
 public int getIndex(List<Integer> list, int target){
 int lo = 0, high = list.size() - 1;
 while(lo <= high){
 int mid = lo + (high - lo) / 2;
 int m = list.get(mid);
 if(m == target)
 return mid;
 else if(m < target){
 lo = mid + 1;
 } else {
 high = mid - 1;
 }
 }
 return lo;
 }
***/