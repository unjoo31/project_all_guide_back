package com.example.kakao.whereStore;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.example.kakao.category.Category;
import com.example.kakao.menu.Menu;
import com.example.kakao.region.Region;
import com.example.kakao.user.User;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="where_store_tb")
public class WhereStore {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(fetch = FetchType.LAZY)
    private Category category;
    @OneToOne(fetch = FetchType.LAZY)
    private Region region;
    @Column(nullable = false)
    private String storeName;
    @Column(nullable = false)
    private String storeAddress;
    @OneToMany(fetch = FetchType.LAZY)
    private Menu menu;

    @Builder
    public WhereStore(int id, Category category, Region region, String storeName, String storeAddress, Menu menu) {
        this.id = id;
        this.category = category;
        this.region = region;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.menu = menu;
    }  
}
