package controller;

import javax.ejb.Singleton;

@Singleton
public class MyEjb {

	public String sayHi() {
		return "Mi numero " + Math.random();
	}

	//DB db = new DB();

}