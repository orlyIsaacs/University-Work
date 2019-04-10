package LCS_LIS;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Vector;


//////////////////////////////////////////////////////////////////////////////
///////////////////////////// lcs dinamic serch////////////////////////////////////
public class Lcs2 {
	
	public static int[][] lcs2 (String s1, String s2)
	{
		int row= s1.length()+1;
		int colom= s2.length()+1;
		int [][]mat= new int[row][colom];
		
		
		//// first condition
		
		for(int i=0; i<row; i++)
			mat[i][0]=0;
		for( int j=0; j<colom; j++)
			mat[0][j]=0;
		
		/// fill mat
		
		for (int i = 1; i <row; i++) {
			for (int j = 1; j < colom; j++) {
				
				if (s1.charAt(i-1)== s2.charAt(j-1))
					mat[i][j]=mat[i-1][j-1]+1;
				else
					mat[i][j]= Math.max(mat[i-1][j], mat[i][j-1]);
// end fill
			}
			
		}
		
		return mat;
	}
		
public static String findOneTrace (String s1, String s2, int[][] mat)
{
		
		//// find trace////
		
		String ans="";
		int i= s1.length();
		int j= s2.length();
		
		while (ans.length()<mat[s1.length()][s2.length()]) /// no more continuation!!!
		{
			if (s1.charAt(i-1)==s2.charAt(j-1)) // if the char is equal
			{
				ans= s1.charAt(i-1)+ans;
				i--;
				j--;
			}
			else if (mat[i-1][j]>mat[i][j-1]) // up
				i--;
			else j--; // left
		}
		
		return ans;
	
	}
	//// all lcs /////////////////////////////////////

//public static HashSet<String> allLIS (int[] arr)
//{
//	int arr2[] = flipArr (arr);
//	int [][] mat = lcs2 (arr,arr2);
//	HashSet<String> ans= new HashSet<>();
//	ans= allLcc(arr, arr2, mat);
//	
//	return ans;
//}
//	


	public static HashSet<String> allLcc (String s1,String s2,int [][] mat)
	{
		 HashSet<String> all= new HashSet<>();
		String ans= "";
		int i= mat.length-1;
		int j= mat[0].length-1;
		allLccRec (s1,s2,all,mat,ans,i,j);
		return all;
	}
	
private static void allLccRec(String s1,String s2, HashSet<String> all, int[][] mat, String ans, int i, int j) {
	
	if (ans.length()==mat[mat.length-1][mat[0].length-1])
		all.add(ans);
	
	else if (s1.charAt(i-1)== s2.charAt(j-1))
	{
		ans= s1.charAt(i-1)+ans;
		allLccRec(s1, s2, all,  mat,  ans,i-1,  j-1);
	}
	else if (mat[i-1][j]>mat[i][j-1])
		allLccRec(s1, s2, all,  mat,  ans,i-1,  j);
	
	else if (mat[i][j-1]>mat[i-1][j])
		allLccRec(s1, s2, all,  mat,  ans, i,  j-1);
	
	else
	{
		allLccRec(s1, s2, all,  mat,  ans, i,  j-1);
		allLccRec(s1, s2, all,  mat,  ans,i-1,  j);
	}
		
	
}
	//////////// all lis polindrom////////////////////////////////

public static HashSet<String> allLicPoli (String s1,String s2,int [][] mat)
{
	HashSet<String> all= new HashSet<>();
	String ans= "";
	int i= mat.length-1;
	int j= mat[0].length-1;
	allLicPoliRec (s1,s2,all,mat,ans,i,j);
	return all;
}

private static void allLicPoliRec(String s1,String s2,HashSet<String> all, int[][] mat, String ans, int i, int j) {

if (ans.length()==mat[mat.length-1][mat[0].length-1])
		{if (ifPoli(ans, 0, ans.length()-1))
			all.add(ans);
		}

else if (s1.charAt(i-1)== s2.charAt(j-1))
{
	ans= s1.charAt(i-1)+ans;
	allLicPoliRec(s1, s2, all,  mat,  ans,i-1,  j-1);
}
else if (mat[i-1][j]>mat[i][j-1])
	allLicPoliRec(s1, s2, all,  mat,  ans,i-1,  j);

else if (mat[i][j-1]>mat[i-1][j])
	allLicPoliRec(s1, s2, all,  mat,  ans, i,  j-1);

else
{
	allLicPoliRec(s1, s2, all,  mat,  ans, i,  j-1);
	allLicPoliRec(s1, s2, all,  mat,  ans,i-1,  j);
}
	

}
	/////////////////////////////////////////////////////////////////////////
	///////////////////////////////// lcs full search////////////////////////
	
	
	public static String lcsFullSearch (String s1, String s2)
	{
		String [] as1= allStrings(s1); 
		String [] as2= allStrings(s2); 
		
		System.out.println("s1- "+ Arrays.deepToString(as1));
		System.out.println("s2- "+ Arrays.deepToString(as2));
		
		String max="";
		for (int i = 0; i < as1.length; i++) {
			for (int j = 0; j < as2.length; j++) {
				
				if (as1[i].equals(as2[j]))
					if (as1[i].length()>max.length())
						max=as1[i];
					
			}
		}
			return max;
		}
	
	
	private static String[] allStrings(String s) {
	
		String [] ans= new String[(int) (Math.pow(2, s.length()))-1];
		String bin;
		for (int i = 1; i <= ans.length; i++) {
			String temp="";
			bin=Integer.toBinaryString(i);
			bin=flip(bin);
			for (int j = 0; j < bin.length(); j++) { // how is in ('1' or '0')
				if (bin.charAt(j)=='1')
					temp+=s.charAt(j);
			}
	
			ans[i-1]=temp;
		}
		
		
		return ans;
	}

	
	private static String flip (String s)
	{
		String ans="";
		for(int i=0; i<s.length(); i++)
			ans= s.charAt(i)+ans;
		return ans;
	}

///////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////// polindroms- all answers /////////////////////////////////////////////////
	
	
	
