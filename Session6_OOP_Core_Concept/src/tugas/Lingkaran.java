package tugas;

public class Lingkaran implements BangunDatar {

  private Integer jariJari;
  private static final double phi = 3.14;

  public Lingkaran(Integer jariJari) {
    this.jariJari = jariJari;
  }

  @Override
  public Integer keliling() {
    double result = 2 * phi * this.jariJari;
    return (int) result;
  }

  @Override
  public Integer luas() {
    double result = phi * (Math.pow(jariJari, 2));
    return (int) result;
  }
}
