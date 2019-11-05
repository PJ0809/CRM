package freecrm.com;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import freecrm.com.base.BaseClass;
import freecrm.com.pages.HomePage;
import freecrm.com.pages.LogInPage;
import junit.framework.Assert;

public class LoginPageTest extends BaseClass{
	
	public static void main(String[] args) {
		
		
		initialization();
		LogInPage login = new LogInPage();
	
		
		login.Login(prop.getProperty("Username"),prop.getProperty("Password"));

		
	    String title = login.LogInTitle();
	    Assert.assertEquals(title, "Comgmento CRM");
	    
		close();
	
	}

}
    