package ��ˮ������;
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
		//Ϊ�˲�ʹ���ַ��������λ��ʹ����ɶ��Ը���һ��(���Բ������������)
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
		char z[]=new char[Math.min(s1.length, s2.length)];//��������������//�ڱ���������
		int L[][]=new int [s1.length][s2.length];//�������������еĳ���//�ڱ�����Ҳ����
		int S[][]=new int [s1.length][s2.length];//״̬����
		//
		//<��L�ĵ����е����н��г�ʼ��>
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
					S[i][j]=1;//���״̬��Ϊ1
				}
				else if(L[i][j-1]>=L[i-1][j])
				{
					L[i][j]=L[i][j-1];//�ͱ���ǰһ��Ԫ��ֵ���
					S[i][j]=2;
				}
				else
				{
					L[i][j]=L[i-1][j];//�ͱ���ǰһ��Ԫ�����
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
		//<�����������ַ�������󹫹��������Ѿ��������ַ�����z����>��66��84�еĴ����ڱ��������ã�
		print(temp1.length,temp2.length,s1,s2,S);
	}
	public static void print(int n,int m,char s1[],char s2[],int S[][])//��������ٴ�������Ļ����Խ���������Ϊȫ�ֱ����������Ҹ��˲�ϲ���������ȫ�ֱ�����
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
