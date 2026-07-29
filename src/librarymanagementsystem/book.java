package librarymanagementsystem;

import java.time.LocalDate;
import java.util.ArrayList;

public class book extends libraryitem implements borrowable {
    private Genre genre;
    private int borrowedPeriod;
    private String ISBN;
    private int numberCopies;
    private int availableCopies;
    private ArrayList<LocalDate> borrowingDates = new ArrayList<LocalDate>();
  
    private ArrayList<String> borrowedUserIDs = new ArrayList<String>();
    private String userID;
    private int overdueDays;
    private int loanPeriod;

 LocalDate lt = LocalDate.now();   
 public book(long id, String title, String author, int yearPublished,
         String userID, int overdueDays, int loanPeriod){
 super(id, title, author, yearPublished);
 this.userID = userID;
 this.overdueDays = overdueDays;
 this.loanPeriod = loanPeriod;
}
    
 public int calculateBorrowingFee(int loadPerod){
     double rateperday = 1.50;
     return (int) (loadPerod * rateperday);
 }

 public String processBorrowing(String userID){
     this.userID = userID;
     return "Borrowed by " + userID;
 }

public int calculateLateFee(int overdueDays){
return overdueDays*2;
}

public int validateBorrowedDays(){
    return 0; 
}
    
public String validateISBN(String ISBN){
    return ISBN; 
}

public String getItemType(){
    return "Book";
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

public void setBorrowedPeriod(int borrowedPeriod){
this.borrowedPeriod = borrowedPeriod;
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
