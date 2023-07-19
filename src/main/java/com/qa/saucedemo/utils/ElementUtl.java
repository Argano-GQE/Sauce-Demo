package com.qa.saucedemo.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * 
 * @author RaviNelluri
 *
 */
public class ElementUtl {

	private WebDriver driver;

	public ElementUtl(WebDriver driver) {
		this.driver = driver;

	}

	/**
	 * 
	 * @param locator
	 * @return WebElement
	 */
	public WebElement getElement(By locator) {

		WebElement element = null;

		try {
			element = driver.findElement(locator);
		} catch (NoSuchElementException e) {
			System.out.println("Getting element exception ..please check the locator again");
			e.printStackTrace();
		}

		return element;

	}

	public void sendKeys(By locator, String value)  {
		
		if (value == null) {
			System.out.println("Value can not be null while using sendkeys method");
			//throw new FrameworkExcepetion("Value Can not be Null");

		}

		getElement(locator).sendKeys(value);

	}

	public void doClick(By locator) {
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getElement(locator).click();

	}

	public String getElementText(By locator) {

		String eleText = getElement(locator).getText();
		System.out.println("Element Text is ->" + eleText);
		return eleText;

	}

	public boolean checkElementIsDisplayed(By locator) {

		return getElement(locator).isDisplayed();

	}

	public String getElementAttribute(By locator, String attrName) {

		return getElement(locator).getAttribute(attrName);

	}

	public boolean checkElementlsDisabled(By locator) {
		String disabledValue = getElement(locator).getAttribute("disabled");
		if (disabledValue.equals("true")) {
			return true;
		}
		return false;

	}

	public List<WebElement> getElements(By locator) {
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return driver.findElements(locator);

	}

	public int getElementsCount(By locator) {

		return getElements(locator).size();

	}

	public List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String text = e.getText();
			if (!text.isEmpty()) {
				eleTextList.add(text);
			}
		}

		return eleTextList;
	}

}
