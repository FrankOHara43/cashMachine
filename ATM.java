import java.io.IOException;

public class ATM {
  
  public static void main(String[] args) throws IOException{
    OptionMenu optionMenu1 = new OptionMenu();
    introduction();
    optionMenu1.mainMenu();
  }
  
  public static void introduction(){
    System.out.println("Welcome to my ATM project");
  }
}

