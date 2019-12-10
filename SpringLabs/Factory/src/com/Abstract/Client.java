package com.Abstract;

public class Client {
	public static void main(String[] args) {
		FactotyOfComputerFactory computer = new FactotyOfComputerFactory();
		
		computer.createComputer("lg");
		computer.createComputer("ss");
	}
}
