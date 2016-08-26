package com.yif.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;






import com.yif.dao.web.Pagination;
import com.yif.util.MessageUtil;

public class PaginationTag extends TagSupport{

	@Autowired
	private MessageUtil messageUtil=new MessageUtil();
	
	private static final long serialVersionUID = 4020914941495362646L;
	
	private String href; // 链接URL
	private String params; // 参数
	private String hrefWithParams;

	private static final int PAGE_NUM = 9;
	private static final int HALF_PAGE_NUM = 4;

	public void setParams(String params) {
		this.params = params;
	}

	public void setHref(String href) {
		this.href = href;
	}

	private void initHrefWithParams(Pagination page){
		StringBuffer sb = new StringBuffer();
		sb.append(href).append("?");
		
		if(StringUtils.isNotBlank(params)){
			sb.append(params).append("&");
		}

		sb.append("s=").append(page.getS());

		hrefWithParams = sb.toString();
	}

	private String p(Integer i){
		return hrefWithParams + "&i=" + i; 
	}

	public int doStartTag() throws JspException {
		Pagination page = (Pagination)pageContext.getAttribute("page", pageContext.REQUEST_SCOPE);
		initHrefWithParams(page);
		if(page.getPageCount() > 1){
			StringBuffer sb = new StringBuffer();
			sb.append("<!-----分页---->\n");
			sb.append("<div class=\"pagess\">\n");
			sb.append("<form method=\"POST\" action=\"").append(hrefWithParams).append("\">");
			sb.append("<ul>\n");
			sb.append("<li><a class=\"last_page\" href=\"").append(p(page.getPrevious())).append("\"><img src=\"images/prev.jpg\"/></a></li>"); 

			int start = page.getI() - HALF_PAGE_NUM;
			int end = page.getI() + HALF_PAGE_NUM;

			if(start < 1){
				start = 1;
				end = PAGE_NUM;
			}

			if(page.getPageCount() - page.getI() < 4){
				start = page.getPageCount() - (PAGE_NUM - 1);
				end = PAGE_NUM;
			}

			if(start < 1){
				start = 1;
			}
			if(end > page.getPageCount()){
				end = page.getPageCount();
			}
			if(start > 1){
				sb.append("<li>�?/li>");
			}		    
			for(int i = start; i <= end; i++){
				String css = "";
				if(i == page.getI()){
					css = "dvc ";
				} 

				sb.append("<li class=\"").append(css).append(" sa\"><a href=\"")
				.append(p(i)).append("\">").append(i).append("</a></li>");
			}
			if(end < page.getPageCount()){
				sb.append("<li>�?/li>");
			}
			 
			sb.append("<li><a class=\"next_page\" href=\"").append(p(page.getNext())).append("\"><s:message code=\'fy.xyy\'/> <img src=\"images/next.jpg\" /></a></li>");
			sb.append("<li class=\"noborder\"><font color=\"#dd0200\">")
			.append(page.getI()).append("</font>/").append(page.getPageCount()).append("</li>");
			sb.append("<li class=\"inp noborder\"><input type=\"text\" name=\"i\" id=\"i\" value=\"\"/></li>");
			sb.append("<li class=\"inp noborder skip_i\">");
			sb.append("<label for=\"tiaozhuan\"></label>");
			sb.append("<input id=\"tiaozhuan\" type=\"submit\" value=\"跳转\" onclick=\"javascript: if($('#i').prop('value') == ''){$('#i').prop('value', 1)}\"/></li>");
			sb.append("<input type=\"hidden\" name=\"s\" value=\"").append(page.getS()).append("\"/></li>");
			sb.append("</ul>");
			sb.append("</form>");
			sb.append("</div>");
			sb.append("<!-----end of分页---->");

			try {
				pageContext.getOut().println(sb.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return EVAL_BODY_INCLUDE;
	}
}