	/// with full serach on full srach
	public static String findPolindrom (String s1)
	{
		String maxp="";
		String [] as1= allStrings(s1);
		System.out.println(Arrays.deepToString(as1));
		for (int i = 0; i < as1.length; i++) {
			if (ifPoli(s1, 0, as1[i].length()-1))
				if (as1[i].length()>maxp.length())
					maxp=as1[i];
				
		}
		return maxp;
	}
	
	///////////////////////////////////////////////////////////////
	public static boolean ifPoli (String s, int i, int j)
	{
		if (j-i ==1 || i==j) return true;
		if (s.charAt(i)==s.charAt(j))
			return ifPoli(s, i+1, j-1);
		return false;		
				
	}
	//////////////////////////// polindrom with flip + full search /////////
	public static String polindrom2( String s1)
	{
		String s2= flip(s1);
		return lcsFullSearch(s1, s2);
	}
	
	///////////////////// polindrom with flip + dimanic selotion = the best!!! //////
	public static String polindrom2best( String s1)
	{
		String s2= flip(s1);
		return "9";
		//return lcs2(s1, s2);
	}
	
	
	
	public static void main(String[] args) {
		
//		String s1= "alfalfa";
//		String s2= "aflafla";
//		System.out.println("s1= "+s1+ "  s2= "+s2);
//		System.out.println("longest sequence is- ");
//		System.out.println(lcs2(s1,s2));
//
//		
		
		
		
	
		//System.out.println(findPolindrom("lafalfa")); // full serch
		//System.out.println(polindrom2("lafalfa")); // flip
		
	//	System.out.println(polindrom2best("avi barazani"));
		String s1= "avi barazani";
		String s2= flip(s1);
		int [][] mat= lcs2(s1,s2);
		System.out.println("String 1= "+s1+ "String 2= "+s2);
		System.out.println("lcs matrix= ");
		for (int i = 0; i < mat.length; i++) {
			System.out.println(Arrays.toString(mat[i]));
		}
		System.out.println("one tace= "+findOneTrace(s1, s2, mat));
		HashSet<String> all= allLcc(s1, s2, mat);
		System.out.println(all.toString());
		
		System.out.println();
		System.out.println("all polindroms=");
		HashSet<String> poli = allLicPoli(s1, s2, mat);
		System.out.println(poli.toString());
		
	
		System.out.println();
		int [] arr= {1,2,3,5,5,2,8};
		System.out.println("all polindroms=");
	//	HashSet<String> alllis = allLIS(arr);
	//	System.out.println(alllis.toString());
		
	

	}

}
