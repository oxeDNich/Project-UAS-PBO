package Project;
import java.util.Scanner;

public class main {
    
    static Scanner scan = new Scanner(System.in);
    

    public static void main (String[] args){
        
        String isContinue= "y";

    while (isContinue.equals("y")) {
        showMenu();
        int selectedMenu = chooseMenu();
          try {
            if (selectedMenu == 1) {
              
            } else if (selectedMenu == 2) {
              
            } else if (selectedMenu == 3) {
              
            } else if (selectedMenu == 4) {
             
            } else if (selectedMenu == 5) {
                
            } else if (selectedMenu == 6){
            
            } else {
              throw new IllegalArgumentException("wrong input");
            }
        } catch (Exception e){
          System.out.println("Error "+ e.getMessage());
        }
        System.out.print("continue ? ");
        isContinue = scan.next();
        }
    }

    public static void showMenu(){
        
    }

    //untuk inputan pilihan Menu (While diatas)
  public static int chooseMenu() {
    System.out.print("choose menu : ");
    int pilihan = scan.nextInt();
    return pilihan;
  }



    
}


