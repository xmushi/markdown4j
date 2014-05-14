package org.markdown4j;

import java.util.List;
import java.util.Map;

public class MyCodePlugin extends Plugin {
    public MyCodePlugin() {
        super("mycode");
    }

    @Override
    public void emit(StringBuilder out, List<String> lines, Map<String, String> params) {
        String code=params.get("code");
        if(code==null||code.length()==0){
            code="java";
        }
        out.append("<pre class=\"brush: ").append(code).append(";toolbar: false;\">");
        for (String line : lines) {
            out.append(line).append("\n");
        }
        out.append("</pre>");
        out.append("<script type=\"text/javascript\">");
        out.append("SyntaxHighlighter.all();");
        out.append("</script>");
    }
}
