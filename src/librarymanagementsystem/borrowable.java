package librarymanagementsystem;

public interface borrowable {
  //  public static final String userId = "";

   String processBorrowing(String userID);
   int calculateLateFee(int overdueDays);
    calculateBorrowingFee(int loadPerod);

}
