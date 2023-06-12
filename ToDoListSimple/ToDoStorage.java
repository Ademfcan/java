
import java.util.LinkedList;
import java.util.Date;
import javax.xml.crypto.Data;

public class ToDoStorage {
    LinkedList<ToDoItem> items;

    public ToDoStorage() {
        items = new LinkedList<ToDoItem>();

    }

    public void add(ToDoItem item) {
        items.add(0, item);
    }

    public ToDoItem getByTitle(String Title) {
        ToDoItem item;
        for (int i = 0; i < items.size(); i++) {
            item = items.get(i);
            if (item.getTitle().equals(Title)) {
                return item;

            }

        }
        return null;
    }

    public ToDoItem getByTitle(Date expr) {
        ToDoItem item;
        for (int i = 0; i < items.size(); i++) {
            item = items.get(i);
            if (item.getExpr().equals(expr)) {
                return item;

            }

        }
        return null;
    }

}