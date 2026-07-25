package librarymanagementsystem;
import java.time.LocalDate;

public class book extends libraryitem implements borrowable {
    private Genre genre;
    private int borrowPeriod;
    private String ISBN;
    private int numberCopies;
    private int availableCopies
    private ArrayList<LocalDate> borrowingDates = new ArrayList<LocalDate>();
    private ArrayList<String> borrowedUserIDs = new ArrayList<String>();

public book(String userID,int overdueDays,int loanPeriod){
super(userID,overdueDays,loanPeriod);
    
}
    
public double calculateBorrowingFee(int loanperiod, double rateperday){
rateperday= 1.50;
    return loanperiod*rateperday;
}

public LocalDate processBorrowing (ArrayList<LocalDate> borrowingdates){

}

public int calculateLateFee(){

}

public int validateBorrowedDays(){

}
    
public String validateISBN(String ISBN){

}

public String getItemType(String Book){
return Book;
}

public Genre getGenre (){
return genre;
}

public void setGenre(Genre genre){
this.genre=genre;
}

public int getBorrowedPeriod(){
return borrowedPeriod;
}

public void setBorrowedPeriod(){
this.borrowedPeriod=borrowedPeriod;
}  

public String getISBN(){
return ISBN;
}

public void setISBN(){
this.ISBN=ISBN;
}   

public int getNumberCopies(){
return numberCopies;
}   

public void setNumberCopies(){
this.numberCopies=numberCopies;
}    

public int availableCopies() {

}
    
    
}
