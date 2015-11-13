

public class PMDTest {
  public static void main(String args[]) {
    PMDTest.CALL_METHOD("hello");
    PMDTest.callHello();
  }

  public static void CALL_METHOD(String iNPUT_PARAMETER) {
    System.out.println(iNPUT_PARAMETER);
  }

  public static void callHello() {
    System.out.println("Hello PMD World!");
  }
}