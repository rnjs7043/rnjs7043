package kr.co.koitt;

import org.springframework.stereotype.Service;

@Service
public class DITestServiceImpl2
					implements DITestService {

	public String data1() {
		return "This is Data no 2.";
	}//data1 - overriding

}//class
