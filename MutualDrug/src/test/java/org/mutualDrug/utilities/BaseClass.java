package org.mutualDrug.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Workbook workbook;
	public static String value;
	public static Sheet sheet;
	public static Cell cell;
	public static Actions a;
	public static Robot r;

	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	public static void launchBrowser(String browser) {
		//RemoteWebDriver driver=null;
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.err.println("undefined browser entered.");
			break;
		}
	}

	public static void launchUrl(String siteUrl) {
		driver.get(siteUrl);
	}

	public static void maxWindow() {
		driver.manage().window().maximize();
	}

	public static void ss(String fileNameHere) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		File destination = new File("./screenshots/" + fileNameHere + ".png");
		FileUtils.copyFile(source, destination);
	}

	public static void input(WebElement WebElementRefName, String yourInput) {
		WebElementRefName.clear();
		WebElementRefName.sendKeys(yourInput);
	}

	public static void btnclick(WebElement element) {
		element.click();
	}

	public static WebElement myXpath(String path) {
		return driver.findElement(By.xpath(path));

	}

	public static WebElement myId(String id) {
		return driver.findElement(By.id(id));

	}
	public static WebElement myId1(String s) {
		return driver.findElement(By.id(s));
	}

	public static WebElement myCss(String cssSelector) {
		return driver.findElement(By.cssSelector(cssSelector));

	}

	public static WebElement myClassName(String className) {
		return driver.findElement(By.className(className));

	}

	public static WebElement myLinkText(String linkText) {
		return driver.findElement(By.linkText(linkText));

	}

	public static WebElement myTagName(String tagName) {
		return driver.findElement(By.tagName(tagName));

	}

	public static String getCurrentUrl() {
		return driver.getCurrentUrl();

	}

	public static String getTitle() {
		return driver.getTitle();

	}

	public static void close() {
		driver.close();
	}

	public static void quit() {
		driver.quit();

	}

	public static void impWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public static void navigateForward() {
		driver.navigate().forward();
	}

	public static void navigateBackword() {
		driver.navigate().back();
	}

	public static void refresh() {
		driver.navigate().refresh();

	}
	
	public static void jclick(WebElement elementName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", elementName);
	}

	


	public static String windowHandle() {
		return driver.getWindowHandle();
	}

	public static Set<String> windowHandles() {
		return driver.getWindowHandles();
	}
	
	public static WebDriver switchToWindow(int i) {
		Set<String> allWin = driver.getWindowHandles();
		List<String> li=new ArrayList<String>();
		li.addAll(allWin);
		return driver.switchTo().window(li.get(i));
	}

	



}
