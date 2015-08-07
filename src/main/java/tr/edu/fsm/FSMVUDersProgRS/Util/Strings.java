package tr.edu.fsm.FSMVUDersProgRS.Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Strings {
	static Properties prop = new Properties();
	static InputStream input = null;

	public static String getStrings(String key) {
		try {

			input = new FileInputStream("strings.properties");

			// load a properties file
			prop.load(input);

		} catch (

		IOException ex)

		{
			ex.printStackTrace();
		} finally
		{
			
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}

		// get the property value and print it out
		return prop.getProperty(key);
	}

}
