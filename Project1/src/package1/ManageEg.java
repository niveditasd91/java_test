package package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManageEg {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.get("http:\\google.com");

		driver.get("http:\\www.naukri.com");
		//driver.quit();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

}}
