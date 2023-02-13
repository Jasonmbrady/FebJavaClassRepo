import java.util.ArrayList;

public class Member {
    private String firstName;
    private String lastName;
    private Integer memberNumber;
    private ArrayList<Book> booksCheckedOut;

    public Member(String firstName, String lastName, Integer memberNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.memberNumber = memberNumber;
        this.booksCheckedOut = new ArrayList<Book>();
    }
    public Member(){
        this.booksCheckedOut = new ArrayList<Book>();
    }; // default constructor

    public void checkOutBook(Book book){
        booksCheckedOut.add(book);
    }
    public void returnBook(Book book){
        booksCheckedOut.remove(book);
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public Integer getMemberNumber() {
        return memberNumber;
    }
    public void setMemberNumber(Integer memberNumber){
        this.memberNumber = memberNumber;
    }
    public ArrayList<Book> getBooksCheckedOut() {
        return booksCheckedOut;
    }
    public void setBooksCheckedOut(ArrayList<Book> booksCheckedOut){
        this.booksCheckedOut = booksCheckedOut;
    }
}
