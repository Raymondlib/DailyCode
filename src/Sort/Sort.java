package Sort;

import java.util.Arrays;

public class Sort {
    void q(int [] a,int l, int r){
        if(l>r) return ;
        int index = pa(a,l,r);
        q(a,l,index-1);
        q(a,index,r);
    }
    int pa(int [] a,int l,int r){
        int i=l,j=r;
        int p = a[r];
        while(i<= j){
            while(a[i] < a[p]) i++;
            while(a[j] > a[p]) j--;
            if(i<j) {
                swap(a,i,j);
                i++;
                j--;
            }

        }
        return i;

    }

    // 生成随机数组
    public static int [] randomArr(){
        int len = (int) (Math.random()*100)+10;
        int [] result = new int[len];
        for(int i =0;i<len;i++){
            result[i] = (int) (Math.random()*100);
        }
        return result;
    }
    public static void swap(int []arr ,int a,int b){
        int t = arr[a];
        arr[a]=arr[b];
        arr[b]=t;
    }

    // 冒泡
    public static void bubble(int [] a){
        if(a.length <=1) return;
        int len = a.length;
        int temp;
        for (int i=len-1;i>=0;i--){
            for (int j=0;j<i;j++){
                if(a[j] > a[j+1]){
                    temp = a[j];
                    a[j] =a[j+1];
                    a[j+1] =temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
    public static int[] bubble2(int [] a){
        if(a.length <=1) return new int[1];
        int len = a.length;
        int temp;
        for (int i=len-1;i>=0;i--){
            for (int j=0;j<i;j++){
                if(a[j] > a[j+1]){
                    temp = a[j];
                    a[j] =a[j+1];
                    a[j+1] =temp;
                }
            }
        }
//        System.out.println(Arrays.toString(a));
        return a;
    }

    public static int partition2(int [] a,int l,int r){
        // 这种写法的问题：返回的位置索引10，只能表明 前9个数是最小的，但是第10个数并不是 之后最大的；
        // 导致 递归时，只能 l ~ index -1     index ~ r ；就是缺少一个把数值给到第 k 大的位置上
        int left = l;
        int right =r;
        dealPivot(a,l,r);
        int t= a[r-1];
//        int t=  a[(r+l)/2];
        while(l<=r){ // 双指针
            // 写法，from 程序员面试金典
            while( a[l]> t) l++;
            while( a[r]<t) r--;
            if(l<=r){
                int temp= a[l];
                a[l] = a[r];
                a[r] = temp;
                l++;r--;
            }
        }
        System.out.println("l="+l);

        System.out.println("t="+t);
        System.out.println(a[l]);
        for(int i=left;i<=right;i++){
            System.out.print(a[i]+" ");
        }
//        System.out.println();
        return l;// l 的含义： 前面 前面l 个数字是一波，即 0 ~ l-1
    }
    private static void dealPivot(int[] arr, int left, int right) {
        int mid = (left + right) / 2;
//        if(right - left == 1) return;
        if (arr[left] > arr[right]) {
            swap(arr, left, right);
        }
        if (arr[left] > arr[mid]) {
            swap(arr, left, mid);
        }
        if (arr[right] < arr[mid]) {
            swap(arr, right, mid);
        }
        // 枢纽值被放在序列末尾
        swap(arr, right - 1, mid);
    }
    // 快速排序
    public static void quicksort(int [] a,int l,int r){
        if(a.length <=1) return;
        if(l>=r) return;
        int index = partition2(a,l,r);
        quicksort(a,l,index-1); // 易错，
        quicksort(a,index,r); // 因为partition2时，交换后，index++了，因此此时左边ok，index 到右边是不能 写成index +1
    }
    public static boolean check(int [] a,int []b){
        if(a.length != b.length) return false;
        for (int i = 0;i< a.length;i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }
    // 利用快排 o(n) 时间内找出 无序数组 第k大的数
    public static void getTheK(int [] a,int k){
        int start = 0,end = a.length-1;
        int index = partition2(a, start,end );

        while(index != k){
            if(index > k){
                index = partition2(a,start,index-1);
            }else {
                index = partition2(a,index,end);
            }

        }

        System.out.println(Arrays.toString(a));
        for(int i=0;i<10;i++){
            for(int j=10;j<a.length;j++){
                if(a[i]<a[j]){
                    System.out.println(a[i] + " "+a[j]);
                    System.out.println("err");
                }
            }
        }
    }

    public static void main(String[] args) {
//        for(int numOfCase = 0;numOfCase < 10;numOfCase++){
//            int [] test = randomArr();
//            int [] trueAns = test.clone();
//            trueAns = bubble2(trueAns);
//            System.out.println(Arrays.toString(test));
//            quicksort(test,0,test.length-1);
//            System.out.println(Arrays.toString(test));
//            System.out.println(check(trueAns,test));
//        }
        int [] test = randomArr();
        getTheK(test,10);

    }
}
