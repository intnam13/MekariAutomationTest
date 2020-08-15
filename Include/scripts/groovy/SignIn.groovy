import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class SignIn {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */
	@Given("user navigate to amazon website")
	def navigateToAmazonUrl() {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(GlobalVariable.url_amazon)
		WebUI.takeScreenshot()
	}

	@When("user go to sign in screen")
	def go_to_sign_in_screen() {
		WebUI.mouseOver(findTestObject('nav-link-accountList'))
		WebUI.click(findTestObject('button_signIn'))
		WebUI.takeScreenshot()
	}

	@And("user enter (.*)")
	def enter_email(String email){
		if(email == "empty"){
			WebUI.setText(findTestObject('textbox_email'), "")
		}else{
			WebUI.setText(findTestObject('textbox_email'), email)
		}
		WebUI.takeScreenshot()
	}

	@And("user click on continue button")
	def click_on_continue_button(){
		WebUI.click(findTestObject('button_continue'))
	}

	@Then("I verify the (.*)")
	def I_verify_the_status_in_step(String warningMessage) {
		WebUI.delay(1)
		WebUI.verifyTextPresent(warningMessage, false)
		WebUI.takeScreenshot()
	}
}