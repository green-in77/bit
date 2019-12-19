package Quiz;

import java.io.Serializable;
import java.util.Scanner;

//BMI 처럼...만들기.

public class Grade implements Serializable{
    private double math = 0; // 수학
    private double java = 0; // 자바
    private double python = 0; // 파이썬
    private double avg = 0; // 평균
    private String you = null; //등급
    
    public Grade input(Grade grade){ // 성적입력
        Scanner scan = new Scanner(System.in);
        System.out.print("수학점수 입력하세요 : ");
        this.math = scan.nextInt();
        System.out.print("자바점수 입력하세요 : ");
        this.java = scan.nextInt();
        System.out.print("파이선점수 입력하세요 : ");
        this.python = scan.nextInt();
        
        this.avg = (this.math+this.java+this.python)/3; //평균저장
        if(this.avg>90){ // 평균에 따른 등급저장
            this.you = "A+";
        }else if(this.avg>80 && this.avg<=90){
            this.you = "A";
        }else if(this.avg>70 && this.avg<=80){
            this.you = "B+";
        }else if(this.avg>60 && this.avg<=70){
            this.you = "B";
        }else {
            this.you = "C";
        }
        return grade;
    }
 
    public double getMath() {
        return math;
    }
 
    public void setMath(double math) {
        this.math = math;
    }
 
    public double getJava() {
        return java;
    }
 
    public void setJava(double java) {
        this.java = java;
    }
 
    public double getPython() {
        return python;
    }
 
    public void setPython(double python) {
        this.python = python;
    }
 
    public double getAvg() {
        return avg;
    }
 
    public void setAvg(double avg) {
        this.avg = avg;
    }
 
    public String getYou() {
        return you;
    }
 
    public void setYou(String you) {
        this.you = you;
    }
 
    @Override
    public String toString() {
        return "Grade [math=" + math + ", java=" + java + ", python=" + python + ", avg=" + avg + ", you=" + you + "]";
    }
 
 
    
    
}//class
