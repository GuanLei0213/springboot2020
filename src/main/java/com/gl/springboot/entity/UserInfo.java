package com.gl.springboot.entity;

import com.gl.springboot.annotation.Validate;
import lombok.Data;

@Data
public class UserInfo implements Comparable<UserInfo> {

    @Validate(minLength = 2,maxLength = 8,blank = true)
    private String userId;

    private String userName;

    private Integer userAge;

    private String userSex;

    private String userWork;

    public UserInfo() {
    }

    public UserInfo(String userId, String userName, Integer userAge) {
        this.userId = userId;
        this.userName = userName;
        this.userAge = userAge;
    }

    @Override
    public int compareTo(UserInfo o) {
        if (this.userAge > o.getUserAge()){
            return 1;
        }
        return -1;
    }
}
