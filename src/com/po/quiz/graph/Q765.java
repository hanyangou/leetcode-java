package com.po.quiz.graph;

/***
 * core technique: cyclic swap.
 * algo:
 *  1. first we build an array called `pos` to track the position of each element in the original array. This `pos` array
 *  will be used to identify the position for given element, which will be used to retrieve the position of partner in later step.
 *  2. loop over `row` and for each of the position we do the following steps:
 *      I. check if element in current index is the partner of next index
 *      II. if it is, then we advance to next index (by adding 2)
 *      III. if not, then first we find out the value of the partner for current one.
 *      IV. then we identify the position of that partner.
 *      V. swap the current one to the position NEXT TO it's partner and increment `ans`. remember also update positions in `pos` accordingly
 *      VI now, we have new value in `current`, repeat the step I
 * ps:
 *  1. ptr refers to partner
 *  2. we will say the partner of N is N + 1 if N is even, or N - 1 if N is odd. This is because we start the element from 0 and categorize
 *  every two elements into same group. be careful if the question changes the statement from 0 to 1 or other number.
 */
public class Q765 {
    int ans = 0;
    public int minSwapsCouples(int[] row) {
        int[] pos = new int[row.length];
        //building position array for each of the element in row
        for(int i = 0; i < row.length; i++){
            pos[row[i]] = i;
        }

        //loop over the half of array to make sure we can cover all the element that needs to be swapped
        for(int i = 0; i < row.length - 1; i+=2){
            while (getPtr(row[i]) != row[i+1]) { //partner not sit to next other, swap
                int ptrPos = pos[getPtr(row[i])];
                int nextSeat = getNextSeat(ptrPos);
                //swap seat to the one next to it's partner. remember to update pos arr as well
                swap(row, i, nextSeat);
                pos[row[i]] = i;
                pos[row[nextSeat]] = nextSeat;
            }
        }

        return ans;
    }

    public void swap(int[] row, int a, int b){
            int tmp = row[a];
            row[a] = row[b];
            row[b] = tmp;
            ans++;
    }

    //get next seat of love seat for given one
    public int getNextSeat(int seat){
        if(seat % 2 == 0) return seat + 1;
        else return seat - 1;
    }
    //get the partner value of given element
    public int getPtr(int p){
        if(p % 2 == 0) return p + 1;
        else return p - 1;
    }
}
