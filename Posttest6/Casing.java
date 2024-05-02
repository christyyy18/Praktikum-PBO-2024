package Posttest6;

import java.util.ArrayList;
import java.util.Scanner;

interface ProductManagement {
    void createData();
    void readAllData();
    void updateData();
    void deleteData();
    void menu();

    //2 method
    void searchByName(String name);
    void displayTotalProducts();
}

abstract class CasingHP {
    private String nama;
    private int stok;
    private int harga;
    private String tipeHp;

    public CasingHP(String nama, int stok, int harga, String tipeHp) {
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
        this.tipeHp = tipeHp;
    }

    // Getter
    public String getNama() {
        return nama;
    }

    public int getStok() {
        return stok;
    }

    public int getHarga() {
        return harga;
    }

    public String getTipeHp() {
        return tipeHp;
    }

    // Setter
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setTipeHp(String tipeHp) {
        this.tipeHp = tipeHp;
    }

    public abstract void displayInfo();
}

final class CasingBiasa extends CasingHP {
    public CasingBiasa(String nama, int stok, int harga, String tipeHp) {
        super(nama, stok, harga, tipeHp);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void displayInfo() {
        System.out.println("====================================");
        System.out.println("Nama : " + getNama());
        System.out.println("Stok : " + getStok());
        System.out.println("Harga : " + getHarga());
        System.out.println("Tipe HP : " + getTipeHp());
        System.out.println("Kategori : Biasa");
        System.out.println("====================================");
    }
}

final class CasingAntiCrack extends CasingHP {
    private boolean anticrack;

    public CasingAntiCrack(String nama, int stok, int harga, String tipeHp, boolean anticrack) {
        super(nama, stok, harga, tipeHp);
        this.anticrack = anticrack;
    }
    //getter
    public boolean isAnticrack() {
        return anticrack;
    }

    public void setAnticrack(boolean anticrack) {
        this.anticrack = anticrack;
    }

    //overloading
    public CasingAntiCrack(String nama, int stok, int harga, String tipeHp) {
        this(nama, stok, harga, tipeHp, false);
    }

    @Override
    public void displayInfo() {
        System.out.println("====================================");
        System.out.println("Nama : " + getNama());
        System.out.println("Stok : " + getStok());
        System.out.println("Harga : " + getHarga());
        System.out.println("Tipe HP : " + getTipeHp());
        System.out.println("Anticrack : " + (anticrack ? "Ya" : "Tidak"));
        System.out.println("====================================");
    }
}

public final class Casing implements ProductManagement {
    private ArrayList<CasingHP> listCasingHP = new ArrayList<>();

    @Override
    public void menu() {
        System.out.println("==========================================");
        System.out.println("| Sistem Penjualan Online Shop Casing HP |");
        System.out.println("==========================================");
        System.out.println("1. Tambah Produk");
        System.out.println("2. Tampilkan Produk");
        System.out.println("3. Perbarui Produk");
        System.out.println("4. Hapus Produk");
        System.out.println("5. Cari Produk");
        System.out.println("6. Total Produk");
        System.out.println("7. Keluar");
        System.out.println("======================================");
        System.out.print("Pilih menu : ");
    }

    public void createData() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Masukkan nama produk : ");
        String nama = sc.nextLine();
        System.out.print("Masukkan jumlah stok : ");
        int stok = sc.nextInt();
        System.out.print("Masukkan harga : ");
        int harga = sc.nextInt();
        System.out.print("Masukkan tipe Hp : ");
        sc.nextLine();
        String tipeHp = sc.nextLine();
        System.out.println("Apakah casing anticrack? (true/false) : ");
        boolean anticrack = sc.nextBoolean();
        if (anticrack) {
            listCasingHP.add(new CasingAntiCrack(nama, stok, harga, tipeHp, true));
        } else {
            listCasingHP.add(new CasingBiasa(nama, stok, harga, tipeHp));
        }
    } catch (Exception e) {
        System.out.println("Input yang anda masukkan tidak valid");
        sc.nextLine();
    }
}
    @Override
    public void readAllData() {
        System.out.println("Daftar Produk : ");
        for (CasingHP casingHP : listCasingHP) {
            casingHP.displayInfo();
            }
        }

    @Override
    public void updateData() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Masukkan nama produk :");
        String nama = sc.nextLine();
        boolean isFound = false;
        for (CasingHP casingHP : listCasingHP) {
            if (casingHP.getNama().equalsIgnoreCase(nama)) {
                System.out.print("Masukkan nama produk baru :");
                String namaBaru = sc.nextLine();
                System.out.print("Masukkan jumlah stok baru :");
                int stokBaru = sc.nextInt();
                System.out.print("Masukkan harga baru :");
                int hargaBaru = sc.nextInt();
                System.out.print("Masukkan tipe HP baru :");
                sc.nextLine();
                String tipeHPBaru = sc.nextLine();
                if (casingHP instanceof CasingAntiCrack) {
                    System.out.println("Apakah casing anticrack? (true/false) : ");
                    boolean anticrack = sc.nextBoolean();
                    ((CasingAntiCrack) casingHP).setAnticrack(anticrack);
                }
                casingHP.setNama(namaBaru);
                casingHP.setStok(stokBaru);
                casingHP.setHarga(hargaBaru);
                casingHP.setTipeHp(tipeHPBaru);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("Produk tidak ditemukan");
        }
    } catch (Exception e) {
        System.out.println("Telah terjadi kesalahan saat memperbarui produk");
        sc.nextLine();
    }
}

    @Override
    public void deleteData() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Masukkan nama produk :");
        String nama = sc.nextLine();
        boolean isFound = false;
        for (int i = 0; i < listCasingHP.size(); i++) {
            if (listCasingHP.get(i).getNama().equalsIgnoreCase(nama)) {
                listCasingHP.remove(i);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("Produk tidak ditemukan");
        }
    } catch (Exception e) {
        System.out.println("Telah terjadi kesalahan saat menghapus produk");
        sc.nextLine();
    }
}

    @Override
    public void searchByName(String name) {
        boolean found = false;
        for (CasingHP casingHP : listCasingHP) {
            if (casingHP.getNama().equalsIgnoreCase(name)) {
                casingHP.displayInfo();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Produk dengan nama'" + name + "'tidak ditemukan");
        }
    }

    @Override
    public void displayTotalProducts() {
        System.out.println("Total produk: " + listCasingHP.size());
    }


    public static void main(String[] args) {
        Casing programPenjualan  = new Casing();
        Scanner sc = new Scanner(System.in);
        int pilih;
        do {
            programPenjualan.menu();
            pilih = sc.nextInt();
            switch (pilih) {
                case 1:
                    programPenjualan.createData();
                    System.out.println("");
                    System.out.println("~ Produk telah ditambahkan! ~");
                    System.out.println("");
                    break;
                case 2:
                    programPenjualan.readAllData();
                    System.out.println("");
                    break;
                case 3:
                    programPenjualan.updateData();
                    System.out.println("~ Produk telah diperbarui! ~");
                    System.out.println("");
                    break;
                case 4:
                    programPenjualan.deleteData();
                    System.out.println("~ Produk telah dihapus! ~");
                    System.out.println("");
                    break;
                case 5:
                    System.out.println("Masukkan nama produk yang ingin dicari: ");
                    sc.nextLine();
                    String productName = sc.nextLine();
                    programPenjualan.searchByName(productName);
                    break;
                case 6:
                    programPenjualan.displayTotalProducts();
                    break;
                case 7:
                    System.out.println("Terimakasih telah mengunjungi Olshop Kami!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        } while (pilih != 5);
    }
}