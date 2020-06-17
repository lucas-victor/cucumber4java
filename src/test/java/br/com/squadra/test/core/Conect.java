package br.com.squadra.test.core;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conect {

	private String dbName;
	private String user;
	private String pass;
	private String server;
	private String port;
	private String connectionUrl;
	private Connection con;

	public Conect() {
	}

	public Conect(String dbName, String user, String pass, String server, String port) {
		this.dbName = dbName;
		this.user = user;
		this.pass = pass;
		this.server = server;
		this.port = port;
	}

	public Connection getConnectionSql() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(getUrlConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	private String getUrlConnection() {
		this.connectionUrl = "jdbc:sqlserver://" + getServer() + ":" + getPort() + ";databaseName=" + getDbName() + ";user=" + getUser()
				+ ";password=" + getPass();
		return this.connectionUrl;
	}
	

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
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

	public String getConnectionUrl() {
		return connectionUrl;
	}

	public void setConnectionUrl(String connectionUrl) {
		this.connectionUrl = connectionUrl;
	}

}
