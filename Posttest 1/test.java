import java.util.ArrayList;
import java.util.Scanner;

class CasingHP {
    String nama;
    int stok;
    int harga;
    String deskripsi;

    public CasingHP(String nama, int stok, int harga, String deskripsi) {
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
        this.deskripsi = deskripsi;
    }
}

class ProgramPenjualan {
    ArrayList<CasingHP> listCasingHP = new ArrayList<CasingHP>();

    void menu() {
        System.out.println("Sistem Penjualan Online Shop Casing HP");
        System.out.println("======================================");
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
        System.out.print("Masukkan deskripsi : ");
        sc.nextLine();
        String deskripsi = sc.nextLine();
        listCasingHP.add(new CasingHP(nama, stok, harga, deskripsi));
    }

    void readAllData() {
        System.out.println("Daftar Produk : ");
        for (CasingHP casingHP : listCasingHP) {
                System.out.println("====================================");
                System.out.println("Nama : " + casingHP.nama);
                System.out.println("Stok : " + casingHP.stok);
                System.out.println("Harga : " + casingHP.harga);
                System.out.println("Deskripsi : " + casingHP.deskripsi);
            }
        }

    void updateData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nama produk :");
        String nama = sc.nextLine();
        for (CasingHP casingHP : listCasingHP) {
            if (casingHP.nama.equalsIgnoreCase(nama)) {
                System.out.print("Masukkan nama produk baru :");
                ;
                casingHP.nama = sc.nextLine();
                System.out.print("Masukkan jumlah stok baru :");
                ;
                casingHP.stok = sc.nextInt();
                System.out.print("Masukkan harga baru :");
                ;
                casingHP.harga = sc.nextInt();
                System.out.print("Masukkan deskripsi baru :");
                ;
                sc.nextLine();
                casingHP.deskripsi = sc.nextLine();
            }
        }
    }

    void deleteData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nama produk :");
        String nama = sc.nextLine();
        for (int i = 0; i < listCasingHP.size(); i++) {
            if (listCasingHP.get(i).nama.equalsIgnoreCase(nama)) {
                listCasingHP.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        ProgramPenjualan programPenjualan = new ProgramPenjualan();
        Scanner sc = new Scanner(System.in);
        int pilih;
        do {
            programPenjualan.menu();
            pilih = sc.nextInt();
            switch (pilih) {
                case 1:
                    programPenjualan.createData();
                    break;
                case 2:
                    programPenjualan.readAllData();
                    break;
                case 3:
                    programPenjualan.updateData();
                    break;
                case 4:
                    programPenjualan.deleteData();
                    break;
                case 5:
                    System.out.println("Terimakasih telah menggunakan");
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        } while (pilih != 5);
    }
}