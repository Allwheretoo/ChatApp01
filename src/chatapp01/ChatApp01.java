
package chatapp01;
import java.util.Scanner;

public class ChatApp01 {

   String Username;
   String Password;
   String cellphoneNumber;
   
   //Username validation
   public boolean checkUsername(String Username) {
       return Username.length()>=5 && Username.contains("_");
   }
       //Password validation
  public boolean checkPasswordComplexity(String Password) {
           boolean passwordNumber = Password.matches(".*\\d.*");
           boolean passwordSpecial = Password.matches(".*[^a-zA-Z0-9].*");
           return Password.length() >=8 &&  passwordNumber && passwordSpecial;
       }

       //Cellphone number validation
   public boolean checkCellphoneNumber(String cellphoneNumber) {
           return cellphoneNumber.startsWith("+27") && cellphoneNumber.length() ==12;
           
       }
       
       //Register user method
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

