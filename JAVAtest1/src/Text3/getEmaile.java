package Text3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class getEmaile{
	
	
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		String str="<html><body><a href=\"http://www.baidu.com\">百度</a>，<a href='www.webmeteor.cn/course/java' target='_blank'>网易</a>，<a href='/news/13432.html' target=\"_blank\">内部地址</a></body></html>";
		String paternStr1 = "http.*?(?=\\\")";
		Pattern p1 = Pattern.compile(paternStr1);
		Matcher m1 = p1.matcher(str);
		if (m1.find()) {
			System.out.println(m1.group(0));
		}
		String paternStr2 = "www.w.*?(?=')";
		Pattern p2 = Pattern.compile(paternStr2);
		Matcher m2 = p2.matcher(str);
		if (m2.find()) {
			System.out.println(m2.group(0));
		}		
		String paternStr3 = "/news.*?(?=\')";
		Pattern p3 = Pattern.compile(paternStr3);
		Matcher m3 = p3.matcher(str);
		if (m3.find()) {
			System.out.println(m3.group(0));
		}		
		System.out.println("_____________");
		String str1 = sc.nextLine();
		String paternStr4 = "href=\\'[a-z.0-9A-z//]{6,60}|href=\"http:\\/+(w+\\..{3,5}\\.com)";
		Pattern p4 = Pattern.compile(paternStr4);
		Matcher m4 = p4.matcher(str1);
		while (m4.find()) {
			System.out.println(m4.group().substring(6));
		}
		sc.close();
	}

	

	
}