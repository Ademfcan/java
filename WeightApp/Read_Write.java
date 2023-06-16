import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Read_Write {
    private static String fileName;
    private static PrintWriter saveName;
    private static FileReader readName;
    private static BufferedReader bReader;

    public static void Start() {
        fileName = input("Name the file:") + ".txt";
        CreateFile(fileName);
    }

    public static void CreateFile(String fileName) {
        try {
            File name = new File(fileName);

            if (name.createNewFile()) {
                System.out.println("File " + name.getName() + " has been created");

            } else {
                System.out.println("File " + name.getName() + " already exists!");
            }

            saveName = new PrintWriter(fileName);
            readName = new FileReader(fileName);
            bReader = new BufferedReader(readName);
        } catch (FileNotFoundException aaa) {
            System.out.println("File does not exist");
        } catch (IOException ioex) {
            System.out.println("An error has occured");
            ioex.printStackTrace();
        }
    }

    public static String input(String Input) {
        System.out.println(Input);
        Scanner checkline = new Scanner(System.in);
        String theinput = checkline.nextLine();
        return theinput;
    }

    public static void SaveName() {
        String name = input("Please enter your name to be saved");
        saveName.println(name);
        saveName.flush();
    }

    public static void ReadName() {
        String line;

        try {
            while ((line = bReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException a) {
            System.out.println("There was an error");
            a.printStackTrace();
        }
    }
}
