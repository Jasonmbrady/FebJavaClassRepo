public class LibraryTest {
    public static void main(String[] args){
        // Where the magic happens
        // Book myBook = new Book();
        Book theHobbit = new Book("The Hobbit", "J.R.R Tolkien", "Fantasy", 295);
        Book theLordOfTheRings = new Book("Fellowship of the Ring", "J.R.R Tolkien", "Fantasy", 421);
        Book theSilmarillion = new Book("The Silmarillion", "J.R.R Tolkien", "Fantasy", 700);

        Member jason = new Member("Jason", "Brady", 
        1);

        jason.checkOutBook(theSilmarillion);
        jason.checkOutBook(theSilmarillion);
        System.out.println(jason.getBooksCheckedOut());
        jason.returnBook(theSilmarillion);
        System.out.println(jason.getBooksCheckedOut());
        }
}