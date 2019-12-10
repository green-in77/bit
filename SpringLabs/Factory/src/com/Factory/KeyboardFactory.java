package com.Factory;

public class KeyboardFactory {
	public Keyboard createKeyboard(String type) {
		Keyboard keyboard = null;
		
		if(type.equals("lg")) {
			keyboard = new LgKeyboard();
		}else if(type.equals("ss")) {
			keyboard = new SsKeyboard();
		}
		return keyboard;
	}
}
