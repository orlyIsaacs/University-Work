package MAX_MAX;


// ������� ��������� ����� ����� ���� ��������. ����� ��� ��� ����� ������ ���� ����� ������� ����� ����.

import javax.activation.MailcapCommandMap;

public class Fibo {
	
	 static long [] fibo =new long[100];
	 
	public static long  fibofunk (int a)
	{
		if (fibo[a]!=0) return fibo[a];
		
		if (a==0 || a==1)
		{
			return 1;
		}
		
		fibo[a]= fibofunk (a-1) +fibofunk (a-2);
		return fibo[a];
	}
	
	public static void main(String[] args) {
		int a=19;
		System.out.println("fibonachi nuber in place:"+a+"is- " +fibofunk(a));
	}

}
