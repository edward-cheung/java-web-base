package cn.edcheung.javaWebBase.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ArrayList进行删除最久未使用(第一个)key-value，新的key被命中变成最新被使用(先删除然后插入末尾)操作都是O(n)
 */
public class LRUCache1 {

    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    int maxSize;

    public LRUCache1(int capacity) {
        maxSize = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key))//不存在返回-1
            return -1;
        int val = map.get(key);
        put(key, val);//要更新位置 变成最新 很重要！
        return val;
    }

    public void put(int key, int value) {
        //如果key存在，直接更新即可
        if (map.containsKey(key)) {
            list.remove((Integer) key);
            list.add(key);
        } else {//如果不存在 要插入到最后，但是如果容量满了需要删除第一个(最久)
            if (!map.containsKey(key)) {
                if (list.size() == maxSize) {
                    map.remove(list.get(0));
                    list.remove(0);
                }
                list.add(key);
            }
        }
        map.put(key, value);
    }
}
