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
	
	public static void main (String[] args) {
		//DbManager db = DbManager.getDbManagerSql();
		//db.backupDbSql();
		
		//DbManager db = DbManager.getDbManagerMySql();
		//db.backupDbMySql();
		//db.restoreDbMySql();
	}

	private final static String MIRROR_DBNAME_RESTORE_SQL = "LUKSDB_2020_06_17_08_04_23.BAK";
	private final static String DBNAME_SUPPORT_RESTORE_SQL = "master";
	private final static String SQL_BKP_PATH = "D:\\testBackupSql\\"; 
	
	private final static String MYSQL_DUMP_PATH = "D:\\xampp\\mysql\\bin\\mysqldump.exe";
	private final static String MYSQL_FOLDER_PATH = "D:\\xampp\\mysql\\bin\\mysql";
	private final static String MYSQL_BKP_PATH = "D:\\dumpMySql\\";
	private final static String MIRROR_DBNAME_RESTORE_MYSQL = "meubkpluksdb.sql";
	
	private String user = "sa";
	private String pass = "123";
	private String dbName = "DbLuksTest";
	private String server = "localhost";
	private String port = "1433";
	private Connection con = null;
	
	
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
		//dados conexao db principal da automacao sqlServer
		return new DbManager("sa", "123", "DbLuksTest", "localhost", "1433");
	}
	
	public static DbManager getDbManagerMySql() {
		//dados conexao db mySql
		return new DbManager("root", "", "luksdb");		 
	}
	
	public void backupDbSql() {
		Conect conect = new Conect(getDbName(), getUser(), getPass(), getServer(), getPort());
		String query = "BACKUP DATABASE "+ getDbName() +" TO DISK = '" + SQL_BKP_PATH + "LUKSDB_" + gerarNomeComData() + ".BAK'";
		try {
			con = conect.getConnectionSql();
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.execute();
			con.close();
			System.out.println("Backup realizado!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void restoreDbSql() {
		Conect conect = new Conect(DBNAME_SUPPORT_RESTORE_SQL, getUser(), getPass(), getServer(), getPort());
		String query1 = "ALTER DATABASE " + getDbName() + " SET SINGLE_USER WITH ROLLBACK IMMEDIATE";
		String query2 = "RESTORE DATABASE " + getDbName() + " FROM DISK = '" + SQL_BKP_PATH + MIRROR_DBNAME_RESTORE_SQL + "' WITH REPLACE";
		try {
			con = conect.getConnectionSql();
			PreparedStatement stmt = con.prepareStatement(query1);
			stmt.execute();
			stmt = con.prepareStatement(query2);
			stmt.execute();
			con.close();
			System.out.println("Banco restaurado!");
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


	public void backupDbMySql() {
		String dump = "cmd.exe /c " + MYSQL_DUMP_PATH + " --user=" + getUser() + " --password=" + getPass() + " " + getDbName() + " > "
				+ MYSQL_BKP_PATH + "bkpLuksDb" + gerarNomeComData() + ".sql";
		Runtime bkp = Runtime.getRuntime();
		try {
			bkp.exec(dump);
			System.out.println("Backup realizado!");
			//System.out.println(dump);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void restoreDbMySql() {
		String restauraBkp = "cmd.exe /c " + MYSQL_FOLDER_PATH + " --user=" + getUser() + " --password=" + getPass() + " "
				+ getDbName() + " < " + MYSQL_BKP_PATH + MIRROR_DBNAME_RESTORE_MYSQL;
		try {
			Runtime.getRuntime().exec(restauraBkp);
			System.out.println("Banco restaurado!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String gerarNomeComData() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd _ hh:mm:ss");
		Calendar c = Calendar.getInstance();
		String s = sdf.format(c.getTime());
		return s.replace("/", "_").replace(" ", "").replace(":", "_");
	}


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
