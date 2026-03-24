package collection.set;

import java.util.*;

public class LottoGame {

    public static void main(String[] args) {
        Set<Integer> lotto = new HashSet<>();

        Random random = new Random();

        // 6개가 될때까지 계속 추가
        while (lotto.size() < 6) {
            int number = random.nextInt(45) + 1;
            lotto.add(number);
        }

        // ArrayList 생성자 안에 set 계열을 넣으면 자동으로 ArrayList 객체를 생성해준다.
        List<Integer> lottoNumber = new ArrayList<>(lotto);
        Collections.sort(lottoNumber);

        System.out.println("이번 주 로또 번호: " + lottoNumber);
        System.out.println("총 " + lottoNumber.size() + "개");
    }
}
