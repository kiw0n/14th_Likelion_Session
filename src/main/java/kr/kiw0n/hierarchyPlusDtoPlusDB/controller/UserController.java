package kr.kiw0n.hierarchyPlusDtoPlusDB.controller;

import java.util.List;
import java.util.Scanner;

import kr.kiw0n.hierarchyPlusDtoPlusDB.dto.UserDto;
import kr.kiw0n.hierarchyPlusDtoPlusDB.service.UserService;

public class UserController {
    private final UserService userService = new UserService();
    private final Scanner sc = new Scanner(System.in);

    public void start(){
        while (true) {
            System.out.println("\n***** 회원 관리 프로그램 *****");
            System.out.println("1. 회원가입");
            System.out.println("2. 회원조회");
            System.out.println("3. 회원목록");
            System.out.println("4. 회원업데이트");
            System.out.println("5. 회원삭제");
            System.out.println("0. 종료");
            System.out.println("메뉴 선택: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("프로그램 종료");
                    return;
                case 1:
                    signUp(); break;
                case 2:
                    findUser(); break;
                case 3:
                        showUsers(); break;
                case 4:
                    updateUser(); break;
                case 5:
                    deleteUser(); break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private void signUp(){
        System.out.print("이름: ");
        String name = sc.nextLine();
        System.out.print("나이: ");
        int age = sc.nextInt();
        System.out.print("학년: ");
        int grade = sc.nextInt();
        System.out.print("성별: ");
        String gender = sc.next();
        sc.nextLine();

        UserDto dto = new UserDto(name, age, grade, gender);

        userService.signUp(dto);

        System.out.println("회원가입 성공!!");
    }

    private void findUser(){
        System.out.print("이름: ");
        String name = sc.nextLine();

        UserDto user = userService.findUser(name);

        if (user != null){
            System.out.println("이름: " + user.name + ", 나이: " + user.age +
                    ", 학년: " + user.grade + ", 성별: " + user.gender);
        } else {
            System.out.println("회원을 찾을 수 없습니다.");
        }
    }

    private void showUsers(){
        List<UserDto> users = userService.showUsers();

        System.out.println("회원 목록");
        for (UserDto user : users){
            System.out.println("이름: " + user.name + ", 나이: " + user.age +
                    ", 학년: " + user.grade + ", 성별: " + user.gender);
        }
    }

    private void updateUser(){
        System.out.print("이름: ");
        String name = sc.nextLine();
        System.out.print("새 나이: ");
        int age = sc.nextInt();
        System.out.print("새 학년: ");
        int grade = sc.nextInt();
        System.out.print("새 성별: ");
        String gender = sc.next();
        sc.nextLine();

        UserDto dto = new UserDto(name, age, grade, gender);

        boolean result = userService.updateUser(name, dto);

        if (result){
            System.out.println("수정 완료!!");
        } else{
            System.out.println("회원을 찾을 수 없습니다.");
        }
    }

    private void deleteUser(){
        System.out.print("이름: ");
        String name = sc.nextLine();

        boolean result = userService.deleteUser(name);

        if (result){
            System.out.println("삭제 완료!!");
        } else{
            System.out.println("회원을 찾을 수 없습니다.");
        }
    }
}