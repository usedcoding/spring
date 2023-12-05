package com.std.sbb.user;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    //SecurityConfig에서 @Bean으로 생성한 PasswordEncoder 객체
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String username, String email, String password) {
        //SiteUser 객체 생성
        SiteUser user = new SiteUser();
        //SiteUser 객체에 새롭게 받은 username을 저장한다.
        user.setUsername(username);
        //SiteUser 객체에 새롭게 받은 email 을 저장한다.
        user.setEmail(email);
        //password는 보안을 위해 반드시 암호화를 해서 저장해야 한다.
        //암호화를 위해 시큐리티의 BCryptPasswordEncoder 클래스를 사용했다.
        //하지만 이렇게 객체를 직접 저장하게 되면 암호화 방식 변경시 일일이 찾아야 한다.
        //SecurityConfig에서 @Bean을 사용하여 만든다.
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //uSiteUser 객체에 새롭게 받아 암호화한 password를 저장한다.
        user.setPassword(passwordEncoder.encode(password));
        //저장된 모든 SiteUser 객체 데이터를 userRepository에 저장 한다.
        this.userRepository.save(user);
        //생성된 SiteUser 객체를 반환한다.
        return user;

    }
}
