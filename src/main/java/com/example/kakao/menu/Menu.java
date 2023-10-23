package com.example.kakao.menu;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="menu_tb")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String menuName;
    @Column(nullable = false)
    private String menuPrice;

    @Builder
    public Menu(int id, String menuName, String menuPrice) {
        this.id = id;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
    }   
}
