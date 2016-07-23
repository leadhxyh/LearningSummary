/**
 *	请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
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
        
        //以下情况pattern肯定非空，str可能为空
        if (*(pattern + 1) == '*') {			//遇到*
            
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
            return reMatch(str + 1, pattern +　1);
        
        return false;
    }
};
