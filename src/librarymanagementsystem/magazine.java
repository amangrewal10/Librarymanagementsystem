package librarymanagementsystem;
import java.util.*;

public class magazine extends libraryitem implements reservable {
    private int issueNumber;
    private boolean monthlyEdition;
    private ArrayList<Integer> reservedSlots = new ArrayList<>();
    private ArrayList<String> reservedUserIDs = new ArrayList<>();

    public magazine(long id, String title, String author, int yearPublished) {
        super(id, title, author, yearPublished);

    }

    public boolean validateTimeSlot(int timeSlot) {
        if (timeSlot < 11 || timeSlot > 15) {
            throw new IllegalArgumentException("Invalid time slot");
        }
        return true;
    }

    public boolean reserveItem(String itemId, int timeSlot, String userID) {
        try {
            validateTimeSlot(timeSlot);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }

        if (reservedSlots.contains(timeSlot)) {
            return false;
        }

        reservedSlots.add(timeSlot);
        reservedUserIDs.add(userID);
        return true;
    }

    public void checkReservationStatus(String itemId) {
        System.out.println("Reservation schedule for \"" + getTitle() + "\" (ID: " + getId() + "):");
        for (int slot = 11; slot <= 15; slot++) {
            int index = reservedSlots.indexOf(slot);
            if (index != -1) {
                System.out.println(slot + ":00 - Booked by " + reservedUserIDs.get(index));
            } else {
                System.out.println(slot + ":00 - Free");
            }
        }
    }

    public String getItemType() {
        return "Magazine";
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public ArrayList<Integer> getReservedSlots() {
        return reservedSlots;
    }

    public boolean getMonthlyEdition() {
        return monthlyEdition;
    }

    public void setMonthlyEdition(boolean monthlyEdition) {
        this.monthlyEdition = monthlyEdition;
    }

    @Override
    public String toString() {
        return super.toString() + ", Issue #: " + issueNumber + ", Monthly Edition: " + monthlyEdition;
    }

}

