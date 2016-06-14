
import java.util.Scanner;


public class ClimateMain {

	public static void main(String args[])
	{

		Climate.assignData();
		System.out.println("Please enter the climate Condition  HOT/COLD");
		Scanner cin =new Scanner(System.in);
		String climate=cin.nextLine();
		System.out.println("Enter the choice you would want to select");
		System.out.println("1 Put on footwear");
		System.out.println("2 Put on headwear");
		System.out.println("3 Put on socks");
		System.out.println("4 Put on shirt");
		System.out.println("5 Put on jacket");
		System.out.println("6 Put on pants");
		System.out.println("7 Leave house");
		System.out.println("8 Take off pajamas");
		System.out.println("Please enter the input in the given format: like 1,2,3,4 etc");
		String input=cin.nextLine();
		String inputs=input.replaceAll(" ","");

		if(climate.equalsIgnoreCase("HOT"))
		{
			System.out.println(Climate.climateVerification(Climate.HOT,inputs));	
		}
		else
			if(climate.equalsIgnoreCase("COLD"))
			{
				System.out.println(Climate.climateVerification(Climate.COLD,inputs));	
			}else
			{
				System.out.println("Invalid command please choose appropriate option");
			}

	}





}
