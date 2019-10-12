package com.helloworld.passport.util;

import org.junit.Assert;
import java.util.HashMap;

public class DataParserTest {
    public static void runTest() {
        HashMap<String,String>expectedMap = new HashMap<String, String>();
        expectedMap.put("IDTYPE", "TEST");
        expectedMap.put("NAME", "PURDUE PETE");
        Assert.assertEquals(expectedMap, DataParser.parseDataToMap("IDTYPE:TEST,NAME:PURDUE PETE,"));

        Assert.assertEquals("IDTYPE:TEST,NAME:PURDUE PETE,", DataParser.parseMapToData(expectedMap));
    }
}
