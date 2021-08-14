package classscheduler;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    //setup
    Scanner scan = new Scanner(System.in);
    String chosenName = "empty";
    String teacherName = "none";
    int chosenBlock = 0;
    int numberOfClasses = 0;
    int id = -1;
    Class blank = new Class(chosenName, teacherName, chosenBlock, id);
    id++;
      


    //number of classes
    System.out.println("How many classes would you like to add?");
    int checkNumClasses = scan.nextInt();
    scan.nextLine();
    if(checkNumClasses <= 0) {
      System.out.println("Number of classes must be positive. Setting to 8.");
      numberOfClasses = 8;
    } else if(checkNumClasses > 15) {
      System.out.println("Maximum number of classes is 15. Setting to 8.");
      numberOfClasses = 8;
    } else {
      numberOfClasses = checkNumClasses;
    }
    Database.setNumClasses(numberOfClasses);
   


    //adding classes
    for(int i = 0; i < numberOfClasses; i++) {
      System.out.print("Block: ");
        int checkBlock = scan.nextInt();
        scan.nextLine();
        if(checkBlock > 0 && checkBlock < 5) {
          chosenBlock = checkBlock;
        } else {
          System.out.println("Block is from 1 to 4!");
          i--;
          continue;
        }
      System.out.print("Class Name: ");
      chosenName = scan.nextLine();

      System.out.print("Teacher: ");
      teacherName = scan.nextLine();
      System.out.print("\n");
     

      listOfClasses.addToList(i, new Class(chosenName, teacherName, chosenBlock, id));
      System.out.println("Class added.");
    }



    //tasks
    Schedule list = new Schedule(blank);
    int addID = 0;
    int dropBlock = 0;
    final int n = 0;
    while(n == 0) {
      System.out.println("Choose one: add, drop, viewSchedule, viewAvailable");
      String chosenTask = scan.nextLine();
      
      if(chosenTask.equals("add")) {
        System.out.println("Choose a class ID");
        addID = scan.nextInt();
        scan.nextLine();
        if(addID < 0 || addID >= numberOfClasses) {
          System.out.println("Please enter the ID of a class.");
        } else {
          list.add(addID, blank);
        }
      
      } else if(chosenTask.equals("drop")) {
        System.out.println("Choose a block");
        dropBlock = scan.nextInt();
        scan.nextLine();
        if(dropBlock > 4 || dropBlock < 0) {
          System.out.println("Please enter a valid block.");
        } else {
          int dropBlockInArray = dropBlock - 1;
          list.drop(dropBlockInArray, blank);
        }

      } else if(chosenTask.equals("viewSchedule")) {
        list.view();

      } else if(chosenTask.equals("viewAvailable")) {
        list.viewAvailable(blank);

      } else {
        System.out.println("You know what choose means right? Type one of the options.");
      }
    }

  }
}