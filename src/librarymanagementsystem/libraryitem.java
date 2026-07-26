package librarymanagementsystem;
import java.time.LocalTime;

abstract class libraryitem {
    private long id;
    private String title;
    private String author;
    private int yearPublished;
    
    public libraryItem(long id,String title,String author,int yearPublished){
        super();
        setID(id);
        setTitle(title);
        setAuthor(author);
        setYearPublished(yearPublished);
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
    int year = timeNow.getYear();
  if (year <= yearPublished){
return year;
  }else{
year=yearPublished;
return year;      
  }
    }
    
    public abstract void getItemType(String itemId){
return itemId;
    }
    
    public String getId(){
return id;
    }
    public void setID(long id){
this.id=id;
    }
    public String getTtile(){
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
    public String getYearpublished(){
return yearPublished
    }
    public void setYearpublished(int yearPublished){
this.yearPublished=yearPublished;
    }
        

}
