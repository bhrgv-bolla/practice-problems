package com.problems.practice.trie;

/**
 * A ternary trie
 * @author bbolla
 *
 */
public class TernaryTrie implements Trie {
	
	TernaryTrieNode rootNode;
	
	
	TernaryTrie() {
		this.rootNode = null;
	}
	
	
	public boolean search(String item) {
		if(item == null || rootNode == null) return false;
		if(item.length() == 0) return false;
		
		TernaryTrieNode currentNode = rootNode;
		
		//Traverse the trie
		for(int i=0; i<item.length();) {
			if(currentNode == null) return false;
			char val = item.charAt(i);
			if(currentNode.val == val) {
				i++;
				if(i == item.length()) {
					if(currentNode.item == null) return false;
					else {
						return currentNode.item.equals(item);
					}
					
				}
				currentNode = currentNode.middle;
			} else if(currentNode.val > val) {
				currentNode = currentNode.left;
			} else if(currentNode.val > val) {
				currentNode = currentNode.right;
			}
		}
		
		return true;
	}
	
	
	public void add(String item) {
		if(item == null || item.length() == 0) return;
		if(rootNode == null) rootNode = new TernaryTrieNode(item.charAt(0));
		TernaryTrieNode currentNode = rootNode;
		TernaryTrieNode parentNode = null;
		boolean left =false, right =false, middle = false;
		for(int i=0; i<item.length();) {
			char val = item.charAt(i);
			if(currentNode == null) {//insert in to current value.
				i++;
				if(middle) {
					currentNode = parentNode.middle = new TernaryTrieNode(val);
				} else if(left) {
					currentNode = parentNode.left = new TernaryTrieNode(val);
				} else if(right) {
					currentNode = parentNode.right = new TernaryTrieNode(val);
				}
				middle = true;
				left = right = false;
				parentNode = currentNode;
				currentNode = currentNode.middle;
			} else if(currentNode.val == val) { //insert here.
				i++;
				parentNode = currentNode;
				currentNode = currentNode.middle;
				middle = true;
				left = right = false;
			} else if(currentNode.val > val) {
				parentNode = currentNode;
				currentNode = currentNode.left;
				left = true;
				middle = right = false;
			} else if(currentNode.val < val) {
				parentNode = currentNode;
				currentNode = currentNode.right;
				right = true;
				middle = left = false;
			}
		}
		
		parentNode.item = item; // set the string value.
	}
	
	public void print() {
		inorder(rootNode);
	}


	private void inorder(TernaryTrieNode node) {
		if(node == null) return;
		if(node.left != null) inorder(node.left);
		System.out.print(node.val);
		if(node.item != null) System.out.println("\n------------------------------------------");
		if(node.middle != null) inorder(node.middle);
		if(node.right != null) inorder(node.right);
	}

}
