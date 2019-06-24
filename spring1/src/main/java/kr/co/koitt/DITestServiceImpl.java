package kr.co.koitt;

import org.springframework.stereotype.Service;

public class DITestServiceImpl
					implements DITestService {

	public String data1() {
		return "This is Data no 1.";
	}//data1 - overriding

}//class
