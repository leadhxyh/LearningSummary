/*
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。 
处理:
1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加；(文件所在的目录不同，文件名和行号相同也要合并)
2.超过16个字符的文件名称，只记录文件的最后有效16个字符；(如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
3.输入的文件可能带路径，记录文件名称不能带路径

输入描述:
一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。

    文件路径为windows格式

    如：E:\V1R2\product\fpgadrive.c 1325


输出描述:
将所有的记录统计并将结果输出，格式：文件名代码行数数目，一个空格隔开，如: fpgadrive.c 1325 1 

    结果根据数目从多到少排序，数目相同的情况下，按照输入第一次出现顺序排序。

    如果超过8条记录，则只输出前8条记录.

    如果文件名的长度超过16个字符，则只输出后16个字符

输入例子:
E:\V1R2\product\fpgadrive.c 1325

输出例子:
fpgadrive.c 1325 1
*/

/*
 *	知识点：1、正则表达式的书写，如插入反斜杠为"\\\\". 2、String.substring()下标
 */

import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String file;
        int line;
        String nameLine;
        Map<String, Integer> map = new LinkedHashMap();
        

        while (in.hasNext()) {
            file = in.next();
            line = in.nextInt();
            //获取文件名
            String[] ss = file.split("\\\\");
            file = ss[ss.length - 1];
            //文件名加行号
            nameLine = file + " " + line;
            Integer i;
            if ((i = map.get(nameLine)) == null) {
            	map.put(nameLine, 1);
            } else {
            	map.put(nameLine, ++i);
            }
        }
        in.close();
        //按出现次数进行稳定排序
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
        	@Override
        	public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        		return o1.getValue() > o2.getValue() ? -1 : (o1.getValue() == o2.getValue() ? 0 : 1);
        	}
		});
        
        //输出前8条错误，只输出后16位
        print(list);
    }
    
    public static void print(List<Map.Entry<String, Integer>> list){
    	int len = list.size();
    	Map.Entry<String, Integer> entry;
        int lens = 8 < list.size() ? 8 : list.size();
        
    	for (int i = 0; i < lens; i++) {
    		entry = list.get(i);
    		String nameLine = entry.getKey();
    		Integer count = entry.getValue();
    		String[] split = nameLine.split("\\s");
    		int start = (split[0].length() - 16) > 0 ? (split[0].length() - 16) : 0;
    		String name = split[0].substring(start, split[0].length());
    		String line = split[1];
    		System.out.println(name + " " + line + " " + count);
    	}
    }
}
