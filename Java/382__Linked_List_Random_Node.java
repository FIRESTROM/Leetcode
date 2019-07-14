/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    ListNode head;
	int size;
	Random random;

	/** @param head The linked list's head.
		Note that the head is guaranteed to be not null, so it contains at least one node. */
	public Solution(ListNode head) {
		this.head = head;
        random = new Random();
		size = 0;
		ListNode temp = head;
		while (temp != null) {
			size++;
			temp = temp.next;
		}
	}

	/** Returns a random node's value. */
	public int getRandom() {
		ListNode current = head;
		int randomNumber = random.nextInt(size);
		while (current != null){
			if (randomNumber == 0) return current.val;
			current = current.next;
			randomNumber--;
		}
		return 0;
	}
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
