package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Trademart_ReadConfig {
	Properties pro;
	public Trademart_ReadConfig() {

	File f=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Trademart.properties");
 try {
	 FileInputStream fis=new FileInputStream(f);
	 pro=new Properties();
	 pro.load(fis);
	 
 }catch(Exception e) {
	 System.out.println(e.getMessage());
 }


}


public String ApplicationURL() {
	String url=pro.getProperty("baseURL");
	return url;
	
}

public String Email() {
	String email=pro.getProperty("Email");
	return email;
}

public String Password() {
	String pwd=pro.getProperty("Password");
	return pwd;


}
}
