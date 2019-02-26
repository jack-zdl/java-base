package com.zhang.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 功能说明:    <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间:2018/7/8 21:50<br>
 * <br>
 */
public class SortUser {

    public static void main(String[] args) {
        List<User> users = new ArrayList<User>();
        users.add(new User(78, 26));
        users.add(new User(67, 23));
        users.add(new User(34, 56));
        users.add(new User(55, 23));
        Collections.sort(users);
        for(User user : users){
            System.out.println(user.getScore() + "," + user.getAge());
        }

    }

    public int baseConversion(int n){
        int module = n % 3;
        n = n /3;
//        if(){
//
//        }
        return 1;
    }
}
