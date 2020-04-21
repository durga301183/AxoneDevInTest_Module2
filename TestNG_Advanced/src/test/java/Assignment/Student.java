package Assignment;

public class Student {

//Class to represent a student with marks of five subjects.

     private int[] marks;
    public int[] getMarks()
    {
        return marks;
    }
    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public String findGrade(){
        if (marks == null) {
                return "Absent";
            }
            int total = 0;
            for (int i = 0; i < marks.length; i++) {
                total += marks[i];
            }
            double avg = total/marks.length;
            if(avg >= 80) {
                return "A";
            } else if (avg <80 && avg >=60) {
                return "B";
            } else if (avg <60 && avg >=40) {
                return "C";
            }
            return "Fail";
        }
    }







