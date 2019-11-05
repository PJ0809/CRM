package freecrm.com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public  class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	
	public static void initialization() {
		
		FileInputStream	file = null;
		try {
			file = new FileInputStream("C:\\Users\\YELLOYOLK\\OneDrive\\SELENIUMEASY\\com\\src\\main\\java\\freecrm\\com\\config\\config.properties");
			prop = new Properties();
			prop.load(file);
		
		
		} catch (FileNotFoundException e) {
		System.out.println("1");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("2");
			e.printStackTrace();
		}
		
		
		
		String browser = prop.getProperty("BROWSER");
		if(browser.equalsIgnoreCase("CHROME")) {
		
		String currentDir = System.getProperty("user.dir");
		String driverspath = currentDir+"\\src\\chromedriver.exe";
		System.setProperty("Webdriver.chrome.com", driverspath);
		driver = new ChromeDriver();
			
		}else {
			
			String currentDir = System.getProperty("user.dir");
			String driverspath = currentDir+"\\src\\geckodriver.exe";
			System.setProperty("Webdriver.gecko.com", driverspath);
			driver = new FirefoxDriver();
				
			}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		int implicitwait = Integer.parseInt(prop.getProperty("IMPLICIT-WAIT"));
		int pageload = Integer.parseInt(prop.getProperty("PAGE-LOAD"));
		driver.manage().timeouts().pageLoadTimeout(pageload, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implicitwait, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
		
	}
	
	public static void close() {
		
		
		driver.quit();
	}

}
