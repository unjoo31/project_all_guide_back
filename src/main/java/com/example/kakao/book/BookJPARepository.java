package com.example.kakao.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJPARepository extends JpaRepository<Book, Integer> {

}
