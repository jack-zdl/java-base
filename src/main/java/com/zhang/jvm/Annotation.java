package com.zhang.jvm;

/**
 * @author zhangdl
 * @version class v1.0
 * @date 2017/8/2 21:44
 */
public
class Annotation {

    @Override
    public String toString(){
        return "";
    }

    public static void A(){
        throw new  Error();

    }

//    public int A(int i){
//        System.out.println(i);
//        return i+1;
//    }

    public static
    void main(String[] args) {
        int i =1,j =1,k=0;
        try {
//           A();
            System.out.println("A");
//            i ++;
//            j --;
//            k = i = j =1;
//            if( i == j){
//                System.out.println(i +"aaa"+ j);
//                i++;
//            }

//       }catch (ArithmeticException e){
//           System.out.println(0);
//       }catch (ArrayIndexOutOfBoundsException e){
//           System.out.println(1);
        }catch (Exception e){
            System.out.println("B");
        }finally {
            System.out.println("c");
        }
        System.out.println("D");
    }
}
