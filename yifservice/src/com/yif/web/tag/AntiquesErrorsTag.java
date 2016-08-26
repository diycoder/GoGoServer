package com.yif.web.tag;

import javax.servlet.jsp.JspException;

import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.tags.form.ErrorsTag;
import org.springframework.web.servlet.tags.form.TagWriter;

public class AntiquesErrorsTag extends ErrorsTag
{
  public String getElement(){
	  return "label";
  }
  
  protected void renderDefaultContent(TagWriter tagWriter)
    throws JspException
  {
	this.setDynamicAttribute("", "for", this.getPath());
    tagWriter.startTag(getElement());
    writeDefaultAttributes(tagWriter);
    String delimiter = ObjectUtils.getDisplayString(evaluate("delimiter", getDelimiter()));
    String[] errorMessages = getBindStatus().getErrorMessages();
    for (int i = 0; i < errorMessages.length; i++)
    {
      String errorMessage = errorMessages[i];
      if (i > 0) {
        tagWriter.appendValue(delimiter);
      }
      tagWriter.appendValue(getDisplayString(errorMessage));
    }
    tagWriter.endTag();
  }
}
