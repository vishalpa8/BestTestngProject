package constants;

import java.net.URISyntaxException;
import java.nio.file.Paths;

public class AppConstants {

    public static String TARGET_FOLDER_LOCATION;

    static{
        try {
            TARGET_FOLDER_LOCATION = Paths.get(AppConstants.class.getResource("/").toURI()).getParent().toString();
        }catch(URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static final String EXTENT_REPORT_LOCATION = "/report/ExtentReport.html";
    public static final String SCREENSHOT_LOCATION = "..\\..\\target\\capturedScreenshot\\";

    private static String DEFAULT_BROWSER = "edge";
    public static String RUN_MODE = "local";
    private static String DEFAULT_APP_URL = "https://devterrystauber.participateloan.com/";

    private static String BROWSER_PROPERTY = "browser";
    private static String BROWSER_RUN_MODE_PROPERTY = "browserRunMode";
    private static String DATA_SOURCE_PROPERTY = "testData.yml";


    public static final String DATA_SOURCE = DATA_SOURCE_PROPERTY;
    public static final String BROWSER = System.getProperty(BROWSER_PROPERTY)!=null ? System.getProperty(BROWSER_PROPERTY) : DEFAULT_BROWSER;
    public static final String BROWSER_RUN_MODE = System.getProperty(BROWSER_RUN_MODE_PROPERTY);
    public static final String APP_URL = DEFAULT_APP_URL;


}
