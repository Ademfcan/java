import java.sql.*;;

public class Database {
    private Connection conn = null;
    Statement stmt = null;

    public Database() {

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            System.out.println("Opened database successfully");

            stmt = conn.createStatement();
            String sql = "CREATE TABLE USER " +
                    "(ID INTEGER  PRIMARY KEY AUTOINCREMENT    NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AGE            INT     NOT NULL, " +
                    " WEIGHT         INT     NOT NULL, " +
                    " USERNAME       TEXT    NOT NULL, " +
                    " PASSWORD       TEXT    NOT NULL )";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        System.out.println("Table created successfully");
    }

    public boolean AddUser(User u) {
        try {
            String sql = "INSERT INTO USER (NAME,AGE,WEIGHT,USERNAME,PASSWORD) " +
                    "VALUES ('" + u.GetName() + "'," + u.GetAge() + "," + u.GetWeight() + ",'" + u.GetUsername() + "','"
                    + u.GetPassWord() + "')";
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            conn.commit();
            return true;
        }

        catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return false;
        }
    }

    public boolean CheckUser(String userName, String password) {
        try {
            String sql = "SELECT * FROM USER WHERE USERNAME = '" + userName + "' AND PASSWORD = '" + password + "'";
            stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                return true;
            }
            return false;

        } catch (Exception e) {
            
            return false;
        }

    }

    public User GetCurrentUserInfo(String Username){
        try {
            String sql = "SELECT * FROM USER WHERE USERNAME = '" + Username + "'";
            stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(sql);
            if(res.next()){
                User u = new User(res.getString("NAME"), res.getInt("AGE"), res.getInt("WEIGHT"), res.getString("USERNAME"), res.getString("PASSWORD"));
                return u;
            }
            return null;
            

        }
        catch (Exception e)
        {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            return null;
        }

    }
}