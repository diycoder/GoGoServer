package com.yif.dao.web;

import com.yif.util.StringUtil;



public class SearchDTO {
	 
	private String startDate;// 开始时间
	private String endDate;// 结束时间
	private String strParam;// 查询条件
	private Integer showFlag;// 是否显示
	
	
	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getStrParam() {
		return strParam;
	}


	public void setStrParam(String strParam) {
		this.strParam = strParam;
	}


	public Integer getShowFlag() {
		return showFlag;
	}


	public void setShowFlag(Integer showFlag) {
		this.showFlag = showFlag;
	}


	public String toParamString() {

		StringBuffer sb = new StringBuffer();
		 
		if (StringUtil.notEmpty(startDate)) {
			sb.append("&startDate=").append(startDate);
		}

		if (StringUtil.notEmpty(endDate)) {
			sb.append("&endDate=").append(endDate);
		}

		return sb.toString();
	}

	 

}
