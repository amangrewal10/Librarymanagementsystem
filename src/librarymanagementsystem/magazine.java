package librarymanagementsystem;

public class magazine extends libraryitem implements reservable{
private int issueNumber;
private boolean monthlyEdition;
private ArrayList<Integer> reservedSlots = new ArrayList<>();
private ArrayList<String> reservedUserIDs = new ArrayList<>();  

public magazine(long id, String title, String author, int yearPublished){
super(id,title, author, yearPublished);

}
  
public boolean validateTimeSlot(int timeSlot){

}

public void reserveItem(String itemId, int timeSlot, String userID){

}

public void checkReservationStatus(String itemId){

}

public String getItemType(String Magazine)
  return Magazine;

}

public int getIssueNumber(){
return issueNumber;
}

public void setIssueNumber(int issueNumber){
this.issueNumber=issueNumber;
  }

public boolean getMonthlyEdition(){
  return monthlyEdition;
}

public void setMonthlyEdition(boolean monthlyEdition){
this.monthlyEdition=monthlyEdition;
  }



}
