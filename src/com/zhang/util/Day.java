package com.zhang.util;

/**
 * @Description:
 * @Author: dl.zhang
 * @CreateDate: 2019/3/8 8:40
 **/
public enum Day {

    MONDAY(1, "星期一", "各种不在状态"){
        @Override
        public Day getNext() {
            return TUESDAY;
        }
    },
    TUESDAY(2, "星期二", "依旧犯困"){
        @Override
        public Day getNext() {
            return WEDNESDAY;
        }
    },
    WEDNESDAY(3, "星期三", "感觉半周终于过去了"){
        @Override
        public Day getNext() {
            return THURSDAY;
        }
    },
    THURSDAY(4, "星期四", "期待这星期五"){
        @Override
        public Day getNext() {
            return FRIDAY;
        }
    },
    FRIDAY(5, "星期五", "感觉还不错"){
        @Override
        public Day getNext() {
            return SATURDAY;
        }
    },
    SATURDAY(6, "星期六", "感觉非常好"){
        @Override
        public Day getNext() {
            return SUNDAY;
        }
    },
    SUNDAY(7, "星期日", "感觉周末还没过够。。。"){
        @Override
        public Day getNext() {
            return MONDAY;
        }
    };

    Day(int index, String name, String value) {
        this.index = index;
        this.name = name;
        this.value = value;
    }

    private int index;
    private String name;
    private String value;
    public abstract Day getNext();

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

class EnumTest {
    Day day;

    public EnumTest(Day day) {
        this.day = day;
    }

    public void tellItLikeItIs() {
        switch (day) {
            case MONDAY:
                System.out.println(day.getName()+day.getValue());
                System.out.println(day.getName()+"的下一天是"+day.getNext().getName());
                break;

            case FRIDAY:
                System.out.println(day.getName()+day.getValue());
                System.out.println(day.getName()+"的下一天是"+day.getNext().getName());
                break;

            case SATURDAY: case SUNDAY:
                System.out.println(day.getName()+day.getValue());
                System.out.println(day.getName()+"的下一天是"+day.getNext().getName());
                break;

            default:
                System.out.println(day.getName()+day.getValue());
                System.out.println(day.getName()+"的下一天是"+day.getNext().getName());
                break;
        }
    }

    public static void main(String[] args) {
        EnumTest firstDay = new EnumTest(Day.MONDAY);
        firstDay.tellItLikeItIs();
        EnumTest thirdDay = new EnumTest(Day.WEDNESDAY);
        thirdDay.tellItLikeItIs();
        EnumTest fifthDay = new EnumTest(Day.FRIDAY);
        fifthDay.tellItLikeItIs();
        EnumTest sixthDay = new EnumTest(Day.SATURDAY);
        sixthDay.tellItLikeItIs();
        EnumTest seventhDay = new EnumTest(Day.SUNDAY);
        seventhDay.tellItLikeItIs();
    }
}
