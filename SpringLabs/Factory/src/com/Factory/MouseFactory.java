package com.Factory;

public class MouseFactory {
	public Mouse createMouse(String type) {
		Mouse mouse = null;
		
		if(type.equals("lg")) {
			mouse = new LgMouse();
		}else if(type.equals("ss")) {
			mouse = new SsMouse();
		}
		
		return mouse;
	}
}
