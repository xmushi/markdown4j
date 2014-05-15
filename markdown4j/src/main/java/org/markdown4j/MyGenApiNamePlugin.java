package org.markdown4j;

import java.util.List;
import java.util.Map;

public class MyGenApiNamePlugin extends Plugin {
    public static final String PLUGIN_NAME="genapiname";
    public MyGenApiNamePlugin() {
        super(PLUGIN_NAME);
    }

    @Override
    public void emit(StringBuilder out, List<String> lines, Map<String, String> params) {
        //lines
        out.append(MyGenThreadLocal.t.get().get("name"));
    }
    
    
    
}
