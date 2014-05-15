package org.markdown4j;

import java.util.List;
import java.util.Map;

public class MyGenCodePlugin extends MyCodePlugin {
    public static final String PLUGIN_NAME="mygencode";
    public MyGenCodePlugin() {
        super(PLUGIN_NAME);
    }

    @Override
    public void emit(StringBuilder out, List<String> lines, Map<String, String> params) {
        //lines
        super.emit(out, lines, params);
    }
    
    
    
}
