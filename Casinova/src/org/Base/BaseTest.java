package org.Base;

import java.io.FileInputStream;
import java.util.Properties;

import org.Utils.Excel_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;

public abstract class BaseTest {
	private static final Object[] Object = null;
	public static WebDriver driver;
	public static Properties config;
	public static Properties error;
	public static Properties object;
	public static Properties xlProperties;
	 public static Excel_Reader excel;
	public ExtentReports extent = new ExtentReports();
	public static boolean isTestPass = true;
	// public static ExtentTest extentlogs;

	public static void initialize() {
		// initialize config property file
		try {
			config = new Properties();
			config.load(new FileInputStream("./org.properties/config.properties"));
		}

		catch (Exception e) {
			e.getMessage();
		}
		// initialize error property file
		try {
			error = new Properties();
			error.load(new FileInputStream("./org.properties/error.properties"));
			System.out.println(config.getProperty("megha"));
		} catch (Exception e) {
			e.getMessage();
		}
		// initialize object property file
		try {
			object = new Properties();
			object.load(new FileInputStream("./org.properties/object.properties"));
		}

		catch (Exception e) {
			e.getMessage();
		}

		// initialize xls property file
		try {
			xlProperties = new Properties();
			xlProperties.load(new FileInputStream("./org.properties/xls.properties"));
		}

		catch (Exception e) {
			e.getMessage();
		}
	}

	public void openBrowser() {
		if (config.getProperty("browser").equals("firefox"))
			driver = new FirefoxDriver();
		else if (config.getProperty("browser").equals("chrome"))
			driver = new ChromeDriver();
	}

	public void openURL() {
		driver.get(config.getProperty("url"));
	}

	public void closeBrowser() {
		driver.close();
	}

	public static WebElement getElement(String locator, WebDriver driver) {
		String[] objects = locator.split("-", 2);
		String locatorType = objects[0];
		String locatorvalue = objects[1];
		By by = null;
		WebElement element = null;

		if (locatorType.equals("id")) {
			try {
				by = By.id(locatorvalue);
			} catch (Throwable t) {
				System.out.println("Element not found");
				return null;
			}
		}

		else if (locatorType.equals("name")) {
			try {
				by = By.id(locatorvalue);
			}

			catch (Throwable t) {
				System.out.println("Element not found");
				return null;
			}
		}

		else if (locatorType.equals("tagname")) {
			try {
				by = By.id(locatorvalue);

			} catch (Throwable t) {
				System.out.println("Element not found");
				return null;
			}
		} else if (locatorType.equals("linktext")) {
			try {
				by = By.id(locatorvalue);
			} catch (Throwable t) {
				System.out.println("Element not found");
				return null;
			}
		}

		else if (locatorType.equals("partialLinkText")) {
			try {
				by = By.id(locatorvalue);
			} catch (Throwable t) {
				System.out.println("Element not found");
				return null;

			}
		}

		else if (locatorType.equals("cssSel")) {
			try {
				by = By.id(locatorvalue);
			} catch (Throwable t) {
				System.out.println("Element not found");
				return null;
			}
		}

		else if (locatorType.equals("xPath")) {
			try {
				by = By.id(locatorvalue);

			} catch (Throwable t) {
				System.out.println("Element not found");
				return null;
			}

			if (locatorType.equals("className")) {
				try {
					by = By.id(locatorvalue);
				} catch (Throwable t) {
					System.out.println("Element not found");
					return null;
				}
			}

			else {
				System.out.println("element not identified");
			}
			if (driver.findElements(by).size() > 0) {
				element = driver.findElement(by);

			}

		}
		return element;

	}

}
