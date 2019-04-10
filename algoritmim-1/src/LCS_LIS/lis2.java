package LCS_LIS;

import java.util.Arrays;

public class lis2 {


	/////////////////////////lis in o(NlogN)//////////////////////////
	public static int lis2 (int[] arr)
	{

		int [][] mat= new int[arr.length][arr.length];
		mat[0][0]= arr[0];
		int insert=0;
		int depth=0;
		for (int i = 0; i < arr.length; i++) {

			insert=binSearch (mat,arr[i],0,depth);
			mat[insert][insert]=arr[i];
			//copyrowAbuv(mat,insert); // cpoy the row abouv to the current row
			if (insert== depth)
				depth++;

		}
		//		System.out.println("mat is: ");
		//		for (int i1 = 0; i1 < mat.length; i1++) {
		//			System.out.println(Arrays.toString(mat[i1]));
		//		} 


		//return mat[depth-1];
		return depth;
	}

	private static void copyrowAbuv(int[][] mat, int depth) {
		if (depth==0) return;
		for (int i = 0; i < depth; i++) {
			mat[depth][i]= mat[depth-1][i];
		}

	}

	private static int binSearch(int[][] mat, int value, int start, int end) {

		if(end-start==1) // left with 2 sqers
			if (mat[start][start]>value)
				return start ;
			else return end;

		int middle= (start+end)/2;

		if (mat[middle][middle]==value)
			return middle;

		else if (mat[middle][middle]> value)// go left
			return binSearch(mat, value, start, middle);
		else  // go right
			return binSearch(mat,value, middle, end);

	}



	//////////////////////////// only length nlogn///////////////////

	public static int lisSize (int [] arr)
	{
		int[] diagonal= new int[arr.length];
		int insert=0;
		int len=0;
		diagonal[0]= arr[0];
		for (int i = 1; i < arr.length; i++) {

			insert= binSearch2 (diagonal,arr[i], 0, len);
			diagonal[insert]= arr[i];
			if (insert==len)
				len++;

			return len;

		}



		return 0;
	}


	private static int binSearch2(int[] diagonal, int value, int start, int end) {

		if (end-start==1)
			if (diagonal[start]>value)
				return start;
			else
				return end;

		int middle= (start +end) /2;
		if (diagonal[middle]==value)
			return value;
		else if (diagonal[middle]> value)
			return binSearch2(diagonal, value, start, middle); // go left
		else return binSearch2(diagonal, value, middle, end); // go rifht

	}

	///////////////////////////////////// bitonic - up dowen ///////////////////////////
	public static void bitonic (int [] arr)
	{
		int [] up = new int [arr.length];
		int [] down = new int [arr.length];
		int [] sum = new int [arr.length];

		for (int i = 0; i < arr.length; i++) {

			up[i]= lisPart(arr,i);
			down[i] =lds (arr,i);
			sum[i]= up[i]+down[i]-1;
		}


		System.out.println("up-   "+Arrays.toString(up));
		System.out.println("down- "+Arrays.toString(down));
		System.out.println("sum-  "+Arrays.toString(sum));

		///////////////fined max////////////////////
		int max=0;
		for (int i = 0; i < sum.length; i++) {
			if (sum[i]>max)
				max= sum[i];
		}

		System.out.println("longest bitonic is at length: "+max);
	}











	private static int lds(int[] arr, int i) {
		arr= flipArr(arr);
		int [] temp= Arrays.copyOfRange(arr, i, arr.length);
		return lis2(temp);


	}

	private static int[] flipArr(int[] arr) {
		int [] temp =new int [arr.length];
		for (int i = 0; i < temp.length; i++) {
			temp[i]= arr[arr.length-i-1];

		}

		return temp;
	}

	private static int lisPart(int[] arr, int i) {
		int [] temp= Arrays.copyOf(arr, i+1);
		return lis2(temp);
	}
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////lis with lcs//////////////////////////////////////////
	public static String lisWithLcs (int [] arr)
	{
		
		int [] sorted= Arrays.copyOf(arr,arr.length);
		Arrays.sort(sorted);
		return lcs2(arr, sorted);
	}


	//////////////////////////////////////////////////////////////////////////////
	///////////////////////////// lcs dinamic serch with numbers////////////////////////////////////
	

		public static String lcs2 (int [] a, int [] b)
		{
			int row= a.length+1;
			int colom= b.length+1;
			int [][]mat= new int[row][colom];


			//// first condition
			for(int i=0; i<row; i++)
				mat[i][0]=0;
			for( int j=0; j<colom; j++)
				mat[0][j]=0;

			/// fill mat

			for (int i = 1; i <row; i++) {
				for (int j = 1; j < colom; j++) {

					if (a[i-1]== b[j-1])
						mat[i][j]=mat[i-1][j-1]+1;
					else
						mat[i][j]= Math.max(mat[i-1][j], mat[i][j-1]);
					//end fill
				}

			}
			/// print
			for (int i = 0; i < row; i++) {
				System.out.println(Arrays.toString(mat[i]));

			}

			//return mat[mat.length-1][mat.length-1];
			//// find trace////
			
						String ans="";
						int i= row-1;
						int j= colom-1;
			
						while (ans.length()<mat[row-1][colom-1]) /// no more continuation!!!
						{
							if (a[i-1]==b[j-1]) // if the char is equal
							{
								ans= a[i-1]+ans;
								i--;
								j--;
							}
							else if (mat[i-1][j]>mat[i][j-1]) // up
								i--;
							else j--; // left
						}
			
						return ans;

		}


	public static void main(String[] args) {

		int [] arr= {70,80,90,1,2,3,4,-5,6,7,8};
		System.out.println("the arr is: "+Arrays.toString(arr));
		System.out.println("longest seqence: ");
		//System.out.println(Arrays.toString(lis2(arr)));

		//System.out.println("size= "+lis2(arr));
		bitonic(arr);
		
		System.out.println("lis with lcs: "+ lisWithLcs(arr));

	}
}


