package PatternTest;

import java.util.regex.*;

public class PatternTest {
    public static void main(String[] args) throws Exception {
    	boolean a,a1;
    	
    	a=Pattern.matches("\\d+", "22a23");
    	a1=Pattern.matches("\\d+", "2223");
    	System.out.println(a);    	
    	System.out.println(a1);

    	Pattern p = Pattern.compile("\\d+");
    	Matcher m1 = p.matcher("啦啦啦123hh");
    	System.out.println(m1.matches());
    	Matcher m2 = p.matcher("2345");
    	System.out.println(m2.matches());
    	System.out.println("************");
    	Pattern p1=Pattern.compile("\\d+");
    	Matcher m = p1.matcher("1213baa34aaa");
    	System.out.println(m.lookingAt());
    	System.out.println(m.start());
    	System.out.println(m.end());
    	System.out.println(m.group());
    	System.out.println("************");
    	Pattern p2 = Pattern.compile("([a-z]+)(\\d+)");
    	Matcher m3 = p2.matcher("aaa12345ff");
    	System.out.println(m3.find()); 
    	System.out.println(m3.group(1));
    	System.out.println(m3.start(1));
    	System.out.println(m3.end(1));
    	System.out.println(m3.group(2));
    	System.out.println(m3.start(2));
    	System.out.println(m3.end(2));
    	System.out.println("____________");
		String str = "北京市(海淀区)(朝阳区)";
		String paternStr = "海淀.*?(?=\\)";
		Pattern pattern = Pattern.compile(paternStr);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			System.out.println(matcher.group(0));
		}

    }
    
}