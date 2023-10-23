package com.example.kakao.pay;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.example.kakao.allGuide.AllGuide;
import com.example.kakao.user.User;
import com.example.kakao.whereGuide.WhereGuide;
import com.example.kakao.whoGuide.WhoGuide;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="pay_tb")
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    private WhereGuide whereGuide;

    @Builder
    public Pay(int id, User user, WhereGuide whereGuide) {
        this.id = id;
        this.user = user;
        this.whereGuide = whereGuide;
    }    
}
