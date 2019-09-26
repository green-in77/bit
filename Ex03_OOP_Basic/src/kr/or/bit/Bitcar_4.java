package Ex_Team1;

public class CarStore_main {
 public static void main(String[] args) {
  CarStore smartCar = new CarStore("smart", 10000);
  smartCar.getPrice();
  smartCar.getType();
  smartCar.printInfo();
  CarStore smartCar2 = new CarStore("smart", 10000);
  CarStore smartCar3 = new CarStore("smart", 10000);

  CarStore webCar = new CarStore("web", 10000);
  webCar.getPrice();
  webCar.getType();
  webCar.printInfo();
  CarStore webCar2 = new CarStore("web", 10000);
  CarStore webCar3 = new CarStore("web", 10000);

  // 차종이 맞지 않습니다.
  CarStore javaCar0 = new CarStore("java12", 10000);

  CarStore javaCar = new CarStore("java", 10000);
  javaCar.getPrice();
  javaCar.getType();
  javaCar.printInfo();

  javaCar.printSmartTypeTotalCount();
  javaCar.printWebTypeTotalCount();
  javaCar.printJavaTypeTotalCount();
  javaCar.printTotalCount();
 }
}

class CarStore {
 private String type;
 private int price;
 private char mark;

 private static int smartTypeTotalCount;
 private static int webTypeTotalCount;
 private static int javaTypeTotalCount;

 public String getType() {
  return type;
 }

 public int getPrice() {
  return price;
 }

 public CarStore(String type, int price) {
  if (checkType(type)) {
   this.type = type;
   this.price = price;
  } else {
   System.out.println("차종이 맞지 않습니다.");
   System.exit(0);
  }
 }

 public void printInfo() {
  switch (type) {
  case "smart":
   printSmartInfo();
   break;
  case "web":
   printWebInfo();
   break;
  case "java":
   printJavaInfo();
   break;
  }
 }

 public void printSmartTypeTotalCount() {
  System.out.println("Smart Type 누적 대수 :" + smartTypeTotalCount);
 }

 public void printWebTypeTotalCount() {
  System.out.println("Web Type 누적 대수 :" + webTypeTotalCount);
 }

 public void printJavaTypeTotalCount() {
  System.out.println("Java Type 누적 대수 :" + javaTypeTotalCount);
 }

 public void printTotalCount() {
  int total = smartTypeTotalCount + webTypeTotalCount + javaTypeTotalCount;
  System.out.println("총 누적 대수 :" + total);
 }

 private boolean checkType(String type) {
  boolean result = true;
  if (type.equals("smart")) {
   mark = '△';
   smartTypeTotalCount++;
  } else if (type.equals("web")) {
   mark = '▽';
   webTypeTotalCount++;
  } else if (type.equals("java")) {
   mark = '□';
   javaTypeTotalCount++;
  } else
   result = false;

  return result;
 }

 private void printSmartInfo() {
  for (int i = 0; i < 5; i++) {
   for (int j = 4; j > i; j--)
    System.out.print(" ");
   for (int k = 0; k < i * 2 + 1; k++)
    System.out.print("*");
   System.out.println();
  }

  System.out.printf("%s %c %d\n", type, mark, price);
 }

 private void printWebInfo() {
  for (int i = 0; i < 5; i++) {
   for (int j = 0; j < i; j++)
    System.out.print(" ");
   for (int k = 9; k > i * 2; k--)
    System.out.print("*");
   System.out.println();
  }

  System.out.printf("%s %c %d\n", type, mark, price);
 }

 private void printJavaInfo() {
  for (int i = 0; i < 5; i++) {
   for (int j = 0; j < 15; j++)
    System.out.print("*");
   System.out.println();
  }

  System.out.printf("%s %c %d\n", type, mark, price);
 }
}
