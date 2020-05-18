package leetcode1000.binarySearch;

public class t69 {
    /**
     *  求x 的根号，向下取整
     *  2020 - 5-9 雷鹏程
     */
    public static void main(String[] args) {
        int x=100;
        int left = 1, right = x, ans;
        ans =0;
        while (left <= right) {
            int mid = left + (right - left) / 2; //mid为在原来的基础上+一半
            if (mid <= x / mid) {  // 注意 乘法溢出；
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
    }
}

