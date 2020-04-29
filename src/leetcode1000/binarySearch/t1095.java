package leetcode1000.binarySearch;

/**
 * 每日一题 leetcode  4月29日
 * 山脉数组, 二分查找
 */
public class t1095 {
    class MountainArray {
        private final static int error= Integer.MIN_VALUE;
        private int [] arr;
        private int length;
        public int get(int index) {
            if(index >=0 && index <length)
            return arr[index];
            else return error;
        }
        public int length() {return length;}
  }
    int binarySearch(MountainArray mountainArr,int l,int r,int target,int flag){
        target = target *flag; // 通过flag 1，-1 来实现递增和递减 的二分查找
        while(l<=r){
            int mid = (l+r)/2;
            int cur = mountainArr.get(mid) * flag;
            if(target == cur) return mid;
            else if(target > cur) l = mid+1;
            else r =mid-1;
        }
        // 因为正常返回的是索引,而索引>=0，所以可以使用-1 作为没找到的返回码
        return -1;
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int l =0;
        int r = mountainArr.length()-1;
        while(l<r){ // 这里不能写 等号，因为当取等时，程序会进入死循环 因为r =mid ，而不是mid -1
            int mid = (l+r)/2;
            if(mountainArr.get(mid) < mountainArr.get(mid+1)){
                l = mid+1; // 因为mid已经被排除，不会是峰值，
            }else{
                r = mid;
            }
        }
        int p = l;
        int res = binarySearch(mountainArr,0,p,target,1);
        if(res!=-1) return res;
        else return binarySearch(mountainArr,p,mountainArr.length()-1,target,-1);
    }
}
