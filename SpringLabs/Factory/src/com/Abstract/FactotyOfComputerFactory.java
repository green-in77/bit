package com.Abstract;

public class FactotyOfComputerFactory {
	public void createComputer(String type) {
		ComputerFactory computerfactory = null;
		
		if(type.equals("lg")) {
			computerfactory = new LgComputerFactory();
		}else if(type.equals("ss")) {
			computerfactory = new SsComputerFactory();
		}
		
		computerfactory.createKeyboard();
		computerfactory.createMouse();
		
	}
}
