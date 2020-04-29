package leetcode1000.binarySearch;
// 搜索旋转有序数组，
// 二分，分类讨论，画图，注意处理==情况，熟练写出二分
//2020年4月27日  leetcode
public class t33 {
    public static int search(int[] nums, int target) {
        int l=0;
        int s=target;
        int r= nums.length-1;
        if(r<0) return -1;
        if(r==0){
            if(target == nums[0]) return 0;
            else return -1;
        }
        int mid;
        while(l<=r){
            mid = (r-l)/2 +l;
            if(nums[mid]==s) return mid;
            if(nums[mid] >= nums[0]) {
                if (nums[mid] > s && s>=nums[0]) r = mid - 1;
                else l = mid + 1;
            }else {
                if(s<nums[0] && s>nums[mid]) {
                    l=mid+1;
                }else {
                    r= mid-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] t= new int[]{4,5,6,7,0,1,2};
        int r=search(t,0);
        System.out.println(r);
//        System.out.println(String.format("%.3f",x));
    }
}
