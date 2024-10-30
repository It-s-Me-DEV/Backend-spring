package me.shinsunyoung.springbootdeveloper.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest { // 사용자 정보를 담고있는 객체 설정
    private String email;
    private String password;
}
