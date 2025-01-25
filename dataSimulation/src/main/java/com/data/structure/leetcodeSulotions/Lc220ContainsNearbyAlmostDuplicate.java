package com.data.structure.leetcodeSulotions;

import java.util.TreeSet;

public class Lc220ContainsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        // TreeSet 用于维护一个有序的窗口
        TreeSet<Long> set = new TreeSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            // 将当前元素转换为 long 类型，防止溢出
            long num = nums[i];
            
            // 查找窗口内是否存在满足条件的元素
            Long floor = set.floor(num + valueDiff);
            Long ceiling = set.ceiling(num - valueDiff);
            
            if ((floor != null && floor >= num) || (ceiling != null && ceiling <= num)) {
                return true;
            }
            
            // 将当前元素加入窗口
            set.add(num);
            
            // 维护窗口大小为 indexDiff
            if (set.size() > indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }
        
        return false;
    }
}
