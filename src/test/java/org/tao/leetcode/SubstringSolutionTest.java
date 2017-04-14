package org.tao.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by zkdu8y8 on 8/11/2016.
 */
public class SubstringSolutionTest {
    @Test
    public void testMinWindow() {
        SubstringSolution solution = new SubstringSolution();
        //System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
        //System.out.println(solution.minWindow("ABDCD", "ABC"));
        System.out.println(solution.minWindow("bba", "ab"));
    }

    @Test
    public void testMaxSubStringOfDisctChars() throws NoSuchAlgorithmException {
        SubstringSolution solution = new SubstringSolution();
//        //System.out.println(solution.getMaxSubOfDistinctChar("google",2));
//        Assert.assertEquals("goog",solution.getMaxSubOf2Char("google"));
//        Assert.assertEquals("gggggog",solution.getMaxSubOf2Char("123gggggogl33ee66"));
//        Assert.assertEquals("333ee",solution.getMaxSubOf2Char("gogl333ee66"));
//        Assert.assertEquals("ee66666", solution.getMaxSubOf2Char("gogl333ee66666"));

        for (int i=0; i<5000; ++i) {
            final String data = prepareRandomString(20,5);
            Assert.assertEquals("Failed on "+data, solution.getMaxSubOf2Char(data),solution.getMaxSubOf2Char_v2(data));
        }

        System.out.println(solution.getMaxSubOf2Char_v1("aaa"));
    }

    protected String prepareRandomString(int size, int numberOfCharacter) throws NoSuchAlgorithmException {
        final StringBuffer result = new StringBuffer();
        final SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        for (int i=0; i<size; ++i)
            result.append((char)(random.nextInt(numberOfCharacter)+'a'));
        return result.toString();
    }
}
