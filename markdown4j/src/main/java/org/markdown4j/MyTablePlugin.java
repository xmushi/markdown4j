package org.markdown4j;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MyTablePlugin extends Plugin {
    public MyTablePlugin() {
        super("mytable");
    }

    @Override
    public void emit(StringBuilder out, List<String> lines, Map<String, String> params) {
        out.append("<table class='mytable' ");
        String width = params.get("width");
        if (width != null && width.length() > 0) {
            out.append("width=\"").append(width).append("\" ");
        }
        out.append(">");
        int idx = 1;
        String linestr = "";
        for (String line : lines) {
            if (line.endsWith("|")) {
                linestr+=line;
                String[] splits = linestr.substring(1).split("\\|");//去掉第一个|
                if (idx == 1) {
                    out.append("<thead>");
                    out.append("<tr>");
                    for (String split : splits) {
                        String process="&nbsp;&nbsp;";
                        try {
                            process = Markdown4jProcessor.getProcessor().process(split);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        out.append("<th>").append(process).append("</th>");
                    }
                    out.append("</tr>");
                    out.append("</thead>");
                    out.append("<tbody>");
                } else {
                    out.append("<tr class=\"" + (idx % 2 == 1 ? "odd" : "even") + "\" >");
                    for (String split : splits) {
                        String process="&nbsp;&nbsp;";
                        try {
                            process = Markdown4jProcessor.getProcessor().process(split);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        out.append("<td>").append(process).append("</td>");
                    }
                    out.append("</tr>");
                }
                linestr = "";
                idx++;
            } else {
                linestr += line;
                linestr+="\n";
            }
        }
        out.append("</tbody>");
        out.append("</table>");
    }
}
