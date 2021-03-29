package tugas;

public class Tugas {
  public static void main(String[] args) {
    Segitiga segitiga = new Segitiga(5, 5);
    Persegi persegi = new Persegi(5);
    PersegiPanjang persegiPanjang = new PersegiPanjang(5, 10);
    Lingkaran lingkaran = new Lingkaran(10);

    /*Hitung keliling*/
    System.out.println("Keliling Segitiga = " + segitiga.keliling());
    System.out.println("Keliling Persegi = " + persegi.keliling());
    System.out.println("Keliling Persegi Panjang = " + persegiPanjang.keliling());
    System.out.println("Keliling Linkaran = " + lingkaran.keliling());

    /*Hitung Luas*/
    System.out.println("Luas Segitiga = " + segitiga.luas());
    System.out.println("Luas Persegi = " + persegi.luas());
    System.out.println("Luas Persegi Panjang = " + persegiPanjang.luas());
    System.out.println("Luas Linkaran = " + lingkaran.luas());
  }
}
