package NUMBER_GAME;

import java.util.Arrays;
import java.util.Scanner;



public class NumberGame {

	int arr[];

	///constructor
	public NumberGame(int[] arr) {
		super();
		this.arr = arr;
	}

	/// witch asrategi- returns 0 for even and 1 for odd
	public int atrategi (int index1, int index2)
	{
		int sumEven=0;
		int sumOdd=0;

		for(int i=index1; i<index2 ;i+=2)// scanning the arry
		{
			sumEven+=arr[i];
			sumOdd+=arr[i+1];
			System.out.println();
		}

		if (sumEven>sumOdd) return 0;// returning the max
		else return 1;

	}
	
	// prints the  array between i-j
	public void printarrIJ (int index1, int index2)
	{
		for( int i=index1; i<=index2; i++)
			System.out.print(arr[i]+", ");
	}

	
	
	/// the game!!!!
	public void CleverGame ()
	{
		Scanner sc = new Scanner(System.in);
		int i=0; int j=arr.length-1;
		int myans, answer;
		int myPoints=0; 
		int yourPoints=0;
		
		
		int astr=this.atrategi(i,j);
		if (astr==0) //// wining by chousing even index
		{

			System.out.println(Arrays.toString(arr));
			System.out.println("i play first");


			while (i<j)
			{
				//astr=this.atrategi(i,j);
				   

				if (i%2==0) 	myans=i;
				else myans=j;

				System.out.println("i chous :"+arr[myans]) ;
				if (myans==i)i++;
				else j--;
				myPoints+=arr[myans];
				System.out.println("your tern to play, cohus between :" +arr[i]+" or " +arr[j]);
				System.out.println();
				printarrIJ(i, j);
				answer= sc.nextInt();
				if (answer==arr[i])
				{
					yourPoints+=arr[i];
					i++;
					System.out.println("my points: "+myPoints+"   your points: "+yourPoints);
					System.out.println();
					printarrIJ(i, j);
				}
				else
				{
					yourPoints+=arr[j];
					j--;
					System.out.println("my points: "+myPoints+"   your points: "+yourPoints);
					System.out.println();
					printarrIJ(i, j);
				} 

			}// end while



		}// end if- winning by chousing odd index
		else{

			System.out.println(Arrays.toString(arr));
			System.out.println("i play first");


			while (i<j)
			{

				if (i%2==1) 	myans=i;
				else myans=j;

				System.out.println("i chous :"+arr[myans]) ;
				if (myans==i)i++;
				else j--;
				myPoints+=arr[myans];
				System.out.println("your tern to play, cohus between :" +arr[i]+" or " +arr[j]);
				System.out.println();
				printarrIJ(i, j);
				answer= sc.nextInt();
				if (answer==arr[i])
				{
					yourPoints+=arr[i];
					i++;
					System.out.println("my points: "+myPoints+"   your points: "+yourPoints);
					System.out.println();
					printarrIJ(i, j);
				}
				else
				{
					yourPoints+=arr[j];
					j--;
					System.out.println("my points: "+myPoints+"   your points: "+yourPoints);
					System.out.println();
					printarrIJ(i, j);
				} 
			}
				

        

			}// end while;

		   if (myPoints>yourPoints)
		   System.out.println("end of game! i win :)");
		   else if (myPoints==yourPoints)
			   System.out.println("end of game! TEKO");
		   else
			   System.out.println("end of game! you win :(");
			   
		}
	//end funk



	public static void main(String[] args) {

		int a[]={1,2,30,4};
		NumberGame game1= new NumberGame(a);
		game1.CleverGame();
	}
}





