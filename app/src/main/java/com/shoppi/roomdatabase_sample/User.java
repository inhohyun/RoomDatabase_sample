package com.shoppi.roomdatabase_sample;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity // room라이브러리 개체 추가
public class User { // 클래스 이름 기준으로 테이블이 생성
    @PrimaryKey(autoGenerate = true) // true로 하면 사용자가 추가 될 때마다 자동으로 id가 생성됨(0에서 자동으로 1, 2로 올라감), false면 user.setId해서 생성해줘야 함

    private int id = 0; // 하나의 사용자에 대한 고유 id 값

    private String name;

    private String age;

    private String phoneNumber;

    // getter & setter : db에서 가져오거나 세팅하기 위한 준비단계, alt+insert로 생성


    public int getId() {//getter
        return id;
    }

    public void setId(int id) {//setter
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
