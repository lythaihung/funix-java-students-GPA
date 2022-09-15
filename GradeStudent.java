import java.util.Scanner;
public class GradeStudent {
    //advance : total of weight =100
    public static int weightMidTerm=0;
    public static int weightFinalTerm=0;
    public static int weightHomeWork=0;
    public static void main(String[] args) {
        //welcome
        begin();
        System.out.println();
        Scanner sc = new Scanner(System.in);
        //advance: check validate weight
        //input midterm score
        double midTermScore = midTerm(sc);
        System.out.println();
        //input final score
        double finalTermScore = finalTerm(sc);
        System.out.println();
        //input homework score
        double homeworkScore = homework(sc);
        System.out.println();
        while (weightMidTerm+weightFinalTerm+weightHomeWork!=100) {
            System.out.println("The weight of the 3 test scores must sum exactly 100. \n" +
                    "Less than or greater than 100 is not allowed!\n" +
                    "Please try again!...\n");
            midTermScore = midTerm(sc);
            System.out.println();
            finalTermScore = finalTerm(sc);
            System.out.println();
            homeworkScore = homework(sc);
            System.out.println();
        } ;
        //print report
        report(midTermScore, finalTermScore, homeworkScore );
        //ending program

    }
    public static void begin(){
        System.out.println("This program reads exam/homework scores and reports your overall course grade");
    }
    public static double midTerm(Scanner sc){
        System.out.println("Midterm:");
        //input weight // advance
        System.out.print("Weight (0-100)? ");
        weightMidTerm = sc.nextInt();
        if (weightMidTerm > 100) {
            System.out.println("Weight have to equal or less than 100!");
            System.out.print("Weight (0-100)? ");
            weightMidTerm = sc.nextInt();
        }
        //input score earned
        System.out.print("Score earned? ");
        int scoreEarned = sc.nextInt();
        //input score shifted
        System.out.print("Were score shifted (1=yes, 2=no)? ");
        int scoreShifted= sc.nextInt();
        if (scoreShifted==1) {
            System.out.print("Shift amount? ");
            scoreEarned+=sc.nextInt();
        }
        //count out total point: score earned + shifted ; max: 100
        if (scoreEarned>100) scoreEarned=100;
        System.out.println("Total points = " +scoreEarned +" / 100");
        //count out weighted score: total point * weight
        double weightedScore= Math.round((double) scoreEarned/100*weightMidTerm*10)/10.00; //làm tròn 1 chữ số thập phân
        System.out.println("Weight score = " +weightedScore+" / "+weightMidTerm);
        //return score of this term
        return weightedScore;
    }
    public static double finalTerm(Scanner sc){
        System.out.println("Final:");
        //input weight // advance
        System.out.print("Weight (0-100)? ");
        weightFinalTerm = sc.nextInt();
        if (weightFinalTerm>100) {
            System.out.println("Weight have to equal or less than 100!");
            System.out.print("Weight (0-100)? ");
            weightFinalTerm = sc.nextInt();
        }
        //input score earned
        System.out.print("Score earned? ");
        int scoreEarned = sc.nextInt();
        //input score shifted
        System.out.print("Were score shifted (1=yes, 2=no)? ");
        int scoreShifted= sc.nextInt();
        if (scoreShifted==1) {
            System.out.print("Shift amount? ");
            scoreEarned+=sc.nextInt();
        }
        //count out total point: score earned + shifted ; max: 100
        if (scoreEarned>100) scoreEarned=100;
        System.out.println("Total points = " +scoreEarned +" / 100");
        //count out weighted score: total point * weight
        double weightedScore= Math.round((double) scoreEarned/100*weightFinalTerm*10)/10.00;
        System.out.println("Weight score = " +weightedScore+" / "+weightFinalTerm);
        //return score of final term
        return weightedScore;
    }
    public static double homework (Scanner sc){
        System.out.println("Homework:");
        //input weight //advance
        System.out.print("Weight (0-100)? ");
        weightHomeWork = sc.nextInt();
        if (weightHomeWork>100) {
            System.out.println("Weight have to equal or less than 100!");
            System.out.print("Weight (0-100)? ");
            weightHomeWork = sc.nextInt();
        }
        //input number of asm
        System.out.print("Number of assignments? ");
        int numberOfAsm = sc.nextInt();
        //asm1 : current score; max:20
        //asm2 : current score; max:32
        //asm3 : current score; max:40
        //count out total asm = asm1+asm2+asm3
        int sumAsmScore=0;
        int sumMaxScore=0;
        for(int i=1; i<=numberOfAsm;i++){
            System.out.print("Assignment "+i+" score and max? ");
            sumAsmScore+=sc.nextInt();
            sumMaxScore+=sc.nextInt();
        }
        //advance : asm max 150
        if (sumAsmScore>150) sumAsmScore=150;
        if (sumMaxScore>150) sumMaxScore=150;
        //input section attended
        System.out.print("How many sections did you attend? ");
        int sectionAttend = sc.nextInt();
        //count out section point = section attend *5 ; max 30
        int sectionPoint = sectionAttend*5;
        if(sectionPoint>30) sectionPoint=30;
        System.out.println("Section points = "+sectionPoint+" / 30");
        //count out total point = asm + section ; max = max asm + max section
        int totalPoint = sumAsmScore+sectionPoint;
        int totalMaxPoint= sumMaxScore+30;
        System.out.println("Total points = "+totalPoint+" / "+totalMaxPoint);
        //count out weights core= total point/ max * weight;
        double weightedScore = Math.round( (double) totalPoint/totalMaxPoint*weightHomeWork*10)/10.00;
        System.out.println("Weighted score = "+weightedScore+" / "+weightHomeWork);
        //return score of homework
        return weightedScore;
    }
    public static void report (double score1, double score2, double score3){
        //count out grade point from 3 score (midterm,final, homework)
        double grade=Math.round((score1+score2+score3)*10)/10.0;
        System.out.println("Overall percentage = "+grade);
        //count out GPA
        double GPA = 0.0;
        String rating = "You are weak!";
        if (grade>=85)  {
            GPA=3.0;
            rating ="You are excellent!";
        }
        else if (grade>=75 && grade<85) {
            GPA=2.0;
            rating ="You are good!";
        }
        else if (grade>=60 && grade<75) {
            GPA=1.0;
            rating = "You are average!";
        }
        System.out.println("Your grade will be at least : "+GPA);
        System.out.println(rating);
    }
}
