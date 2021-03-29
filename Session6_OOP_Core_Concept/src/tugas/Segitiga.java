package tugas;

public class Segitiga implements BangunDatar {

  private Integer sisi;
  private Integer alas;
  private Integer tinggi;

  public Segitiga(Integer alas, Integer tinggi) {
    this.alas = alas;
    this.sisi = alas;
    this.tinggi = tinggi;
  }

  @Override
  public Integer keliling() {
    return this.sisi + this.sisi + this.sisi;
  }

  @Override
  public Integer luas() {
    return (this.alas * this.tinggi) / 2;
  }
}
