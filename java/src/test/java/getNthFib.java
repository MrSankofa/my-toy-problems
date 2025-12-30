import org.junit.jupiter.api.Test;

public class getNthFib {



  public static int getNthFib(int n) {

    if( n == 2) {
      return 1;
    } else if( n <= 1) {
      return 0;
    } else {
      return getNthFib(n - 1) + getNthFib(n - 2);
    }
  }
}
