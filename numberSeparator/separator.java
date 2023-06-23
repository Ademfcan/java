import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Comparator;
import java.util.Scanner;

public class separator {
    public static void main(String[] args) {

        String path = "C:\\Projs\\java\\numberSeparator\\splitted.txt";
        try {
            String[] comparator = {
                    "Spokane",
                    "NewmanLake",
                    "PendOreille",
                    "Okanogan",
                    "Methow",
                    "ConconullyLake",
                    "Wenatchee",
                    "Chelan",
                    "UpperYakima",
                    "LowerYakima",
                    "AhtanumCreek",
                    "WallaWalla",
                    "LowerSnake",
                    "Cowlitz",
                    "Lewis",
                    "White",
                    "Green",
                    "Puyallup",
                    "Cedar",
                    "Snoqualmie",
                    "Skykomish",
                    "Skagit",
                    "Baker",
                    "Nooksack",
                    "OlympicPeninsula"
            };
            BufferedReader fileReader = new BufferedReader(new FileReader(path));
            String[] nextLine = fileReader.readLine().split(" ");
            for (int i = 0; i < comparator.length; i++) {
                if (nextLine[0].toLowerCase().equals(comparator[i].toLowerCase())) {
                    System.out.println(nextLine[1]);
                } else {
                    System.out.println("   ");
                }
                nextLine = fileReader.readLine().split(" ");
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}