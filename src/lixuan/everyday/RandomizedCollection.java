package lixuan.everyday;

import java.util.*;

public class RandomizedCollection {
    private Map<Integer, Set<Integer>> indexMap;
    private List<Integer> nums;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        indexMap=new HashMap<>();
        nums=new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        nums.add(val);
        boolean flag=indexMap.containsKey(val);
        Set<Integer> set = indexMap.getOrDefault(val, new HashSet<>());
        set.add(nums.size()-1);
        indexMap.put(val,set);
        return flag;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!indexMap.containsKey(val)){
            return false;
        }
        Integer index = indexMap.get(val).iterator().next();
        int lastNum=nums.get(nums.size()-1);
        nums.set(index,lastNum);
        indexMap.get(lastNum).remove(nums.size()-1);
        indexMap.get(val).remove(index);
        if (index<nums.size()-1){
            indexMap.get(lastNum).add(index);
        }
        if (indexMap.get(val).size()==0){
            indexMap.remove(val);
        }
        nums.remove(nums.size()-1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get((int)Math.random()*nums.size());
    }

}
