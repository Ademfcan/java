public class Person {
    private String FirstName, LastName;

    public Person(String FirstName, String LastName){
        this.FirstName = FirstName;
        this.LastName = LastName;
    }

    public String SayHi()
    {
        return "Hi from " + this.FirstName;
    }
}
