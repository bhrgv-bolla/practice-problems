package com.problems.practice.trie;

import static org.junit.Assert.*;

import org.junit.Test;

import com.problems.Logger;

public class TrieTests {

	@Test
	public void testsTrie() {
		Trie trie = new Trie();
		//add operations
		trie.add("found");
		trie.add("second string");
		trie.add("could you find $ me");
		
		trie.print();
		
		//search operations
		assertTrue(trie.search("could you find $ me"));
		
		assertFalse(trie.search("could you"));
		
		assertFalse(trie.search(""));
		assertFalse(trie.search(null));
	}

}
