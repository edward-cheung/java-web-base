package cn.edcheung.javaWebBase.algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 哈希+双链表实现，get和put都是O(1)时间复杂度：
 * 将key-val的数据存到一个Node类中，然后每个Node知道左右节点，在插入链表的时候直接存入Map中，这样Map在查询的时候可以直接返回该节点，
 * 双链表知道左右节点可以直接将该节点在双链表中删除
 */
class LRUCache2 {
    static class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class DoubleList {
        private Node head;// 头节点
        private Node tail;// 尾节点
        private int length;

        public DoubleList() {
            head = new Node(-1, -1);
            tail = head;
            length = 0;
        }

        void add(Node teamNode) {
            tail.next = teamNode;// 默认尾节点插入
            teamNode.pre = tail;
            tail = teamNode;
            length++;
        }

        void deleteFirst() {
            if (head.next == null)
                return;
            if (head.next == tail)//如果删除的那个刚好是tail  注意啦 tail指针前面移动
                tail = head;
            head.next = head.next.next;

            if (head.next != null)
                head.next.pre = head;
            length--;
        }

        void deleteNode(Node team) {
            team.pre.next = team.next;
            if (team.next != null)
                team.next.pre = team.pre;
            if (team == tail)
                tail = tail.pre;
            team.pre = null;
            team.next = null;
            length--;
        }

        public String toString() {
            Node team = head.next;
            StringBuilder vaString = new StringBuilder("len:" + length + " ");
            while (team != null) {
                vaString.append("key:").append(team.key).append(" val:").append(team.value).append(" ");
                team = team.next;
            }
            return vaString.toString();
        }
    }

    Map<Integer, Node> map = new HashMap<>();
    DoubleList doubleList;//存储顺序
    int maxSize;
    LinkedList<Integer> list2 = new LinkedList<>();

    public LRUCache2(int capacity) {
        doubleList = new DoubleList();
        maxSize = capacity;
    }

    public void print() {
        System.out.print("maplen:" + map.keySet().size() + " ");
        for (Integer in : map.keySet()) {
            System.out.print("key:" + in + " val:" + map.get(in).value + " ");
        }
        System.out.print("              ");
        System.out.println("listLen:" + doubleList.length + " " + doubleList.toString() + " maxSize:" + maxSize);
    }

    public int get(int key) {
        int val;
        if (!map.containsKey(key))
            return -1;
        val = map.get(key).value;
        Node team = map.get(key);
        doubleList.deleteNode(team);
        doubleList.add(team);
        return val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {// 已经有这个key 不考虑长短直接删除然后更新
            Node deleteNode = map.get(key);
            doubleList.deleteNode(deleteNode);
        } else if (doubleList.length == maxSize) {//不包含并且长度小于
            Node first = doubleList.head.next;
            map.remove(first.key);
            doubleList.deleteFirst();
        }
        Node node = new Node(key, value);
        doubleList.add(node);
        map.put(key, node);
    }
}

