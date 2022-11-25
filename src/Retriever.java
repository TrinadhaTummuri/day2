
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Retriever {
	static final String url="jdbc:mysql://localhost:3306/democog";
      static final String user="root";
	static final String pass="root";
	static final String query="select * from student";
	static final String query1="select * from student where id=?";

	public static void main(String[] args) {

		try(Connection con=DriverManager.getConnection(url,user,pass);
				Statement st=con.createStatement();
				ResultSet rs= st.executeQuery(query);){
			
			while(rs.next()) {
				System.out.print("\nid = "+ rs.getInt("id"));
				System.out.print("\t\tname = "+ rs.getString("name"));
				System.out.print("\t\tcity = "+ rs.getString("city"));
				System.out.print("\t\tsubject = "+ rs.getString("course"));
				System.out.print("\t\tmarks = "+ rs.getInt("marks"));
			}
			
		} catch(SQLException e) {
			
		}
	}
}

 