package tugas;

public class PersegiPanjang implements BangunDatar {

  private Integer panjang;
  private Integer lebar;

  public PersegiPanjang(Integer panjang, Integer lebar) {
    this.panjang = panjang;
    this.lebar = lebar;
  }

  @Override
  public Integer keliling() {
    return 2 * (this.panjang * this.lebar);
  }

  @Override
  public Integer luas() {
    return this.panjang * this.lebar;
  }
}
