package com.problems.practice.unionfind;

import org.junit.Test;

import com.problems.Logger;


public class QuickFindTest {

	@Test
	public void test() {
		UnionFindInterface unionFind = new QuickUnion(10);
		unionFind.union(1, 2);
		unionFind.union(1, 3);
		unionFind.union(1, 7);
		unionFind.union(7, 0);
		
		//You need to see 1 5 times.
		Logger.debug(unionFind.toString());
	}

}
