import java.util.HashMap;
import java.util.Scanner;

public class InventorySystem {
	public static Scanner scanner = new Scanner(System.in);
	public static HashMap<String, Product> products = new HashMap<>();
	
	public static void main(String[] args) {
		menu();
    }
	
	private static void menu() {
		System.out.println("Press 1 to add an item.\n" + 
				   		   "Press 2 to delete an item.\n" +
				   		   "Press 3 to update an item.\n" + 
				   		   "Press 4 to show all the items.\n" +
				   		   "Press 5 to quit the program.");
		int choice = Integer.parseInt(scanner.nextLine());
		choiceProcessor(choice);
	}
	
	private static void choiceProcessor(int choice) {
    	switch (choice) {
        case 1:
            add();
            break;
            
        case 2:
            delete();
            break;
            
        case 3:
            update();
            break;
            
        case 4:
            show();
            break;
            
        case 5:
        	System.exit(0);
            break;
            
        default:
            System.out.println("Number is not 1, 2, 3, 4, or 5!");
            break;
    	}
    }
	
	private static void add() {
		System.out.println("Enter the name:");
		String nameInput = String.valueOf(scanner.nextLine());
		System.out.println("Enter the serial number:");
		String serialInput = String.valueOf(scanner.nextLine());
		System.out.println("Enter the value in dollars (whole number):");
		int valueInput = Integer.valueOf(scanner.nextLine());
		
		products.put(serialInput, new Product(nameInput, serialInput, valueInput));
		menu();
	}
	
	private static void delete() {
		System.out.println("Enter the serial number of the item to delete:");
		String serialInput = String.valueOf(scanner.nextLine());
        
		products.remove(serialInput, serialInput);
		menu();
	}
	
	private static void update() {
		System.out.println("Enter the serial number of the item to change:");
		String serialInput = String.valueOf(scanner.nextLine());
		System.out.println("Enter the new name:");
		String nameInput = String.valueOf(scanner.nextLine());
		System.out.println("Enter the new value in dollars (whole number):");
		int valueInput = Integer.valueOf(scanner.nextLine());
		
		products.put(serialInput, new Product(nameInput, serialInput, valueInput));
		menu();
	}
	
	private static void show() {
		for (String key: products.keySet()) {
		    String name = products.get(key).getName();
		    int value = products.get(key).getValue();
		    System.out.println(name + "," + key + "," + value);
		}
		menu();
	}
	
	public static class Product {
	    private String name;
	    private String serial;
	    private int value;
	    
	    public Product(String name, String serial, int value) {
	        this.name = name;
	        this.serial = serial;
	        this.value = value;
	    }
	    
	    public String getName() {
	        return name;
	    }
	    
	    public String getSerial() {
	        return serial;
	    }
	    
	    public int getValue() {
	        return value;
	    }
	}
}
