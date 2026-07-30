package librarymanagementsystem;
import java.util.*;

public class magazine extends libraryitem implements reservable{
private int issueNumber;
private boolean monthlyEdition;
private ArrayList<Integer> reservedSlots = new ArrayList<>();
private ArrayList<String> reservedUserIDs = new ArrayList<>();  

public magazine(long id, String title, String author, int yearPublished){
super(id,title, author, yearPublished);

}
  //
public boolean validateTimeSlot(int timeSlot){
	  try{
		    if(timeSlot > 11 && timeSlot <=15){
		      return true;
		    }
		    else {
		    	return false;
		    }

		  }catch(Exception e){		 
		    throw e;
		  }
   
}

public void reserveItem(String itemId, int timeSlot, String userID){
  Scanner in = new Scanner(System.in);
  System.out.println("Reserve a time slot for a magazine.");
  for(int i = 0; i >= 4;i++{
System.out.println(timeSlot+":00");
  }
   timeSlot = in.nextInt();
   reservedSlots.add(timeSlot);
  
  System.out.println(Enter UserID);
  userID=in.nextLine();
 reservedUserIDs.add(userID); 
  
}

public void checkReservationStatus(String itemId){
for(int time = 0; time <= 4;time++) {
System.out.println(reservedSlots.get(time));		
}
}

public String getItemType(){
    return "Magazine";
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
