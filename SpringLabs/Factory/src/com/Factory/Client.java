package com.Factory;

public class Client {
	public static void main(String[] args) {
		ComputerFactory computerfactory = new ComputerFactory();
		
		computerfactory.createComputer("lg");
		computerfactory.createComputer("ss");
	}
}
