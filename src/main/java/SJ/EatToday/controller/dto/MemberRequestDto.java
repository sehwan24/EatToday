package SJ.EatToday.controller.dto;

import SJ.EatToday.domain.Authority;
import SJ.EatToday.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequestDto {

    private String email;
    private String password;

    public Member toMember(PasswordEncoder passwordEncoder) {
        System.out.println("email = " + email);
        System.out.println("password = " + password);
        return Member.builder()
                .email(email.split("\"")[3])//.split("\"")[3])
                .password(passwordEncoder.encode(password.split("\"")[3]))//.split("\"")[3]))
                .authority(Authority.ROLE_USER)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        System.out.println("email = " + email);
        System.out.println("password = " + password);
        return new UsernamePasswordAuthenticationToken(email.split("\"")[3], password.split("\"")[3]);//.split("\"")[3], password.split("\"")[3]);
    }
}
