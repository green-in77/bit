package com.Factory;

public class ComputerFactory {
	public void createComputer(String type) {
		KeyboardFactory keyboardfactory = new KeyboardFactory();
		MouseFactory mousefactory = new MouseFactory();
		
		keyboardfactory.createKeyboard(type);
		mousefactory.createMouse(type);
		
		System.out.println("---" + type + " 컴퓨터 완성 ---");
	}
}
