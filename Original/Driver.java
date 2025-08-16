import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    // Instance variables (if needed)

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);

        initializeDogList();
        initializeMonkeyList();
    //menu loop 
    char menuChoice;
    do {
    	displayMenu();
    	String input = scanner.nextLine();
    	
    	if (input.isEmpty() || input.length() != 1) {
            System.out.println("Invalid Input!");
            continue;
        }

    	menuChoice = input.charAt(0);

    	switch (menuChoice) {
    		case '1':
    			intakeNewDog(scanner);
    			break;
    		case '2':
    			intakeNewMonkey(scanner);
    			break;
    		case '3':
    			reserveAnimal(scanner);
    			break;
    		case '4':
    			printDogs();
    			break;
    		case '5':
    			printMonkeys();
    			break;
    		case '6':
    			printAvailableAnimals();
    			break;
    		case 'q':
    			System.out.println("Exiting application.");
    	}
    } while (menuChoice != 'q');
        // Add a loop that displays the menu, accepts the users input
        // and takes the appropriate action.
	// For the project submission you must also include input validation
        // and appropriate feedback to the user.
        // Hint: create a Scanner and pass it to the necessary
        // methods 
	// Hint: Menu options 4, 5, and 6 should all connect to the printAnimals() method.

    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }
    //monkey list
    public static void initializeMonkeyList() {
    	Monkey monkey1 = new Monkey("Cleo", "Capuchin", "female", "3", "20.2", "12-28-2020", "United States", "in service", false, "United States");
    	Monkey monkey2 = new Monkey("Zeno", "Macaque", "male", "2", "23.2", "06-15-2021", "United States", "Phase I", true, "United States");
    	Monkey monkey3 = new Monkey("Byuri", "Tamarin", "female", "7", "16.5", "10-18-2016", "United States", "in services", true, "United States");
    	
    	monkeyList.add(monkey1);
    	monkeyList.add(monkey2);
    	monkeyList.add(monkey3);
    }

    // Adds monkeys to a list for testing
    //Optional for testing
   


    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; 
            }
        }
        System.out.println("What is the breed of the dog?");
        String breed = scanner.nextLine();

        System.out.println("What is the gender of the dog?");
        String gender = scanner.nextLine();

        System.out.println("What is the age of the dog?");
        String age = scanner.nextLine();

        System.out.println("What is the weight of the dog?");
        String weight = scanner.nextLine();

        System.out.println("When was the dog acquired (date)?");
        String acquisitionDate = scanner.nextLine();

        System.out.println("From which country was the dog acquired?");
        String acquisitionCountry = scanner.nextLine();

        System.out.println("What is the training status of the dog?");
        String trainingStatus = scanner.nextLine();

        System.out.println("Is the dog reserved? (true or false)");
        boolean isReserved = scanner.nextBoolean();
        
 
        scanner.nextLine();

        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, isReserved, "United States");
        dogList.add(newDog);

        System.out.println("New dog named " + name + " has been added to the system.\n");
    }
        
    
      
    
    
    

        // Complete intakeNewMonkey
	//Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also  validate the input
	// to make sure the monkey doesn't already exist and the species type is allowed
        public static void intakeNewMonkey(Scanner scanner) {
            System.out.println("The method intakeNewMonkey needs to be implemented");
            
            System.out.println("What is the monkey's name?");
        	String name = scanner.nextLine();
        	for(Monkey monkey: monkeyList) {
        		if (monkey.getName().equalsIgnoreCase(name)) {
        			System.out.println("\n\nThis monky is already in our system]n]n");
        			return;
        		}
        	}
        	System.out.println("What is the species of the monkey?");
        	String species = scanner.nextLine();
        	
        	if (!isValidSpecies(species)) {
                System.out.println("\nInvalid species type. Please enter a valid species.\n");
                return; 
            }

        	System.out.println("What is the gender of the monkey?");
        	String gender = scanner.nextLine();
        	
        	System.out.println("What is the age of the monkey?");
        	String age = scanner.nextLine();
        	
        	System.out.println("When did you acquire the monkey");
        	String acquisitionDate = scanner.nextLine();
        	
        	System.out.println("What country did you get the monkey");
        	String acquisitionCountry = scanner.nextLine();
        	
        	System.out.println("What is the status of the monkey?");
        	String trainingStatus = scanner.nextLine();
        	
        	System.out.println("Is the monkey reserved?");
        	boolean isReserved = scanner.nextBoolean();
        	
        	Monkey newMonkey= new Monkey(name, species, gender, age, acquisitionDate, acquisitionCountry, status);
        	monkeyList.add(newMonkey);
        	System.out.println("New monkey " + name + " has been added to the system.\n");
        }
        private static boolean isValidSpecies(String species) {
        	String[] validSpecies = {"Capuchin", "Guenon ", "Macaque", "Marmoset", "Squirrel monkey", "Tamarin"};
        	for (String valid : validSpecies) {
                if (species.equalsIgnoreCase(valid)) {
                    return true;
                }
            }
            return false;
        }
        

        // Complete reserveAnimal
        // You will need to find the animal by animal type and in service country
        public static void reserveAnimal(Scanner scanner) {
            System.out.println("The method reserveAnimal needs to be implemented");
            System.out.println("Enter the type of animal");
            String animalType = scanner.nextLine();
            
            if (animalType.equalsIgnoreCase("dog")) {
            	System.out.println("Enter in-service country");
            	String inServiceCountry = scanner.nextLine();
            	
            	for (Dog dog : dogList) {
            		if (dog.getStatus().equalsIgnoreCase("in service") && dog.getInServiceCountry().equalsIgnoreCase(inServiceCountry) && !dog.isReserved()) {
            			dog.setReserved(true);
            			System.out.println("The dog named " + dog.getName() + " has been reserved.");
            			return;
            		}
            	}
            	System.out.println("No available dogs of that type and location.");
        }
            else if (animalType.equalsIgnoreCase("monkey")) {
            	System.out.println("Enter the in-service country:");
            	String inServiceCountry = scanner.nextLine();
            	for (Monkey monkey : monkeyList) {
            		if (monkey.getStatus().equalsIgnoreCase("in service") && monkey.getInServiceCountry().equalsIgnoreCase(inServiceCountry) && !monkey.isReserved()) {
            			monkey.setReserved(true);
            			System.out.println("The monkey named " + monkey.getName() + "has been reserved.");
            			return;
            		}
            	}
            	System.out.println("No available monkeys of that type and location.");
            
            	}
            }
    	

        // Complete printAnimals
        // Include the animal name, status, acquisition country and if the animal is reserved.
	// Remember that this method connects to three different menu items.
        // The printAnimals() method has three different outputs
        // based on the listType parameter
        // dog - prints the list of dogs
        // monkey - prints the list of monkeys
        // available - prints a combined list of all animals that are
        // fully trained ("in service") but not reserved 
	// Remember that you only have to fully implement ONE of these lists. 
	// The other lists can have a print statement saying "This option needs to be implemented".
	// To score "exemplary" you must correctly implement the "available" list.
        public static void printAnimals() {
            System.out.println("The method printAnimals needs to be implemented");
            System.out.println("List of available animals");
            
            //for dogs
            System.out.println("Dogs:");
            for (Dog dog : dogList) {
            	if (dog.status().equalsIgnoreCase("in service") && !dog.isReserved()) {
            		System.out.println(dog.getName() + " (" + dog.getSpecies() + ")");
            	}
            }
            //for monkeys
            System.out.println("Monkeys:");
            for (Monkey monkey : monkeyList) {
            	if (monkey.status().equalsIgnoreCase("in service") && !monkey.isReserved()) {
            		System.out.println(monkey.getName() + " (" + monkey.getSpecies() + ")");
            	}
            }
           
        }
}

