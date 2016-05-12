package com.jinhaoplus.oj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jinhaoplus.oj.common.OrderRepo;
import com.jinhaoplus.oj.dao.PairDao;
import com.jinhaoplus.oj.domain.Pair;

@Controller
public class PairController {
	@Autowired
	private PairDao pairDao;
	public void setPairDao(PairDao pairDao) {
		this.pairDao = pairDao;
	}
	
	@RequestMapping(value="/index")
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@RequestMapping(value="/pairOrder",method=RequestMethod.POST)
	public ModelAndView pairOrder(HttpServletRequest request,HttpServletResponse response,Pair pair){
		ModelAndView modelAndView = new ModelAndView();
		Pair thePair = pairDao.getPairByBitCode(pair.getBitCode());
		if(thePair.getUserName().equals(pair.getUserName())){
			if(thePair.getrOrder()==null || "".equals(thePair.getrOrder())){
				modelAndView.setViewName("result");
				String order = OrderRepo.getOrder();
				thePair.setrOrder(order);
				pairDao.updatePairByBitCode(thePair);
				modelAndView.addObject("returnOrder", order);
			}else{
				modelAndView.setViewName("index");
				modelAndView.addObject("signupInfo", "排号已经确定");
			}
		}else {
			modelAndView.setViewName("index");
			modelAndView.addObject("signupInfo", "学号姓名不匹配");
		}
		return modelAndView;
	}
	
	
}
