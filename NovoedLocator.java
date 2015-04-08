import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class NovoedLocator
{
	public void main()throws IOException {
		readMethod();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("Welcome to the Location Search Engine");
			System.out.println("Choose One of the following options\n");
			System.out.println("a) Find by city");
			System.out.println("b) Find by state");
			System.out.println("c) Find by country");
			System.out.println("d) Find partners by proximity");
			System.out.println("e) Find a remote partners");
			System.out.println("f) Exit");
			char option = (char) br.read();
			switch (option) {
				case 'a': 
					findByCity();
					break;
				case 'b': 
					findByState();
					break;
				case 'c':
					findByCountry();
					break;
				/*case 'd':
					findByProximity();
					break;
				case 'e':
					findRemotePartners();
					break;*/
				case 'f':
					System.out.println("Have a great day");
					System.exit();
				default:
					System.out.println("Please enter a valid option");
			}
			System.out.println();
		}	
	}

	public void readMethod()throws IOException {
		FileInputStream fileIn = new FileInputStream("Data_file.txt");
		FileInputStream fileIn2 = new FileInputStream("GEODATASOURCE-CITIES-FREE.txt");
        FileInputStream fileIn3 = new FileInputStream("GEODATASOURCE-COUNTRY.txt");
        int citybit = 0;
        int countrybit = 0;
        int statebit = 0;
		Scanner scan = new Scanner(fileIn);
		Scanner scan2 = new Scanner(fileIn2);
		Scanner scan3 = new Scanner(fileIn3);
		ArrayList<String> x = new ArrayList<String>(3);
		
		for (int i = 0; i < 1100; i += 1)
            first_name.add(scan.nextLine());
        for (int i = 0; i < 1100; i += 1)
        	last_name.add(scan.nextLine());
        for (int i = 0; i < 1100; i += 1) {
        	addresses.add(scan.nextLine());
        	x = Arrays.asList(addresses.get(i).split(","));
        	outer:
        	for (int j = 0; j < x.size(); j += 1) {
	        	String str = x.get(i);
	        	do {
	        		String place = scan2.nextLine();
	        		if (str.equals(place.substring(3, place.length()))) {
	        			city_list.add(str);
	        			citybit = 1;
	        			break;
	        		}
	        		if (citybit == 1) {
	        			break;
	        		}
	        	} while (scan2.hasNextLine())
	        	do {
	        		String place = scan3.nextLine();
	        		if (str.equals(place.substring(10, place.length()))) {
	        			country_list.add(str);
	        			countrybit = 1;
	        			break;
	        		}
	        		if (countrybit == 1) {
	        			break;
	        		}
	        	} while (scan3.hasNextLine())
	        	if (countrybit == 1 && citybit == 1) {
	        		state_list.add(str);
	        		statebit = 1;
	        	}
	        }
	        if (statebit == 0) {
	        	state_list.add("");
	        }
	        if (countrybit == 0) {
	        	country_list.add("");
	        }
	     	if (citybit == 0) {
	     		city_list.add("");
	     	}
	     	statebit = 0;
	     	citybit = 0;
	     	countrybit = 0;
	    }
	}

	public void findByCity()throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the city you want to find students by");
		String cur_city = br.readLine();
		if (cur_city.trim().length() == 0) {
			System.out.println("Invalid Input");
			return;
		}
		System.out.println("Students from the same city include");
		for (int i = 0; i < 1100; i += 1) {
			if (cur_city.equals(city_list.get(i)))
				System.out.println(first_name.get(i)+" "+last_name.get(i));
		}
		System.out.println();
	}


	public void findByState()throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the state you want to find students by");
		String cur_state = br.readLine();
		if (cur_state.trim().length() == 0) {
			System.out.println("Invalid Input");
			return;
		}
		System.out.println("Students from the same state include");
		for (int i = 0; i < 1100; i += 1) {
			if (cur_state.equals(state_list.get(i)))
				System.out.println(first_name.get(i)+" "+last_name.get(i));
		}
		System.out.println();
	}
	public void findByCountry()throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the country you want to find students by");
		String cur_country = br.readLine();
		if (cur_country.trim().length() == 0) {
			System.out.println("Invalid Input");
			return;
		}
		System.out.println("Students from the same state include");
		for (int i = 0; i < 1100; i += 1) {
			if (cur_country.equals(country_list.get(i)))
				System.out.println(first_name.get(i)+" "+last_name.get(i));
		}
		System.out.println();
	}


	}
	ArrayList<String> first_name = new ArrayList<String>();
	ArrayList<String> last_name = new ArrayList<String>();
	ArrayList<String> addresses = new ArrayList<String>();	
	ArrayList<String> city_list = new ArrayList<String>();
	ArrayList<String> state_list = new ArrayList<String>();
	ArrayList<String> country_list = new ArrayList<String>();
}