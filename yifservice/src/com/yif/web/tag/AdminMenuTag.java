package com.yif.web.tag;

import javax.servlet.jsp.tagext.TagSupport;

public class AdminMenuTag extends TagSupport {
//	private String href;
//	private AdminPriviledgeEnum pri;
//
//	public void setPri(AdminPriviledgeEnum pri) {
//		this.pri = pri;
//	}
//
//	public void setHref(String href) {
//		this.href = href;
//	}
//
//	public int doStartTag() throws JspException {
//		AdminUser user = UserSessionUtil.currentAdmin();
//		if(user.hasPriviledge(pri)){
//			try {
//				StringBuffer sb = new StringBuffer("<li");
//				
//				String menuId = user.getMenuId();
//				if(StringUtils.isNotBlank(menuId)){
//					if(menuId.equals(pri.toString())){
//						sb.append(" class=\"active1\"");
//					}
//				}
//				sb.append("><a href=\"").append(href);
//				sb.append("\">").append(pri.getText()).append("</a></li>");
//				JspWriter out = pageContext.getOut();
//				
//				out.println(sb.toString());
//			} catch (Exception e) {
//				throw new JspException(e.getMessage());
//			}
//		}
//
//		return EVAL_BODY_INCLUDE;
//	}
}
