package generic.ch02;

import generic.ch01.Plastic;
import generic.ch01.Powder;

/**
 *  제네릭 프로그래밍
 *  문법: 클래스, 데이터타입, 메서드 등에서<T> 대체 문자열을 선언할 수 있다.
 */

public class GenericPrinter<T> {

    // T(type) 라는 대체 문자 사용 가능 E, K, V(사실 아무 의미없는 문자열일 뿐이다)

    T material;

    public T getMaterial() {
        return material;
    }

    public void setMaterial (T material) {
        this.material = material;
    }

    public static void main(String[] args) {
        // 제네릭 프로그래밍을 활용하면 타입에 안정성을 줘서 컴파일 시(코드 작성시)
        // 명확하게 타입을 지정할 수 있다.
        Plastic plastic1 = new Plastic();
        Powder powder1 = new Powder();

        GenericPrinter<Plastic> genericPrinter = new GenericPrinter<>();

        // 컴파일 시저메 플라스틱을 넣기로 했는데 다른 타이비 들어가면 컴파일 오류가 발생
        //genericPrinter.setMaterial(powder1);
        genericPrinter.setMaterial(plastic1);
        Plastic tempPlastic = genericPrinter.getMaterial();
        // 컴파일 시점에 역시 타입을 확인 할 수 있어 추가로 다운캐스팅 작업도 필요가 없다.
        //Powder tempPlastic = genericPrinter.getMaterial();

    }
}
