package mytestpack;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class jibe {
	public static void main(String[] args){
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://demo.cc.staging.jibe.com/recruiters/login");
		driver.findElement(By.xpath("//input[@ng-model='username']")).sendKeys("demo@jibe.com");
		driver.findElement(By.xpath("//input[@ng-model='password']")).sendKeys("jibejibe1124");
		driver.findElement(By.xpath("//input[@ng-model='password']")).submit();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='add-candidate-btn']")));
		
		driver.findElement(By.xpath("//*[@class='add-candidate-btn']")).click();
		driver.findElement(By.id("manual-entry-btn")).click();
		
		driver.findElement(By.name("givenName")).sendKeys("Hanan");
		driver.findElement(By.name("familyName")).sendKeys("Basuony");
		driver.findElement(By.name("primaryEmail")).sendKeys("test231-22ww34-23536@gmail.com");
		
		driver.findElement(By.name("givenName")).submit();
		
		
		WebDriverWait waitMail = new WebDriverWait(driver, 30);
		WebElement elementMail = waitMail.until(
		        ExpectedConditions.visibilityOfElementLocated(By.id("email-candidate-btn")));
		
		driver.findElement(By.id("email-candidate-btn")).click();
		driver.findElement(By.name("subject")).sendKeys("Welcome to Jibe");
		
		
		WebDriverWait waitFrame = new WebDriverWait(driver, 30);
		WebElement elementFrame = waitFrame.until(
		        ExpectedConditions.visibilityOfElementLocated(By.id("uiTinymce0_ifr")));
		
		WebElement editorFrame = driver.findElement(By.id("uiTinymce0_ifr"));
		driver.switchTo().frame(editorFrame);
		driver.findElement(By.tagName("body")).sendKeys("Thank you for submitting you information, we will contact you soon.");
		
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//button[contains(text(), 'Preview Email')]")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'Send Email')]")).click();
		
	}
}
