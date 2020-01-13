package 新水果命名;
import java.util.Scanner;

public class main {
	
	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		String str1=input.next();
		String str2=input.next();
		cal(str1,str2);
	}
	
	public static void cal(String str1,String str2)
	{
		char temp1[]=str1.toCharArray();
		char temp2[]=str2.toCharArray();
		//为了不使用字符数组的首位，使程序可读性更好一点(可以不进行这个处理)
		char s1[]=new char[temp1.length+1];
		char s2[]=new char[temp2.length+1];
		int i,j,k;
		for(i=0,j=1;j<s1.length;i++,j++)
		{
			s1[j]=temp1[i];
		}
		for(i=0,j=1;j<s2.length;i++,j++)
		{
			s2[j]=temp2[i];
		}
		//
		char z[]=new char[Math.min(s1.length, s2.length)];//存放最长公共子序列//在本题中无用
		int L[][]=new int [s1.length][s2.length];//存放最长公共子序列的长度//在本题中也无用
		int S[][]=new int [s1.length][s2.length];//状态矩阵
		//
		//<对L的第零行第零列进行初始化>
		for(j=0;j<s2.length;j++)
		{
			L[0][j]=0;
		}
		for(i=0;i<s1.length;i++)
		{
			L[i][0]=0;
		}
		///>
		for(i=1;i<s1.length;i++)
		{
			for(j=1;j<s2.length;j++)
			{
				if(s1[i]==s2[j])
				{
					L[i][j]=L[i-1][j-1]+1;
					S[i][j]=1;//相等状态置为1
				}
				else if(L[i][j-1]>=L[i-1][j])
				{
					L[i][j]=L[i][j-1];//和本行前一个元素值相等
					S[i][j]=2;
				}
				else
				{
					L[i][j]=L[i-1][j];//和本列前一个元素相等
					S[i][j]=3;
				}
				
			}
		}
		i=temp1.length;
		j=temp2.length;
		k=L[temp1.length][temp2.length];
		while(i>0&&j>0)
		{
			if(S[i][j]==1)
			{
				z[k]=s1[i];
				k--;i--;j--;
			}
			else if(S[i][j]==2)
			{
				j--;
			}
			else 
			{
				i--;
			}
		}
		//<到这里两个字符串的最大公共子序列已经保存在字符数组z中了>（66到84行的代码在本题中无用）
		print(temp1.length,temp2.length,s1,s2,S);
	}
	public static void print(int n,int m,char s1[],char s2[],int S[][])//这里想减少传入参数的话可以将后三个设为全局变量，但是我个人不喜欢随便设置全局变量。
	{
		if(n==0&&m==0)
			return;
		
		if(S[n][m]==1)
		{
			print(n-1,m-1,s1,s2,S);
			System.out.print(s1[n]);
		}
		else if(S[n][m]==2||(S[n][m]==0&&n==0))
		{
			print(n,m-1,s1,s2,S);
			System.out.print(s2[m]);
		}
		else if(S[n][m]==3||(S[n][m]==0&&m==0))
		{
			print(n-1,m,s1,s2,S);
			System.out.print(s1[n]);
		}
	}
}
