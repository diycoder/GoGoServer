package com.yif.dao.web;

public class PrevNextPagination extends Pagination {
	public void setS(int s) {
		this.s = s ;
	}
	
	public void setFirstResult(int i) {
		if(i == 0){
			firstResult = 0;
		} else {
			firstResult = i - 1;
		}
	}
}
