package br.com.squadra.test.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;

public class DbManager {
	
	//private final static String DBNAME_SUPPORT_RESTORE_SQL = "master";
	private final static String MIRROR_DBNAME_RESTORE_SQL = "LUKSDB_19-06-2020_20.44.28.BAK";
	private final static String SQL_BKP_PATH = "D:\\testBackupSql\\";

	private final static String MIRROR_DBNAME_RESTORE_MYSQL = "meubkpluksdb.sql";
	private final static String MYSQL_DUMP_PATH = "D:\\xampp\\mysql\\bin\\mysqldump.exe";
	private final static String MYSQL_FOLDER_PATH = "D:\\xampp\\mysql\\bin\\mysql";
	private final static String MYSQL_BKP_PATH = "D:\\dumpMySql\\";

	private final static String QUERY_ACTUAL_RESULT_PATH = "target/report-html/actualQueryResults/";
	private final static String QUERY_EXPECTED_RESULT_PATH = "src/test/java/expectedQueryResults/";

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
		// dados conexao db principal da automacao sqlServer
		return new DbManager("sa", "123", "DbLuksTest", "localhost", "1433");
	}

	public static DbManager getDbManagerMySql() {
		// dados conexao db mySql (bonus)
		return new DbManager("root", "", "luksdb");
	}

	public void backupDbSql() {
		Conect conect = new Conect(getDbName(), getUser(), getPass(), getServer(), getPort());
		String query = "BACKUP DATABASE " + getDbName() + " TO DISK = '" + SQL_BKP_PATH + "LUKSDB_" + gerarNomeComData()
				+ ".BAK'";
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

	public void restoreDbSql() { //DBNAME_SUPPORT_RESTORE_SQL
		Conect conect = new Conect(getDbName(), getUser(), getPass(), getServer(), getPort());
		String query1 = "Use master ALTER DATABASE " + getDbName() + " SET SINGLE_USER WITH ROLLBACK IMMEDIATE";
		String query2 = "Use master RESTORE DATABASE " + getDbName() + " FROM DISK = '" + SQL_BKP_PATH + MIRROR_DBNAME_RESTORE_SQL
				+ "' WITH REPLACE";
		PreparedStatement stmt;
		try {
			con = conect.getConnectionSql();
			stmt = con.prepareStatement(query1);
			stmt.execute();
			stmt = con.prepareStatement(query2);
			stmt.execute();
			con.close();
			System.out.println("Banco restaurado!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void executeQuery(String query) {
		Conect conect = new Conect(getDbName(), getUser(), getPass(), getServer(), getPort());
		PreparedStatement stmt;
		try {
			con = conect.getConnectionSql();
			stmt = con.prepareStatement(query);
			stmt.execute();
			con.close();
			System.out.println("query executada");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String executeQueryGetResult(String fileName, String query) {
		Conect conect = new Conect(getDbName(), getUser(), getPass(), getServer(), getPort());
		ResultSet rs = null;
		String result = "";
		try {
			con = conect.getConnectionSql();
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			result = getTextResultSet(rs);
			System.out.println("query executada");
			//writeFileResult(fileName, result);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String executeQueryWithResultFile(String fileName, String query) {
		Conect conect = new Conect(getDbName(), getUser(), getPass(), getServer(), getPort());
		ResultSet rs = null;
		String result = "";
		String newFileName = "";
		try {
			con = conect.getConnectionSql();
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			result = getTextResultSet(rs);
			System.out.println("query executada");
			newFileName = writeFileResult(fileName, result);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newFileName;
	}

	public String getTextResultSet(ResultSet rs) throws SQLException {
		String result = "";
		List<List> table = new ArrayList<List>();
		List<String> columnNames = new ArrayList<String>();
		ResultSetMetaData meta = rs.getMetaData();

		for (int i = 1; i <= meta.getColumnCount(); i++) {
			String nomeColunm = meta.getColumnName(i);
			columnNames.add(nomeColunm);
		}
		table.add(columnNames);

		while (rs.next()) {
			List<String> values = new ArrayList<String>();
			for (int i = 1; i <= meta.getColumnCount(); i++) {
				values.add(rs.getString(i));
			}
			table.add(values);
		}

		String tabelaTexto = table.toString();
		result = tabelaTexto
				.replace("], ", "\n")
				.replace("[", "")
				.replace(",", "")
				.replace("]]", "");

		return result;
	}

	public String writeFileResult(String fileName, String text) {
		String newFileName = fileName + "_" + gerarNomeComData() + ".txt";
		String fullNameArq = QUERY_ACTUAL_RESULT_PATH + newFileName;
		
		try {
			FileWriter arq = new FileWriter(fullNameArq);
			PrintWriter gravaArq = new PrintWriter(arq);
			gravaArq.print(text);
			arq.close();
			System.out.println("Arquivo gravado: " + fullNameArq);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return newFileName;
	}

	public void assertFilesResults(String fileNameExp, String fileNameAct) {

		String expFilePath = QUERY_EXPECTED_RESULT_PATH + fileNameExp;
		String actFilePath = QUERY_ACTUAL_RESULT_PATH + fileNameAct;

		File fileExp = new File(expFilePath);
		File fileAct = new File(actFilePath);
		
		boolean equals = assertTwoFiles(fileExp, fileAct);
		Assert.assertEquals(true, equals);

	}

	private boolean assertTwoFiles(File file1, File file2) {
		try {
			if (FileUtils.contentEquals(file1, file2)) {
				return true;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public String readFileResults(String fullPathFile) {
		BufferedReader buffRead;
		String file = "";
		try {
			buffRead = new BufferedReader(new FileReader(fullPathFile));
			while (true) {
				if (file != null) {
					System.out.println(file);
				} else
					break;
				file = buffRead.readLine();
			}
			buffRead.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	public void printResultSet(ResultSet rs) {
		try {
			while (rs.next()) {
				// teste
				System.out
						.println(rs.getString("nome") + " " + rs.getString("descricao") + " " + rs.getString("preco"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void backupDbMySql() {
		String dump = "cmd.exe /c " + MYSQL_DUMP_PATH + " --user=" + getUser() + " --password=" + getPass() + " "
				+ getDbName() + " > " + MYSQL_BKP_PATH + "bkpLuksDb" + gerarNomeComData() + ".sql";
		Runtime bkp = Runtime.getRuntime();
		try {
			bkp.exec(dump);
			System.out.println("Backup realizado!");
			// System.out.println(dump);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void restoreDbMySql() {
		String restauraBkp = "cmd.exe /c " + MYSQL_FOLDER_PATH + " --user=" + getUser() + " --password=" + getPass()
				+ " " + getDbName() + " < " + MYSQL_BKP_PATH + MIRROR_DBNAME_RESTORE_MYSQL;
		try {
			Runtime.getRuntime().exec(restauraBkp);
			System.out.println("Banco restaurado!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String gerarNomeComData() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH.mm.ss");
		Calendar c = Calendar.getInstance();
		String s = sdf.format(c.getTime());
		return s; 
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
