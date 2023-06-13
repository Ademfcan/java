
import java.util.LinkedList;
import java.util.Date;
import javax.xml.crypto.Data;
import javax.xml.validation.ValidatorHandler;

public class ToDoStorage{
    LinkedList<ToDoItem> items;

    public ToDoStorage() {
        items = new LinkedList<ToDoItem>();

    }

    public void add(ToDoItem item) {
        items.add(0, item);
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

    public void printAll(){
        if(items.size() > 0){
        for(ToDoItem i : items){
            System.out.println(i.ToString());
        }
        }
        else{
            System.out.println("There are currently no items");
        }
        
    }

}