package cn.app.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
	//����ģʽ
	///private static ConfigManager configManager;
	//����ģʽ
	///private static ConfigManager configManager = new ConfigManager();
	private static ConfigManager configManager = ConfigManagerHelper.CM;
	///private static ConfigManager configManager;
	
	private Properties props;
	
	private ConfigManager() {
		props=new Properties();
		String configFile = "database.properties";
		InputStream is=ConfigManager.class.getClassLoader().getResourceAsStream(configFile);
		try {
			props.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*//ͬ�� 
	public static synchronized ConfigManager getInstance() {
		//����ģʽ
		if(configManager == null) {
			configManager = new ConfigManager();
		}
		
		return configManager;
	}*/
	
	//����ģʽ
	/*public static ConfigManager getInstance() {
		configManager = ConfigManagerHelper.CM;
		return configManager;
	}*/
	//************************************
	public static ConfigManager getInstance() {
		//configManager = new ConfigManager();
		//configManager = ConfigManagerHelper.CM;
		return configManager;
	}
	
	public static class ConfigManagerHelper {
		private static final ConfigManager CM = new ConfigManager();
	}
	
	
	public String getValue(String key) {
		return props.getProperty(key);
	}
}
