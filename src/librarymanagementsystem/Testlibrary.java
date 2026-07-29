package librarymanagementsystem;
import java.util.*;
import java.io.*;
public class Testlibrary {

Scanner in = new Scanner(System.in);  
ArrayList<String> readingItem = new ArrayList<>();

File adminAccounts = new File(adminAccounts.txt);    

  try{
adminAccounts.write("adminLibrary,adminRead");
adminAccounts.close();  
}catch(IOException e ){
System.out.println("Write error");
e.printStackTrace();  
}
  
System.out.println("Enter admin username);
String adminUser = in.nextLine():

System.out.println("Enter admin password);
String adminPassword = in.nextLine():  

  
}
