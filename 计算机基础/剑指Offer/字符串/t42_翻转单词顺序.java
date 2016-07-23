/**
 *	ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish������������ȴ������������˼�����磬��student. a am I������������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ���ȷ�ľ���Ӧ���ǡ�I am a student.����Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
 */

/**
 *	˼·��1����תÿ������ 2����ת��������
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
                while (end < len && s[end] != ' ') {		//ע�⣺end < len��ǰ����ֹԽ��
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
