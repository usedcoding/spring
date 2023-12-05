package com.std.sbb.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
    //username의 길이가 최소 3에서 최대 25이다.
    @Size(min = 3, max = 25)
    //username에는 빈 값이나 null이 들어가는지 검증하고 만약 빈 값이나 null이 들어 가게 된다면 지정된 메시지를 출력 한다.
    @NotEmpty(message = "사용자ID는 필수항목입니다.")
    private String username;
    //password1에 빈 값이나 null이 들어가는지 검증하고 만약 빈 값이나 null이 들어 가게 된다면 지정된 메시지를 출력 한다.
    @NotEmpty(message = "비밀번호는 필수항목입니다.")
    private String password1;
    //password2에 빈 값이나 null이 들어가는지 검증하고 만약 빈 값이나 null이 들어 가게 된다면 지정된 메시지를 출력 한다.
    @NotEmpty(message = "비밀번호 확인은 필수항목입니다.")
    private String password2;
    //email에 빈 값이나 null이 들어가는지 검증하고 만약 빈 값이나 null이 들어 가게 된다면 지정된 메시지를 출력 한다.
    @NotEmpty(message = "이메일은 필수항목입니다.")
    //해당 속성의 값이 email의 형태와 일치 하는지 검증한다.
    @Email
    private String email;
}