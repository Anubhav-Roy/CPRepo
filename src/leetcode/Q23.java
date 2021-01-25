package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * Link :-
 *
 */

public class Q23 {

    public static void main(String[] args){

        ListNode a= new ListNode(6);
        ListNode b= new ListNode(4,a);
        ListNode c= new ListNode(2,b);
        ListNode d= new ListNode(0,c);

        ListNode a1= new ListNode(7);
        ListNode b1= new ListNode(5,a1);
        ListNode c1= new ListNode(3,b1);
        ListNode d1= new ListNode(1,c1);

        ListNode[] lists = {d,d1};

        ListNode[] empty = {null,null};
        mergeKLists(empty);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNodeQueue> queue=new PriorityQueue<>();

        for(int i =0;i < lists.length ; i++) {
            if(lists[i]!=null)
                queue.add(new ListNodeQueue(lists[i]));
        }

        ListNode result = null;
        ListNode previousNode = null;

        while(queue.size()!=0){
            ListNodeQueue top = queue.poll();
            ListNode currentNode = top.node;

            if(currentNode==null)
                continue;

            ListNode newNode =  new ListNode();
            newNode.val = currentNode.val;

            if(previousNode==null){
                result = newNode;
                previousNode = result;
            }else{
                previousNode.next= newNode;
                previousNode = newNode;
            }

            if(currentNode.next!=null){
                ListNodeQueue queue1 = new ListNodeQueue(currentNode.next);
                queue.add(queue1);
            }
        }

        return result;
    }

    public static  class ListNodeQueue implements Comparable<ListNodeQueue>{
        ListNode node;

        ListNodeQueue(ListNode node) {
            this.node = node;
        }

        @Override
        public int compareTo(ListNodeQueue o) {
            return node.val - o.node.val;
        }
    }

      public static class ListNode {
          int val;
          ListNode next;

          ListNode() {
          }

          ListNode(int val) {
              this.val = val;
          }

          ListNode(int val, ListNode next) {
              this.val = val;
              this.next = next;
          }
      }



}
