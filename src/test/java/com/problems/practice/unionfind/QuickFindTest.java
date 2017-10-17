package com.problems.practice.unionfind;

import static org.junit.Assert.*;


import org.junit.Test;

import com.problems.Logger;

public class QuickFindTest {

	@Test
	public void test() {
		UnionFindInterface unionFind = new QuickFind(10);
		unionFind.union(1, 2);
		unionFind.union(1, 3);
		unionFind.union(1, 7);
		unionFind.union(7, 0);
		
		//You need to see 1 5 times.
		Logger.debug(unionFind.toString());
	}

}
