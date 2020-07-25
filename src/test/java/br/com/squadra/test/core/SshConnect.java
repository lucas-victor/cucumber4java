package br.com.squadra.test.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;

import com.jcraft.jsch.*;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SshConnect {

	private JSch ssh = null;
	private Session session = null;
	private Channel channel = null;
	private BufferedReader reader = null;
	private String usuario = "";
	private String senha = "";
	private int porta = 0;
	private String host = "";
	private boolean ready = false;
	private String commandOutPut = "";
	
	
	public static void main(String[] args) throws JSchException {
//		SshConnect ssh = new SshConnect("luks", "Lav150516", "192.168.15.23", 22);
//		System.out.println(ssh.executeCommandBash("ls"));
		//SshConnect.getSshConnection().executeCommandBash("ls ~/Downloads/");
		//SshConnect.getSshConnection().executeCommandBash("ls ~/Downloads/");
		SshConnect.getSshConnection().download("~/Downloads/teamviewer_15.5.3_amd64.deb", "D:\\testBackupSql");
	}

	public static SshConnect getSshConnection() {
		return new SshConnect("luks", "Lav150516", "192.168.15.23", 22);
	}

	public SshConnect(String usuario, String senha, String host, int porta) {

		try {

			this.ssh = new JSch();
			this.usuario = usuario;
			this.senha = senha;
			this.host = host;
			this.porta = porta;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean connect() throws JSchException {

		try {
			
			session = ssh.getSession(this.usuario, this.host, this.porta);
			session.setPassword(this.senha);
			session.setConfig("StrictHostKeyChecking", "no");
			session.connect(30000);
			setSession(session);
			setReady(true);

			return true;
		} catch (Exception e) {
			setReady(false);
		}
		return false;
	}

	public void close() {

		if (channel != null)
			channel.disconnect();

		if (session != null)
			session.disconnect();

		setReady(false);
	}

	public String executeCommandBash(String comando) {

		try {
			connect();
			channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand(comando);
			setCommandOutput(channel.getInputStream());
			//InputStream reader = channel.getInputStream();
			channel.connect(30000);

			StringBuilder sBuilder = new StringBuilder();
			String lido = reader.readLine();

			while (lido != null) {
				sBuilder.append(lido);
				sBuilder.append("\n");
				lido = reader.readLine();
			}
			close();
			System.out.println(sBuilder.toString());
			return sBuilder.toString();

		} catch (Exception e) {
			close();
			e.printStackTrace();
		}
		return null;
	}
	
	public void setCommandOutput(InputStream input) {
		 this.reader = new BufferedReader(new InputStreamReader(input));
	}

	public boolean upload(String origem, String dirDestino) {

		try {
			File origem_ = new File(origem);
			dirDestino = dirDestino.replace(" ", "_");
			String destino = dirDestino.concat("/").concat(origem_.getName());
			return upload(origem, destino, dirDestino);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean upload(String origem, String destino, String dirDestino) {

		try {
			ChannelSftp sftp = (ChannelSftp) session.openChannel("sftp");
			sftp.connect();
			dirDestino = dirDestino.replace(" ", "_");
			sftp.cd(dirDestino);
			sftp.put(origem, destino);
			sftp.disconnect();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean download(String arquivoRemoto, String arquivoLocal) {

		try {
			connect();
			ChannelSftp sftp = (ChannelSftp) session.openChannel("sftp");
			sftp.connect();
			sftp.get(arquivoRemoto, arquivoLocal);
			sftp.disconnect();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	public boolean isReady() {
		return ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}
	
	public String getCommandOutPut() {
		return commandOutPut;
	}

	public void setCommandOutPut(String commandOutPut) {
		this.commandOutPut = commandOutPut;
	}

}
