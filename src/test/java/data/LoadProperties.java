package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

	public static Properties userData 
	= loaProperties(System.getProperty("user.dir") + "/src/main/java/properties/userdata.properties");

	public static Properties loaProperties(String path) {
		Properties pro = new Properties();		
		try {
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Error occurred: " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error occurred: " + e.getMessage());
		}

		return pro;
	}
}
