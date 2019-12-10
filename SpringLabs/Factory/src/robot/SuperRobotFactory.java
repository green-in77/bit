package robot;

public class SuperRobotFactory extends RobotFactory{

	@Override
	Robot createRobot(String name) {
		Robot robot = null;
		
		if(name.equals("super")) {
			robot = new SuperRobot();
		}else if(name.equals("power")) {
			robot = new PowerRobot();
		}
		
		return robot;
	}

}
