import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class User {
    private int Id;
    private String Name;
    private int Age; 
    private int Weight;
    private String UserName;
    private String Password;

    public User(String name, int age, int weight, String userName, String password)
    {
        Id = ThreadLocalRandom.current().nextInt(1000, 4001);
        Name = name;
        Age = age;
        Weight = weight;
        UserName = userName;
        Password = password;

    }

    public int GetID(){
        return this.Id;

    }

    public String GetName(){
        return this.Name;

    }

    public int GetAge(){
        return this.Age;

    }

    public int GetWeight(){
        return this.Weight;

    }

    public String GetPassWord(){
        return this.Password;

    }

    public String GetUsername(){
        return this.UserName;

    }
    
}
