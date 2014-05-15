package org.markdown4j;

import java.util.Map;

public class MyGenThreadLocal {
    public static ThreadLocal<Map<String,Object>> t = new ThreadLocal<Map<String,Object>>();
}
