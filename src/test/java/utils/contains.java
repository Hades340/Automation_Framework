package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.MediaType;

public class contains {
	public static final String dataFolder = "data/";
	public static String fileExcelName = "";
	public static String sheetName = "";
	public static String testCaseName = "";
	public static final String pass = "PASS";
	public static final String fail = "FAIL";
	public static final int TIME_WAITING = 30;
	public static  String folderReprotLocation = "reports/" + getCurrentDateTime("yyyyMMdd-HHmmss") + "/";
	public static final String folderImgReport = "imgReport/";
	public static final String folderVideoReport = "videoReport/";
	// cấu hình url cho insert API
	public static final String url = "http://localhost:8085/";
	public static final String urlUI = "http://localhost:8081/";
	public static final String report = "report/";
	public static final String ApiTestSuite = "api/testsuite/";
	public static final String ApiTestCase = "api/testcase/";
	public static final String ApiTestCases = "api/testcases/";
	public static final String ApiTestLog = "api/testlog/";
	public static final String ApiTestLogs = "api/testlogs/";
	public static final String ApiImg = "api/img/";
	public static final String ApiVideo = "api/video/";

	public static final String apiRegression = "api/regression/save";
	// cấu hình cho API thư viện OKHttp
	public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
	public static final MediaType MEDIA_TYPE_JPG = MediaType.parse("image/jpeg");
	public static final MediaType MEDIA_TYPE_VIDEO = MediaType.parse("video/mp4");
	public static StringBuilder errorLog;
	// kiểm tra xem có sendtoserver hay ko 
	public static int sendToServer = 0; // 1 -> send to server
	
	// Current time
	public static String getCurrentDateTime(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date timenow = new Date();
		String strtimenow = sdf.format(timenow);
		return strtimenow;
	}

	public static String getCurrentTime2() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
		Date timenow = new Date();
		String strtimenow = sdf.format(timenow);
		return strtimenow;
	}

	public static String getCurrentDay2() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date timenow = new Date();
		String strtimenow = sdf.format(timenow);
		return strtimenow;
	}

	public static int rowNumber(String no) {
		return Integer.valueOf(no);
	} 
	// sử dụng cho phần report
		public static String pattern = "yyyy-MM-dd HH:mm:ss";
		public static SimpleDateFormat formatDate = new SimpleDateFormat(pattern);
		public static String patternMilliS = "SSSS";
		public static SimpleDateFormat formatMillisecond = new SimpleDateFormat(patternMilliS);
		public static SimpleDateFormat formateTimeStamp = new SimpleDateFormat("HH:mm:ss");
		public static String timeDateReport(Date date) {
			return formatDate.format(date);
		}
}
