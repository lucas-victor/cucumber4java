package br.com.squadra.test.core;

import static br.com.squadra.test.core.DriverFactory.getDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.exec.OS;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import cucumber.api.Scenario;


public class Report {
	
	private final static String SCREENSHOT_PATH = "target/report-html/screenShot/";
	private final static String RELATIVE_SCREENSHOT_PATH = "screenShot/";
	private final static String REPORT_CONFIG = System.getProperty("user.dir") + "\\src\\test\\resources\\configs\\extent-config.xml";
	private final static String SOURCE_FOLDER_ZIP = System.getProperty("user.dir") + "\\target\\report-html";
	private final static String SOURCE_FOLDER_ZIP_LINUX = System.getProperty("user.dir") + "//target//report-html";
	private final static String REPORT_PATH = System.getProperty("user.dir") + "\\target\\report-html\\";
	private final static String REPORT_PATH_LINUX = System.getProperty("user.dir") + "//target//report-html//";
	
	private final static String SCREENSHOT_FOLDER = System.getProperty("user.dir") + "/target/report-html/screenShot";
	private final static String QUERY_FOLDER_ACT = System.getProperty("user.dir") + "/target/report-html/actualQueryResults"; 
	private final static String QUERY_FOLDER_EXP = System.getProperty("user.dir") + "/src/test/java/expectedQueryResults";
	private final static String LOGGER_FOLDER = System.getProperty("user.dir") + "/target/report-html/logger";
	private final static String SPARK_FOLDER = System.getProperty("user.dir") + "/target/report-html/spark";
	private final static String REPORT_FOLDER = System.getProperty("user.dir") + "/target/report-html";
	
	private final static String SCREENSHOT_FOLDER_LINUX = System.getProperty("user.dir") + "//target//report-html//screenShot";
	private final static String QUERY_FOLDER_ACT_LINUX = System.getProperty("user.dir") + "//target//report-html//actualQueryResults"; 
	private final static String QUERY_FOLDER_EXP_LINUX = System.getProperty("user.dir") + "//src//test//java//expectedQueryResults";
	private final static String LOGGER_FOLDER_LINUX = System.getProperty("user.dir") + "//target//report-html//logger";
	private final static String SPARK_FOLDER_LINUX = System.getProperty("user.dir") + "//target//report-html//spark";
	private final static String REPORT_FOLDER_LINUX = System.getProperty("user.dir") + "//target//report-html";
	
	private TakesScreenshot ss;
	private Scenario scenario;

	public Report() {		
	}
	
	public String getReportConfigPath() {
		return REPORT_CONFIG;
	}
	
