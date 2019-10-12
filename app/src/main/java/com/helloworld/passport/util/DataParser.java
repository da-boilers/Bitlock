package com.helloworld.passport.util;

import java.util.HashMap;
import java.util.Map;

/*
Converts data format a:
"IDTYPE":"(IDTYPE)","NAME":"(NAME)",...
To a java-friendly hash map
 */

public class DataParser {
    public static HashMap<String, String> parseDataToMap(String data) {
        HashMap<String, String> parsedData = new HashMap<String, String>();
        String[] splitData = data.split(",");
        for(String keyPair: splitData) {
            parsedData.put(
                    keyPair.substring(0, keyPair.indexOf(':')),
                    keyPair.substring(keyPair.indexOf(':') + 1)
            );
        }

        return parsedData;
    }

    public static String parseMapToData(HashMap<String, String> map) {
        String data = "";
        for(Map.Entry entry: map.entrySet()) {
            data += entry.getKey();
            data += ":";
            data += entry.getValue();
            data += ",";
        }
        return data;
    }
}
