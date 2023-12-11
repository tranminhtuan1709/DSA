package Others;

import java.util.ArrayList;

public class Array_to_BST {
    public void preOrder(int left, int right, int[] nums, ArrayList<Integer> res) {
        if (left <= right) {
            int mid = (left + right) / 2;
            res.add(nums[mid]);
            preOrder(left, mid - 1, nums, res);
            preOrder(mid + 1, right, nums, res);
        }
    }
    public int[] sortedArrayToBST(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        preOrder(0, nums.length - 1, nums, res);
        int[] tree = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            tree[i] = res.get(i);
        }
        return tree;
    }
}
