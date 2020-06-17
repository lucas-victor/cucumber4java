package br.com.squadra.test.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DbManager {
	
	public static void main(String[] args) {
		//DbManager db = DbManager.getDbManagerSql();
		DbManager db = new DbManager();
		//db.executaQuery("insert into produtos (nome, descricao, preco) values ('test3', 'test3', 2.00)");
		//db.printResultSet(db.executaQueryResultSet("select * from produtos"));
		//db.BackupDbSql();
		//db.RestoreDbSql();	
	}

	private String mySqlDumpPath = "D:\\xampp\\mysql\\bin\\mysqldump.exe";
	private String BkpAbsolutPath = "D:\\dumpMySql\\meubkpluksdb.sql";

	private String user = "sa";
	private String pass = "123";
	private String dbName = "DbLuksTest";
	private String server = "localhost";
	private String port = "1433";
	private Connection con = null;
	private String bkpSqlPath = "'D:\\testBackupSql\\LUKSDB_TEST_BKP.BAK'"; 

	public DbManager() {
	}

	public DbManager(String user, String pass, String dbName) {
		this.user = user;
		this.pass = pass;
		this.dbName = dbName;
	}

	public DbManager(String user, String pass, String dbName, String server, String port) {
		this.user = user;
		this.pass = pass;
		this.dbName = dbName;
		this.server = server;
		this.port = port;
	}

	public static DbManager getDbManagerSql() {
		DbManager db = new DbManager("sa", "123", "DbLuksTest", "localhost", "1433");
		return db;
	}
	
//	public static DbManager getDbManagerMySql() {
//		DbManager db = new DbManager("root", "", "luksdb");
//		return db;
//	}
	
	public void BackupDbSql() {
		Conect conect = new Conect(getDbName(), getUser(), getPass(), getServer(), getPort());
		String query = "BACKUP DATABASE "+ getDbName() +" TO DISK = " + bkpSqlPath;
		try {
			con = conect.getConnectionSql();
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void RestoreDbSql() {
		Conect conect = new Conect("master", getUser(), getPass(), getServer(), getPort());
		String query = "RESTORE DATABASE " + getDbName() + " FROM DISK = " + bkpSqlPath + " WITH REPLACE";
		try {
			con = conect.getConnectionSql();
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void executaQuery(String query) {
		Conect conect = new Conect(getDbName(), getUser(), getPass(), getServer(), getPort());
		try {
			con = conect.getConnectionSql();
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public ResultSet executaQueryResultSet(String query) {
		Conect conect = new Conect(getDbName(), getUser(), getPass(), getServer(), getPort());
		ResultSet rs = null;
		try {
			con = conect.getConnectionSql();
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);	
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public void printResultSet(ResultSet rs) {
        try {
			while (rs.next()) {
				//teste
			    System.out.println(rs.getString("nome") + " " + rs.getString("descricao")+ " " + rs.getString("preco"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// metodo exemplo
	public void backupMySql() {
		// bkp
		String dump = "cmd.exe /c " + mySqlDumpPath + " --user=" + user + " --password=" + pass + " " + dbName + " > "
				+ BkpAbsolutPath;
		Runtime bkp = Runtime.getRuntime();
		try {
			bkp.exec(dump);
			System.out.println(dump);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// metodo exemplo
	public void restoreMySql() {
		// restaura bkp
		String restauraBkp = "cmd.exe /c D:\\xampp\\mysql\\bin\\mysql --user=" + user + " --password=" + pass + " "
				+ dbName + " < " + "D:\\dumpMySql\\meubkpluksdb.sql";
		try {
			System.out.println("Restaurando a base.");
			Runtime.getRuntime().exec(restauraBkp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String gerarNomeComData() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd _ hh:mm:ss");

		Calendar c = Calendar.getInstance();
		String s = sdf.format(c.getTime());
		return s.replace("/", "-").replace(" ", "").replace(":", ".");
	}

//	/**
//	 * Classe que realiza exportaÃ§Ã£o de banco de dados MySql
//	 * 
//	 * @param host     - EndereÃ§o host do banco de Dados ex:localhost
//	 * @param bd       - Nome do Banco de Dados ex:meubd
//	 * @param usuario  - Usuario de acesso ao banco de dados : ex:root
//	 * @param senha    - Senha de Acesso ao banco de dados : ex:1234
//	 * @param location - Local que serÃ¡ salvo o sql contendo apenas o nome sem a
//	 *                 extensÃ£o ex:c:\\backup
//	 * @return - uma string informando se o processo foi salvo com sucesso ou nÃ£o
//	 */
//	public static String exportarBD(String host, String bd, String usuario, String senha, String location) {
//
//		StringBuilder dump = new StringBuilder();
//
//		// local onde se encontra o MysqlDump
//		dump.append("D:\\xampp\\mysql\\bin\\mysqldump.exe");
//		// solicitando o host ex:localhost
//		dump.append(" -h");
//		dump.append(host);
//		// solicitando o usuario
//		dump.append(" -u");
//		dump.append(usuario);
//		// solicitando a senha
//		dump.append(" -p");
//		dump.append(senha);
//		// solicitando o bd
//		dump.append(" --add-drop-database -B");// se existir o sql, sobrescreverÃ¡
//		dump.append(bd);
//		// solicitando o local para salvar ex:c\\mysql
//		dump.append(" -r");
//		dump.append(location);
//		dump.append(gerarNomeComData());// esse metodo devolverÃ¡ o ano seguido da hora ex:mysql20170609_073230
//		dump.append(".sql");// add a extensÃ£o .sql
//
//		Process p;
//		try {
//			p = Runtime.getRuntime().exec(dump.toString());
//			p.waitFor();
//		} catch (IOException e) {
//			e.printStackTrace();
//			return "Erro ao realizar Backup";
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//			return "Erro ao realizar Backup";
//		}
//		return "Banco de Dados foi Exportado com sucesso para a pasta \n" + location;
//
//	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
}
