package kr.kiw0n.hierarchyPlusDtoPlusDB.domain;

public class User {
    private String name; // 이름
    private int age; // 나이
    private int grade; // 학년
    private String gender; // 성별

    public User(String name, int age, int grade, String gender) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.gender = gender;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public int getGrade(){
        return grade;
    }
    public String getGender(){
        return gender;
    }

    public void update(int age, int grade, String gender){
        this.age = age;
        this.grade = grade;
        this.gender = gender;
    }
}