import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListBox {
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		/*WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/mege/Desktop/findEle.html");
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int count=allLinks.size();
		System.out.println(count);
		allLinks.get(1).click();*/

		//print the no of links present on the web page	
		/*WebDriver driver=new ChromeDriver();
		driver.get("http://www.flipkart.com");
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		  List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int count=allLinks.size();
		System.out.println(count);*/

		//	print the text and url present on the web page	
		/*	WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/mege/Desktop/findEle.html");
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		for (WebElement al : allLinks) {
		String text = al.getText();	
		String url = al.getAttribute("href");
		System.out.println(text);
		System.out.println(url);
		}
		for (int i = 0; i < allLinks.size(); i++) {
			WebElement link = allLinks.get(i);
			String text = link.getText();
			String url = link.getAttribute("href");
			System.out.println(text+"--> "+url);*/

		//Autosuggestion
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		driver.findElement(By.id("lst-ib")).sendKeys("java");
		List<WebElement> allLinks = driver.findElements(By.xpath("//div[contains(text(),'java')]"));
		System.out.println(allLinks.size());
		allLinks.forEach((e) -> System.out.println(e.getText()));
		allLinks.get(0).click();
		
		/*for (WebElement link : allLinks) {
			
			System.out.println(link.getText());
		}
		//allLinks.get(0).click();
		
	
		//driver.close();

*/
	}

}






