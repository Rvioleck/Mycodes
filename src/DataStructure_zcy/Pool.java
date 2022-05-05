package DataStructure_zcy;

import java.util.HashMap;

public class Pool<K> {
    /*
     * 实现O(1)的插入、删除和随机键值
     * */

    private final HashMap<K, Integer> keyIndexMap;
    private final HashMap<Integer, K> indexKeyMap;
    private int size;

    public Pool() {
        keyIndexMap = new HashMap<>();
        indexKeyMap = new HashMap<>();
        size = 0;
    }

    public void insert(K key) {
        if (!keyIndexMap.containsKey(key)) {
            keyIndexMap.put(key, size);
            indexKeyMap.put(size++, key);
        }
    }

    public void delete(K key) {
        if (keyIndexMap.containsKey(key)) {
            int deleteIndex = keyIndexMap.get(key);
            int lastIndex = --size;
            K lastKey = indexKeyMap.get(lastIndex);
            keyIndexMap.put(lastKey, deleteIndex);
            keyIndexMap.remove(key);
            indexKeyMap.put(deleteIndex, lastKey);
            indexKeyMap.remove(deleteIndex);
        }
    }

    public K getRandom() {
        if (size == 0) {
            return null;
        }
        int randomIndex = (int) (Math.random() * size); // 0~size-1
        return indexKeyMap.get(randomIndex);
    }


    public static void main(String[] args) {
        Pool<String> pool = new Pool<>();
        pool.insert("fang");
        pool.insert("yi");
        pool.insert("yi");
        pool.insert("zhou");
        System.out.println(pool.getRandom());
        pool.delete("fang");
    }

}
