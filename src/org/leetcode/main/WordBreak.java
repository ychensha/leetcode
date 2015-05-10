package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class WordBreak {
	public boolean wordBreakBackTracking(String s, Set<String> dict) {
		return wordBreak(s, 0, new HashSet<>(dict));
	}

	private boolean wordBreak(String s, int offset, Set<String> dict) {
		if (offset == s.length()) {
			System.out.println("find");
			return true;
		}
		boolean res = false;
		for (int i = offset + 1; i <= s.length(); i++) {
			String word = s.substring(offset, i);
			if (dict.contains(word)) {
				res = res || wordBreak(s, i, dict);
			}
		}
		return res;
	}

	public boolean wordBreak(String s, Set<String> dict) {
		boolean[][] opt = new boolean[s.length() + 1][s.length() + 1];
		for (int i = 0; i <= s.length(); i++) {
			opt[0][i] = true;
			opt[i][0] = true;
		}
		int wordLength = 0;
		for(String word : dict) {
			wordLength = Math.max(wordLength, word.length());
		}
		for (int start = 1; start <= s.length(); start++) {
			int minEnd = Math.min(s.length(), start + wordLength - 1);
			for (int end = start; end <= minEnd; end++) {
				String word = s.substring(start - 1, end);
				opt[start][end] = opt[1][end]
						|| (opt[1][start - 1] && dict.contains(word));
				opt[1][end] = opt[start][end] || opt[1][end];
			}
		}
		return opt[1][s.length()];
	}

	@Test
	public void test() {
		assertEquals(
				true,
				wordBreak("leetcode",
						new HashSet<>(Arrays.asList("leet", "code"))));
	}

	@Test
	public void test1() {
		assertEquals(
				false,
				wordBreak(
						"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
						new HashSet<>(Arrays.asList("a", "aa", "aaa", "aaaa",
								"aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa",
								"aaaaaaaaa", "aaaaaaaaaa"))));
	}
}
