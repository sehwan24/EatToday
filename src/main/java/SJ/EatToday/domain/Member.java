package SJ.EatToday.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)  //기본 생성자 생성
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @OneToOne(mappedBy = "member", fetch = FetchType.LAZY)
    private Preference preference;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public Member(String password, String email, Authority authority) {
        this.password = password;
        this.email = email;
        this.authority = authority;
    }
}
