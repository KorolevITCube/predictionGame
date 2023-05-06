import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {
    private String databaseUrl = "jdbc:postgresql://localhost:5432/Kamin";
    private String user = "postgres";
    private String password = "manager";
    private String driverName = "org.postgresql.Driver";

    private final String selectWhereId = "select * from prediction where id = ?";

    public Connection getConnection(){
        try {
            Class.forName(driverName);
            var connect = DriverManager
                    .getConnection(databaseUrl,
                            user, password);
            connect.setAutoCommit(false);
            return connect;
        }catch(Exception e){
            return null;
        }
    }

    public void closeConnection(Connection connect){
        try {
            connect.commit();
            connect.close();
            System.out.println("Connection closed");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getPrediction(Integer id) {
        Connection connect = null;
        String predict = "";
        try{
            connect = getConnection();
            PreparedStatement prepStatement = connect.prepareStatement(selectWhereId);
            prepStatement.setInt(1,id);
            ResultSet result = prepStatement.executeQuery();
            while(result.next()){
                predict = result.getString("text");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            closeConnection(connect);
        }
        return predict;
    }
}
