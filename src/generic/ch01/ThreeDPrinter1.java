package generic.ch01;

public class ThreeDPrinter1 {

    // 재료
    Plastic material;

    // 재료를 꺼냄
    public Plastic getMaterial() {
        return material;
    }

    // 재료를 넣음
    public void setMaterial(Plastic material) {
        this.material = material;
    }

    // 테스트 코드
    public static void main(String[] args) {
        Plastic plastic = new Plastic();
        ThreeDPrinter1 threeDPrinter1 = new ThreeDPrinter1();
        // 재료 장착
        threeDPrinter1.setMaterial(plastic);
        System.out.println(threeDPrinter1.getMaterial());
        // threeDPrinter1.getMaterial() --> plastic의  주소값
    }

}

