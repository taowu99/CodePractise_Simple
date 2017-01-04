package org.tao.leetcode;

import java.util.*;

/**
 * Created by zkdu8y8 on 12/8/2016.
 */
public class WordSolution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] brk = new boolean[s.length()];
        int lf = -1;
        for (int i=s.length()-1; i>=0; --i) {
            brk[i]=wordDict.contains(s.substring(i));
            lf = lf>=0? lf:i;
        }
        if (lf<0)
            return false;

        for (int i=lf-1; i>=0; --i) {
            if (brk[i])
                continue;
            for (int j=i+1;j<=lf;++j) {
                if (wordDict.contains(s.substring(i,j)) && brk[j]) {
                    brk[i] = true;
                    break;
                }
            }
        }
        return brk[0];
    }

    public boolean wordBreak_DPB(String s, Set<String> wordDict) {
        boolean[] brk = new boolean[s.length()];
        int lf;
        for (lf=s.length()-1; lf>=0; --lf) {
            brk[lf]=wordDict.contains(s.substring(lf));
            if (brk[lf])
                break;
        }
        if (lf<0)
            return false;

        for (int i=lf-1; i>=0; --i) {
            if (brk[i]=wordDict.contains(s.substring(i)))
                continue;
            for (int j=i+1;j<=lf;++j) {
                if (wordDict.contains(s.substring(i,j)) && brk[j]) {
                    brk[i] = true;
                    break;
                }
            }
        }
        return brk[0];
    }

    public boolean wordBreak_DP1(String s, Set<String> wordDict) {
        boolean[] brk = new boolean[s.length()+1];
        brk[s.length()]=true;
        brk[s.length()-1] = wordDict.contains(s.substring(s.length()-1));
        for (int i=s.length()-2; i>=0; --i) {
            brk[i]=false;
            for (int j=i+1;j<=s.length();++j) {
                if (wordDict.contains(s.substring(i,j)) && brk[j]) {
                    brk[i] = true;
                    break;
                }
            }
        }
        return brk[0];
    }

    public boolean wordBreak_Rcr(String s, Set<String> wordDict) {
        for (int i=1; i<=s.length(); ++i) {
            if (wordDict.contains(s.substring(0,i)))
                if (i==s.length())
                    return true;
                else if (!wordBreak_Rcr(s.substring(i), wordDict))
                    continue;
                else
                    return true;
        }
        return false;
    }

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        return ladderLengthOneEnd(beginWord,endWord,wordList);
    }

    public int ladderLengthOneEnd(String beginWord, String endWord, Set<String> wordList) {
        int len=1;
        Set<String> visited = new HashSet();
        Queue<String> cache = new LinkedList<>();
        cache.add(beginWord);

        while (!cache.isEmpty()) {
            final int lvl = cache.size();
            for (int cnt=0; cnt<lvl; ++cnt) {
                String wrd = cache.poll();
                visited.add(wrd);

                for (int i = 0; i < wrd.length(); ++i) {
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        StringBuffer nxt = new StringBuffer(wrd).replace(i, i + 1, ch + "");
                        if (visited.contains(nxt.toString()) || !wordList.contains(nxt.toString()))
                            continue;
                        if (endWord.equals(nxt.toString()))
                            return len + 1;

                        cache.add(nxt.toString());
                    }
                }
            }
            ++len;
        }

        return 0;
    }

    public int ladderLengthTwoEnd(String beginWord, String endWord, Set<String> wordList) {
        int len=1;
        Set<String> visited = new HashSet();
        Queue<String> cacheHead = new LinkedList<>();
        cacheHead.add(beginWord);

        Queue<String> cacheTail = new LinkedList<>();
        cacheTail.add(endWord);

        Queue<String> cache = cacheHead.size()>cacheTail.size()?cacheTail:cacheHead;
        Queue<String> desti = cacheHead.size()>cacheTail.size()?cacheHead:cacheTail;

        while (!cache.isEmpty()) {
            final int lvl = cache.size();
            for (int cnt=0; cnt<lvl; ++cnt) {
                String wrd = cache.poll();
                visited.add(wrd);

                for (int i = 0; i < wrd.length(); ++i) {
                    for (char ch = 'a'; ch <= 'z'; ++ch) {
                        StringBuffer nxt = new StringBuffer(wrd).replace(i, i + 1, ch + "");
                        if (visited.contains(nxt.toString()) || !wordList.contains(nxt.toString()))
                            continue;
                        if (desti.contains(nxt.toString()))
                            return len + 1;

                        cache.add(nxt.toString());
                    }
                }
            }
            ++len;
            cache = cacheHead.size()>cacheTail.size()?cacheTail:cacheHead;
            desti = cacheHead.size()>cacheTail.size()?cacheHead:cacheTail;
        }

        return 0;
    }
}
