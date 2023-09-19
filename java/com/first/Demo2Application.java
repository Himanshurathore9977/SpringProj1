package com.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.second.SecondUser;



@Configuration
@ComponentScan(basePackages = {"com.second"})
@ComponentScan(basePackages = {"com.first"})
public class Demo2Application {
	@Autowired
	static Run app ; 
	
	
	@Autowired
	@Qualifier("omg")
	public Application click ; 
	
	
	@Autowired
	SecondUser sec ;
	
	
	public static void main(String[] args) {
	 
		SpringApplication.run(Demo2Application.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Demo2Application.class) ; 
		System.out.println("Hello Spring ");
		Run app = context.getBean("run" , Run.class) ; 
		app.click() ; 
		
		
		
		context.close(); 	
	}
	public void run(String ...args) {
		app.click() ; 
		click.DoubleClick();
		click.oneClick();
		click.tap();
		
		sec.secondUser();
	}
	
}

interface Application{
	public void oneClick ()  ; 
	public void DoubleClick () ; 
	public void tap() ; 
}


@Component("run")
class Run{
	@Autowired
	@Qualifier("omg")
	public Application click ; 
	
	@Autowired
	SecondUser sec ; 
	
	
	public void click() {
		click.oneClick ()  ; 
		click.DoubleClick () ; 
		click.tap() ;
		
		sec.secondUser();
	}
}
@Component("omg")
@Scope(value = "prototype")
class Omagle implements Application{
	String colour ; 
	public void oneClick() {
		System.out.println("oneClick Omagle Run ");
	}
	public void DoubleClick() {
		System.out.println("DoubleClick : Omagle Stop ");
	}
	public void tap() {
		System.out.println(" tap connecting  to other person ");
	}
	public Omagle() {
		super();
		System.out.println("Object Created for Omagle Class ");
	}
}

@Component("snap")
class SnapChat implements Application{
	public SnapChat() {
		super();
		System.out.println("Object Created for SnapChat Class ");
	}
	public void oneClick()  {
		System.out.println("oneClick SnapChat streak  ");
	}
	public void DoubleClick() {
		System.out.println("DoubleClick SnapChat photo  ");
	}
	public void tap() {
		System.out.println(" tap to make video  ");

	}
}

@Component("insta")
@Primary
class Instagram  implements Application{
	public Instagram() {
		super();
		System.out.println("Object Created for Instagram Class ");
		// TODO Auto-generated constructor stub
	}
	public void oneClick()  {
		System.out.println("oneClick Instagram Open  ");
	} 
	public void DoubleClick() {
		System.out.println("DoubleClick Instagram Like post  ");
	}
	public void tap() {
		System.out.println(" Tap to go Live");
	
	}
}
