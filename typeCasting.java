package practiceproj;
import java.util.Scanner;

public class typeCasting {

	public static void main(String[] args) {
		
		try (//Taking input using scanner
		Scanner sc = new Scanner(System.in)) {
			//Implicit type casting or widening
			 char c = 'z';
			 int n = c; // char to integer
			 System.out.println("value of c is :" +n);
			 
			 float f = n; // integer to float
			 System.out.println("Value of f is :" +f);
			 
			 long l = n;
			 System.out.println("value of l is:" +l);
			 
			 double d = n; // long to double
			 System.out.println("value of d is :" +d);
			 
			 System.out.println("\n");
			 
			 //Explicit type casting or Narrowing
			 System.out.println("Enter the floating point number:");
			 float num = sc.nextFloat();
			 int no = (int) num;  //float to integer
			 System.out.println("Integer value:" +no);
		}

	}

}
