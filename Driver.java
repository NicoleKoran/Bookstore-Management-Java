// ------------------------------------------------------------
// Assignment #0
// Question: Part II
// Written by: Nicole Koran 40281430
// ------------------------------------------------------------

import java.util.Scanner;

public class Driver {
	// create static variable
	private static int failedAttempts = 0;
	private static Scanner scan = new Scanner(System.in);
	
	//Book book1 = new Book("hi", "nicole", 12234, 30.99);
	//inventory[0] = book1;
	
	public static void main(String[] args) {
		
		//static Book book1 = new Book("Hi", "Nicole Koran", 2384930, 30.99);
		
		final int password = 249;
		final int maxAttempts = 3;
		final int maxFailedAttempts = 12;
		boolean keepGoing = true;
		
		//display a welcome message
		System.out.println("Welcome!\n");
		
		System.out.print("Please enter the maximum number of books your bookstore can contain: ");
		int maxBooks = scan.nextInt();

        // Create an empty array called inventory
		Book[] inventory = new Book[maxBooks];
	
	while (keepGoing) {
	
	displayMenu();
	int choice = scan.nextInt();
	
	switch (choice) {
	case 1: 
	{
		 
			
			int attempts = 0;
			boolean doneAdding = true;
			while (attempts < maxAttempts && doneAdding == true)
				{
					System.out.println("Please enter your password: ");
					int userPassword = scan.nextInt();
						if (userPassword == password)
							{
							System.out.println("How many books would you like to enter? Number of books: ");
							 int addBooks = scan.nextInt();
							 
							 if ((Book.findNumberOfCreatedBooks() + addBooks) <= maxBooks) {
								for (int i = 0; i < addBooks; i++)
								{
									System.out.println("Please enter the title, author, ISBN, and price (in that order) of the book # " +i+ "you want to add. ");
									
									// Read book details from the user
							        String title = scan.next();
							        String author = scan.next();
							        long isbn = scan.nextLong();
							        double price = scan.nextDouble();
							        
							        // Create a new Book instance
							        Book newBook = new Book(title, author, isbn, price);

							        // Add the new book to the inventory array
							        inventory[Book.findNumberOfCreatedBooks() - 1] = newBook;
								}
								 
								 int numOfBooks =+ addBooks;
								 doneAdding = false;
							 }
							 else System.out.println("Sorry you can only have " + (maxBooks - Book.findNumberOfCreatedBooks()) + " remaining places.");
							 break;
							}
						
						else {
							attempts ++;
							failedAttempts++;
							}
				}
		
    if (failedAttemptsCounts() == maxFailedAttempts) {
            // Too many failed attempts, terminate the program
            System.out.println("Program detected suspicious activities and will terminate immediately!");
            System.exit(0); 
            
    }
            break;
   }
	
	case 2:	
	{
		int attempts = 0;
		while (attempts < maxAttempts)
			{
				System.out.println("Please enter your password: ");
				int userPassword = scan.nextInt();
					if (userPassword == password)
						{
						updateBookInfo(scan, inventory);
						
						break;
						}
					
					else {
						attempts ++;
						}
			}
	
	}

	case 3:{
		System.out.println("Please enter the author you wish to search by: ");
		String searchAuthor = scan.next();
	    
	    // Display books by the requested author
	    displayBooksByAuthor(inventory, searchAuthor);
	    break;
		}

	case 4:{
		System.out.println("Please enter the price in which you'd like to see all books under: ");
		double maxPrice = scan.nextDouble();
		for (int i = 0; i < inventory.length; i++) {
			if (inventory[i] != null && inventory[i].getPrice() <= maxPrice) {
				System.out.println(inventory[i].toString());
			}
		}
		break;
	}
	
	case 5:
		System.out.println("Thank you for using our system. Goodbye, have a nice day!");
		System.exit(0);
	}

	}

	}
	
	
	
	public static void displayMenu() {
			System.out.println("\nWhat do you want to do?\n"
			+ "1. Enter new books (password required)\n"
			+ "2. Change information of a book (password required)\n"
			+ "3. Display all books by a specific author\n"
			+ "4. Display all books under a certain a price.\n"
			+ "5. Quit\n"
			+ "Please enter your choice > ");
		}
	
	public static int failedAttemptsCounts() {
        return failedAttempts;
    }
	
	
	public static void updateBookInfo(Scanner scan, Book[] inventory) {
		System.out.println("Enter the book number you wish to update: ");
		int bookNumber = scan.nextInt();
		if (bookNumber <= Book.findNumberOfCreatedBooks())
			{
			changeInfo(scan, inventory, bookNumber);
			}
		else
		{
			System.out.println("This book does not exist. Enter 1 if you would like to re-enter another book or enter 2 if you'd like to return to the main menu. ");
			int option = scan.nextInt();
			if (option == 1) {
				updateBookInfo(scan, inventory);
			}
		}
	}
	
	
	public static void changeInfo(Scanner scan, Book[] inventory, int bookNumber) {
		System.out.println("Book # " + bookNumber);
		System.out.println(inventory[(bookNumber-1)].toString());
		System.out.println("\nWhat information would you like to\n"
				+ "change?\n"
				+ "1. author\n"
				+ "2. title\n"
				+ "3. ISBN\n"
				+ "4. price\n"
				+ "5. Quit\n"
				+ "Enter your choice >");
		int changeOption = scan.nextInt();
		switch (changeOption) {
			case 1:
				System.out.println("Enter the new author: ");
				String newAuthor = scan.next();
				inventory[bookNumber-1].setAuthor(newAuthor);
				System.out.println(inventory[(bookNumber-1)].toString());
				break;
			case 2:
				System.out.println("Enter the new title: ");
				String newTitle = scan.next();
	            inventory[bookNumber - 1].setTitle(newTitle);
	    		System.out.println(inventory[(bookNumber-1)].toString());
	            break;
			case 3:
	            System.out.println("Enter the new ISBN: ");
	            long newIsbn = scan.nextLong();
	            inventory[bookNumber - 1].setIsbn(newIsbn);
	    		System.out.println(inventory[(bookNumber-1)].toString());
	    		break;
	        case 4:
	            System.out.println("Enter the new price: ");
	            double newPrice = scan.nextDouble();
	            inventory[bookNumber - 1].setPrice(newPrice);
	    		System.out.println(inventory[(bookNumber-1)].toString());
	    		break;
	        case 5:
	            System.out.println("Quitting update.");
	            break;
	        default:
	        	changeInfo(scan, inventory, bookNumber);
	            break;
	
		}
		
	}
	
	
	public static void displayBooksByAuthor(Book[] inventory, String searchAuthor) {
		System.out.println("Books by author '" + searchAuthor + "':");
			for (int i = 0; i < inventory.length; i++) {
				if (inventory[i] != null && inventory[i].getAuthor().equalsIgnoreCase(searchAuthor)){
					System.out.println(inventory[i].toString());
				}
			}
	}
	
	
	
}