	public static Report getReport() {
		return new Report();
	}
	//print tela e salva relatorio - scenario
	public void getScreenShot(Scenario cenario) throws IOException {
		this.ss = (TakesScreenshot) getDriver();
		this.scenario = cenario;
		
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		String ImageName = cenario.getName().trim() + ".jpg";
		String imagePath = SCREENSHOT_PATH + ImageName;
		FileUtils.copyFile(arquivo, new File(imagePath));
		
		/*
		 * cenario.write("Adicionando imagem no relatorio pelo cenario..."); byte []
		 * screenshot = ss.getScreenshotAs(OutputType.BYTES); cenario.embed(screenshot,
		 * "target/png");
		 */
		
		//writeReport("Imagem adicionada no relatorio: " + ImageName);
		
		addImageReport(RELATIVE_SCREENSHOT_PATH + ImageName);
	}
	//print tela e salva relatorio - string
	public void getScreenShot(String printName) {
		this.ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		String ImageName = printName.trim() + ".jpg";
		String imagePath = SCREENSHOT_PATH + ImageName;
		
		try {
			FileUtils.copyFile(arquivo, new File(imagePath));
			//writeReport("Imagem adicionada no relatorio: " + ImageName);
			addImageReport(RELATIVE_SCREENSHOT_PATH + ImageName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//escreve conteudo do arquivo de resultado da query no relatorio.
	public void writeReportSql(String resultFileName) {
		String fullFilePath = QUERY_FOLDER_ACT + "/" + resultFileName ;
		BufferedReader buffRead;
		String linha = "";
		try {
			buffRead = new BufferedReader(new FileReader(fullFilePath));
			while (true) {
				if (linha != null) {
					//System.out.println(linha);
					writeReport(linha);
				} else
					break;
				linha = buffRead.readLine();
			}
			buffRead.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	//escreve no relatorio
	public void writeReport(String msg) {
		ExtentCucumberAdapter.addTestStepLog(msg);
	}
	//adiciona imagem relatorio
	private void addImageReport(String imageName) throws IOException {
		ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(imageName);
	}
	
	public Scenario getScenario() {
		return this.scenario;
	}
	
	//faz backup da pasta de relatorio zip 
	public void zipFolder()  {

		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH.mm.ss");
		String osname = System.getProperty("os.name");
		String nomeDir = "";
		if (osname.equalsIgnoreCase("windows")) {
			nomeDir = System.getProperty("user.dir") + "\\target\\report-html-" + dateFormat.format(date);
		}
		else {
			nomeDir = System.getProperty("user.dir") + "//target//report-html-" + dateFormat.format(date);
		}
		
		new File(nomeDir).mkdir();
		
		File reportDir = null;
		if (osname.equalsIgnoreCase("windows")) {
			reportDir = new File(REPORT_PATH);
		}else {
			reportDir = new File(REPORT_PATH_LINUX);
		}
		
		
		if (reportDir.exists()) {
			String srcFolder = "";
			String destZipFile = "";
			if (osname.equalsIgnoreCase("windows")) {
				srcFolder = SOURCE_FOLDER_ZIP;
				destZipFile = nomeDir + "\\report-html-" + dateFormat.format(date) + ".zip";
			}
			else {
				srcFolder = SOURCE_FOLDER_ZIP_LINUX;
				destZipFile = nomeDir + "//report-html-" + dateFormat.format(date) + ".zip";
			}
			ZipOutputStream zip = null;
			FileOutputStream fileWriter = null;

			try {
				fileWriter = new FileOutputStream(destZipFile);
				zip = new ZipOutputStream(fileWriter);
				
				addFolderToZip("", srcFolder, zip);
				zip.flush();
				zip.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("Backup do relatório realizado com sucesso!");
		}
		else {
			System.out.println("Não há relatórios para backup.");
		}

	}

	private void addFileToZip(String path, String srcFile, ZipOutputStream zip) throws Exception {

		File folder = new File(srcFile);
		String osname = System.getProperty("os.name");
		
		if (folder.isDirectory()) {
			addFolderToZip(path, srcFile, zip);
		} else {
			byte[] buf = new byte[1024];
			int len;
			FileInputStream in = new FileInputStream(srcFile);
			if (osname.equalsIgnoreCase("windows")) {
				zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
			}else {
				zip.putNextEntry(new ZipEntry(path + "//" + folder.getName()));
			}
			while ((len = in.read(buf)) > 0) {
				zip.write(buf, 0, len);
			}
			in.close();
		}
	}

	private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip) throws Exception {
		File folder = new File(srcFolder);
		String osname = System.getProperty("os.name");
		
		for (String fileName : folder.list()) {
			if (path.equals("")) {
				if (osname.equalsIgnoreCase("windows")) {
					addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
				}else {
					addFileToZip(folder.getName(), srcFolder + "//" + fileName, zip);
				}				
			} else {
				if (osname.equalsIgnoreCase("windows")) {
					addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip);
				}
				else {
					addFileToZip(path + "//" + folder.getName(), srcFolder + "//" + fileName, zip);
				}
			}
		}
	}
	
	//limpa pasta de relatorios
	public void limparPastas() {
		String osname = System.getProperty("os.name");
		File pasta1 = null;
		File pasta2 = null;
		File pasta3 = null;
		File pasta4 = null;
		File pasta5 = null;
		
		if (osname.toLowerCase().contains("windows")) {
			pasta1 = new File(SCREENSHOT_FOLDER);
			pasta2 = new File(QUERY_FOLDER_ACT);
			pasta3 = new File(LOGGER_FOLDER);
			pasta4 = new File(SPARK_FOLDER);
			pasta5 = new File(REPORT_FOLDER);
		}else {
			pasta1 = new File(SCREENSHOT_FOLDER_LINUX);
			pasta2 = new File(QUERY_FOLDER_ACT_LINUX);
			pasta3 = new File(LOGGER_FOLDER_LINUX);
			pasta4 = new File(SPARK_FOLDER_LINUX);
			pasta5 = new File(REPORT_FOLDER_LINUX);
		}
		
		System.out.println("Limpando pastas de arquivos...");
		deleteAndCreateFileDirs(pasta5);
		deleteAndCreateFileDirs(pasta4);
		deleteAndCreateFileDirs(pasta3);
		deleteAndCreateFileDirs(pasta2);
		deleteAndCreateFileDirs(pasta1);
		System.out.println("Arquivos deletados! \n");
	}
	//deleta arquivos
	private void deleteFiles(File file) {
		File[] files = file.listFiles();
		for (File file1 : files) {
			
			file1.setWritable(true);
			file1.delete();
		}
	}
	//deleta e recria diretorios
	private void deleteAndCreateFileDirs(File file) {
		if (file.exists()) {
			deleteFiles(file);
			file.mkdir();
		}else {
			file.mkdir();
		}
	}
}
