package model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Dictionary;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import controller.*;

public class ConsultaDb {
	private String sqlString = "";


	public ResultSet consultaTodos(String tabela) {
		sqlString = "SELECT * FROM"+tabela+";";
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
	
	public ResultSet consultaPorId(String tabela, String campo, String codigo) {
		sqlString = "SELECT * FROM " + tabela + "WHERE "+campo+"='"+codigo+"';";
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

	public boolean consultaLoginAdm(String login, String senha) {
		sqlString = "SELECT * FROM ADMINISTRADOR WHERE"
				+ " userAdmin='"+login.trim() 
				+ "' AND senhaAdmin='" +senha.trim()+"';"; 		
		DbConn dbc = new DbConn();
		if (dbc.getConnection()) {
			try {
				dbc.st = dbc.con.prepareStatement(sqlString);				
				dbc.rs = dbc.st.executeQuery();
				while (dbc.rs.next()) {
					return true;
				}
			} catch (SQLException e) {
				return false;
			}			
		}else {
			return false;
		}
		return false;
	}

}
