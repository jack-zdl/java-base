package com.zhang.sort;

import java.util.Objects;

/**
 * 功能说明:    <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间:2018/7/8 21:48<br>
 * <br>
 */
public class User implements Comparable<User>{

    private int score;

    private int age;

    public User(int score, int age){
        super();
        this.score = score;
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public int compareTo(User o) {
        int i = this.getAge() - o.getAge();//先按照年龄排序
        if(i == 0){
            return this.score - o.getScore();//如果年龄相等了再用分数进行排序
        }
        return i;
    }

    @Override
    public String toString() {
        return "User{" +
                "score=" + score +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return score == user.score &&
                age == user.age;
    }

    @Override
    public int hashCode() {

        return Objects.hash(score, age);
    }
}
