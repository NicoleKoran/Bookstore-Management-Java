// ------------------------------------------------------------
// Assignment #0
// Question: Part I
// Written by: Nicole Koran 40281430
// ------------------------------------------------------------


public class Book {

	// declare four attributes
	private String title;
	private String author;
	private long isbn;
	private double price;
	private static int numOfBooks = 0;
	
	//constructor
	public Book(String title, String author, long isbn, double price) {
		
		//initialize attributes
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		
		numOfBooks ++;
	}
	
	 // Copy constructor
	public Book(Book other) {
		this(other.title, other.author, other.isbn, other.price);
	}
	
	//Accessor methods
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public long getIsbn() {
		return isbn;
	}
	
	public double getPrice() {
		return price;
	}
	
	//mutator methods
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	// method that returns number of books created
	public static int findNumberOfCreatedBooks() {
		return numOfBooks;
	}
	
	//check if two book are the same. they are the same if they have the same isbn and price
	public boolean equals(Object obj) {
	    // Check if the reference is the same
	    if (this == obj) {
	        return true;
	    }

	    // Cast the object to a Book
	    Book other = (Book) obj;

	    // Compare attributes for equality
	    return this.isbn == other.isbn && this.price == other.price;
	}
	
	//check if two book have the same author
		public boolean equalsAuthor(Object obj) {
		    // Check if the reference is the same
		    if (this == obj) {
		        return true;
		    }

		    // Cast the object to a Book
		    Book other = (Book) obj;

		    // Compare attributes for equality
		    return this.author == other.author;
		}
	
	//method that displays all the information of the book
	public String toString() {
		return "\nTitle: " +title+ "\nAuthor: " +author+ "\nISBN: " +isbn+ "\nPrice: " +price;
	}
	
	
	
}
