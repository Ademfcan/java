import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class CsvReaderWriter {
    private FileWriter writer;
    private BufferedReader reader;
    private File path;

    public CsvReaderWriter() {
        path = new File("C:\\Projs\\java\\ToDoListSimple\\TaskStorage.txt");
        try {
           
            reader = new BufferedReader(new FileReader(path));
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }

    public LinkedList<ToDoItem> readFromFile() {
        LinkedList<ToDoItem> items = new LinkedList<ToDoItem>();
        try {
            String lineRead = reader.readLine();
            while (lineRead != null) {
                String[] lineSplit = lineRead.split(",");
                items.add(new ToDoItem(lineSplit[0], lineSplit[1], parseDate(lineSplit[2]),0 >=parseDate(lineSplit[2]).compareTo(new Date())));
                lineRead = reader.readLine();
            }
        } catch (Exception e) {
            System.out.println("Io error occurred, please restart the program");
        }
        return items;
    }

    public void writeToFile(LinkedList<ToDoItem> items) {
       
        Format dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            writer = new FileWriter(path);
            for (ToDoItem i : items) {
                writer.write(i.getTitle() + "," + i.getDescr() + "," + dateFormat.format(i.getExpr()) + "," + i.checkComplete() + "\n");
            }
            writer.flush();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private Date parseDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parsedDate = dateFormat.parse(date);
            return parsedDate;
        } catch (Exception e) {
            // TODO: handle exception
            // System.out.println("Invalid date format: " + date);
            // e.printStackTrace();
            return null;
        }
    }

    private boolean parseBool(String bool){
        return bool.equals("true");
            
    
    }
}
