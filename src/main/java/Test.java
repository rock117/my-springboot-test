import java.sql.*;
public class Test {
    private final static String url = "jdbc:postgresql://localhost/stock_research";
    private final static String user = "postgres";
    private  final static String password = "123456";

    private static final String QUERY = "select * from stock_market_quotation";
    private static final String SELECT_ALL_QUERY = "select * from stock_market_quotation";


    public static void getAllUsers() throws SQLException {
        // using try-with-resources to avoid closing resources (boiler plate
        // code)

        // Step 1: Establishing a Connection
         Connection connection = DriverManager.getConnection(url, user, password);
             // Step 2:Create a statement using connection object
            // PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);) {
           // System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
       //     ResultSet rs = preparedStatement.executeQuery();
            Statement statement = connection.createStatement();
             ResultSet rs =  statement.executeQuery(SELECT_ALL_QUERY);
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                String password = rs.getString("password");
                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
            }
            System.out.println("done...");

    }

    public static void main(String[] args)throws Exception{
        getAllUsers();
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
