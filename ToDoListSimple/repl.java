import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.jws.soap.SOAPBinding;
import javax.xml.crypto.Data;

public class repl {
    private static boolean isRunning;
    private static ToDoStorage storage;
    public repl(){
        
    }

    public void Start(){
        isRunning = true;
        PrintOptions(false);
        storage = new ToDoStorage();
        Functions();

    }

    public void Finish(){
        isRunning = false;
    }

    private void Functions(){
        
        while(isRunning == true){
            String readToLower = ReadLine().toLowerCase();
            switch(readToLower){
                case "add":
                add();
                break;
                case "remove":
                remove();
                break;
                case "search":
                search();
                break;
                case "print all":
                printAll();
                break;
                case "printall":
                printAll();
                break;
                case "quit":
                Finish();
                break;
                default:
                System.out.println("The input provided does not match any commands");
                PrintOptions(true);

            }
        }
    }

    private String ReadLine(){
        return input(">>>");
    }

    private void PrintOptions(boolean recall){
        if(!recall){
        System.out.println("The interface is wating for a command \n " + 
        "Some examples of commands are: Add, Remove, Print All, Search, Quit");
        }
        else{
            System.out.println("Some examples of commands are: Add, Remove, Print All, Search, Quit");
        }
    }

    private String input(String prompt){
        Scanner scan  = new Scanner(System.in);
        System.out.print(prompt + ": ");
        String ans = scan.nextLine();
        return ans;
        

    }

    private void printAll(){
        storage.printAll();

    }

    private void search(){
      
        

    }

    private void remove(){
        String ident = input("What is the title of the item you want to remove?(Use print all if you dont know)");
        storage.Remove(ident); 

    }

    private void add(){
        String title = input("What is the title of the item you want to add?");
        String desc = input("What is the description of the item you want to add?");
        Date expr = parseDate(input("What date will your item expire? (Format in yyyy-mm-dd || ex: 2023-10-6)"));
        if(expr != null){storage.add(new ToDoItem(title, desc, expr));}
        

    }

    private Date parseDate(String inputDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = dateFormat.parse(inputDate);
            return date;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Invalid date format: " + inputDate);
            e.printStackTrace();
            return null;
        }
    }

}
