package com.assuranceNavigationPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MousehoverLink {
	WebDriver driver;
		public MousehoverLink(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//@FindBys(xpath="ul[class *='cosmos-navbar-right list-unstyled']>li")  private List<WebElement>  links; 
	public void lifeLineLinks() {
		System.out.println("<<<<<<<<<<how many links on navigation bar.>>>>>>>>>>>");
	 List<WebElement>links=driver.findElements(By.cssSelector("ul[class *='cosmos-navbar-right list-unstyled']>li"));
	//List<WebElement> links=driver.findElements(By.linkText("Lifeline Service"));
	int size=links.size();
	System.out.println(" the navigation size "+size);
	
	for (int i = 0; i <size; i++) {
		WebElement ele=links.get(i);
		//System.out.println(ele.getAttribute("innerHTML"));
		System.out.println(ele.getText());
		
	}
	}
	
	public void enhanceLoop() {
		System.out.println("<<<<<<<<<<how many links on navigation bar with enhance loop.>>>>>>>>>>>");
	List<WebElement> links =driver.findElements(By.cssSelector("ul[class *='cosmos-navbar-right list-unstyled']>li"));
	
	for (WebElement i : links) {
		System.out.println(i.getText());
	}

	}
	
	
	public void MousehoverLinkRegression() {
		this.lifeLineLinks();
		this.enhanceLoop();
	}
	
	


}
