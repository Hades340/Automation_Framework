package Actions;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utils.UtilsActions;

public class LoginFourWayAction {
    public boolean checkLoginScreen(AppiumDriver<MobileElement> appiumDriver) {
        boolean result = false;
        try {
            Thread.sleep(8000);
            MobileElement buttonLogin = appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.widget.Button[1]");
            buttonLogin.click();
            result = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            UtilsActions.saveErrorToLog(e.getMessage());
        }
        return result;
    }
    public boolean inputLoginScreen(AppiumDriver<MobileElement> appiumDriver,String username, String password) {
        boolean result = false;
        try {
            Thread.sleep(1000);
            MobileElement usernameEl = appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]");
            usernameEl.sendKeys(username);
            MobileElement passwordEl = appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]");
            passwordEl.sendKeys(password);
            MobileElement btnLogin = appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button");
            btnLogin.click();
            result = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            UtilsActions.saveErrorToLog(e.getMessage());
        }
        return result;
    }
    public boolean checkHomePageLogin(AppiumDriver<MobileElement> appiumDriver){
        boolean result = false;
        try {
            MobileElement clickHome = appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]");
            clickHome.click();
            result = true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            UtilsActions.saveErrorToLog(e.getMessage());
        }
        return result;
    }
}
