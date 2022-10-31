package com.shoppi.roomdatabase_sample;

import androidx.room.Database;
import androidx.room.RoomDatabase;

//room을 활용하려면 클래스마다 @로 언온테이션?을 준비 해줘야함

@Database(entities = {User.class}, version = 1) //변경사항에대해 관리하려면 버전을 명시해줘야 함, User라는 테이블 안에 데이터를 넣을 것임
public abstract class UserDatabase extends RoomDatabase { //추상 클래스 활용
    public abstract UserDao userDao(); // 아까 만든 UserDao

}
