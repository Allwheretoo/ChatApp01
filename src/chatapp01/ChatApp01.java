
package chatapp01;
import java.util.Scanner;

public class ChatApp01 {

   String Username;
   String Password;
   String cellphoneNumber;
   
   //Username validation
   //Username should contain an underscore
   //Username should mot be longer than five characters
   public boolean checkUsername(String Username) {
       return Username.length()>=5 && Username.contains("_");
   }
       //Password validation
       //Should contain at least eight characters 
       //Contain a capital letter
       //Should contain a number
       //Should contain a special character
  public boolean checkPasswordComplexity(String Password) {
           boolean passwordNumber = Password.matches(".*\\d.*");
           boolean passwordSpecial = Password.matches(".*[^a-zA-Z0-9].*");
           return Password.length() >=8 &&  passwordNumber && passwordSpecial;
       }

       //Cellphone number validation
       //Should contain an international country code
       //Number should be ten characters long
   public boolean checkCellphoneNumber(String cellphoneNumber) {
           return cellphoneNumber.startsWith("+27") && cellphoneNumber.length() ==12;
           
       }
       
       //Register user method
       //Ensures that the password meets the requirements
       //Ensures that the username meets the requirements
       //Ensures that the cellphone number is the correct length and that it has an international code
       public String registerUser(String Username, String Password, String cellphoneNumber) {
         if (!checkUsername(Username)) {
             return "The username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
         }
         
         if (!checkPasswordComplexity(Password)) {
             return "Password is not correctlu formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
         }
         
         if (!checkCellphoneNumber(cellphoneNumber)){
             return "The cellphone number is incorrectly formatted or does not contain international code; please correct the number and try again";
                     
             
         }
       this.Username = Username;
       this.Password = Password;
       this.cellphoneNumber = cellphoneNumber;
       
       return "The above conditions have been met, and the user has been registered succesfully.";
       }
       
       //Login Method
       public boolean loginUser(String Username,String Password) {
           return this.Username.equals(Username) && this.Password.equals(Password);
       }
      
       //Login Status Message
       public String returnLoginStatus(boolean Loginstatus) {
           if (Loginstatus) {
               return "A successful login! Welcome " + Username + ". It is great to see you!";
           } else {
               return "A failed login. Incorrect username or password.";
           }
       }
       
   

    

    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        ChatApp01 chatapp01 = new ChatApp01();
        
        //Registration
        System.out.println("Enter username: ");
        String Username = input.nextLine();
        
        System.out.println("Enter password: ");
        String Password = input.nextLine();
        
        System.out.println("Enter cellphone number: ");
        String cellphoneNumber = input.nextLine();
        
        String registrationMesaage = chatapp01.registerUser(Username, Password, cellphoneNumber);
        System.out.println(registrationMesaage);
        
        //Login
        System.out.println("\n--- Login ---");
        
        System.out.println("Enter username: ");
        String loginUsername = input.nextLine();
        
        System.out.println("Enter Password: ");
        String loginPassword = input.nextLine();
        
        boolean LoginStatus = chatapp01.loginUser(loginUsername, loginPassword);
        System.out.println(chatapp01.returnLoginStatus(LoginStatus));
    }
    
    
 }

