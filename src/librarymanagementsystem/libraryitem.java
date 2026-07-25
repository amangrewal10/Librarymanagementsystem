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
    
    public String validateTitle(){
        
    }
    public  int validateYear(){

    }
    public abstract void getItemType(){

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
