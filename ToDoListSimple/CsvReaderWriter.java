
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
    private FileWriter finWriter;
    private BufferedReader Finreader;
    private BufferedReader Curreader;
    private File CurrentPath;
    private File FinishedPath;

    public CsvReaderWriter() {
        CurrentPath = new File("C:\\Projs\\java\\ToDoListSimple\\TaskStorage.txt");
        FinishedPath = new File("C:\\Projs\\java\\ToDoListSimple\\Finished.txt");
        try {
           
            Finreader = new BufferedReader(new FileReader(FinishedPath));
            Curreader = new BufferedReader(new FileReader(CurrentPath));

        } catch (Exception e) {
            System.out.println("File not found");
        }
    }

    public LinkedList<ToDoItem> readFromFile() {
        LinkedList<ToDoItem> items = new LinkedList<ToDoItem>();
        try {
            String lineRead = Curreader.readLine();
            while (lineRead != null) {
                String[] lineSplit = lineRead.split(",");
                items.add(new ToDoItem(lineSplit[0], lineSplit[1], parseDate(lineSplit[2]),0 >=parseDate(lineSplit[2]).compareTo(new Date())));
                lineRead = Curreader.readLine();
            }
        } catch (Exception e) {
            System.out.println("Io error occurred, please restart the program");
        }
        return items;
    }

    public LinkedList<ToDoItem> readFromFinished() {
        LinkedList<ToDoItem> items = new LinkedList<ToDoItem>();
        try {
            String lineRead = Finreader.readLine();
            while (lineRead != null) {
                String[] lineSplit = lineRead.split(",");
                items.add(new ToDoItem(lineSplit[0], lineSplit[1], parseDate(lineSplit[2]),0 >=parseDate(lineSplit[2]).compareTo(new Date())));
                lineRead = Finreader.readLine();
            }
        } catch (Exception e) {
            System.out.println("Io error occurred, please restart the program");
        }
        return items;
    }

    public void writeToFile(LinkedList<ToDoItem> items) {
       
        Format dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            writer = new FileWriter(CurrentPath);
            finWriter = new FileWriter(FinishedPath);
            for (ToDoItem i : items) {
                if(i.checkComplete()){
                    finWriter.write(i.getTitle() + "," + i.getDescr() + "," + dateFormat.format(i.getExpr()) + "," + i.checkComplete() + "\n");
                }
                writer.write(i.getTitle() + "," + i.getDescr() + "," + dateFormat.format(i.getExpr()) + "," + i.checkComplete() + "\n");
            }
            writer.flush();
            finWriter.flush();
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

    
}
