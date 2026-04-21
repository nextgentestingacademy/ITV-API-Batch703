package utils;

import java.io.FileInputStream;
import java.util.Properties;

import io.restassured.RestAssured;

public class ConfigReader {
	
	public ConfigReader() {
		loadConfig();
	}
	
	public void loadConfig() {
		Properties prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("src/test/resources/config.properties");
			prop.load(fis);
			String baseurl = prop.getProperty("serverUrl");
			RestAssured.baseURI = baseurl;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
