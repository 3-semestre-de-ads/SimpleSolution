package model;

import java.sql.SQLException;

import services.DbConn;

public class AdministradorDAO {
	private DbConn dbc = new DbConn();
	private String sql;
	
	public boolean efetuaLogin(String usuario, String senha) {
		sql = "SELECT * FROM ADMINISTRADOR WHERE userAdmin=? AND senhaAdmin=?";
		if (dbc.getConnection()) {
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setString(1, usuario.trim());
				dbc.st.setString(2, senha.trim());
				dbc.rs = dbc.st.executeQuery();
				return true;
				
			} catch (SQLException e) {
				return false;
			}
		}
		return false;
	}
}
