package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class config {
    public static Properties property() throws IOException {
		Properties prop = new Properties();
		// FileInputStream ip = new FileInputStream(".\\Configuration\\digital.properties");
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/Configuration/digital.properties");
		prop.load(ip);
		return prop;
	}

	public static String getProperty(String key) throws IOException {
		return property().getProperty(key);
	}
}
