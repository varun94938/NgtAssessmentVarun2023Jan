package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {
	public Properties prop;

	public void loadPropertiesFile() {

		prop = new Properties();

		File propFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\data.properties");

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(propFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
