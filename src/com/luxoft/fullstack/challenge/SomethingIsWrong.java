package com.luxoft.fullstack.challenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class SomethingIsWrong {

    private static final String CITY = "Springfield";

    public static void main(String args[]) {

        Student bartSimpson = new Student("bartSimpson123", "Bart", "Simpson", "ElBarto", "742 Evergreen Terrace", "45789", CITY, "USA");
        Student lisaSimpson = new Student("lisaSimpson456", "Lisa", "Simpson", "Lisa", "742 Evergreen Terrace", "45789", CITY, "USA");
        Student nelsonMuntz = new Student("nelsonMuntz789", "Nelson", "Muntz", "Nelson", "743 Evergreen Terrace", "45789", CITY, "USA");
        Student milhouseVanHouten =
            new Student("milhouseVanHouten012", "Milhouse", "Van Houten", "Milhouse", "744 Evergreen Terrace", CITY, "45789", "USA");
        Student ralphWiggum = new Student("ralphWiggum345", "Ralph", "Wiggum", "Ralph", "745 Evergreen Terrace", "45789", CITY, "USA");
        Student martinPrince = new Student("martinPrince678", "Martin", "Prince", "Martin", "746 Evergreen Terrace", "45789", CITY, "USA");

        final Set<Student> studentsThatHaveTakenTheSpringfieldExam = new HashSet();
        studentsThatHaveTakenTheSpringfieldExam.add(bartSimpson);
        studentsThatHaveTakenTheSpringfieldExam.add(lisaSimpson);
        studentsThatHaveTakenTheSpringfieldExam.add(nelsonMuntz);
        studentsThatHaveTakenTheSpringfieldExam.add(milhouseVanHouten);
        studentsThatHaveTakenTheSpringfieldExam.add(martinPrince);

        List<Student> studentsThatMissedOrFailedTheExam = getStudentsThatMissedOrFailedTheExam();
        //Only those students who didn't take the exam are allowed to take it again
        studentsThatMissedOrFailedTheExam.stream().filter(student -> !studentsThatHaveTakenTheSpringfieldExam.contains(student))
            .forEach(s -> System.out.println(String.format("%s %s can take the exam", s.getFirstName(), s.getLastName())));

        //Check that only students living in Springfield, took the exam
        Optional<Boolean> checkAllStudentsAreFromSpringfield =
            studentsThatHaveTakenTheSpringfieldExam.stream().map(s -> s.getCity().equals(CITY)).findAny();
        if (checkAllStudentsAreFromSpringfield.isPresent()) {
            System.err.println("********* WARNING!!!! ********** There are students from other cities taking this exam!");
        }

        /***********************************************  Expected result ********************************************
         * We know that all students are from Springfield and that only Ralph has a chance to take the exam
         ************************************************************************************************************/

    }

    private static List<Student> getStudentsThatMissedOrFailedTheExam() {
        //Call external service that gives us the students that either failed the exam or didn't take it the first time
        Student failed1 =
            new Student("bartSimpson123", "Bart", "Simpson", "ElBarto", "742 Evergreen Terrace", "45789", "Springfield", "USA");
        Student failed2 =
            new Student("nelsonMuntz789", "Nelson", "Muntz", "Nelson", "743 Evergreen Terrace", "45789", "Springfield", "USA");
        Student missing1 =
            new Student("ralphWiggum345", "Ralph", "Wiggum", "Ralph", "745 Evergreen Terrace", "45789", "Springfield", "USA");

        return Arrays.asList(failed1, failed2, missing1);
    }

}
