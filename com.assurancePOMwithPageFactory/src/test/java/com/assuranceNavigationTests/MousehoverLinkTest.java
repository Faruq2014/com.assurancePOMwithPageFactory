package com.assuranceNavigationTests;

import org.testng.annotations.Test;

import com.assuranceBase.BaseTest;
import com.assuranceNavigationPages.MousehoverLink;

public class MousehoverLinkTest extends BaseTest{
	
	@Test(priority=1,groups= {"functional"})
	public void lifeLineLinkstest() {	
	MousehoverLink ml = new MousehoverLink(driver);
	ml.lifeLineLinks();
	}
	
	@Test(priority=2,groups= {"functional"})
	public void enhanceLoopTest() {
		MousehoverLink ml = new MousehoverLink(driver);
		ml.enhanceLoop();
	}
	
	@Test(priority=3,groups= {"regression"})
	public void MousehoverLinkRegression() {
		MousehoverLink ml = new MousehoverLink(driver);
		ml.MousehoverLinkRegression();
	}

}
