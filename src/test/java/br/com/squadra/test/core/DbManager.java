package br.com.squadra.test.core;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DbManager {
	
	private String mySqlDumpPath = "D:\\xampp\\mysql\\bin\\mysqldump.exe";
	private String BkpAbsolutPath = "D:\\dumpMySql\\meubkpluksdb.sql"; 
	
	private String user = "root";
	private String pass = "";
	private String dbName = "luksdb";
	private String stringConection = "";
	private String host = "";
	
	public DbManager() {	
	}
	
	public DbManager(String user, String pass, String dbName) {
		this.user = user;
		this.pass = pass;
		this.dbName = dbName;
	}
	
	public DbManager(String user, String pass, String dbName, String host) {
		this.user = user;
		this.pass = pass;
		this.dbName = dbName;
		this.host = host;
	}

	public void backupMySql() {
		// bkp
		String dump = "cmd.exe /c "+mySqlDumpPath+" --user="+user+" --password="+pass+" "+dbName+" > " + BkpAbsolutPath;
		Runtime bkp = Runtime.getRuntime();
		try {
			bkp.exec(dump);
			System.out.println(dump);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void restoreMySql() {
		// restaura bkp
		String restauraBkp = "cmd.exe /c D:\\xampp\\mysql\\bin\\mysql --user="+user+" --password="+pass+" "+dbName+" < "
				+ "D:\\dumpMySql\\meubkpluksdb.sql";
		try {
			System.out.println("Restaurando a base.");
			Runtime.getRuntime().exec(restauraBkp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return a data com o horario
	 */
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
	
	public String getStringConection() {
		return stringConection;
	}
	public void setStringConection(String stringConection) {
		this.stringConection = stringConection;
	}
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
}
