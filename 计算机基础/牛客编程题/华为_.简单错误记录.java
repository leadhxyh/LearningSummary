/*
 * ����һ���򵥴����¼����Сģ�飬�ܹ���¼����Ĵ������ڵ��ļ����ƺ��кš� 
����:
1.��¼���8�������¼������ͬ�Ĵ����¼(���ļ����ƺ��к���ȫƥ��)ֻ��¼һ��������������ӣ�(�ļ����ڵ�Ŀ¼��ͬ���ļ������к���ͬҲҪ�ϲ�)
2.����16���ַ����ļ����ƣ�ֻ��¼�ļ��������Ч16���ַ���(����ļ�����ͬ����ֻ���ļ����ĺ�16���ַ����к���ͬ��Ҳ��Ҫ�ϲ�)
3.������ļ����ܴ�·������¼�ļ����Ʋ��ܴ�·��

��������:
һ�л�����ַ�����ÿ�а�����·���ļ����ƣ��кţ��Կո������

    �ļ�·��Ϊwindows��ʽ

    �磺E:\V1R2\product\fpgadrive.c 1325


�������:
�����еļ�¼ͳ�Ʋ�������������ʽ���ļ�������������Ŀ��һ���ո��������: fpgadrive.c 1325 1 

    ���������Ŀ�Ӷൽ��������Ŀ��ͬ������£����������һ�γ���˳������

    �������8����¼����ֻ���ǰ8����¼.

    ����ļ����ĳ��ȳ���16���ַ�����ֻ�����16���ַ�

��������:
E:\V1R2\product\fpgadrive.c 1325

�������:
fpgadrive.c 1325 1
*/

/*
 *	֪ʶ�㣺1��������ʽ����д������뷴б��Ϊ"\\\\". 2��String.substring()�±�
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
            //��ȡ�ļ���
            String[] ss = file.split("\\\\");
            file = ss[ss.length - 1];
            //�ļ������к�
            nameLine = file + " " + line;
            Integer i;
            if ((i = map.get(nameLine)) == null) {
            	map.put(nameLine, 1);
            } else {
            	map.put(nameLine, ++i);
            }
        }
        in.close();
        //�����ִ��������ȶ�����
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
        	@Override
        	public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        		return o1.getValue() > o2.getValue() ? -1 : (o1.getValue() == o2.getValue() ? 0 : 1);
        	}
		});
        
        //���ǰ8������ֻ�����16λ
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
