package librarymanagementsystem;
import java.time.LocalDate;

public abstract class libraryitem {
    private long id;
    private String title;
    private String author;
    private int yearPublished;
    
    public libraryitem(long id, String title, String author, int yearPublished) {

        this.id = id;
        this.title = validateTitle(title);
        this.author = author;
        this.yearPublished = validateYear(yearPublished);

    }
    
    public String validateTitle(String title){
        if (title.length() > 5 && title.length() < 100){
        return "Valid";
        }else{
        return "Untitled";  
        }
    }
    
    public int validateYear(int year){
        LocalDate timeNow = LocalDate.now();
        int currentYear = timeNow.getYear();
        if (currentYear <= yearPublished) {  
            return year;
        } else {
            year = yearPublished;
            return year;
        }
    }
    
    public abstract String getItemType();
    
      @Override
     public String toString() {
    return id+": "+title+", "+author+", "+yearPublished;
    }
    
    public long getId(){
return id;
    }
    public void setID(long id){
this.id=id;
    }
    public String getTitle(){
return title;
    }
    public void setTtile(String title){
this.title=title;
    }
    public String getAuthor(){
return author;
    }
    public void setAuthor(String author){
this.author=author;
    }
    public int getYearpublished(){
return yearPublished;
    }
    public void setYearpublished(int yearPublished){
this.yearPublished=yearPublished;
    }
        

}
