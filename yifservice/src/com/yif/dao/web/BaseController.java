package com.yif.dao.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.yif.bean.User;
import com.yif.util.UserSessionUtil;

public class BaseController extends MultiActionController {
	@Value("${static.server}")
	private String staticServer = "";


	public BaseController() {

	}

	 

	 

	@ModelAttribute
	protected void homePageHeaderCommonProcess(ModelMap model) {
		model.addAttribute("staticServer", staticServer);
	}

	public int currentUserId() {
		User user = UserSessionUtil.currentUser();

		if (user != null) {
			return user.getId();
		}

		return 0;
	}

//	public String currentUserName() {
//		User user = UserSessionUtil.currentUser();
//
//		if (user != null) {
//			return user.getName();
//		}
//
//		return null;
//
//	}

	public String currentLocale() {
		Locale locale = LocaleContextHolder.getLocale();
		
		return "zh_CN";
	}

	protected <T> T getSessionAttribute(HttpSession session,
			String attributeName) {
		return (T) session.getAttribute(attributeName);
	}

	protected void setSessionAttribute(HttpSession session,
			String attributeName, Object attribute) {
		session.setAttribute(attributeName, attribute);
	}

	public HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
	}

	public Object getSessionAttribute(String key) {
		return getRequest().getSession().getAttribute(key);
	}

	 
	//时间list
		public void getTimeList(ModelMap model){
			List<String> list = new ArrayList<String>();
			for(int i=1;i<48;i++){
				int m=i%2==0? 0:3;
				String time = i/2+":"+m+"0";
				list.add(time);
			}
			list.add("00:00");
			model.addAttribute("timeList", list);
		}
		
		
	/**
	 * 消除重复项
	 * @param list
	 */
/*	public void removelist(List<DealerLocaleDTO> list){
		List<Integer> dealerIdLists = new ArrayList<Integer>();
		for(DealerLocaleDTO dto : list){
			dealerIdLists.add(dto.getId());
		}
		//主营商品
		List<CategoryLocaleDTO> categoryLocaleLists = 	categoryService.getCategoryLocaleDTOByDealerIdListTypeLocale(AppConstants.CAT_TYPE.ART, this.currentLocale(), dealerIdLists);
		for(CategoryLocaleDTO ct : categoryLocaleLists){
			int dearId = ct.getDealerId();
			for(DealerLocaleDTO dto : list){
				int id = dto.getId();
				if(dearId==id){
					if(StringUtil.notEmpty(dto.getMaincom())){
						dto.setMaincom(dto.getMaincom() +" "+ct.getName() );
					}else{
						dto.setMaincom(ct.getName());
					}
				}
			}
		}
        if(!list.isEmpty()){
            for(int i=0;i<list.size();i++){
                for(int j=list.size()-1;j>i;j--){
                    if(list.get(i).getId().equals(list.get(j).getId())){
                    	list.remove(j);
                    }
                }
            }
        }
	}*/
		

}
