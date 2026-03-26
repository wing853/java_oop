package generic.ch03;


import generic.ch02.Water;

public class MainTest {

    public static void main(String[] args) {
        Water water = new Water();
        Plastic plastic = new Plastic();
        Powder powder = new Powder();

        // GenericExtendsPrinter <-- 제네릭 클래스로 설계되어있어 <>를 사용할 수 있다.
        // GenericExtendsPrinter<water> printer = new GenericExtendsPrinter();
        // 오류 발생 - Water 타입은 Material의 자식이 아니기 때문에 사용 할 수 없음

        GenericExtendsPrinter<Plastic> printer = new GenericExtendsPrinter<>();
        printer.setMaterial(plastic);
        System.out.println(printer.getMaterial());
        printer.getMaterial().showInfo();
    }
}
