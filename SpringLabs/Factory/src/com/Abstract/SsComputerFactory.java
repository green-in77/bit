package com.Abstract;


public class SsComputerFactory implements ComputerFactory{

	@Override
	public Keyboard createKeyboard() {
		return new SsKeyboard();
	}

	@Override
	public Mouse createMouse() {
		return new SsMouse();
	}
	
}
