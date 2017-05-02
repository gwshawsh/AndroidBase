package com.gws.android.tips.util;


import android.content.res.XmlResourceParser;
import android.util.ArrayMap;

/**
 * Created by jara on 2017-3-24.
 */

public class XmlUtil {

    public static ArrayMap<String, ArrayMap<String, String>> parseNodes
            (XmlResourceParser xmlResourceParser) throws Exception{
        if (xmlResourceParser==null) {
            return null;
        }
        ArrayMap<String, ArrayMap<String,String>> map = null;
        ArrayMap<String, String> arrayMap = null;
        int root = xmlResourceParser.getEventType();
        while (root != XmlResourceParser.END_DOCUMENT) {
            switch (root) {
                case XmlResourceParser.START_DOCUMENT:
                    map = new ArrayMap<>();
                    break;
                case XmlResourceParser.START_TAG:
                    if("index".equals(xmlResourceParser.getName())){
                        String nodeName = xmlResourceParser.getAttributeValue(0);
                        arrayMap = new ArrayMap<>();
                        if (map != null) {
                            map.put(nodeName, arrayMap);
                        }
                    }
                    else if ("node".equals(xmlResourceParser.getName())){
                        String node = xmlResourceParser.getAttributeValue(0);
                        String nodeName = xmlResourceParser.nextText();
                        if (arrayMap != null) {
                            arrayMap.put(node, nodeName);
                        }
                    }
                    break;
                case XmlResourceParser.END_TAG:
                    if("index".equals(xmlResourceParser.getName())){
                        arrayMap = null;
                    }
                    break;
                default:
                    break;
            }
            root = xmlResourceParser.next();
        }
        return map;
    }

}
