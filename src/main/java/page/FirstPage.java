package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.junit.Assert;

public class FirstPage {

	WebDriver driver;

	public FirstPage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"todos-content\"]/form/ul/li[1]/input")
	WebElement SELECT_SINGLE_ELEMENT;

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/input[1]")
	WebElement REMOVE_BUTTON_ELEMENT;

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/input[3]")
	WebElement TOGGLE_ALL_CHECKBOX;

// //*[@id="todos-content"]/form/ul/li[2]/input

//	@FindBy(how = How.XPATH, using = "//*[@id=\"todos-content\"]/form/ul/li[1]/input")
//	WebElement FIRST_ELEMENT;
//
//	@FindBy(how = How.XPATH, using = "//*[@id=\"todos-content\"]/form/ul/li[2]/input")
//	WebElement second_element;
//
//	@FindBy(how = How.XPATH, using = "//*[@id=\"todos-content\"]/form/ul/li[3]/input")
//	WebElement third_element;

	public void clickToggleAll() {
		TOGGLE_ALL_CHECKBOX.click();

	}

	public String selectSingleElement() {
		SELECT_SINGLE_ELEMENT.click();
		return SELECT_SINGLE_ELEMENT.getText();

	}

	public void clickOnRemoveButton() {
		REMOVE_BUTTON_ELEMENT.click();
	}

	public boolean doesSingleElementExsist() {
		try {
			SELECT_SINGLE_ELEMENT.getTagName();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

}
