package com.Abstract;


public class LgComputerFactory implements ComputerFactory{

	@Override
	public Keyboard createKeyboard() {
		return new LgKeyboard();
	}

	@Override
	public Mouse createMouse() {
		return new LgMouse();
	}
	
}
