/**
 * 
 */
/**
 * @author TAO ZHANG
 *
 */
package com.leetcode.oj.ReverseNodesinkGroup;


public class ReverseNodesinkGroup{
	 public ListNode reverseKGroup(ListNode head, int k) {
        int length = this.getLength(head);
        if(k<=1 || length <=1 || k>length){return head;}
        if(k>=2){
        	ListNode temp = head.next;
            head.next = temp.next;
            temp.next = head;
            head = temp;
            k-=2;
        }
        ListNode currNode = head;
        ListNode nextNode = head.next;
        while(k>0){
            ListNode temp = nextNode.next;
            nextNode.next = temp.next;
            temp.next = currNode;
            currNode = temp;
            k--;
        }
        return currNode;
    }
    public int getLength(ListNode head){            //pay attention to the reference value, the copy of the reference
        int length=0;
        while(head!=null){
            length++;
            head=head.next;
        }
        return length;
    }
	public static void main(String[] args){
		ReverseNodesinkGroup rng = new ReverseNodesinkGroup();
		ListNode head = new ListNode(0);
		ListNode curr = head;
		int i=3;
		while(i>0){curr.next = new ListNode(4-i);i--;curr = curr.next;}
		head = rng.reverseKGroup(head, 4);
		System.out.println(rng.getLength(head)+" "+head.val);
	}
}