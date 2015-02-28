package org.leetcode.main;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * 从最低位到最高位一位一位的来
 */
public class IntegertoRoman {
    public String intToRoman(int num) {
        String[][] roman = {
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            {"", "M", "MM", "MMM"}
        };
        
        String ret = "";
        int digit = 0;
        while (num != 0) {
            int remain = num % 10;
            ret = roman[digit][remain] + ret;
            digit++;
            num /= 10;
        }
        
        return ret;
    }
	@Test
	public void test() {
		assertEquals("MMXVI", intToRoman(2016));
	}

}
