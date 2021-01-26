package com.company;

public class Main {

    public static void main(String[] args) {
        StudentCollection sc = new StudentCollection();
        sc.Add(new Student(0, "Аблаев", "Артур", "Зинурович", "1998-08-11", "Бахчисарай", "+79787278622", "Менеджемнт и экономика", 3, "I-2-18"));
        sc.Add(new Student(1, "Одобаши", "Сали", "Асанович", "1999-07-10", "Судак", "+79116695947", "Менеджемнт и экономика", 1, "I-1-18"));
        sc.Add(new Student(2, "Мартыненко", "Роман", "Сергеевич", "1999-08-25", "Джанкой", "+79180303030", "Менеджемнт и экономика", 2, "I-2-18"));
        sc.Add(new Student(3, "Мартыненко", "Роман", "Сергеевич", "1999-08-25", "Джанкой", "+79180303030", "Менеджемнт", 2, "I-2-18"));

        for(Student i: sc.ListStudentsInGroup("I-2-18")){
            System.out.println(i.toString());
        }
        System.out.println();

        for(Student i: sc.ListStudentBornAfterYear("1998-03-03")){
            System.out.println(i.toString());
        }
        System.out.println();

        sc.ListOfStudyGroup();
        System.out.println();

        sc.ListStudentsInCoursesAndFaculty();
    }
}
