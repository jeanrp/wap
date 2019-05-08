package com.customtag.model;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class Head extends SimpleTagSupport {
    String theColor;
    String words;

    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        if (theColor != null)
            out.write(String.format("<span style='color:%s'>%s</span>", theColor, words));
        else
            out.write(String.format("<span>%s</span>", words));
    }

    public void setTheColor(String theColor) {
        this.theColor = theColor;
    }

    public void setWords(String words) {
        this.words = words;
    }
}
