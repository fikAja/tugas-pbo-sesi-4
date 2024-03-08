import java.lang.Math;

abstract class BangunDatar {
    abstract double luas();
    abstract double keliling();
}

class Segitiga extends BangunDatar {
    protected double alas, tinggi, sisi1, sisi2, sisi3;

    public Segitiga(double alas, double tinggi, double sisi1, double sisi2, double sisi3) {
        this.alas = alas;
        this.tinggi = tinggi;
        this.sisi1 = sisi1;
        this.sisi2 = sisi2;
        this.sisi3 = sisi3;
    }

    @Override
    double luas() {
        double s = (sisi1 + sisi2 + sisi3) / 2;
        return Math.sqrt(s * (s - sisi1) * (s - sisi2) * (s - sisi3));
    }

    @Override
    double keliling() {
        return sisi1 + sisi2 + sisi3;
    }
}

class SegitigaSikuSiku extends Segitiga {
    public SegitigaSikuSiku(double alas, double tinggi, double sisi1, double sisi2) {
        super(alas, tinggi, sisi1, sisi2, Math.sqrt(alas * alas + tinggi * tinggi));
    }
}

class SegitigaSamaKaki extends Segitiga {
    public SegitigaSamaKaki(double alas, double tinggi, double sisi) {
        super(alas, tinggi, sisi, sisi, sisi);
    }
}

class SegitigaSamaSisi extends Segitiga {
    public SegitigaSamaSisi(double sisi) {
        super(sisi, (Math.sqrt(3) / 2) * sisi, sisi, sisi, sisi);
    }
}

class SegitigaSembarang extends Segitiga {
    public SegitigaSembarang(double alas, double tinggi, double sisi1, double sisi2, double sisi3) {
        super(alas, tinggi, sisi1, sisi2, sisi3);
    }
}

class Persegi extends BangunDatar {
    private double sisi;

    public Persegi(double sisi) {
        this.sisi = sisi;
    }

    @Override
    double luas() {
        return sisi * sisi;
    }

    @Override
    double keliling() {
        return 4 * sisi;
    }
}

class Lingkaran extends BangunDatar {
    private double radius;

    public Lingkaran(double radius) {
        this.radius = radius;
    }

    @Override
    double luas() {
        return Math.PI * radius * radius;
    }

    @Override
    double keliling() {
        return 2 * Math.PI * radius;
    }
}

public class Main {
    public static void main(String[] args) {
        Persegi persegi = new Persegi(5);
        System.out.println("Luas Persegi: " + persegi.luas());
        System.out.println("Keliling Persegi: " + persegi.keliling());

        Lingkaran lingkaran = new Lingkaran(7);
        System.out.println("Luas Lingkaran: " + lingkaran.luas());
        System.out.println("Keliling Lingkaran: " + lingkaran.keliling());

        SegitigaSamaSisi segitigaSamaSisi = new SegitigaSamaSisi(6);
        System.out.println("Luas Segitiga Sama Sisi: " + segitigaSamaSisi.luas());
        System.out.println("Keliling Segitiga Sama Sisi: " + segitigaSamaSisi.keliling());
    }
}
