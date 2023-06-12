import java.util.Calendar;
import java.util.Date;
public class main {
    private static ToDoStorage storage;
    public static void main(String[] args) {
        storage = new ToDoStorage();
        
        storage.add(new ToDoItem("Homework", "test", Calendar.getInstance().getTime()));
        System.out.println(storage.getByTitle("Homework").ToString());
    
    
    }
}
