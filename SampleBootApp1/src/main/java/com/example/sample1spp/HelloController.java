package com.example.sample1app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.sample1app.repositories.PersonRepository;

import jakarta.transaction.Transactional;


@Controller
public class HelloController {
	
//	@RequestMapping("/{temp}")
//	public String index(@PathVariable String temp) {
//		switch (temp) {
//		case "index":
//			return "index";
//		default:
//			return "other";
//		
//		}
//	}
	
//	@RequestMapping()
//	public String index(Model model) {
//		model.addAttribute("msg", "これはコントローラーに用意したメッセージです。");
//		return "index";
//	}
//	
//	@RequestMapping("/{num}")
//	public String index(@PathVariable int num, Model model) {
//		int res = 0;
//		for(int i = 1; i <= num; i++) {
//			res += i;
//		}
//		model.addAttribute("msg", "total: " + res);
//		return "index";
//	}
	
//	@RequestMapping("/{num}")
//	public ModelAndView index(@PathVariable int num, ModelAndView mav) {
//		int total = 0;
//		for(int i = 1; i <= num; i++) {
//			total += i;
//		}
//		mav.addObject("msg", num + "までの合計を計算します。");
//		mav.addObject("content", "total:" + total);
//		mav.setViewName("index");
//		return mav;
//	}
	
//	@RequestMapping(value="/", method=RequestMethod.GET)
//	public ModelAndView index(ModelAndView mav) {
//		mav.addObject("msg", "名前を書いてください。");
//		mav.setViewName("index");
//		return mav;
//	}
//	
//	@RequestMapping(value="/", method=RequestMethod.POST)
//	public ModelAndView form(@RequestParam("text1") String str, 
//			ModelAndView mav) {
//		mav.addObject("msg", "こんにちは、" + str + "さん！");
//		mav.addObject("value", str);
//		mav.setViewName("index");
//		return mav;
//	}
	
//	@RequestMapping(value="/", method=RequestMethod.GET)
//	public ModelAndView index(ModelAndView mav) {
//		mav.addObject("msg", "フォームを送信ください。");
//		mav.setViewName("index");
//		return mav;
//	}
//	
//	@RequestMapping(value="/", method=RequestMethod.POST)
//	public ModelAndView form(
//			@RequestParam(value="check1", required=false) boolean check1,
//			@RequestParam(value="radio1", required=false) String radio1,
//			@RequestParam(value="select1", required=false) String select1,
//			@RequestParam(value="select2", required=false) String[] select2,
//			ModelAndView mav) {
//		String res = "";
//		try {
//			res = "check:" + check1 +
//					" radio:" + radio1 +
//					" select:" + select1 + "\nselect2:";
//		} catch (NullPointerException e) {
//		}
//		try {
//			res += select2[0];
//			for(int i = 1; i < select2.length; i++) {
//				res += ", " + select2[i];
//			}
//		} catch (NullPointerException e) {
//			res += "null";
//		}
//		
//		mav.addObject("msg", res);
//		mav.setViewName("index");
//		return mav;
//	}
	
//	@RequestMapping(value="/", method=RequestMethod.GET)
//	public ModelAndView index(ModelAndView mav) {
//		mav.addObject("msg", "HelloController/indexのページです。");
//		mav.setViewName("index");
//		return mav;
//	}
//	
//	
//	@RequestMapping(value="/other")
//	public String other() {
//		return "redirect:/";
//	}
//	
//	@RequestMapping(value="/home")
//	public String home() {
//		return "forward:/";
//	}
	
	
//	private boolean flag = false;
//	@RequestMapping("/")
//	public ModelAndView index(ModelAndView mav) {
//		flag = !flag;
//		mav.setViewName("index");
//		mav.addObject("flag", flag);
//		mav.addObject("msg", "サンプルのメッセージです。");
//		return mav;
//	}
	
//	@RequestMapping("/")
//	public ModelAndView index(ModelAndView mav) {
//		mav.setViewName("index");
//		mav.addObject("msg", "データを表示します。");
//		String[] data = new String[] {"One", "Two", "Three"};
//		mav.addObject("data", data);		
//		return mav;
//	}
	
//	@RequestMapping("/{month}")
//	public ModelAndView index(@PathVariable int month, ModelAndView mav) {
//		mav.setViewName("index");
//		mav.addObject("msg", month + "月は？");
//		mav.addObject("month", month);		
//		return mav;
//	}
	
//	@Autowired
//	PersonRepository repository;
//	@RequestMapping("/")
//	public ModelAndView index(ModelAndView mav) {
//		mav.setViewName("index");
//		mav.addObject("msg", "this is JPA sample data.");
//		mav.addObject("title", "Hello page");
//		Iterable<Person> list = repository.findAll();
//		mav.addObject("data", list);
//		return mav;
//	}
	
	@Autowired
	PersonRepository repository;
	@RequestMapping("/")
	public ModelAndView index(
			@ModelAttribute("formModel") Person Person,
			ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("msg", "this is JPA sample data.");
		mav.addObject("title", "Hello page");
		List<Person> list = repository.findAll();
		mav.addObject("data", list);
		return mav;
	}
	@RequestMapping(value="/", method=RequestMethod.POST)
	@Transactional
	public ModelAndView form(
			@ModelAttribute("formModel") Person Person,
			ModelAndView mav) {
		
		repository.saveAndFlush(Person);
		return new ModelAndView("redirect:/");
	}
	
}
