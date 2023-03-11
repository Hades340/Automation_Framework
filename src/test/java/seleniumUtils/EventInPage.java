package seleniumUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.UtilsActions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class EventInPage {
	public static boolean clickButton(WebDriver driver, By elementFindBy) {
		boolean click = false;
		try {
			WebElement btnClick = driver.findElement(elementFindBy);
			if (!btnClick.isDisplayed()) {
				btnClick.click();
				click = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			UtilsActions.saveErrorToLog(e.getMessage());
		}
		return click;
	}

	public static boolean inputTextField(WebDriver driver, By elementFindBy, String valueInput) {
		boolean input = false;
		try {
			WebElement textField = driver.findElement(elementFindBy);
			if (!textField.isDisplayed()) {
				textField.clear();
				textField.sendKeys(valueInput);
				input = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			UtilsActions.saveErrorToLog(e.getMessage());
		}
		return input;
	}

	public static boolean selectComboboxByValue(WebDriver driver, By elementFindBy, String valueSelect) {
		boolean check = false;
		try {
			WebElement combobox = driver.findElement(elementFindBy);
			Select selectCombobox = new Select(combobox);
			selectCombobox.selectByValue(valueSelect);
			check = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			UtilsActions.saveErrorToLog(e.getMessage());
		}
		return check;
	}

	public static boolean selectComboboxByIndex(WebDriver driver, By elementFindBy, int valueIndex) {
		boolean check = false;
		try {
			WebElement combobox = driver.findElement(elementFindBy);
			Select selectCombobox = new Select(combobox);
			selectCombobox.selectByIndex(valueIndex);
			check = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			UtilsActions.saveErrorToLog(e.getMessage());
		}
		return check;
	}

	public static boolean selectComboboxByVisibleText(WebDriver driver, By elementFindBy, String visibleText) {
		boolean check = false;
		try {
			WebElement combobox = driver.findElement(elementFindBy);
			Select selectCombobox = new Select(combobox);
			selectCombobox.selectByVisibleText(visibleText);
			check = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			UtilsActions.saveErrorToLog(e.getMessage());
		}
		return check;
	}

	public static boolean checkElementInPage(WebDriver driver, By elementFindBy) {
		boolean check = false;
		try {
			boolean element = driver.findElements(elementFindBy).size()>0;
			if (element) {
				check = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			UtilsActions.saveErrorToLog(e.getMessage());
		}
		return check;
	}
	public static List<String> getAllOptionValueInSelectComboBox(WebDriver driver, By elementFindBy) {
		List<String> allOption = new ArrayList<>();
		try {
			WebElement combobox = driver.findElement(elementFindBy);
			Select selectCombobox = new Select(combobox);
			selectCombobox.getOptions().forEach(o -> {
				allOption.add(o.getAttribute("value"));
			});
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			UtilsActions.saveErrorToLog(e.getMessage());
		}
		return allOption;
	} 
	public static boolean switchWindowHasString(WebDriver driver, String stringInWindow) {
		boolean result = false;
		try {
			Set<String> lstWindow = driver.getWindowHandles();
			if (lstWindow.size()>0) {
				for (String window : lstWindow) {
					driver.switchTo().window(window);
					if (driver.getPageSource().contains(stringInWindow)) {
						result = true;
						break;
					}
					else {
						 Thread.sleep(1000);
					}
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			UtilsActions.saveErrorToLog(e.getMessage());
		}
		return result;
	}
	public boolean clickButtonUsingJS(WebDriver driver, By elementFindBy) {
		boolean result = false;
		try {
			WebElement element = driver.findElement(elementFindBy);
			if (!element.isDisplayed()) {
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", element);
				result = true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
			UtilsActions.saveErrorToLog(e.getMessage());
		}
		return result;
	}
	public boolean hoverToElement(WebDriver driver, By findElementBy){
		boolean result = false;
		try {
			WebElement element = driver.findElement(findElementBy);
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
		}catch (Exception e){
			result = false;
			System.out.println(e.getMessage());
			UtilsActions.saveErrorToLog(e.getMessage());
		}
		return result;
	}
 }
