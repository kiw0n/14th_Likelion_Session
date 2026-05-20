package kr.kiw0n.hierarchyPlusDtoPlusDB.dto;

public class UserDto {
    public String name;
    public int age;
    public int grade;
    public String gender;

    public UserDto(String name, int age, int grade, String gender) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getGrade() {
        return grade;
    }

    public String getGender() {
        return gender;
    }
}