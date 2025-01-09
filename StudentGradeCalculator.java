import java.util.*;
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[]args){
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of subjects:");
        int subjects=scanner.nextInt();
        scanner.nextLine();
        
        int marks[] = new int[subjects];
        int totalMarks=0;

        for(int i=0;i<subjects;i++){
            System.out.println("Enter the marks obtained by the student in subject"+(i+1)+":");
            marks[i]=scanner.nextInt();
            totalMarks+=marks[i];  
        }
        double AvgPercentage= (double) totalMarks/subjects;  //we can take double or float our wish for more precision we take double here
        char grade;

        if(AvgPercentage>=90){
            grade ='A';
        }
        else if(AvgPercentage>=80){
            grade ='B';
        }
        else if(AvgPercentage>=70){
            grade ='C';
        }
        else if(AvgPercentage>=60){
            grade ='D';
        }
        else{
            grade ='F';
        }
        
        System.out.println("----Results of the Students----");
        System.out.println("Total Marks: "+totalMarks);
        System.out.println("Average Percentage: "+AvgPercentage);
        System.out.println("Grade of the Student: "+grade);

        scanner.close();
      
    }
}
