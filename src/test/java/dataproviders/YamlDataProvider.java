package dataproviders;

import org.testng.annotations.DataProvider;
import tests.Base.BaseTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Map;

public class YamlDataProvider {


    @DataProvider(name = "testData-dataSource")
    public static Object[][] getData(Method method){
        final String DATA_MODE_PROPERTY = "test.dataMode";
        final String DEFAULT_DATA_MODE = "regression";

        String testDataMode = System.getProperty(DATA_MODE_PROPERTY)!=null?System.getProperty(DATA_MODE_PROPERTY) : DEFAULT_DATA_MODE;
        String className = method.getDeclaringClass().getName();
        className = className.substring(className.lastIndexOf('.') + 1);

        System.out.println("In the Data: " + className + '.' + method.getName() + '.' + testDataMode);

        ArrayList<Map<String,Object>> list = BaseTest.yamlDataReader.getList
                (className + "." + method.getName() + "." + testDataMode);

        Object[][] data = new Object[list.size()][1];
        int row = 0;
        int col = 0;

        for (Map<String,Object> mapValue : list){
            data[row][col] = mapValue;
            row++;
        }


        return data;
    }

}