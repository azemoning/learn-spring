package tugas;

public class Persegi implements BangunDatar {
  private Integer sisi;

  public Persegi(Integer sisi) {
    this.sisi = sisi;
  }

  @Override
  public Integer keliling() {
    return 4 * this.sisi;
  }

  @Override
  public Integer luas() {
    return this.sisi * this.sisi;
  }
}
