/**
 *	��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ��� �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ�����磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��
 */

class Solution {
public:
    bool match(char* str, char* pattern)
    {
    	return reMatch(str, pattern);
    }
    
    bool reMatch(char* str, char* pattern) {
        if (*str == '\0' && *pattern == '\0') {
            return true;
        }
        if (*str != '\0' && *pattern == '\0') {
        	return false;  
        }
        
        //�������pattern�϶��ǿգ�str����Ϊ��
        if (*(pattern + 1) == '*') {			//����*
            
            if (*str == '\0') {		//	'\0', 'a*'
                return reMatch(str, pattern + 2);
            }
            if ((*str == *pattern) || (*pattern == '.')) {	// 'ab', 'a*b'
            	return reMatch(str, pattern + 2)
                	|| reMatch(str + 1, pattern + 2)
               		|| reMatch(str + 1, pattern);
            }
            
            return reMatch(str, pattern + 2);		// 'bb', 'a*b'
        }
        
        
        if (((*str == *pattern) || (*pattern == '.')) && *str != '\0')	// 'ab', 'ac'
            return reMatch(str + 1, pattern +��1);
        
        return false;
    }
};
