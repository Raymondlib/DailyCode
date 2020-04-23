package leetcode1000;

// 快慢指针，解决 寻找重复数； 数组看作链表； 每个数字看作一个指针，表示从 索引1 指向a[1]
// 第一个数字 a[0],没有数字指向它，因此是头节点；
public class t287 {
    public static int findDuplicate(int[] nums) {
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;

    }
    public static void main(String[] args) {

    }
}

