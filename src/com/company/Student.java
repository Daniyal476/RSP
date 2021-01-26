package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Student {
    /*
    ID, фамилия, имя, отчетсво, Дата рождения, адрес, телефон, Факультет, Курс, Группа.
     */

    Integer Id;
    String LastName;
    String FirstName;
    String Patronymic;
    Date DateOfBirth;
    String Address;
    String PhoneNumber;
    String Faculty;
    Integer Course;
    String Group;

    public Student(Integer id, String lastName, String firstName,
                   String patronymic, String dateOfBirth, String address,
                   String phoneNumber, String faculty, Integer course, String group) {
        Id = id;
        LastName = lastName;
        FirstName = firstName;
        Patronymic = patronymic;
        setDateOfBirth(dateOfBirth);
        Address = address;
        setPhoneNumber(phoneNumber);
        Faculty = faculty;
        Course = course;
        Group = group;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setPatronymic(String patronymic) {
        Patronymic = patronymic;
    }

    public void setDateOfBirth(String dateOfBirth) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); // формат даты
        try{
            this.DateOfBirth = simpleDateFormat.parse(dateOfBirth); // Парсинг строки и присвоение даты
        } catch (ParseException e){
            System.out.println("Неверный формат даты");
        }
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        String pattern = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$"; // паттерн для валидации номера телефона
        if (phoneNumber.matches(pattern)){ // Проверка валидации по паттерну
            PhoneNumber = phoneNumber;
        }
    }

    public void setFaculty(String faculty) {
        Faculty = faculty;
    }

    public void setCourse(Integer course) {
        Course = course;
    }

    public void setGroup(String group) {
        Group = group;
    }

    public Integer getId() {
        return Id;
    }

    public String getLastName() {
        return LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public String getDateOfBirthString() {
        return String.format("%1$td %1$tB %1$tY", DateOfBirth);
    }

    public String getAddress() {
        return Address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getFaculty() {
        return Faculty;
    }

    public Integer getCourse() {
        return Course;
    }

    public String getGroup() {
        return Group;
    }

    @Override
    public String toString() {
        return "Студетнт: " +
                "Id=" + Id +
                ", LastName='" + LastName + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", Patronymic='" + Patronymic + '\'' +
                ", DateOfBirth=" + DateOfBirth +'\'' +
                ", Address='" + Address + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Faculty='" + Faculty + '\'' +
                ", Course=" + Course + '\'' +
                ", Group=" + Group +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(Id, student.Id) &&
                Objects.equals(LastName, student.LastName) &&
                Objects.equals(FirstName, student.FirstName) &&
                Objects.equals(Patronymic, student.Patronymic) &&
                Objects.equals(DateOfBirth, student.DateOfBirth) &&
                Objects.equals(Address, student.Address) &&
                Objects.equals(PhoneNumber, student.PhoneNumber) &&
                Objects.equals(Faculty, student.Faculty) &&
                Objects.equals(Course, student.Course) &&
                Objects.equals(Group, student.Group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, LastName, FirstName, Patronymic, DateOfBirth, Address, PhoneNumber, Faculty, Course, Group);
    }
}
