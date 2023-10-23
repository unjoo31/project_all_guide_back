package com.example.kakao.HashMenu;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.example.kakao.menu.Menu;
import com.example.kakao.whereGuide.WhereGuide;
import com.example.kakao.whereStore.WhereStore;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="hash_menu_tb")
public class HashMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;
    @ManyToOne(fetch = FetchType.LAZY)
    private WhereStore whereStore;
    @ManyToOne(fetch = FetchType.LAZY)
    private WhereGuide whereGuide;

    @Builder
    public HashMenu(int id, Menu menu, WhereStore whereStore, WhereGuide whereGuide) {
        this.id = id;
        this.menu = menu;
        this.whereStore = whereStore;
        this.whereGuide = whereGuide;
    }
}
