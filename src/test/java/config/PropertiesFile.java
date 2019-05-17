package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import actual_test.TestNGDemo;

public class PropertiesFile {
	static Properties prop = new Properties() ;
	static String projectPath = System.getProperty("user.dir") ;
	
	public static void main(String[] args) {
		getProperties();
		setProperties();
	}
	
	public static void getProperties() {
		try {			
			InputStream inputStream = new FileInputStream(projectPath + "/src/test/java/config/config.properties") ;
			prop.load(inputStream);
			String browser = prop.getProperty("browser") ;
			System.out.println(browser);
			TestNGDemo.browserName = browser ;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static void setProperties() {
		try {
			OutputStream output = new FileOutputStream(projectPath + "/src/test/java/config/config.properties") ;
			prop.setProperty("url", "www.google.co.in") ;
			prop.store(output, projectPath) ;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
