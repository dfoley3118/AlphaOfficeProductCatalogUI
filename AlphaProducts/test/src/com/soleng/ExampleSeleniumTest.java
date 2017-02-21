package com.soleng;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class ExampleSeleniumTest {
	private WebDriver driver;

	private final String URL = "http://140.86.32.144/AlphaProducts/viewrecords";

	@Before
	public void setUp() throws Exception {
		this.driver = new HtmlUnitDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		if (driver != null)
			this.driver.quit();
	}

	@Test
	public void testPageConnection() throws Exception {
		this.driver.get(URL);
		assertEquals("Hello World", this.driver.getTitle());
	}

	@Test
	public void testCrayolaMarkersFound() throws Exception {
		// setup
		System.out.println("Starting test " + new Object() {
		}.getClass().getEnclosingMethod().getName());
		driver.get(URL);

		// execute
		List<WebElement> elements = driver.findElements(By.xpath(".//*[@id='products']/h4"));
		boolean found = false;
		for (WebElement element : elements) {
			System.out.println("element:  " + element.getText());
			if (element.getText().contains("Crayola Original Markers - Broad Line, Classic Colors")) {
				found = true;
				break;
			}
		}

		// assert
		assertTrue(found);
	}
}
