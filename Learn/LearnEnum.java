public class LearnEnum
{
    enum Color
    {
        RED,
        BLUE,
        GREEN,
        YELLOW
    }

    public static void main(String[] args) {
        Color  c = Color.RED;
        System.out.println(c);

        Color d = Color.BLUE;
        System.out.println(c == d);
    }
}