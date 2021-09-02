package test;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import org.junit.Assert;

import page.FirstPage;

public class AddDataTest {

	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://techfios.com/test/101/index.php");

	}

	@Test
	public void aCheckBox() {

		FirstPage firstPage = PageFactory.initElements(driver, FirstPage.class);
		firstPage.clickToggleAll();
		verifyAllElementsAreCheked();
	}

	// First check one box to remove
	// second click the remove button to remove it
	// Validate that a single list item could be removed
	@Test
	public void bCheckBoxToRemove() {

		FirstPage firstPage = PageFactory.initElements(driver, FirstPage.class);

		String selectedText = firstPage.selectSingleElement();
		firstPage.clickOnRemoveButton();
		verifyElementGotDeleted(selectedText);

	}

	public void verifyAllElementsAreCheked() {

		for (int i = 1; i <= 200; i++) {
			try {
				WebElement curElement = driver
						.findElement(By.xpath("//*[@id=\"todos-content\"]/form/ul/li[" + i + "]/input"));

				Assert.assertEquals("Line no " + i + " is not checked", Boolean.TRUE, curElement.isSelected());
			} catch (NoSuchElementException nse) {
				break;
			}

		}
	}

	public void verifyElementGotDeleted(String originalText) {

		for (int i = 1; i <= 200; i++) {
			try {
				WebElement curElement = driver
						.findElement(By.xpath("//*[@id=\"todos-content\"]/form/ul/li[" + i + "]/input"));

				Assert.assertNotEquals("Line no " + i + " is same as our original text", originalText,
						curElement.getText());
			} catch (NoSuchElementException nse) {
				break;
			}

		}
	}

	// Turn on toggle all
	// click on remove buttonT
	@Test
	public void cVerifyAllListItemsGotDeleted() {

		FirstPage firstPage = PageFactory.initElements(driver, FirstPage.class);
		firstPage.clickToggleAll();
		firstPage.clickOnRemoveButton();
		validateAllGotDeleted(firstPage);
	}

	public void validateAllGotDeleted(FirstPage page) {

		boolean firstLineFound = page.doesSingleElementExsist();

		Assert.assertEquals("At least one item is still remaining after deleting all of them", false, firstLineFound);

	}
}
