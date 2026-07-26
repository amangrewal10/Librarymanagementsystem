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

 LocalDate lt = LocalDate.now();   
public book(String userID,int overdueDays,int loanPeriod){
super(userID,overdueDays,loanPeriod);
    
}
    
public double calculateBorrowingFee(int loanperiod, double rateperday){
rateperday= 1.50;
    return loanperiod*rateperday;
}

public LocalDate processBorrowing (ArrayList<LocalDate> borrowingdates){

}

public int calculateLateFee(int overdueDays){
return overdueDays*2;
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

public void setBorrowedPeriod(int BorrowedPeriod){
this.borrowedPeriod=borrowedPeriod;
}  

public String getISBN(){
return ISBN;
}

public void setISBN(String ISBN){
this.ISBN=ISBN;
}   

public int getNumberCopies(){
return numberCopies;
}   

public void setNumberCopies(int numberCopies){
this.numberCopies=numberCopies;
}    
    
public int getAvailableCopies() {
return availableCopies;
}

    
}
