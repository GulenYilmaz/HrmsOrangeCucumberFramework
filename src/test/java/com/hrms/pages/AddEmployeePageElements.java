package com.hrms.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class AddEmployeePageElements extends BaseClass{

	@FindBy(id="firstName")
	public WebElement firstName;
	
	
	@FindBy(id="middleName")
	public WebElement middleName;
	
	
	@FindBy(id="lastName")
	public WebElement lastName;
	
	@FindBy(id="employeeId")
	public WebElement empId;	
	
	@FindBy(id="chkLogin")
	public WebElement createLoginDetailsBtn;
	
	@FindBy(id="user_name")
	public WebElement userName;
	
	
	@FindBy(id="user_password")
	public WebElement password;
	
	@FindBy(id="re_password")
	public WebElement confirmPassword;
	
	@FindBy(id="btnSave")
	public WebElement saveBtn;
	
	public static void addEmployee(String firstName, String middleName, String lastName, String userName, String password) {
		AddEmployeePageElements addEmp=new AddEmployeePageElements();
		CommonMethods.sendText(addEmp.firstName, firstName);
		CommonMethods.sendText(addEmp.middleName, middleName);
		CommonMethods.sendText(addEmp.lastName, lastName);
		
		CommonMethods.jsClick(addEmp.createLoginDetailsBtn);
		
		CommonMethods.sendText(addEmp.userName, userName);
		CommonMethods.sendText(addEmp.password, password);
		CommonMethods.sendText(addEmp.confirmPassword, password);
		
		CommonMethods.jsClick(addEmp.saveBtn);	
	}
	
	public AddEmployeePageElements() {
		PageFactory.initElements(driver, this);
	}
}