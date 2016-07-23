/**
 *	牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */

/**
 *	思路：1、翻转每个单词 2、翻转整个句子
 */

public class Solution {
    public String ReverseSentence(String str) {
        if (str == null)
            return null;
        if (str.length() == 0)
            return str;
        
        int len = str.length();
        char[] s = str.toCharArray();
        int begin = 0;
        int end = 0;
        while (begin < len) {
            if (s[begin] == ' ') {
                begin++;
            } else {
                end = begin;
                while (end < len && s[end] != ' ') {		//注意：end < len在前，防止越界
                    end++;
                }
        
                reverse(s, begin, end - 1);
                
                begin = end;
            }
        }
        reverse(s, 0, len - 1);
        return String.valueOf(s);
    }
    
    public void reverse(char[] s, int index1, int index2) {
        char tem = s[index1];
        while (index1 < index2) {
            tem = s[index1];
            s[index1] = s[index2];
           	s[index2] = tem;
            index1++;
            index2--;
        }
    }
}
