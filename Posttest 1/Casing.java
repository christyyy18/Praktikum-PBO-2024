import java.util.ArrayList;
import java.util.Scanner;

class CasingHP {
    String nama;
    int stok;
    int harga;
    String tipeHp;

    public CasingHP(String nama, int stok, int harga, String tipeHp) {
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
        this.tipeHp = tipeHp;
    }
}

class ProgramPenjualan {
    ArrayList<CasingHP> listCasingHP = new ArrayList<>();

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
                System.out.println("Nama : " + casingHP.nama);
                System.out.println("Stok : " + casingHP.stok);
                System.out.println("Harga : " + casingHP.harga);
                System.out.println("tipe Hp : " + casingHP.tipeHp);
                System.out.println("====================================");
            }
        }

    void updateData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan nama produk :");
        String nama = sc.nextLine();
        boolean isFound = false;
        for (int i = 0; i < listCasingHP.size(); i++) {
            if (listCasingHP.get(i).nama.equalsIgnoreCase(nama)) {
                System.out.print("Masukkan nama produk baru :");
                String namaBaru = sc.nextLine();
                System.out.print("Masukkan jumlah stok baru :");
                int stokBaru = sc.nextInt();
                System.out.print("Masukkan harga baru :");
                int hargaBaru = sc.nextInt();
                System.out.print("Masukkan tipe HP baru :");
                sc.nextLine();
                String tipeHPBaru = sc.nextLine();
                listCasingHP.set(i, new CasingHP(namaBaru, stokBaru, hargaBaru, tipeHPBaru));
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
            if (listCasingHP.get(i).nama.equalsIgnoreCase(nama)) {
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
        ProgramPenjualan programPenjualan = new ProgramPenjualan();
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