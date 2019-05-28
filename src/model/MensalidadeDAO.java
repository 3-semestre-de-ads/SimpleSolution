package model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import services.DbConn;

/**
 * Essa classe é responsável por acessar o banco de dados e atualizar a tabela MENSALIDADE
 * Comunicação com a classe Mensalidade
 * @author Simple Solution Devs
 */
public class MensalidadeDAO {
	
	/**
	 * Atributos para realizar conexão com o banco de dados
	 */
	private DbConn dbc = new DbConn();
	private String men, sql;


	
	/**
	 * Método responsável por retornar uma lista com o registro de todos as mensalidades
	 * @return listaMens - lista de mensalidade (array)
	 */
	public Mensalidade[] consultarTodos() {
		sql = "SELECT * FROM MENSALIDADE;";
		Mensalidade[] listaMens = new Mensalidade[] {null};
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.rs = dbc.st.executeQuery();
					dbc.rs.last();
					listaMens = new Mensalidade[dbc.rs.getRow()];
					dbc.rs.beforeFirst();
					int count=0;
					while (dbc.rs.next()) { 
						Mensalidade mensalidade = listaMens[count];
						mensalidade.setCodMens(dbc.rs.getInt(1));
						mensalidade.setDescontoMens(dbc.rs.getDouble(2));
						mensalidade.setTipoPgMens(dbc.rs.getString(3));
						mensalidade.setDataVencMens(dbc.rs.getDate(4));
						count++;
					}									
				}			
			} 
			catch (SQLException e) {
				listaMens=null;
				JOptionPane.showMessageDialog(null,e, "Falha", 1);
			} 
			finally {
				dbc.close();
			}
		}
		return listaMens;
	}



	/**
	 * Método responsável por retornar um registro de acordo com o código fornecido
	 * Tabela MENSALIDADE
	 * @param mensalidade - objeto instânciado da classe Mensalidade
	 * @return mensalidade 
	 */
	public Mensalidade consultar(Mensalidade mensalidade) {
		sql = "SELECT * FROM MENSALIDADE WHERE codMens=?;";
		if (dbc.getConnection()) {
			try {
				if (dbc.getConnection()) {
					dbc.st = dbc.con.prepareStatement(sql);
					dbc.st.setInt(1, mensalidade.getCodMens());
					dbc.rs = dbc.st.executeQuery();
					//mensalidade.setNomeAluno(dbc.rs.getString(2));
					//mensalidade.setNomeAluno(dbc.rs.getString(3));
					//mensaldiade.setNascAluno(dbc.rs.getDate(4));
				}			
			} 
			catch (SQLException e) {
				mensalidade = null;
			} 
			finally {
				dbc.close();
			}
		}
		return mensalidade; 
	}



	/**
	 * Método responsável por retornar o próximo número do índice no banco de dados
	 * Tabela MENSALIDADE
	 * @return r - valor do próximo índice
	 */
	public int proximoId() {
		sql = "SELECT MAX('codMens') FROM MENSALIDADE";
		int r = 0;
		if(dbc.getConnection()) {
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.rs = dbc.st.executeQuery();
				r = dbc.rs.getInt(1)+1;
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
	 * Método responsável por inserir um novo registro ou atualizar um registro existente
	 * Tabela MENSALIDADE
	 * @param mensalidade - objeto instânciado da classe Mensalidade
	 * @return men - mensagem de aviso
	 */
	public String inserirAtualizar(Mensalidade mensalidade) {
		sql = "INSERT INTO MENSALIDADE VALUES(?,?,?,?);";
		if (dbc.getConnection()){
			try {
				dbc.st = dbc.con.prepareStatement(sql);
				dbc.st.setInt(1, mensalidade.getCodMens());
				dbc.st.setDouble(2, mensalidade.getDescontoMens());
				dbc.st.setString(3, mensalidade.getTipoPgMens());
				dbc.st.setDate(4, mensalidade.getDataVencMens());
				dbc.rs = dbc.st.executeQuery();
				men = "Inserido com sucesso";
			}
			catch (SQLException e) {
				sql = "UPDATE MENSALIDADE SET "
						+ "descontoMens=?"
						+ "tipoPgMens=?"
						+ "dataVencMens=?"
						+ "WHERE codMens=?";
				try {
					if (dbc.getConnection()) {
						dbc.st = dbc.con.prepareStatement(sql);
						dbc.st.setDouble(1, mensalidade.getDescontoMens());
						dbc.st.setString(2, mensalidade.getTipoPgMens());
						dbc.st.setDate(3, mensalidade.getDataVencMens());
						dbc.st.setInt(4, mensalidade.getCodMens());
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
