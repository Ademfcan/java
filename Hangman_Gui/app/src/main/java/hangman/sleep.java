package hangman;

public class sleep {
    public static void sleep(int secs){
        try {
            Thread.sleep(secs*1000);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
