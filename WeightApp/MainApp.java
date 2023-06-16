import org.sqlite.core.DB;

public class MainApp {

    public static void main(String[] args) {

        Controls.createDB();

        AppScreen appScreen = new AppScreen();



        appScreen.createSignUP();
        appScreen.createSignIn();

        


        appScreen.SwitchPanel(AppScreen.SIGNUP_CMD);
        appScreen.Show();
        appScreen.HomeScreen();


        // Start();

        // for(int i = 0; i<5; i++)
        // {
        // SaveName();
        // }

        // ReadName();
    }

}
