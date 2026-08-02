package librarymanagementsystem;

public interface borrowable {

   String processBorrowing(String userID);
   int calculateLateFee(int overdueDays);
   int calculateBorrowingFee(int loadPerod);

}
