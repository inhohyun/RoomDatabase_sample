package com.shoppi.roomdatabase_sample;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/*
Data Access Obhect
* */
@Dao //
public interface UserDao {
    @Insert // 삽입
    void setInsertUser(User user); // 앞서 만든 getter setter를 받아오는 역할

    @Update //수정
    void setUpdateUser(User user);

    @Delete // 삭제
    void setDeletUser(User user);

    //조회 쿼리
    @Query("SELECT * FROM User") // 쿼리 : 데이터베이스에 요청하는 명령문, * : 모든 속성
    List<User> getUserAll();
}
