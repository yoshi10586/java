package com.example.sample1app;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.sample1app.repositories.PersonRepository;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
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
		//List<Person> list = repository.findAll();
		List<Person> list = repository.findAllOrderByName();
		mav.addObject("data", list);
		return mav;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	@Transactional
	public ModelAndView form(
			@ModelAttribute("formModel") @Validated Person Person,
			BindingResult result,
			ModelAndView mav) {
		ModelAndView res = null;
		System.out.println(result.getFieldErrors());
		if (!result.hasErrors()) {
			repository.saveAndFlush(Person);
			res = new ModelAndView("redirect:/");
		} else {
			mav.setViewName("index");
			mav.addObject("title", "Hello page");
			mav.addObject("msg", "sorry, error is occurred...");
			Iterable<Person> list = repository.findAll();
			mav.addObject("datalist", list);
			res = mav;
		}
		return res;
	}
	@PostConstruct
	public void init() {
		Person p1 = new Person();
		p1.setName("taro");
		p1.setAge(39);
		p1.setMail("taro@yamada");
		repository.saveAndFlush(p1);
		Person p2 = new Person();
		p2.setName("hanako");
		p2.setAge(28);
		p2.setMail("hanako@flower");
		repository.saveAndFlush(p2);
		Person p3 = new Person();
		p3.setName("sachiko");
		p3.setAge(17);
		p3.setMail("sachiko@happy");
		repository.saveAndFlush(p3);
	}
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView edit(
			@ModelAttribute("formModel") Person Person,
			@PathVariable Long id,
			ModelAndView mav) {
		mav.setViewName("edit");
		mav.addObject("title", "edit Person.");
		Optional<Person> data = repository.findById(id);
		mav.addObject("formModel", data.get());
		return mav;
	}
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	@Transactional
	public ModelAndView update(
			@ModelAttribute("formModel") Person Person,
			ModelAndView mav) {
		repository.saveAndFlush(Person);
		return new ModelAndView("redirect:/");
	}
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView delete(
			@ModelAttribute("formModel") Person Person,
			@PathVariable Long id,
			ModelAndView mav) {
		mav.setViewName("delete");
		mav.addObject("title", "Delete Person.");
		mav.addObject("msg", "Can I delete this record?");
		Optional<Person> data = repository.findById(id);
		mav.addObject("formModel", data.get());
		return mav;
	}
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@Transactional
	public ModelAndView remove(
			@RequestParam Long id,
			ModelAndView mav) {
		repository.deleteById(id);
		return new ModelAndView("redirect:/");
	}
	@Autowired
	PersonDAOPersonImpl dao;
	@RequestMapping(value="/find", method=RequestMethod.GET)
	public ModelAndView find(ModelAndView mav) {
		mav.setViewName("find");
		mav.addObject("msg", "Personのサンプルです。");
		Iterable<Person> list = dao.getAll();
		mav.addObject("data", list);
		return mav;
	}
	@RequestMapping(value="/find", method=RequestMethod.POST)
	public ModelAndView search(HttpServletRequest request, 
			ModelAndView mav) {
		mav.setViewName("find");
//		String param = request.getParameter("find_str");
//		if (param == "") {
//			mav = new ModelAndView("redirect:/find");
//		} else {
//			mav.addObject("title", "Find result");
//			mav.addObject("msg", "「" + param + "」の検索結果");
//			mav.addObject("value", param);
//			Person data = dao.findById(Long.parseLong(param));
//			Person[] list = new Person[] {data};
//			mav.addObject("data", list);	
//		}
//		return mav;
		
//		mav.setViewName("find");
//		String param = request.getParameter("find_str");
//		if (param == "") {
//			mav = new ModelAndView("redirect:/find");
//		} else {
//			mav.addObject("title", "Find result");
//			mav.addObject("msg", "「" + param + "」の検索結果");
//			mav.addObject("value", param);
//			List<Person> list = dao.findByName(param);
//			mav.addObject("data", list);	
//		}
//		return mav;
		
//		mav.setViewName("find");
//		String param = request.getParameter("find_str");
//		if (param == "") {
//			mav = new ModelAndView("redirect:/find");
//		} else {
//			mav.addObject("title", "Find result");
//			mav.addObject("msg", "「" + param + "」の検索結果");
//			mav.addObject("value", param);
//			List<Person> list = dao.find(param);
//			mav.addObject("data", list);	
//		}
//		return mav;
		
		mav.setViewName("find");
		String param = request.getParameter("find_str");
		if (param == "") {
			mav = new ModelAndView("redirect:/find");
		} else {
			String[] params = param.split(",");
			mav.addObject("title", "Find result");
			mav.addObject("msg", "「" + param + "」の検索結果");
			mav.addObject("value", param);
//			List<Person> list = dao.findByAge(
//					Integer.parseInt(params[0]),
//					Integer.parseInt(params[1]));
			List<Person> list = repository.findByAge(
					Integer.parseInt(params[0]),
					Integer.parseInt(params[1]));
			mav.addObject("data", list);	
		}
		return mav;
	}
	@Autowired
	Post post;
	@Autowired
	SampleComponent component;
	@Autowired
	SampleService service;
	@RequestMapping("/bean")
	public ModelAndView bean(ModelAndView mav) {
		mav.setViewName("bean");
		mav.addObject("title", "Bean sample");
		//mav.addObject("msg", "This is bean sample page.");
		//mav.addObject("msg", post);
		mav.addObject("msg", component.message());
		//mav.addObject("data", new Post[] {service.getPost()});
		//mav.addObject("data", service.getAllPosts());
		mav.addObject("data", service.getLocalPosts());
		return mav;
	}
	@RequestMapping(value="/bean", method=RequestMethod.POST)
	public ModelAndView bean(HttpServletRequest request,
			ModelAndView mav) {
		String param = request.getParameter("find_str");
		mav.setViewName("bean");
		mav.addObject("title", "Bean sample");
		mav.addObject("msg", "get id = " + param);
//		Post post = service.getPost(Integer.parseInt(param));
//		mav.addObject("data", new Post[] {post});
		Post post = service.getAndSavePost(Integer.parseInt(param));
		mav.addObject("data", new Post[] {post});
		return mav;
	}
}
