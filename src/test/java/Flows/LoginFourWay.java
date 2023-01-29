package Flows;

import Actions.LoginFacebookActions;
import Actions.LoginFourWayAction;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import readExcel.dataMap;
import readExcel.excelFile;
import utils.UtilsActions;
import utils.contains;
import utils.setup;

import java.util.Map;

import static org.testng.Assert.assertTrue;

public class LoginFourWay extends setup {
    private final LoginFourWayAction login = new LoginFourWayAction();
    @Test(dataProvider = "loginFourWay",priority = 1)
    public void testForLoginPage(String No, String Testname, String Username, String Password, String Alert) {
        int row = Integer.parseInt(No);
        try {
            assertTrue(login.checkLoginScreen(appiumDriver));
            testLogs.log(LogStatus.PASS, "Check screen login success. ", "");
            assertTrue(login.inputLoginScreen(appiumDriver,Username,Password));
            testLogs.log(LogStatus.PASS, "Input username and password success", "");
            assertTrue(login.checkHomePageLogin(appiumDriver));
            testLogs.log(LogStatus.PASS, "Check home page success", "");
            testLogs.log(LogStatus.PASS, Testname+" testcase pass", "");
            excelFile.setPass(dataMap.login.Result.ordinal(), row, dataMap.login.Error.ordinal());
        } catch (AssertionError e) {
            // TODO: handle exception
            UtilsActions.saveErrorToLog(e.getMessage());
            excelFile.setFail(dataMap.login.Result.ordinal(), row, dataMap.login.Error.ordinal());
            testLogs.log(LogStatus.FAIL, Testname+" testcase failed", "");
            assertTrue(false);
        }
    }
    @DataProvider(name ="loginFourWay")
    public static Object[][] getData(ITestContext context){
        Map<String, String> testParams = context.getCurrentXmlTest().getLocalParameters();
        String testData = testParams.get("exelData");
        System.out.println(testData);
        excelFile.getSetUp(testData);

        excelFile.setExcelInfo(contains.dataFolder + contains.fileExcelName, contains.sheetName);
        return excelFile.getData(contains.testCaseName,
                dataMap.login.Result.ordinal(),
                dataMap.login.Testname.ordinal());
    }
}
