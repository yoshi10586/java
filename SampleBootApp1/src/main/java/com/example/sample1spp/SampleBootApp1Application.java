package com.example.sample1spp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/////////  Default  //////////
@SpringBootApplication
public class SampleBootApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(SampleBootApp1Application.class, args);
	}

}

///////////  変数化  //////////
//@SpringBootApplication
//public class SampleBootApp1Application {
//
//	public static void main(String[] args) {
//		//SpringApplication.run(SampleBootApp1Application.class, args);
//		//System.out.println(("Welcome to Spring!!"));
//		SpringApplication app = new SpringApplication(SampleBootApp1Application.class);
//		app.setBannerMode(Mode.OFF);
//		app.run(args);
//
//	}
//
//}

////////////  CommandLineRunner  //////////
//@SpringBootApplication
//public class SampleBootApp1Application  implements CommandLineRunner{
//
//	public static void main(String[] args) {
//		//SpringApplication.run(SampleBootApp1Application.class, args);
//		//System.out.println(("Welcome to Spring!!"));
//		SpringApplication app = new SpringApplication(SampleBootApp1Application.class);
//		app.setBannerMode(Mode.OFF);
//		app.run(args);
//
//	}
//
//	@Override
//	public void run(String[] args) throws Exception {
//		// TODO 自動生成されたメソッド・スタブ
//		System.out.println(("+--------------------------------------"));
//		System.out.println(("|  this is CommandLine Runner program |"));
//		System.out.println(("+--------------------------------------"));
//		System.out.println("[" + String.join(", ", args) + "]");
//
//	}
//
//}

////////////  ApplicationRunner  //////////
//@SpringBootApplication
//public class SampleBootApp1Application  implements ApplicationRunner{
//
//	public static void main(String[] args) {
//		//SpringApplication.run(SampleBootApp1Application.class, args);
//		//System.out.println(("Welcome to Spring!!"));
//		SpringApplication app = new SpringApplication(SampleBootApp1Application.class);
//		app.setBannerMode(Mode.OFF);
//		app.run(args);
//
//	}
//
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		// TODO 自動生成されたメソッド・スタブ
//		System.out.println(("+--------------------------------------"));
//		System.out.println(("|  this is CommandLine Runner program |"));
//		System.out.println(("+--------------------------------------"));
//		System.out.println(args.getOptionNames());
//		System.out.println(args.getNonOptionArgs());
//		System.out.println(Arrays.asList(args.getSourceArgs()));
//
//	}
//
//}

////////////  ApplicationRunner2  //////////
//@SpringBootApplication
//public class SampleBootApp1Application  implements ApplicationRunner{
//
//	public static void main(String[] args) {
//		//SpringApplication.run(SampleBootApp1Application.class, args);
//		//System.out.println(("Welcome to Spring!!"));
//		SpringApplication app = new SpringApplication(SampleBootApp1Application.class);
//		app.setBannerMode(Mode.OFF);
//		app.setHeadless(false);
//		app.run(args);
//
//	}
//
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		// TODO 自動生成されたメソッド・スタブ
//		JFrame frame = new JFrame("Spring Boot Swing APP");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(300, 200);
//		frame.add(new JLabel("Spring Boot Application"));
//		frame.setVisible(true);
//	}
//
//}

//////////// RestController  //////////
//@SpringBootApplication
//@RestController
//public class SampleBootApp1Application {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SampleBootApp1Application.class, args);
//	}
//
//	@RequestMapping("/")
//	public String index(){
//		return "Hello, Spring Boot 3!!!	";
//	}
//				
//}

///////////  RestController2  //////////
//@SpringBootApplication
//@RestController
//public class SampleBootApp1Application {
//	
//	String[][] data = {
//			{"noname", "no email address", "0"},
//			{"taro", "taro@yamada", "39"},
//			{"hanako", "hanako@flower", "28"},
//			{"sachiko", "sachiko@happy", "17"},
//			{"jiro", "jiro@change", "6"}
//	};
//	
//	public static void main(String[] args) {
//		SpringApplication.run(SampleBootApp1Application.class, args);
//	}
//
//	@RequestMapping("/{num}")
//	public String index(@PathVariable int num) {
//		int n = num < 0 ? 0 : num >= data.length ? 0 : num;
//		String[] item = data[n];
//		String msg = "ID=%s. [name: %s, mail: %s, age: %s]";
//		return String.format(msg, num, item[0], item[1], item[2]);
//	}
//
//}

///////////  RestController3  //////////
//@SpringBootApplication
//@RestController
//public class SampleBootApp1Application {
//
//	DataObject[] data = {
//			new DataObject("noname", "no email address", 0),
//			new DataObject("taro", "taro@yamada", 39),
//			new DataObject("hanako", "hanako@flower", 28),
//			new DataObject("sachiko", "sachiko@happy", 17),
//			new DataObject("jiro", "jiro@change", 6)
//	};
//
//	public static void main(String[] args) {
//		SpringApplication.run(SampleBootApp1Application.class, args);
//	}
//
//	@RequestMapping("/{num}")
//	public DataObject index(@PathVariable int num) {
//		int n = num < 0 ? 0 : num >= data.length ? 0 : num;
//		return data[n];
//	}
//
//}
//
//class DataObject {
//	private String name;
//	private String mail;
//	private int age;
//	
//	public DataObject(String name, String mail, int age) {
//		super();
//		this.name = name;
//		this.mail = mail;
//		this.age = age;
//	}
//	
//	public String getName() {return name;}
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	public String getMail() {return mail;}
//	public void setMail(String mail) {
//		this.mail = mail;
//	}
//	
//	public int getAge() {return age;}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	
//}


///////////  RestController4  //////////
//@SpringBootApplication
//@RestController
//public class SampleBootApp1Application {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SampleBootApp1Application.class, args);
//	}
//
//	@RequestMapping("/")
//	public String index(HttpServletRequest request, HttpServletResponse response) {
//		response.setContentType(MediaType.TEXT_HTML_VALUE);
//		String content = """
//				<html>
//					<head>
//					<title>Sample App</title>
//					</head>
//					<body>
//					<h1>Sample App</h1>
//					<p>This is sample app page!</p>
//				</html>
//				""";
//		return content;
//	}
//
//}