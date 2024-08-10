/*
 * 78. Subsets
Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Input: nums = [0]
Output: [[],[0]]
 */
package recursion.lec2;

import java.util.ArrayList;
import java.util.List;

public class _03_print_subsets_of__num_array {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> list = new ArrayList<>();
        list = subsets(nums);
        for (List<Integer> inner : list) {
            System.out.println(inner);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        generate(list, arr, 0, nums);
        return list;
    }

    static void generate(List<List<Integer>> list, List<Integer> arr, int k, int[] nums) {
        if (k == nums.length) {
            list.add(arr);
            return;
        }
        // just like arrays this is pass by refrence so u need to clone it so 
        // that the updated list is backtracked to the upper layers of the recrusion tree
        // structure. else the updated/corrupted list will be passed to the other recursion calls
        List<Integer> arr1 = new ArrayList<>(arr);
        List<Integer> arr2 = new ArrayList<>(arr);

        generate(list, arr1, k+1, nums);
        arr2.add(nums[k]);
        generate(list, arr2, k+1, nums);
    }
}
