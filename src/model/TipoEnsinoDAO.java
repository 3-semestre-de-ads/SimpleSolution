package model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe � respons�vel por acessar o banco de dados e atualizar a tabela TIPOENSINO
 * Comunica��o com a classe TipoEnsino
 * @author Simple Solution Devs
 */
public class TipoEnsinoDAO {

	/**
	 * Atributos para realizar conex�o com o banco de dados
	 */
	private DbConn dbc = new DbConn();
	private String men, sql;


	
	/**
	 * M�todo respons�vel por retornar uma lista com o registro de todos os tipos de ensino
	 * @return listaTE - lista de tipo de ensino (array)
	 */
	public ArrayList<TipoEnsino> consultarTodos() {
		sql = "SELECT * FROM TIPOENSINO;";
		ArrayList<TipoEnsino> listaTE = new ArrayList<TipoEnsino>();
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.rs = dbc.st.executeQuery();
					
					while (dbc.rs.next()) { 
						TipoEnsino te = new TipoEnsino();
						te.setCodTE(dbc.rs.getInt(1));
						te.setNomeTE(dbc.rs.getString(2));
						te.setQtdAlunoTE(dbc.rs.getInt(3));
						listaTE.add(te);
						
					}									
				}			
			} 
			catch (SQLException e) {
				listaTE=null;
				JOptionPane.showMessageDialog(null,e, "Falha", 1);
			} 
			finally {
				dbc.close();
			}
		}
		return listaTE;
	}



	/**
	 * M�todo respons�vel por retornar um registro de acordo com o c�digo fornecido
	 * Tabela TIPOENSINO
	 * @param te - objeto inst�nciado da classe Nota
	 * @return te
	 */
	public TipoEnsino consultar(TipoEnsino te) {
		sql = "SELECT * FROM TIPOENSINO WHERE codTE=?;";
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.st.setInt(1, te.getCodTE());
					dbc.rs = dbc.st.executeQuery();
					while (dbc.rs.next()) {
						te.setNomeTE(dbc.rs.getString(2));
						te.setQtdAlunoTE(dbc.rs.getInt(3));
					}
				}			
			} 
			catch (SQLException e) {
				te = null;
			} 
			finally {
				dbc.close();
			}
		}
		return te; 
	}



	/**
	 * M�todo respons�vel por retornar o pr�ximo n�mero do �ndice no banco de dados
	 * Tabela TIPOENSINO
	 * @return r - valor do pr�ximo �ndice
	 */
	public int proximoId() {
		sql = "SELECT MAX(codTE) FROM TIPOENSINO;";
		int r = 0;
		if(dbc.getConnection()) {
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.rs = dbc.st.executeQuery();
				while (dbc.rs.next()) {
					r = dbc.rs.getInt(1)+1;
				}
				
			}
			catch (SQLException e) {
				r = -1;
			} 
			finally {
				dbc.close();
			}
		}
		return r;
	}


	
	/**
	 * M�todo respons�vel por inserir um novo registro ou atualizar um registro existente
	 * Tabela TIPOENSINO
	 * @param te - objeto inst�nciado da classe TipoEnsino
	 * @return men - mensagem de aviso
	 */
	public String inserirAtualizar(TipoEnsino te) {
		sql = "INSERT INTO TIPOENSINO VALUES(?,?,?);";
		if (dbc.getConnection()){
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setInt(1, te.getCodTE());
				dbc.st.setString(2, te.getNomeTE());
				dbc.st.setInt(3, te.getQtdAlunoTE());
				dbc.rs = dbc.st.executeQuery();
				men = "Inserido com sucesso";
			}
			catch (SQLException e) {
				sql = "UPDATE TIPOENSINO SET "
						+ "nomeTE=?"
						+ "qtdAlunoTE=?"
						+ "WHERE codTE=?";
				try {
					if (dbc.getConnection()) {
						dbc.st = dbc.con.prepareStatement(sql);
						dbc.st.setString(1, te.getNomeTE());
						dbc.st.setInt(2, te.getQtdAlunoTE());
						dbc.st.setInt(3, te.getCodTE());
						dbc.rs = dbc.st.executeQuery();
						men = "Atualizado com sucesso";
					} 
				}
				catch (SQLException e2) {
					men = "Falha: "+ e2;
				}	
			}
			finally {
				dbc.close();
			}
		}
		return men;
	}
}
