import java.util.Calendar;
import java.util.Date;

public class ToDoItem {
    private String title;
    private String description;
    private Date expiration;

    public ToDoItem(String Title, String Description, Date time){
        this.title  = Title;
        this.description = Description;
        this.expiration = time;
    }

    public String getTitle(){
        return title;
    }

    public String getDescr(){
        return description;
    }

    public Date getExpr(){
        return expiration;
    }

    public String ToString(){
        return "The item with the title " + title + " has a description of: " + description + " and  expires on " + expiration.toString();
    }
}
