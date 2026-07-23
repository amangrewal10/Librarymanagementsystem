package librarymanagementsystem;

public interface reservable {

boolean reserveItem(String itemId, int timeSlot, String userID);
void checkReservationStatus(String itemId);
  
}
