import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();

    private static HashMap<String, Dog> dogMap = new HashMap<>();
    private static HashMap<String, Monkey> monkeyMap = new HashMap<>();

    public static void main(String[] args) {
        runApplication();
    }

    private static void runApplication() {
    Scanner scanner = new Scanner(System.in);
    initializeDogList();
    initializeMonkeyList();
    handleMenuLoop(scanner);
}
    private static void processMenuChoice(char choice, Scanner scanner) {
        switch (choice) {
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
            case '7':
                printAnimals();
                break;
            case 'q':
                System.out.println("Exiting application.");
                break;
            default:
                System.out.println("Invalid selection. Please try again.");
        }
    }

    private static void handleMenuLoop(Scanner scanner) {
    char menuChoice = ' ';
    do {
        displayMenu();
        String input = scanner.nextLine();

        if (input.isEmpty() || input.length() != 1) {
            System.out.println("Invalid Input!");
            continue;
        }

        menuChoice = input.charAt(0);

        processMenuChoice(menuChoice, scanner);
    } while (menuChoice != 'q');
}

    


    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[7] Print a list of all animals (dogs and monkeys)");
        System.out.println("[q] Quit application");
        System.out.println("Enter a menu selection");
    }

    private static String promptForString(Scanner scanner, String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);

        dogMap.put(dog1.getName().toLowerCase(), dog1);
        dogMap.put(dog2.getName().toLowerCase(), dog2);
        dogMap.put(dog3.getName().toLowerCase(), dog3);
    }

    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("Cleo", "Capuchin", "female", "3", "12-28-2020", "United States", "in service", false, "United States");
        Monkey monkey2 = new Monkey("Zeno", "Macaque", "male", "2", "06-15-2021", "United States", "Phase I", true, "United States");
        Monkey monkey3 = new Monkey("Byuri", "Tamarin", "female", "7", "10-18-2016", "United States", "in service", true, "United States");

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);

        monkeyMap.put(monkey1.getName().toLowerCase(), monkey1);
        monkeyMap.put(monkey2.getName().toLowerCase(), monkey2);
        monkeyMap.put(monkey3.getName().toLowerCase(), monkey3);
}

    public static void intakeNewDog(Scanner scanner) {
        String name = promptForString(scanner, "What is the dog's name?");
        for (Dog dog : dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return;
            }
        }

        String breed = promptForString(scanner, "What is the breed of the dog?");
        String gender = promptForString(scanner, "What is the gender of the dog?");
        String age = promptForString(scanner, "What is the age of the dog?");
        String weight = promptForString(scanner, "What is the weight of the dog?");
        String acquisitionDate = promptForString(scanner, "When was the dog acquired (date)?");
        String acquisitionCountry = promptForString(scanner, "Which country was the dog acquired?");
        String trainingStatus = promptForString(scanner, "What is the training status of the dog?");

        System.out.println("Is the dog reserved? (true or false)");
        boolean isReserved = scanner.nextBoolean();
        scanner.nextLine(); // Clear newline

        Dog newDog = new Dog(name, breed, gender, age, weight, acquisitionDate, acquisitionCountry, trainingStatus, isReserved, "United States");
        dogList.add(newDog);
        dogMap.put(name.toLowerCase(), newDog);
        System.out.println("New dog named " + name + " has been added to the system.\n");
    }


    public static void intakeNewMonkey(Scanner scanner) {
        String name = promptForString(scanner, "What is the monkey's name?");
        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return;
            }
        }

        String species = promptForString(scanner, "What is the species of the monkey?");
        if (!isValidSpecies(species)) {
            System.out.println("\nInvalid species type. Please enter a valid species.\n");
            return;
        }

        String gender = promptForString(scanner, "What is the gender of the monkey?");
        String age = promptForString(scanner, "What is the age of the monkey?");
        String acquisitionDate = promptForString(scanner, "When did you acquire the monkey?");
        String acquisitionCountry = promptForString(scanner, "What country did you get the monkey from?");
        String trainingStatus = promptForString(scanner, "What is the status of the monkey?");

        System.out.println("Is the monkey reserved? (true or false)");
        boolean isReserved = scanner.nextBoolean();
        scanner.nextLine(); // Clear the newline

        Monkey newMonkey = new Monkey(name, species, gender, age, acquisitionDate, acquisitionCountry, trainingStatus, isReserved, "United States");
        monkeyList.add(newMonkey);
        monkeyMap.put(name.toLowerCase(), newMonkey);
        System.out.println("New monkey " + name + " has been added to the system.\n");
    }   

    private static boolean isValidSpecies(String species) {
        String[] validSpecies = { "Capuchin", "Guenon", "Macaque", "Marmoset", "Squirrel monkey", "Tamarin" };
        for (String valid : validSpecies) {
            if (species.equalsIgnoreCase(valid)) {
                return true;
            }
        }
        return false;
    }

    public static void reserveAnimal(Scanner scanner) {
        System.out.println("Enter the type of animal (dog or monkey):");
        String animalType = scanner.nextLine().toLowerCase();

        System.out.println("Enter the animal's name:");
        String name = scanner.nextLine().toLowerCase();

        if (animalType.equals("dog")) {
            Dog dog = dogMap.get(name);
            if (dog != null && dog.getTrainingStatus().equalsIgnoreCase("in service") && !dog.getReserved()) {
                dog.setReserved(true);
                System.out.println("The dog named " + dog.getName() + " has been reserved.");
            } else {
                System.out.println("Dog not found, not in service, or already reserved.");
            }
        } else if (animalType.equals("monkey")) {
            Monkey monkey = monkeyMap.get(name);
            if (monkey != null && monkey.getTrainingStatus().equalsIgnoreCase("in service") && !monkey.getReserved()) {
                monkey.setReserved(true);
                System.out.println("The monkey named " + monkey.getName() + " has been reserved.");
            } else {
                System.out.println("Monkey not found, not in service, or already reserved.");
            }
        } else {
            System.out.println("Invalid animal type.");
        }
    }
    

    public static void printAnimals() {
        System.out.println("All Dogs:");
        for (Dog dog : dogList) {
            System.out.println("Name: " + dog.getName()
                + ", Breed: " + dog.getBreed()
                + ", Gender: " + dog.getGender()
                + ", Age: " + dog.getAge()
                + ", Weight: " + dog.getWeight()
                + ", Acquisition Date: " + dog.getAcquisitionDate()
                + ", Acquisition Country: " + dog.getAcquisitionLocation()
                + ", Training Status: " + dog.getTrainingStatus()
                + ", Reserved: " + dog.getReserved()
                + ", In-Service Country: " + dog.getInServiceLocation());
    }

    System.out.println("\nAll Monkeys:");
    for (Monkey monkey : monkeyList) {
        System.out.println("Name: " + monkey.getName()
                + ", Species: " + monkey.getSpecies()
                + ", Gender: " + monkey.getGender()
                + ", Age: " + monkey.getAge()
                + ", Acquisition Date: " + monkey.getAcquisitionDate()
                + ", Acquisition Country: " + monkey.getAcquisitionLocation()
                + ", Training Status: " + monkey.getTrainingStatus()
                + ", Reserved: " + monkey.getReserved()
                + ", In-Service Country: " + monkey.getInServiceLocation());
    }
}

    public static void printDogs() {
        for (Dog dog : dogList) {
            System.out.println(dog.getName() + " - " + dog.getTrainingStatus() + ", " + dog.getAcquisitionLocation() + ", Reserved: " + dog.getReserved());
        }
    }

    public static void printMonkeys() {
        for (Monkey monkey : monkeyList) {
            System.out.println(monkey.getName() + " - " + monkey.getTrainingStatus() + ", " + monkey.getAcquisitionLocation() + ", Reserved: " + monkey.getReserved());
        }
    }

    public static void printAvailableAnimals() {
        System.out.println("Available Dogs:");
        for (Dog dog : dogList) {
            if (dog.getTrainingStatus().equalsIgnoreCase("in service") && !dog.getReserved()) {
                System.out.println(dog.getName());
            }
        }

        System.out.println("Available Monkeys:");
        for (Monkey monkey : monkeyList) {
            if (monkey.getTrainingStatus().equalsIgnoreCase("in service") && !monkey.getReserved()) {
                System.out.println(monkey.getName());
            }
        }
    }
}
