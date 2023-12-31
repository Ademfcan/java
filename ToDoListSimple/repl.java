
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class repl {
    private static boolean isRunning;
    private static ToDoStorage storage;

    public repl() {

    }

    public void Start() {
        isRunning = true;
        PrintOptions(false);
        storage = new ToDoStorage();
        Functions();

    }

    public void Finish() {
        isRunning = false;
        storage.FinalizeItems();
    }

    private void Functions() {

        while (isRunning == true) {
            String readToLower[] = ReadLine().toLowerCase().split(" ");
            switch (readToLower[0]) {
                case "add":
                    add();
                    break;
                case "delete":
                case "remove":
                    remove(readToLower);
                    break;
                case "mkcomplete":
                case "markcomplete":
                case "updatecomplete":
                    MkComplete(readToLower);
                    break;
                
                case "search":
                    search(readToLower);
                    break;
                case "printall":
                case "print":
                    printAll();
                    break;
                case "sort":
                case "order":
                    sort(readToLower);
                    break;
                case "update":
                    Update(readToLower);
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

    private String ReadLine() {
        return input(">>>");
    }

    private void PrintOptions(boolean recall) {
        if (!recall) {
            System.out.println("The interface is wating for a command \n " +
                    "Some examples of commands are: Add, Remove, PrintAll, Search, Quit");
        } else {
            System.out.println("Some commands are: Add, Remove, Print All, Search, Quit, //Sort, Update, MkComplete(Use help for more info)");
        }
    }

    private String input(String prompt) {
        Scanner scan = new Scanner(System.in);
        System.out.print(prompt + ": ");
        String ans = scan.nextLine();
        return ans;


    }
    private void sort(String[] input){
        String sortMethod = "date";
        String howSorted = input("Sorted by date, title(alphabeticaly)?");
        if(howSorted.toLowerCase().equals("date")){
            sortMethod = "date";
        }
        else if(howSorted.toLowerCase().equals("title")){
            sortMethod = "title";
        }
        if(input.length<2){
            
            storage.printAll(storage.returnSorted(sortMethod), true);
        }
        else{
            storage.printAll(storage.returnSorted(input[1]), true);
        }
        
    }

    private void help(){
       String helpString = "Available commands and their descriptions:\n" +
        "add - Add a new item to the ToDoList.\n" +
        "delete/remove - Delete an item from the ToDoList.\n" +
        "mkcomplete, markcomplete, or updatecomplete - Mark an item as complete or update its completion status.\n" +
        "search - Search for specific items in the ToDoList.\n" +
        "printall or print - display all items in the ToDoList.\n" +
        "sort or order - Sort the items in the ToDoList based on certain criteria.\n" +
        "update - Update an existing item in the ToDoList.\n" +
        "quit - exit the ToDoList application.\n";
        System.out.println(helpString);
    }

    private void printAll() {
        storage.printAll(null,false);

    }

    private void Update(String[] input){
        String ident;
        if (input.length == 1) {
            ident = input("What is the title of the item you want to update?(Use print all if you dont know)");
        } else {
            ident = input[1];
            
        }
        String title = input("What is the new title?");
        String desc = input("What is the new description?");
        Date expr = parseDate(input("What is the new date(Format in yyyy-mm-dd || ex: 2023-10-6)"));
        String[] customCall = {"remove", ident};
        remove(customCall);
        storage.add(new ToDoItem(title, desc, expr, 0>=expr.compareTo(new Date())));

    }

    private void MkComplete(String[] input){
        String[] ident = new String[input.length-1];
        if (input.length == 1) {
            ident[0] = input("What is the tile of the item you want to mark as complete");

        } 
        else {
            for (int i = 1; i <= ident.length; i++) {
                ident[i-1] = input[i];
            }
        }
        ArrayList<String> nonItems = new ArrayList<String>();
        for (String s : ident) {
            ToDoItem u = storage.findItem(s);
            if (u != null) {
                u.updateComplete(true);
            } else {
                if(ident.length == 1){
                    System.out.println("The item with the title " + s + " dosent exist");
                }
                else{
                    nonItems.add(s);
                }
            }
        }
        if(nonItems.size() > 0){
            System.out.println("The items " + nonItems.toString()  + " dont exist" );
        }
    }

    

    private void search(String[] input) {
        String[] ident = new String[input.length-1];
        if (input.length == 1) {
            ident[0] = input("What is the tile of the item you want to find");

        } 
        else {
            for (int i = 1; i <= ident.length; i++) {
                ident[i-1] = input[i];
            }
        }
        ArrayList<String> nonItems = new ArrayList<String>();
        for (String s : ident) {
            if (storage.findItem(s) != null) {
                System.out.println(storage.findItem(s).ToString());
            } else {
                if(ident.length == 1){
                    System.out.println("The item with the title " + s + " dosent exist");
                }
                else{
                    nonItems.add(s);
                }
            }
        }
        if(nonItems.size() > 0){
            System.out.println("The items " + nonItems.toString()  + " dont exist" );
        }

    }

    private void remove(String[] input) {
        if (input.length == 1) {
            String ident = input("What is the title of the item you want to remove?(Use print all if you dont know)(* removes all)");
            storage.Remove(ident);
        } 
        else {
            for (int i = 1; i < input.length; i++) {
                if(input[i].equals("*")){
                    storage.removeAll();
                    i = input.length +1;
                }
                else{
                    storage.Remove(input[i]);
                }
            }
        }

    }

    private void add() {
        String title = input("What is the title of the item you want to add?");
        String desc = input("What is the description of the item you want to add?");
        Date expr = parseDate(input("What date will your item expire? (Format in yyyy-mm-dd || ex: 2023-10-6)"));
        if (expr != null) {
            storage.add(new ToDoItem(title, desc, expr, 0>=expr.compareTo(new Date())));
        }

    }

    public static Date parseDate(String inputDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = dateFormat.parse(inputDate);
            return date;
        } catch (Exception e) {
            
            System.out.println("Invalid date format: " + inputDate);
            // e.printStackTrace();
            return null;
        }
    }

}
