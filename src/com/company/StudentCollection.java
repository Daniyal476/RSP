package com.company;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StudentCollection {
    int MaxCourse;
    ArrayList<Student> students = new ArrayList<Student>();
    ArrayList<String> faculties = new ArrayList<String>(); // список факультетов
    ArrayList<String> groups = new ArrayList<String>(); // Список групп

    private void AddGroups(Student student){
        if(groups.isEmpty() && !students.isEmpty())  // если список факультета пустой и если список студентов пустой то
        {                                               // внесем факультет первого студента.
            groups.add(students.get(0).getGroup());
            return;
        }

        if(!groups.contains(student.getGroup())){
            groups.add(student.getGroup());
        }
    }

    private void RemoveGroups(Student student){ // удаление факультета
        if(!groups.isEmpty() && !students.contains(student.getGroup())){
            groups.remove(student.getGroup());
        }
    }

    private void AddFaculties(Student student){ // новый факультет факультетов.
        if(faculties.isEmpty() && !students.isEmpty())  // если список факультета пустой и если список студентов пустой то
        {                                               // внесем факультет первого студента.
            faculties.add(students.get(0).getFaculty());
            return;
        }

        if(!faculties.contains(student.getFaculty())){
            faculties.add(student.getFaculty());
        }
    }

    private void RemoveFaculties(Student student){ // удаление факультета
        if(!faculties.isEmpty() && !students.contains(student.getFaculty())){
            faculties.remove(student.getFaculty());
        }
    }

    private boolean ChekUniqueId(Student student){ // проверка уникальности ID.
        if (!students.isEmpty())
        {
            for (Student i: students)
            {
                if (student.getId() == i.getId())
                    return false;
            }
        }
        return true;
    }

    public void Add(Student student){ // внесение нового студента
        if(ChekUniqueId(student))
            students.add(student);
        AddFaculties(student);
        AddGroups(student);
        if(MaxCourse < student.getCourse()) MaxCourse = student.getCourse();
    }

    public void Remove(Student student){ // удаление студента
        students.remove(student);
        RemoveFaculties(student);
        RemoveGroups(student);
    }

    public ArrayList<Student> ListStudentsInGroup(String group){ // Список студентов в заданной группе.
        ArrayList<Student> result = new ArrayList<Student>();
        for (Student i: students) {
            if(i.getGroup() == group){
                result.add(i);
            }
        }
        return result;
    }

    public void ListStudentsInCoursesAndFaculty(){ // Список студентов по факультету и курсу.
        for (String i: faculties) {
            System.out.println(i+": ");
            for (int j=1; j <= MaxCourse; j++){
                System.out.printf("%1$10s %n","Курс "+j+": ");
                for(Student c: students) {
                    if (c.getCourse() == j && c.getFaculty() == i) System.out.printf("%1$5s %2$s %n"," ", c.toString());
                }
            }
        }
    }

    public  ArrayList<Student> ListStudentBornAfterYear(String dateOfBirth){ // Список студентов родившиеся позже заданного года
        ArrayList<Student> result = new ArrayList<Student>();
        Date date = null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); // формат даты
        try{
            date = simpleDateFormat.parse(String.valueOf(dateOfBirth)); // Парсинг строки и присвоение даты
        } catch (ParseException e){
            System.out.println("Неверный формат даты");
        }

        for (Student i: students)
        {
            if(i.getDateOfBirth().getYear() > date.getYear()){
                result.add(i);
            }
        }
        return result;
    }

    public void ListOfStudyGroup(){ // Список учебных групп
        ArrayList<String> result = new ArrayList<String>();

        for (String i: faculties) {
            System.out.println("Факультет: " + i + ": ");
            for(Student j: students){
                if(i == j.getFaculty() && !result.contains(j.getGroup())){
                    result.add(j.getGroup());
                }
            }
            for(String j: result){
                System.out.printf("%1$5s %2$s %n"," ", j.toString());
            }
            result.clear();
        }
    }
}
