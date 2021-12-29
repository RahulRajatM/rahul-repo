package demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyData {

	public static void main(String[] args) throws IOException {
		//create java representation of physical file
		FileInputStream fis= new FileInputStream("./data/commondata.properties");
		//load file 
		Properties p= new Properties();
		p.load(fis);
		String url = p.getProperty("url");
		System.out.println(url);
	}
}
