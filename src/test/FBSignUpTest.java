package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignUpTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		// click on Create new Account

		WebElement signUp = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		signUp.click();

		WebElement fName = driver.findElement(By.xpath("//input[@name='firstname']"));
		WebElement lName = driver.findElement(By.xpath("//input[@name='lastname']"));
		WebElement mobile = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));

		fName.sendKeys("John");
		lName.sendKeys("White");
		mobile.sendKeys("99999999999");
		password.sendKeys("Anc@1234");

		List<WebElement> allMonths = driver.findElements(By.xpath("//select[@id='month']"));
		for (WebElement x : allMonths) {
			System.out.println(x.getText());
		}

		WebElement day = driver.findElement(By.xpath("//select[@title='Day']"));
		Select ddDay = new Select(day);
		ddDay.selectByVisibleText("10");
		// ddDay.selectByValue("10");

		Thread.sleep(2000);

		WebElement Month = driver.findElement(By.xpath("//select[@title='Month']"));
		Select ddMonth = new Select(Month);
		ddMonth.selectByVisibleText("Jan");

		WebElement Year = driver.findElement(By.xpath("//select[@title='Year']"));
		Select ddYear = new Select(Year);
		ddYear.selectByVisibleText("2000");

		String Gender = "Female";

		String genderXpath = "//label[text()='placeholder']"; 
		String newXpath = genderXpath.replace("placeholder", Gender);

		//String newXpath = "//label[text()='" + Gender + "']";

		WebElement genderElem = driver.findElement(By.xpath(newXpath));
		genderElem.click();

		driver.quit();

	}

}
