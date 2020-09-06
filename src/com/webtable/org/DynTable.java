package com.webtable.org;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynTable {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\user\\eclipse-workspace\\WebTable\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.worldometers.info/coronavirus/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		String Cr;
		Cr = "USA";
		/*
		 * List<WebElement> header = driver.findElements(By.xpath(
		 * "//table[@id='main_table_countries_today']/thead/tr/th")); for (int i = 0; i
		 * < header.size(); i++) {
		 * //System.out.println(header.get(i).getText().replaceAll("/n", " ")); }
		 */
		List<WebElement> body = driver.findElements(By.xpath("//table[@id='main_table_countries_today']/tbody/tr"));
		for (int i = 0; i < body.size(); i++) {
			//String rowData = body.get(i).getText();
			//System.out.println(body.get(j).getText());
			List<WebElement> cellBody = driver.findElements(By.xpath("//table[@id='main_table_countries_today']/tbody/tr["+i+"]/td"));
			for (int k = 0; k < cellBody.size(); k++) {
				//String columndata = cellBody.get(k).getText();
				if (cellBody.get(k).getText().contains(Cr)) {
					System.out.println(cellBody.get(1).getText());
					System.out.println(cellBody.get(2).getText());
					System.out.println(cellBody.get(4).getText());
					System.out.println(cellBody.get(6).getText());
					System.out.println(cellBody.get(7).getText());
				}
			}

		}

	}
}
