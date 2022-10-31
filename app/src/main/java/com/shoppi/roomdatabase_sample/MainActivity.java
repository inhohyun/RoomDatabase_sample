package com.shoppi.roomdatabase_sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private UserDao mUserDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //room 사용법

        UserDatabase database = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, "room_sample_db")
                .fallbackToDestructiveMigration() // 스키마(db를 말함) 버전 변경 카능
                .allowMainThreadQueries() // Main Thread에서 DBdp IO(입출력)를 가능하게 함, 쿼리를 사용 가능하도록
                .build();

        mUserDao = database.userDao(); // 아까 만든 인터페이스를 전역변수로 받음, 인터페이스 객체 할당

        //데이터 삽입
//        User user = new User(); // 객체 인스턴스 생성
//        user.setName("인호현");
//        user.setAge("24");
//        user.setPhoneNumber("01029954545");
//        mUserDao.setInsertUser(user);
//드래그+ctrl+/ : 드래그 한 부분 주석처리
        List<User> userList = mUserDao.getUserAll(); // UserDao에서 만든 조회 쿼리를 리스트에 저장
        //데이터 조회, fori+tap하면 자동 for문 완성됨
        for (int i = 0; i < userList.size(); i++) { // database 크기 만큼의 반복
            Log.d("TEST", userList.get(i).getName() + "\n"
                    + userList.get(i).getAge() + "\n"
                    + userList.get(i).getPhoneNumber() + "\n");

        }

//        //데이터 수정
//        User user2 = new User(); // 객체 인스턴스 생성
//        user2.setId(1); // 어떤 id 값을 참조할 것인지, 기본키 참조
//        user2.setName("인호현_수정");
//        user2.setAge("25");
//        user2.setPhoneNumber("01077777777");
//        mUserDao.setUpdateUser(user2);//userDao에 만든 setUpdateUser를 가져와 id(Primary key)가 참조하는 값을 위의 내용으로 수정

        //데이터 삭제
        User user3 = new User();
        user3.setId(2); // 참조할 기본키
        mUserDao.setDeletUser(user3);

    }


}