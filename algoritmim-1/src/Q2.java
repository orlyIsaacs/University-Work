
public class Q2 {
	
	public static int lonlongestSubseqWithDiffOne (int [] arr){
		int [] help = new int [arr.length];
		for (int i = 0; i < help.length; i++) {
			help[i]=1;
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < help.length; j++) {
				if (Math.abs(arr[i]-arr[j])<=1) help[i]=Math.max(help[i], help[j]+1);
			}
		}
		
		int max=help[0];
		for (int i = 1; i < help.length; i++) {
			if (max<help[i]) max=help[i];
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = {1,2,3,4,3,2};
		System.out.println(lonlongestSubseqWithDiffOne(arr));
	
	}

}
