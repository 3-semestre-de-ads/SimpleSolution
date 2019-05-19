package services;
import java.sql.*;


public class DbConn {
	public Connection con = null;	
	public PreparedStatement st = null;
	public ResultSet rs = null;
	
	private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final String LOGIN  = "SA";
	private final String SENHA = "simpleSolution123";
	private final String DATABASE = "SIMPLESOLUTIONSCHOOL";
	private final String URL = "jdbc:sqlserver://172.17.0.2:1433; "
			+ "databaseName="+DATABASE;
	
	public boolean getConnection() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,LOGIN,SENHA);
			return true;
		}
		catch(ClassNotFoundException erro) {
			System.out.println("Driver n�o encontrado");
			return false;
		}
		catch(SQLException erro) {
			System.out.println("Erro "+erro.toString());
			return false;
		}
	}
	public void close() {
		try {
			if(rs!=null) rs.close();
		}
		catch(SQLException erro) {}
		try {
			if(st!=null) st.close();
		}
		catch(SQLException erro) {}
		try {
			if(con!=null) {
				con.close();
			}
		}
		catch(SQLException erro) {}
	}
	
	public ResultSet consultaRegistro(String sqlString) {
		DbConn dbc = new DbConn();		
		if (dbc.getConnection()) {
			try {
				dbc.st = dbc.con.prepareStatement(sqlString);
				dbc.rs = dbc.st.executeQuery();
				return dbc.rs;
			} catch (SQLException e) {
				return null;
			}

		}else {
			return null;
		}
	}

}
