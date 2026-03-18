package io.ch17_1.array;

import java.util.ArrayList;

public class ArrayListEx2 {

    public static void main(String[] args) {
        // 정수, 실수, 불리언, 사용자 정의 객체를 담을수 있는 ArrayList 각각 만들어 사용해보기
        ArrayList<Integer> intList = new ArrayList<>();
        ArrayList<Double> doubleList = new ArrayList<>();
        ArrayList<Boolean> booleanList= new ArrayList<>();
        ArrayList<Book> bookList = new ArrayList<>();

        intList.add(1);
        intList.add(2);
        intList.add(3);

        doubleList.add(0.0);
        doubleList.add(1.0);
        doubleList.add(2.0);

        booleanList.add(true);
        booleanList.add(false);

        Book book = new Book();
        book.title = "123123";
        bookList.add(book);

        System.out.println(intList.get(1));
        System.out.println(doubleList.get(0));
        System.out.println(booleanList.get(1));
        System.out.println(bookList.get(0));
    }

}

class Book {
    String title;
}

