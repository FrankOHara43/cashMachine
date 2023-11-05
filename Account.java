import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Account{

  private int customerNumber;
  private int pinNumber;
  private double checkingBalance = 0;
  private double savingBalance = 0;
  
  Scanner input = new Scanner(System.in);
  DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

  public Account(){
  }
    public Account(int customerNumber, int pinNumber){
      this.customerNumber = customerNumber;
      this.pinNumber = pinNumber;
    }
    public Account(int customerNumber, int pinNumber, double checkingBalance, double savingBalance){
      this.customerNumber = customerNumber;
      this.pinNumber = pinNumber;
      this.checkingBalance = checkingBalance;
      this.savingBalance = savingBalance;
    
    }
    public int setCustomerNumber(int customerNumber){
      this.customerNumber = customerNumber;
      return customerNumber;
    }
    public int getCustomerNumber(){
      return customerNumber;
  }
  public int setPinNumber(int pinNumber){
    this.pinNumber = pinNumber;
    return pinNumber;
  }
  public int getPinNumber(){
    return pinNumber;
  }
  public double getCheckingBalance(){
    return checkingBalance;
  }
  public double getSavingBalance(){
    return savingBalance;
  }
  public double calcCheckingWithdraw(double amount){
    checkingBalance = (checkingBalance - amount);
    return checkingBalance;
  }
  public double calcSavingWithdraw(double amount){
    savingBalance = (savingBalance - amount);
    return savingBalance;
  }
  public double calcCheckingDeposit(double amount){
    if(amount > 0){
      checkingBalance = (checkingBalance + amount);
    }
    else{
      System.out.println("Invalid deposit amount.");
    }
    return checkingBalance;
  }
  public double calcSavingDeposit(double amount){
    if(amount > 0){
      savingBalance = (savingBalance + amount);
    }
    else{
      System.out.println("Invalid deposit amount.");
    }
    return savingBalance;
  }
  public void calcCheckTransfer(double amount){
    checkingBalance = (checkingBalance - amount);
    savingBalance = (savingBalance + amount);
  }
  public void calcSavingTransfer(double amount){
    savingBalance = savingBalance - amount;
    checkingBalance = checkingBalance + amount;
  }
  public void getCheckingWithdrawInput(){
    boolean end = false;
    while(!end){
      try{
        System.out.println("\nCurrent checkings Account Balance: "+ moneyFormat.format(checkingBalance));
        System.out.println("\nAmount you want to withdraw from checkings Account: ");
        double amount = input.nextDouble();
        if((savingBalance - amount) >= 0 && amount >= 0){
          calcCheckingWithdraw(amount);
          System.out.println("\nCurrent Checkings Account Balance: "+ moneyFormat.format(checkingBalance));
          end = true;
        }else{
          System.out.println("\nInvalid withdraw amount.");
        }
      }catch(InputMismatchException e){
        System.out.println("\nInvalid withdraw amount.");
        input.next();
      }
    }
  }
    public void getsavingWithdrawInput(){
      boolean end = false;
      while(!end){
        try{
          System.out.println("Current Savings Account Balance: "+ moneyFormat.format(savingBalance));
            System.out.println("\nAmount you want to withdraw from savings Account: ");
          double amount = input.nextDouble();
          if((savingBalance - amount) >= 0 && amount >= 0){
            calcSavingWithdraw(amount);
            System.out.println("\nCurrent Savings Account Balance: "+ moneyFormat.format(savingBalance));
            end = true;
          
          }else{
            System.out.println("\nInvalid withdraw amount.");
          }
          
      }catch(InputMismatchException e){
          System.out.println("\nInvalid withdraw amount.");
          input.next();
        }
      }
    }
  public void getCheckingDepositInput(){
    boolean end = false;
    while(!end){
      try{
        System.out.println("\nCurrent Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("\nAmount you want to deposit from checkings Account: ");
        double amount = input.nextDouble();
        if((checkingBalance + amount) >= 0 && amount >= 0){
          calcCheckingDeposit(amount);
          System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(checkingBalance));
          end = true;
        }else{
          System.out.println("\nInvalid value");
        }
      }catch(InputMismatchException e){
        System.out.println("\nInvalid value");
        input.next();
      }
    }
  }
  public void getSavingDepositInput(){
    boolean end = false;
    while(!end){
      try{
        System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
        System.out.println("\nAmount you want to deposit in your Savings Account: ");
        double amount = input.nextDouble();
        if((savingBalance + amount) >= 0 && amount >= 0){
          calcSavingDeposit(amount);
          System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
          end = true;
        }else{
          System.out.println("\nInvalid input.");
        }
      }catch(InputMismatchException e){
        System.out.println("\nInvalid Choice.");
        input.next();
      }
    }
  }
  public void getTransferInput(String accType){
    boolean end = false;
    while(!end){
      try{
        if(accType.equals("checkings")){
          System.out.println("\nSelect an account you wish to transfer funds to:");
          System.out.println("1. Savings");
          System.out.println("2. exit");
           System.out.println("\nchoice: ");
          int choice = input.nextInt();
          switch(choice){
            case 1:
              System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(checkingBalance));
              System.out.println("\nAmount you want to deposit into your Savings Account: ");
              double amount = input.nextDouble();
              if((savingBalance + amount) >= 0 && (checkingBalance - amount) >= 0 && amount >= 0){
                calcCheckTransfer(amount);
                System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(checkingBalance));
                System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
                end = true;
              
              }else{
                System.out.println("\nInvalid choice.");
              }
              break;
            case 2:
              return;
            
            default:
              System.out.println("\nInvalid Choice.");
              break;
          }
        }else if(accType.equals("Savings")){
          System.out.println("\nSelect an account you wish to transfer funds to:");
          System.out.println("1. Checkings");
          System.out.println("2. exit");
          System.out.println("\nchoice: ");
          int choice = input.nextInt();
          switch(choice){
              case 1:
              System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
              System.out.println("\nAmount you want to deposit into your savings Account: ");
              double amount = input.nextDouble();
              if((checkingBalance + amount) >= 0 && (savingBalance - amount) >= 0 && amount >= 0){
                calcSavingTransfer(amount);
                System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(checkingBalance));
                System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(savingBalance));
                end = true;
              
        }else{
                System.out.println("\nInvalid choice.");
              }
              break;
              case 2:
              return;
            default: 
              System.out.println("\nInvalid Choice.");
              return;
          }
        }
          
      }catch(InputMismatchException e){
        System.out.println("\nInvalid Choice.");
        input.next();
      }
    }
  }
}
