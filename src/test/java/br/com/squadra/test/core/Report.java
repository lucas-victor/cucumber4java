package br.com.squadra.test.core;

import static br.com.squadra.test.core.DriverFactory.getDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import cucumber.api.Scenario;


public class Report {
	
	private TakesScreenshot ss;
	private Scenario scenario;
	private String screenShotPath = "target/report-html/ScreenShot/";
	private String relativeScreenShotPath = "ScreenShot/";
	
	public Report() {
		
	}
	
	public String getReportConfigPath() {
		String reportConfigPath = System.getProperty("user.dir") + "\\src\\test\\resources\\configs\\extent-config.xml";
		return reportConfigPath;
	}
	
	public void getScreenShot(Scenario cenario) throws IOException {
		this.ss = (TakesScreenshot) getDriver();
		this.scenario = cenario;
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		String ImageName = cenario.getName().trim() + ".jpg";
		String imagePath = screenShotPath + ImageName;
		FileUtils.copyFile(arquivo, new File(imagePath));
		/*
		 * cenario.write("Adicionando imagem no relatorio pelo cenario..."); byte []
		 * screenshot = ss.getScreenshotAs(OutputType.BYTES); cenario.embed(screenshot,
		 * "target/png");
		 */
		writeReport("Imagem adicionada no relatorio: " + ImageName);
		addImageReport(relativeScreenShotPath + ImageName);
	}
	
	public void getScreenShot(String printName) {
		this.ss = (TakesScreenshot) getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		String ImageName = printName.trim() + ".jpg";
		String imagePath = screenShotPath + ImageName;
		try {
			FileUtils.copyFile(arquivo, new File(imagePath));
			writeReport("Imagem adicionada no relatorio: " + ImageName);
			addImageReport(relativeScreenShotPath + ImageName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void writeReport(String msg) {
		ExtentCucumberAdapter.addTestStepLog(msg);
	}
	
	public void addImageReport(String imageName) throws IOException {
		ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(imageName);
	}
	
	public Scenario getScenario() {
		return this.scenario;
	}
	
	
	public void zipFolder()  {

		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH.mm.ss");

		String nomeDir = System.getProperty("user.dir") + "\\target\\report-html-" + dateFormat.format(date);
		new File(nomeDir).mkdir();

		File reportDir = new File(System.getProperty("user.dir") + "\\target\\report-html\\");
		
		if (reportDir.exists()) {
			String srcFolder = System.getProperty("user.dir") + "\\target\\report-html";
			String destZipFile = nomeDir + "\\report-html-" + dateFormat.format(date) + ".zip";

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
			
			System.out.println("Backup do relatorio realiado com sucesso");
		}
		else {
			System.out.println("Não há relatórios para backup.");
		}

	}

	private void addFileToZip(String path, String srcFile, ZipOutputStream zip) throws Exception {

		File folder = new File(srcFile);
		if (folder.isDirectory()) {
			addFolderToZip(path, srcFile, zip);
		} else {
			byte[] buf = new byte[1024];
			int len;
			FileInputStream in = new FileInputStream(srcFile);
			zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
			while ((len = in.read(buf)) > 0) {
				zip.write(buf, 0, len);
			}
			in.close();
		}
	}

	private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip) throws Exception {
		File folder = new File(srcFolder);

		for (String fileName : folder.list()) {
			if (path.equals("")) {
				addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
			} else {
				addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip);
			}
		}
	}

	public void limparPastas() {
		String screenShotPath = System.getProperty("user.dir") + "/target/report-html/ScreenShot";
		String loggerPath = System.getProperty("user.dir") + "/target/report-html/Logger";
		String sparkPath = System.getProperty("user.dir") + "/target/report-html/Spark";
		String reportPath = System.getProperty("user.dir") + "/target/report-html";
		
		File pasta1 = new File(screenShotPath);
		File pasta2 = new File(loggerPath);
		File pasta3 = new File(sparkPath);
		File pasta4 = new File(reportPath);
		
		System.out.println("Limpando pastas de arquivos...");
		if (pasta4.exists()) {
			deleteFiles(pasta4);
			pasta4.mkdir();
		}
		else {
			pasta4.mkdir();
		}
		
		if (pasta3.exists()) {
			deleteFiles(pasta3);
			pasta3.mkdir();
		}else {
			pasta3.mkdir();
		}
		
		if (pasta2.exists()) {
			deleteFiles(pasta2);
			pasta2.mkdir();
		}else {
			pasta2.mkdir();
		}
		
		if (pasta1.exists()) {
			deleteFiles(pasta1);
			pasta1.mkdir();
		}else {
			pasta1.mkdir();
		}
		System.out.println("Arquivos deletados! \n");
	}
	
	private void deleteFiles(File file) {
		File[] files = file.listFiles();
		for (File file1 : files) {
			
			file1.setWritable(true);
			file1.delete();
		}
	}
}
