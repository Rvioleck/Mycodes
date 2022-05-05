package DataStructure_zcy;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionSet<V> {

    static class Element<V>{
        public V value;

        public Element(V value){
            this.value = value;
        }
    }

    public HashMap<V, Element<V>> elementMap;
    // key, parent(key)
    public HashMap<Element<V>, Element<V>> fatherMap;
    // key, size(set(key))
    public HashMap<Element<V>, Integer> sizeMap;

    public UnionSet(List<V> list){
        elementMap = new HashMap<>();
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
        for (V value: list){
            Element<V> element = new Element<>(value);
            elementMap.put(value, element);
            fatherMap.put(element, element);
            sizeMap.put(element, 1);
        }
    }

    private Element<V> findHead(Element<V> element){
        // 找头结点的时候进行路径压缩，扁平化压缩
        Stack<Element<V>> path = new Stack<>();
        while (element != fatherMap.get(element)){
            // 将路径上所有不为根节点的结点记录
            path.push(element);
            element = fatherMap.get(element);
        }
        while (!path.isEmpty()) {
            // 将路径上的所有结点直连根节点
            fatherMap.put(path.pop(), element);
        }
        return element;
    }

    public boolean isSameSet(V a, V b){
        if (elementMap.containsKey(a) && elementMap.containsKey(b)){
            return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
        }
        return false;
    }

    public void union(V a, V b){
        if (elementMap.containsKey(a) && elementMap.containsKey(b)){
            Element<V> AHead = findHead(elementMap.get(a));
            Element<V> BHead = findHead(elementMap.get(b));
            if (AHead != BHead){
                Element<V> bigSet = sizeMap.get(AHead) >= sizeMap.get(BHead) ? AHead : BHead;
                Element<V> smallSet = bigSet == AHead ? BHead : AHead;
                fatherMap.put(smallSet, bigSet);
                sizeMap.put(bigSet, sizeMap.get(AHead) + sizeMap.get(BHead));
                sizeMap.remove(smallSet);
            }
        }
    }
}
