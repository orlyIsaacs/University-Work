package MAX_MAX;




public class BinToDec {
	
	public static int bin2dec (int bin)
	{
		int sum=0;
		return bin2dec( bin, 0,sum);
	}
	
	public static int bin2dec (int bin, int index, int sum)
	{
		if (bin==0) return sum;
		
		if (bin%10==1 )
		sum=sum +(int) Math.pow(2, index);
		
		index++;
		
		 return bin2dec (bin/10, index, sum);
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(bin2dec (1001001));
		
		

	}

}
