package Posttest2;

import java.util.ArrayList;
import java.util.Scanner;

class CasingHP {
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
}

public class Casing {
    private ArrayList<CasingHP> listCasingHP = new ArrayList<>();

    void menu() {
        System.out.println("==========================================");
        System.out.println("| Sistem Penjualan Online Shop Casing HP |");
        System.out.println("==========================================");
        System.out.println("1. Tambah Produk");
        System.out.println("2. Tampilkan Produk");
        System.out.println("3. Perbarui Produk");
        System.out.println("4. Hapus Produk");
        System.out.println("5. Keluar");
        System.out.println("======================================");
        System.out.print("Pilih menu : ");
    }

    void createData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nama produk : ");
        String nama = sc.nextLine();
        System.out.print("Masukkan jumlah stok : ");
        int stok = sc.nextInt();
        System.out.print("Masukkan harga : ");
        int harga = sc.nextInt();
        System.out.print("Masukkan tipe Hp : ");
        sc.nextLine();
        String tipeHp = sc.nextLine();
        listCasingHP.add(new CasingHP(nama, stok, harga, tipeHp));
    }

    void readAllData() {
        System.out.println("Daftar Produk : ");
        for (CasingHP casingHP : listCasingHP) {
                System.out.println("====================================");
                System.out.println("Nama : " + casingHP.getNama());
                System.out.println("Stok : " + casingHP.getStok());
                System.out.println("Harga : " + casingHP.getHarga());
                System.out.println("tipe Hp : " + casingHP.getTipeHp());
                System.out.println("====================================");
            }
        }

    void updateData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nama produk :");
        String nama = sc.nextLine();
        boolean isFound = false;
        for (int i = 0; i < listCasingHP.size(); i++) {
            if (listCasingHP.get(i).getNama().equalsIgnoreCase(nama)) {
                System.out.print("Masukkan nama produk baru :");
                String namaBaru = sc.nextLine();
                System.out.print("Masukkan jumlah stok baru :");
                int stokBaru = sc.nextInt();
                System.out.print("Masukkan harga baru :");
                int hargaBaru = sc.nextInt();
                System.out.print("Masukkan tipe HP baru :");
                sc.nextLine();
                String tipeHPBaru = sc.nextLine();
                listCasingHP.get(i).setNama(namaBaru);
                listCasingHP.get(i).setStok(stokBaru);
                listCasingHP.get(i).setHarga(hargaBaru);
                listCasingHP.get(i).setTipeHp(tipeHPBaru);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("Produk tidak ditemukan");
        }
    }

    void deleteData() {
        Scanner sc = new Scanner(System.in);
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
                    System.out.println("Terimakasih telah mengunjungi Olshop Kami!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        } while (pilih != 5);
    }
}
