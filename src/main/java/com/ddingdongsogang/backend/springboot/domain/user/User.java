package com.ddingdongsogang.backend.springboot.domain.user;


import com.ddingdongsogang.backend.springboot.domain.shared.BaseTimeEntity;
import com.ddingdongsogang.backend.springboot.domain.subscription.Subscription;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nick;

    @Column(nullable = false)
    private String email;

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "user"
    )
    private Set<Subscription> subscriptions;

    @Builder
    public User(String nick, String email) {
        this.nick = nick;
        this.email = email;
    }

    public User update(String nick) {
        this.nick = nick;
        return this;
    }

}
