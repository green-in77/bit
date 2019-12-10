package robot;

public class FactoryMain {
	public static void main(String[] args) {
		RobotFactory robotfactory = new SuperRobotFactory();
		
		Robot robotsuper = robotfactory.createRobot("super");
		System.out.println(robotsuper.getName());
		
		Robot robotpower = robotfactory.createRobot("power");
		System.out.println(robotpower.getName());

	}
}
