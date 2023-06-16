

import java.util.Collections;
import java.util.LinkedList;


public class ToDoStorage{
    LinkedList<ToDoItem> items;
    CsvReaderWriter readerWriter;
    public ToDoStorage() {
        
        readerWriter = new CsvReaderWriter();
        items = readerWriter.readFromFile();
    }

    public void add(ToDoItem item) {
        items.add(0, item);
        System.out.println("The item "+ item.getTitle() + " has been added");
    }

    public void Remove(String identifier){
        if(findItem(identifier) != null){
            items.remove(findItemId(identifier));
            System.out.println("Item " + identifier + " has been removed");
        }
        else{
            System.out.println("The item you want to remove does not exist");
        }
    }

    public ToDoItem findItem(String Ident) {
        ToDoItem item;
        for (int i = 0; i < items.size(); i++) {
            item = items.get(i);
            if (item.getTitle().equals(Ident) || item.getDescr().equals(Ident)) {
                return item;

            }

        }
        return null;
    }

     public int findItemId(String Ident) {
        ToDoItem item;
        for (int i = 0; i < items.size(); i++) {
            item = items.get(i);
            if (item.getTitle().equals(Ident) || item.getDescr().equals(Ident)) {
                return i;

            }

        }
        return (Integer) null;
    }

    public void printAll(LinkedList<ToDoItem> items1, boolean Y){
        if(!Y){
            items1 = items;
        }
        int b = 1;
        if(items.size() > 0){
        for(ToDoItem i : items1){
            
            System.out.println("\u001B[1mTodo Item #:" + b + ":\u001B[0m");
            System.out.println(i.ToString());
            b+=1;
        }
        }
        else{
            System.out.println("There are currently no items");
        }
        
    }

    public LinkedList<ToDoItem> returnSorted(String howToSort){
        LinkedList<ToDoItem> output = new LinkedList<>(items);
        if(howToSort.equals("date")){
            Collections.sort(output);
        }
        else if(howToSort.equals("title")){
            Collections.sort(output);
        }
        else{
            System.out.println("Please make sure you are entering \"date\" or \"title\"");
        }
        return output;
        

        
        
    }

    public void removeAll(){
       if(items.size() > 0){
        for(ToDoItem i : items){
            System.out.println(i.getTitle()  + " has been removed");
            items.remove(findItemId(i.getTitle()));
            
        }
        }
        else{
            System.out.println("There are currently no items");
        }
        
    }

    public void FinalizeItems(){
        readerWriter.writeToFile(items);
    }

    


}