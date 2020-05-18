package leetcode1000;
class Solution {
    /**
     * leetcode 202 快乐数，
     * 1 可以用循环 +set ，当出现重复结果时，结束
     * 2 双指针
     */
    int f(int n){
        int r=0;
        while(n>0){
            int l = n%10;
            r+= l*l;
            n=n/10;
        }
        return r;
    }
    public boolean isHappy(int n) {
        int slow=n;
        int fast=f(n);
        while( fast!=slow){
            if(fast==1) return true;
            slow = f(slow);
            fast = f(f(fast));
        }
        return fast==1;
    }
}
public class twoPointers {

}
