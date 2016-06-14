import java.util.Arrays;
import java.util.HashMap;


public class Climate {
	final static HashMap<Integer,String> HOT=new HashMap<Integer,String>();
	final static HashMap<Integer,String> COLD=new HashMap<Integer,String>();

	//assignData assigns the appropriate values as mentioned for hot and cold climate
	public static  void assignData()
	{
		HOT.put(1, "sandals");
		COLD.put(1, "boots");
		HOT.put(2, "sun visor");
		COLD.put(2, "hat");
		HOT.put(3, "fail");
		COLD.put(3, "socks");
		HOT.put(4, "t-shirt");
		COLD.put(4, "shirt");
		HOT.put(5, "fail");
		COLD.put(5, "jacket");
		HOT.put(6, "shorts");
		COLD.put(6, "pants");
		HOT.put(7, "leaving house");
		COLD.put(7, "leaving house");
		HOT.put(8, "Removing PJs");
		COLD.put(8, "Removing PJs");

	}

	/*climateVerification method  returns the value after checking some
	predefined conditions and evaluating the given input*/
	public static String climateVerification(HashMap<Integer,String> climateData,String x)
	{
		String output="";
		String data[]=x.split(",");
		boolean[] visited=new boolean[8];//checks if a particular option has been already choosen or not
		Arrays.fill(visited, false);

		//checking if the first input from user is "Removing PJs" or not
		if ((data.length==1) ||( !data[0].equals("8") ))
		{
			return "fail";
		}


		for(int i=0;i<data.length;i++)
		{   	
			// Avoiding duplicate entry 
			if(visited[Integer.parseInt(data[i])-1]==true)
			{
				output=output+"fail"+",";
				break;
			}
			visited[Integer.parseInt(data[i])-1]=true;


			// Checking condition if socks and Pants are worn before wearing shoes
			if((data[i].equals("6") && visited[0]==true) || (data[i].equals("3") && visited[0]==true) )
			{

				output=output+"fail"+",";
				break;
			}
			// checking if shirt is  put on before the headwear or jacket
			if((data[i].equals("2")  && visited[3]==false) || (data[i].equals("5") && visited[3]==false))
			{
				output=output+"fail"+",";
				break;
			}
			// Checking if the person leaves the house after putting all the items mentioned in the list
			if(data[i].equals("7") && i!=climateData.size()-1)
			{
				output=output+"fail"+",";
				break;
			}
			/*Checking for the condition when it is hot and a user 
			 * cannot wear socks and jacket hence should stop processing
			commands*/
			if(climateData.get(Integer.parseInt(data[i])).equals("fail"))
			{
				output=output+climateData.get(Integer.parseInt(data[i]))+",";
				break;
			}

			output=output+climateData.get(Integer.parseInt(data[i]))+",";
		}
		return output.substring(0,output.length()-1);
	}
}

