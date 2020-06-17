package br.com.squadra.test.core;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conect {

	private String dbName;
	private String user;
	private String pass;
	private String server;
	private String port;
	private String connectionUrl = "";
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
			con = DriverManager.getConnection(getConnectionUrl());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	private String getConnectionUrl() {
		this.connectionUrl = "jdbc:sqlserver://" + server + ":" + port + ";databaseName=" + dbName + ";user=" + user + ";password=" + pass;
		return this.connectionUrl;
	}
	
}
