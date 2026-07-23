package librarymanagementsystem;
import java.time.LocalDate;

public class book extends libraryitem implements borrowable {
    private Genre genre;
    private int borrowperiod;
    private String ISBN;
    private int numbercopies;
    private ArrayList<LocalDate> borrowingdates = new ArrayList<LocalDate>();
    private ArrayList<String> borroweduserIDs = new ArrayList<String>();
    
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
    
}
