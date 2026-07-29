//Names: Christabel Giner
//Project 2
package librarymanagementsystem;
import java.util.*;
import java.io.*;
public class Testlibrary {
public static void main(String args[]){  
Book book = new Book();
Magazine magazine = new Magazine();
String password, username, getAccount=" ";
  
Scanner in = new Scanner(System.in);  
  
ArrayList<String> readingItem = new ArrayList<>();
ArrayList<String> userLog = new ArrayList<>();  
ArrayList<String> passwordLog = new ArrayList<>();

try{
File adminAccounts = new File("adminAccounts.txt");    
adminAccounts.createNewFile();
}
catch (IOException e){
System.out.println("Creating file Error");
  e.printStackTrace();
}
  

  try{ //writing the admin password(adminRead) and username(adminLibrary) 
FileWriter adminWrite = new FileWriter("adminAccounts.txt"); 	  
adminWrite.write("adminLibrary,adminRead");
adminWrite.close();  
}catch(IOException e ){
System.out.println("-Write error");
e.printStackTrace();  
}

//read password and username into the arraylists

try(Scanner read = new Scanner(adminAccounts)){
while(read.hasNextLine()){
getAccount = read.nextLine();
  
}
username = getAccount.substring(0,11);
password = getAccount.substring(13,21);
  
userLog.add(username);
passwordLog.add(password);  
  
}catch(FileNotFoundException e){
System.out.println("-Read error");
e.printStackTrace();  
}
                          
System.out.println("Enter admin username");
String adminUser = in.nextLine();

System.out.println("Enter admin password");
String adminPassword = in.nextLine();  

 if (adminUser == userLog.get(0) && adminPassword == passwordLog.get(0) ){

}else{
System.out.print("Username/Password not Authorized. End of Program");
  return;
}

}
}
