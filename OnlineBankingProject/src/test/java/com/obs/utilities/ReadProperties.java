package com.obs.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {

	
	public static String readProp(String KeyName) throws IOException {
		FileInputStream fis = new FileInputStream(new File("src/test/resources/ev.properties"));
		
		Properties p = new Properties();
		p.load(fis);
		
		return p.getProperty(KeyName);
	}
}
