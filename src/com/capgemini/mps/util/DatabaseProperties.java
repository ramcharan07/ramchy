  
package com.capgemini.mps.util;  


import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class DatabaseProperties {
	public  static Properties loadProperties(){
		File file=new File("resource\\database.properties");
		if(file.exists() && file.canRead()){
			try(
					FileInputStream fis=new FileInputStream(file);
					){
				Properties properties=new Properties();
				properties.load(fis);
				return properties;
			}catch(IOException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}
		else{
			System.out.println("unable to open the file");
			return null;
		}

	}
} 
 

