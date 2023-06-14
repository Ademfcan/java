import java.util.Calendar;
import java.util.Date;

public class ToDoItem {
    private String title;
    private String description;
    private Date expiration;
    private boolean isCompleted;

    public ToDoItem(String Title, String Description, Date time, boolean MkComplete){
        this.title  = Title;
        this.description = Description;
        this.expiration = time;
        this.isCompleted = MkComplete;
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

    public boolean checkComplete(){
        return isCompleted;
    }

    public void updateComplete(boolean Completed){
        this.isCompleted = Completed;
    }

    public String ToString() {
    return "\u001B[1mName:\u001B[0m " + title + "\n" +
           "\u001B[1mDescription:\u001B[0m " + description + "\n" +
           "\u001B[1mExpires on:\u001B[0m " + expiration.toString() + "\n"+
           "\u001B[1mIsComplete?:\u001B[0m " + isCompleted;
}

}
