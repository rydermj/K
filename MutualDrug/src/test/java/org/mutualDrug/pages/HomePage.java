package org.mutualDrug.pages;

import org.mutualDrug.utilities.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-file-text']")
	private WebElement memberApplication;
	
	@FindBy(css="i.fa.fa-user")
	private WebElement member;
	
	@FindBy(xpath="//span[text()='Details']")
	private WebElement details;
	
	@FindBy(xpath="//a[@class='nav-link router-link-active']")
	private WebElement users;
	
	@FindBy(xpath="//a[@routerlink='members/roles']//span[1]")
	private WebElement roles;

	public WebElement getMemberApplication() {
		return memberApplication;
	}

	public WebElement getMember() {
		return member;
	}

	public WebElement getDetails() {
		return details;
	}

	public WebElement getUsers() {
		return users;
	}

	public WebElement getRoles() {
		return roles;
	}
	
	
	

}
