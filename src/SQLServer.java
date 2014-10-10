import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLServer 
    {
        public static void main(String[] args)
        {
            try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                String userName = "steze";
                String password = "Steffen";
                String url = "jdbc:sqlserver://localhost:1433"+";databaseName=test_18092014";
                Connection con = DriverManager.getConnection(url, userName, password);
                Statement s1 = con.createStatement();
                ResultSet rs = s1.executeQuery("SELECT * FROM Table_1");
                
                //ResultSet rs = s1.executeQuery("insert into Table_1 (id, text)  values (555, 'kakaa')"); 
                //String[] result = new String[20];
                int length =3;
                String output = "";
                
                if(rs!=null){
                    while (rs.next()){
                        	for (int i = 1; i <length; i++){
                    		output = output+" "+rs.getString(i);}
                            
                        }
                    System.out.println(output);
                        }
                    
                
                /*
                if(rs!=null){
                    while (rs.next()){
                        for(int i = 1; i <result.length ;i++)
                        {
                            for(int j = 1; j <result.length;j++)
                            {
                                result[j]=rs.getString(i);
                            System.out.println(result[j]);
                        }
                        }
                    }
                }*/

                //String result = new result[20];

            } catch (Exception e)
            {
                e.printStackTrace();
            }
    }


}