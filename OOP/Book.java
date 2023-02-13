public class Book {
    private String title;
    private String author;
    private String genre;
    private Integer numberOfPages;

    public Book(){};
    public Book(String title, String author, String genre, Integer numberOfPages){
        this.title=title;
        this.author=author;
        this.genre=genre;
        this.numberOfPages=numberOfPages;
    };

    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return this.author;
    }
    public String getGenre(){
        return this.genre;
    }
    public Integer getNumberOfPages(){
        return this.numberOfPages;
    }
}
