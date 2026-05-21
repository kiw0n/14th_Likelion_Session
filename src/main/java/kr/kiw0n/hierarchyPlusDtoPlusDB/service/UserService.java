package kr.kiw0n.hierarchyPlusDtoPlusDB.service;

import java.util.ArrayList;
import java.util.List;

import kr.kiw0n.hierarchyPlusDtoPlusDB.domain.User;
import kr.kiw0n.hierarchyPlusDtoPlusDB.dto.UserDto;
import kr.kiw0n.hierarchyPlusDtoPlusDB.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository = new UserRepository();

    public void signUp(UserDto dto){
        userRepository.save(new User(dto.name, dto.age, dto.grade, dto.gender));
    }

    public UserDto findUser(String name){
        User user = userRepository.findByName(name);

        if (user == null) return null;

        return new UserDto(
                user.getName(),
                user.getAge(),
                user.getGrade(),
                user.getGender()
        );
    }

    public List<UserDto> showUsers(){
        List<User> users = userRepository.findAll();
        List<UserDto> result = new ArrayList<>();

        for (User user : users){
            result.add(new UserDto(
                    user.getName(),
                    user.getAge(),
                    user.getGrade(),
                    user.getGender()));
        }
        return result;
    }

    public boolean updateUser(String name, UserDto dto){

        User updateUser = new User(name, dto.age, dto.grade, dto.gender);// 상태관리

        return userRepository.update(name, updateUser);
    }

    public boolean deleteUser(String name){

        return userRepository.delete(name);//저장 관리
    }
}
