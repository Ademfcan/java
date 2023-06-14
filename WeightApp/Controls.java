import org.sqlite.core.DB;

public class Controls {
    private int Id;
    private static String Name;
    private static int Age;
    private static int Weight;
    private static String UserName;
    private static String Password;
    private static Database Db;
    private static String CurrentName;
    private static int CurrentAge;
    private static int CurrentWeight;
    private static String CurrentUserName;
    private static String CurrentPassword;
    

    public static void createDB() {
        Db = new Database();
    }

    public static void addUsertoDB() {

        User u = new User(Name, Age, Weight, UserName, Password);
        System.out.println(u);
        Db.AddUser(u);
    }

    public static void GetUserValues(String name, int age, int weight, String userName, String password) {
        Name = name;
        Age = age;
        Weight = weight;
        UserName = userName;
        Password = password;
    }

    public static boolean CheckUser(String userName, String password) {
        
        if(Db.CheckUser(userName, password)){
            User u = Db.GetCurrentUserInfo(userName);
            CurrentName = u.GetName();
            CurrentAge = u.GetAge();
            CurrentWeight = u.GetWeight();
            CurrentUserName = u.GetUsername();
            CurrentPassword = u.GetPassWord();
            System.out.println(CurrentName + " " + CurrentAge);
            return true;
        }

        return false;
    }
    public static String GetName(){
        return CurrentName;

    }

    public static int GetAge(){
        return CurrentAge;

    }

    public static int GetWeight(){
        return CurrentWeight;

    }

    public static String GetPassWord(){
        return CurrentPassword;

    }

    public static String GetUsername(){
        return CurrentUserName;

    }
    
}
