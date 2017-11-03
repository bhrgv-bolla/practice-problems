package com.problems.practice.trie;

import lombok.ToString;

@ToString
public class TrieNode {
	
	char val;
	String item;
	TrieNode middle;
	TrieNode left;
	TrieNode right;
	
	TrieNode(char val) {
		this.val = val;
		this.item = null;
		this.middle = null;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * Shortcut to check the String that is formed till now.
	 * @param item
	 * @return
	 */
	boolean equals(String item) {
		if(item == null) return false;
		return item.equals(this.item);
	}
	
	
	/**
	 * Set the string value. 
	 * @param item
	 */
	void setItem(String item) {
		this.item = item;
	}

}
