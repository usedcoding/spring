package com.std.sbb.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SiteUser {
    //해당 변수가 엔티티의 primary key이다.
    @Id
    //primary의 값이 자동으로 생성된다.
    //값이 생성 될 때 마다 1씩 자동으로 증가
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //값이 고유하다, 중복되게 저장할 수 없다.
    @Column(unique = true)
    private String username;

    private String password;

    //값이 고유하다, 중복되게 저장할 수 없다.
    @Column(unique = true)
    private String email;

}
