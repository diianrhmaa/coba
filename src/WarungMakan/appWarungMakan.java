package WarungMakan;
//CLASS CONTAINER 
//Class: pembeli; induk:menu; anak:makanan,minuman; transaksi
import java.util.Scanner;
public class appWarungMakan {
    static cMakanan mkn[] = new cMakanan[15];
    static int jmkn=9;
    static cMinuman mnm[] = new cMinuman[15];
    static int jmnm=7;
    static cPembeli member[] = new cPembeli[20];
    static int jmbr=5;
    //sorting pemasukkan dari yang terbesar
    static cMenu[] sort (cMenu[] MENU, double[] pemasukkan,int jml){
        for (int i = 0; i < jml; i++) {
            for (int j = 0; j < jml-1; j++) {
                if(pemasukkan[j]<pemasukkan[j+1]){
                    double h = pemasukkan[j];
                    pemasukkan[j] = pemasukkan[j+1];
                    pemasukkan[j+1] = h;
                    cMenu t = MENU[j];
                    MENU[j] = MENU[j+1];
                    MENU[j+1] = t;
                }
            }
        }
        return MENU;
    }
    //method untuk menampilkan daftar menu
    static void Menu(int x){
        if(x==1){
            System.out.println("\n  -----Daftar Makanan-----");
            for (int i = 0; i < jmkn; i++) {
                System.out.println("  "+(i+1)+"."+mkn[i].ToString());
            }
        }
        else if(x==2){
            System.out.println("\n  -----Daftar Minuman-----");
            for (int i = 0; i < jmnm; i++) {
                System.out.println("  "+(i+1)+"."+mnm[i].ToString());
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cPembeli pbl = new cPembeli();
        int pilih=0,harga=0,makspbl=25,makspb=10,idxpbl=0,maksmbr=20;
        String nama; 
        String nmPembeli[] = new String [makspbl];
        double totalbiaya[] = new double [makspbl];
        double pmsknMKN [] = new double[15];
        double pmsknMNM [] = new double[15];
        double belanjaMember[]=new double [20];
        int idx2=0,jmlpb=0; belanjaMember[idx2]=0;
        int jml[]=new int[makspb];
        //inisialisasi menu makanan
        mkn[0]=new cMakanan("Pecel",10000);
        mkn[1]=new cMakanan("Gado-gado",17000);
        mkn[2]=new cMakanan("Opor Ayam",26000);
        mkn[3]=new cMakanan("Ayam Bakar",21000);
        mkn[4]=new cMakanan("Ayam Kremes",21000);
        mkn[5]=new cMakanan("Soto",20000);
        mkn[6]=new cMakanan("Rawon",25000);
        mkn[7]=new cMakanan("Nasi Timbel",40000);
        mkn[8]=new cMakanan("Sup Iga",43000);
        //inisialisasi menu minuman
        mnm[0]=new cMinuman("Air Mineral",5000);
        mnm[1]=new cMinuman("Susu Milo",8000);
        mnm[2]=new cMinuman("Teh Manis",3000);
        mnm[3]=new cMinuman("Teh Tawar",3000);
        mnm[4]=new cMinuman("Teh Tarik",4500);
        mnm[5]=new cMinuman("Jeruk",5000);
        mnm[6]=new cMinuman("Kopi",6000);
        //inisialisasi data member
        member[0]=new cPembeli("Alif","Malang");
        member[1]=new cPembeli("Kyla","Semarang");
        member[2]=new cPembeli("Leya","Surabaya");
        member[3]=new cPembeli("Aulia","Jakarta");
        member[4]=new cPembeli("Puspa","Bandung");
        
        do{
            System.out.println("\n===========================");
            System.out.println("     DEPOT WONG MADIUN     ");
            System.out.println("===========================");
            System.out.println("1.Master Data Menu");
            System.out.println("2.Master Data Pembeli");
            System.out.println("3.Transaksi");
            System.out.println("4.Selesai");
            System.out.print("Pilih = ");
            pilih=sc.nextInt();
            switch(pilih){
                case 1:
                    String User = "editMaster";
                    String Pass = "212213";
                    System.out.println("\n  Memerlukan akses untuk menampilkan Menu Master");
                    System.out.println("  Apakah ingin masuk ke Menu Master?");
                    System.out.println("  1.Ya");
                    System.out.println("  2.Tidak");
                    System.out.print("  Pilih = ");
                    int master = sc.nextInt();
                    if(master==1){
                        System.out.println("\n  -----Silakan Login-----");
                        System.out.print("  Username = ");
                        String User2 = sc.next();
                        System.out.print("  Password = ");
                        String Pass2 = sc.next();
                        if(User2.equalsIgnoreCase(User) && Pass2.equalsIgnoreCase(Pass)){
                            int menuMaster=0;
                            do{
                                System.out.println("\n  --------------------------");
                                System.out.println("  -----MASTER DATA MENU-----");
                                System.out.println("  1.Edit Menu Makanan");
                                System.out.println("  2.Edit Menu Minuman");
                                System.out.println("  3.Logout");
                                System.out.print("  Pilih = ");
                                menuMaster = sc.nextInt();
                                switch(menuMaster){
                                    case 1: //EDIT MENU MAKANAN
                                        int pilih1=0;
                                        do{
                                            System.out.println("\n    -----MENU MAKANAN-----");
                                            System.out.println("    1.Lihat Makanan");
                                            System.out.println("    2.Tambah Makanan");
                                            System.out.println("    3.Hapus Makanan");
                                            System.out.println("    4.Ubah Harga Makanan");
                                            System.out.println("    5.Selesai");
                                            System.out.print("    Pilih = ");
                                            pilih1 = sc.nextInt();
                                            switch(pilih1){
                                                case 1://menampilkan daftar menu makanan
                                                    Menu(1);
                                                    break;
                                                case 2: 
                                                    int maksmkn=15;
                                                    System.out.println("\n      -----Tambah Makanan-----");
                                                    if(jmkn<maksmkn){
                                                        System.out.print("      Nama Makanan = ");
                                                        sc = new Scanner(System.in);
                                                        String n = sc.nextLine();
                                                        boolean ada=false;
                                                        for (int i = 0; i < jmkn; i++) {
                                                            if(mkn[i].getNama().equalsIgnoreCase(n)){
                                                                ada=true;
                                                                break;
                                                            }
                                                        }
                                                        if (ada==true){
                                                            System.out.println("      Makanan Sudah Ada!");
                                                        }
                                                        else{
                                                            System.out.print("      Harga = ");
                                                            int h = sc.nextInt();
                                                            mkn[jmkn]=new cMakanan(n,h);
                                                            System.out.println("      Penambahan Sukses...");
                                                            jmkn++;
                                                        }
                                                    }
                                                    else{
                                                        System.out.println("      Kapasitas Penuh!");
                                                    }
                                                    break;
                                                    
                                                case 3:
                                                    System.out.println("\n      -----Hapus  Makanan-----");
                                                    boolean ketemu=false;
                                                    int indeks=0;
                                                    System.out.print("      Nama Makanan = ");
                                                    sc = new Scanner(System.in);
                                                    String n=sc.nextLine();
                                                    for (int i = 0; i < jmkn; i++) {
                                                        indeks=i;
                                                        if(mkn[i].getNama().equalsIgnoreCase(n)){
                                                            ketemu=true;
                                                            break;
                                                        }
                                                    }
                                                    if(ketemu==true){
                                                        int j;
                                                        System.out.println("       Yakin dihapus?");
                                                        System.out.println("       1.Ya");
                                                        System.out.println("       2.Tidak");
                                                        System.out.print("       Pilih = ");
                                                        j = sc.nextInt();
                                                        if(j==1){
                                                            for (int i = indeks; i < jmkn; i++) {
                                                                if(i==jmkn-1)
                                                                    mkn[i]=null;
                                                                else
                                                                    mkn[i]=mkn[i+1];
                                                            }
                                                            System.out.println("      Penghapusan Sukses...");
                                                            jmkn--;
                                                        }
                                                        else
                                                            System.out.println("      Batal dihapus!");
                                                    }
                                                    else
                                                        System.out.println("      Makanan Tidak Ada!");
                                                    break;
                                                case 4:
                                                    System.out.println("\n      -----Ubah Harga Makanan-----");
                                                    ketemu=false;
                                                    int indeks2=0;
                                                    System.out.print("      Nama Makanan = ");
                                                    sc = new Scanner(System.in);
                                                    String m=sc.nextLine();
                                                    for (int i = 0; i < jmkn; i++) {
                                                        indeks2=i;
                                                        if(mkn[i].getNama().equalsIgnoreCase(m)){
                                                            ketemu=true;
                                                            break;
                                                        }
                                                    }
                                                    if(ketemu==true){
                                                        System.out.print("      Masukkan Harga Baru = ");
                                                        int hb = sc.nextInt();
                                                        System.out.println("       Yakin diubah?");
                                                        System.out.println("       1.Ya");
                                                        System.out.println("       2.Tidak");
                                                        System.out.print("      Pilih = ");
                                                        int k = sc.nextInt();
                                                        if(k==1){
                                                            mkn[indeks2].setHarga(hb);
                                                            System.out.println("      Harga Berhasil Diubah!");
                                                        }
                                                        else{
                                                            System.out.println("      Batal Mengubah Harga");
                                                        }
                                                    }
                                                    else
                                                        System.out.println("      Makanan Tidak Ada!");
                                                    break;
                                                case 5:
                                                    System.out.println("    Kembali ke Menu Master...");
                                                    break;
                                            }
                                        }while(pilih1!=5);
                                        break;
                                    case 2: //EDIT MENU MINUMAN
                                        int pilih2=0;
                                        do{
                                            System.out.println("\n    MENU MINUMAN");
                                            System.out.println("    1.Lihat Minuman");
                                            System.out.println("    2.Tambah Minuman");
                                            System.out.println("    3.Hapus Minuman");
                                            System.out.println("    4.Ubah Harga Minuman");
                                            System.out.println("    5.Selesai");
                                            System.out.print("    Pilih = ");
                                            pilih2 = sc.nextInt();
                                            switch(pilih2){
                                                case 1://menampilkan daftar menu minuman
                                                    Menu(2);
                                                    break;
                                                case 2:
                                                    int maksmnm=15;
                                                    System.out.println("\n      -----Tambah Minuman-----");
                                                    if(jmkn<maksmnm){
                                                        System.out.print("      Nama Minuman = ");
                                                        sc = new Scanner(System.in);
                                                        String n = sc.nextLine();
                                                        boolean ada=false;
                                                        for (int i = 0; i < jmnm; i++) {
                                                            if(mnm[i].getNama().equalsIgnoreCase(n)){
                                                                ada=true;
                                                                break;
                                                            }
                                                        }
                                                        if (ada==true){
                                                            System.out.println("      Minuman Sudah Ada!");
                                                        }
                                                        else{
                                                            System.out.print("      Harga = ");
                                                            int h = sc.nextInt();
                                                            mnm[jmnm]=new cMinuman(n,h);
                                                            System.out.println("      Penambahan Sukses...");
                                                            jmnm++;
                                                        }
                                                    }
                                                    else{
                                                        System.out.println("      Kapasitas Penuh!");
                                                    }
                                                    break;
                                                case 3:
                                                    System.out.println("\n      -----Hapus  Minuman-----");
                                                    boolean ketemu=false;
                                                    int indeks=0;
                                                    System.out.print("      Nama Minuman = ");
                                                    sc = new Scanner(System.in);
                                                    String n=sc.nextLine();
                                                    for (int i = 0; i < jmnm; i++) {
                                                        indeks=i;
                                                        if(mnm[i].getNama().equalsIgnoreCase(n)){
                                                            ketemu=true;
                                                            break;
                                                        }
                                                    }
                                                    if(ketemu==true){
                                                        int j;
                                                        System.out.println("       Yakin dihapus?");
                                                        System.out.println("       1.Ya");
                                                        System.out.println("       2.Tidak");
                                                        System.out.print("       Pilih = ");
                                                        j = sc.nextInt();
                                                        if(j==1){
                                                            for (int i = indeks; i < jmnm; i++) {
                                                                if(i==jmnm-1)
                                                                    mnm[i]=null;
                                                                else
                                                                    mnm[i]=mnm[i+1];
                                                            }
                                                            System.out.println("      Penghapusan Sukses...");
                                                            jmnm--;
                                                        }
                                                        else
                                                            System.out.println("      Batal dihapus!");
                                                    }
                                                    else
                                                        System.out.println("      Minuman Tidak Ada!");
                                                    break;
                                                case 4:
                                                    System.out.println("\n      -----Ubah Harga Minuman-----");
                                                    ketemu=false;
                                                    int indeks2=0;
                                                    System.out.print("      Nama Minuman = ");
                                                    sc = new Scanner(System.in);
                                                    String m=sc.nextLine();
                                                    for (int i = 0; i < jmnm; i++) {
                                                        indeks2=i;
                                                        if(mnm[i].getNama().equalsIgnoreCase(m)){
                                                            ketemu=true;
                                                            break;
                                                        }
                                                    }
                                                    if(ketemu==true){
                                                        System.out.print("      Masukkan Harga Baru = ");
                                                        int hb = sc.nextInt();
                                                        System.out.println("       Yakin diubah?");
                                                        System.out.println("       1.Ya");
                                                        System.out.println("       2.Tidak");
                                                        System.out.print("       Pilih = ");
                                                        int k = sc.nextInt();
                                                        if(k==1){
                                                            mnm[indeks2].setHarga(hb);
                                                            System.out.println("      Harga Berhasil Diubah!");
                                                        }
                                                        else{
                                                            System.out.println("      Batal Mengubah Harga");
                                                        }
                                                    }
                                                    else
                                                        System.out.println("      Minuman Tidak Ada!");
                                                    break;
                                                case 5:
                                                    System.out.println("    Kembali ke Menu Master...");
                                                    break;
                                            }
                                        }while(pilih2!=5);
                                        break;
                                    case 3:
                                        System.out.println("\n  Kembali ke Menu Utama!");
                                        break;
                                }
                            }while(menuMaster!=3);
                        }
                        else{
                            System.out.println("  Username atau Password Salah!");
                        }
                    }
                    else {
                        System.out.println("\n  Kembali ke Menu Utama!");
                    }
                    break;
                
                case 2:
                    int pilih5=0;
                    String UserMember = "editMember";
                    String PassMember = "212213";
                    System.out.println("\n  Memerlukan akses untuk menampilkan Menu Master");
                    System.out.println("  Apakah ingin masuk ke Menu Master?");
                    System.out.println("  1.Ya");
                    System.out.println("  2.Tidak");
                    System.out.print("  Pilih = ");
                    int masterMember = sc.nextInt();
                    if(masterMember==1){
                        System.out.println("\n  -----Silakan Login-----");
                        System.out.print("  Username = ");
                        String UserMember2 = sc.next();
                        System.out.print("  Password = ");
                        String PassMember2 = sc.next();
                        if(UserMember2.equalsIgnoreCase(UserMember) && PassMember2.equalsIgnoreCase(PassMember)){
                            do{
                                System.out.println("\n  ----------------------------");
                                System.out.println("  -----MASTER DATA MEMBER-----");
                                System.out.println("  1.Lihat Data Member");
                                System.out.println("  2.Tambah Data Member");
                                System.out.println("  3.Ubah Alamat Member");
                                System.out.println("  4.Hapus Data Member");
                                System.out.println("  5.Daftar Belanja Member");
                                System.out.println("  6.Logout");
                                System.out.print("  Pilih = ");
                                pilih5 = sc.nextInt();
                                switch(pilih5){
                                    case 1:
                                        System.out.println("\n    -----Daftar Member-----");
                                        for (int i = 0; i < jmbr; i++) {
                                            System.out.println("  "+(i+1)+"."+member[i].ToStringMember());
                                        }
                                        break;
                                    case 2:
                                        System.out.println("\n    -----Tambah Member-----");
                                        System.out.print("    Nama Pelanggan = ");
                                        sc = new Scanner(System.in);
                                        String nmMember = sc.nextLine();
                                        if(jmbr<maksmbr){
                                            boolean ada=false;
                                            for (int i = 0; i < jmbr; i++) {
                                                if(member[i].getMember().equalsIgnoreCase(nmMember)){
                                                    ada=true;
                                                    break;
                                                }
                                            }
                                            if (ada==true){
                                                System.out.println("      Member Sudah Ada!");
                                            }
                                            else{
                                                System.out.print("    Alamat Pelanggan = ");
                                                sc = new Scanner(System.in);
                                                String alamat = sc.nextLine();
                                                member[jmbr]=new cPembeli(nmMember,alamat);
                                                System.out.println("      Penambahan Sukses...");
                                                jmbr++;
                                            }
                                        }
                                        else{
                                            System.out.println("      Kapasitas Penuh!");
                                        }
                                        break;
                                    case 3:
                                        System.out.println("\n    -----Ubah Alamat Member-----");
                                        System.out.print("    Nama Pelanggan = ");
                                        sc = new Scanner(System.in);
                                        nmMember = sc.nextLine();
                                        boolean ketemu=false;
                                        int indeks3=0;
                                        for (int i = 0; i < jmbr; i++) {
                                            indeks3=i;
                                            if(member[i].getMember().equalsIgnoreCase(nmMember)){
                                                ketemu=true;
                                                break;
                                            }
                                        }
                                        if(ketemu==true){
                                            System.out.print("    Alamat Baru Pelanggan = ");
                                            sc = new Scanner(System.in);
                                            String alamat = sc.nextLine();
                                            System.out.println("      Yakin diubah?");
                                            System.out.println("      1.Ya");
                                            System.out.println("      2.Tidak");
                                            System.out.print("      Pilih = ");
                                            int x = sc.nextInt();
                                            if(x==1){
                                                member[indeks3].setAlamat(alamat);
                                                System.out.println("      Alamat Berhasil Diubah!");
                                            }
                                            else{
                                                System.out.println("      Batal Mengubah Alamat");
                                            }
                                        }
                                        else
                                            System.out.println("      Member Tidak Ada!");
                                        break;
                                    case 4:
                                        System.out.println("\n    -----Hapus Member-----");
                                        System.out.print("    Nama Pelanggan = ");
                                        sc = new Scanner(System.in);
                                        String namaMember = sc.nextLine();
                                        boolean ada2=false;
                                        int idx=0;
                                        for (int i = 0; i < jmbr; i++) {
                                            if(member[i].getMember().equalsIgnoreCase(namaMember)){
                                                ada2=true;
                                                idx=i;
                                                break;
                                            }
                                        }
                                        if(ada2==true){
                                            System.out.println("      Yakin dihapus?");
                                            System.out.println("      1.Ya");
                                            System.out.println("      2.Tidak");
                                            System.out.print("      Pilih = ");
                                            int pilihHPS = sc.nextInt();
                                            if(pilihHPS==1){
                                                for (int i = idx; i < jmbr; i++) {
                                                    if(idx==jmbr-1){
                                                        member[i]=null;
                                                    }
                                                    else{
                                                        member[i]=member[i+1];
                                                    }
                                                }
                                                jmbr--;
                                                System.out.println("      Member berhasil dihapus..");
                                            }
                                            else{
                                                System.out.println("      Batal dihapus..");
                                            }
                                        }
                                        else{
                                            System.out.println("    Member TIDAK ADA!");
                                        }
                                        break;
                                    case 5://menampilkan data pembelanjan dari pembeli dgn status sbg member
                                        System.out.println("\n    -----Daftar Belanja Member-----");
                                        for (int i = 0; i < jmbr; i++) {
                                            for (int j = 0; j < jmbr-1; j++) {
                                                if(belanjaMember[j]<belanjaMember[j+1]){
                                                    double h = belanjaMember[j];
                                                    belanjaMember[j] = belanjaMember[j+1];
                                                    belanjaMember[j+1] = h;
                                                    cPembeli t = member[j];
                                                    member[j] = member[j+1];
                                                    member[j+1] = t;
                                                }
                                            }
                                        }
                                        System.out.println("    NO Nama\tAlamat  \tTotal Belanja");
                                        for (int i = 0; i < jmbr; i++) {
                                            System.out.println("    "+(i+1)+"."+member[i].ToStringMember()
                                                    +"\tRp."+belanjaMember[i]);
                                        }
                                        break;
                                    case 6:
                                        System.out.println("\n  Kembali ke Menu Utama!");
                                        break;
                                }
                            }while(pilih5!=6);
                        }
                        else{
                            System.out.println("  Username atau Password Salah!");
                        }
                    }
                    else{
                        System.out.println("\n  Kembali ke Menu Utama!");
                    }
                    break;
                    
                case 3:
                    int pilih4=0,jumlah=0,jpb=0;
                    String menuPb;
                    totalbiaya[idxpbl]=0;
                    cTransaksi beli = new cTransaksi();
                    String menupb[]=new String[makspb];
                    int hargapb[]=new int [makspb];
                    int Jumlah[]=new int[makspb];
                    do{
                        System.out.println("\n  ------------------------");
                        System.out.println("  -----MENU TRANSAKSI-----");
                        System.out.println("  1.Isi Pembeli");
                        System.out.println("  2.Tambah Pesanan");
                        System.out.println("  3.Hapus Pesanan");
                        System.out.println("  4.Lihat Pesanan");
                        System.out.println("  5.Selesai");
                        System.out.print("  Pilih = ");
                        pilih4 = sc.nextInt();
                        switch(pilih4){
                            case 1://sub menu pembeli
                                System.out.println("\n    Kode Pemesanan = "+(idxpbl+1));
                                System.out.print("    Nama Pembeli = ");
                                sc = new Scanner(System.in);
                                String nm=sc.nextLine();
                                pbl.setNama(nm);
                                nmPembeli[idxpbl]=nm;
                                beli.isiPembeli(pbl);
                                break;
                            case 2:
                                int pilihMenu=0;
                                if(jpb>=10){
                                    System.out.println("\n    Kapasitas Pemesanan Penuh!");
                                }
                                else{
                                    do{
                                        System.out.println("\n    -----Tambah Pesanan-----");
                                        System.out.println("    1.Menu Makanan");
                                        System.out.println("    2.Menu Minuman");
                                        System.out.println("    3.Selesai");
                                        System.out.print("    Pilih = ");
                                        pilihMenu = sc.nextInt();
                                        switch(pilihMenu){
                                            case 1:
                                                int selesai=0; harga=0;
                                                Menu(1);
                                                System.out.println("\n    -----Pilih Menu-----");
                                                do{
                                                    int indeks=0;
                                                    System.out.print("    Nama Makanan = ");
                                                    sc = new Scanner(System.in);
                                                    nama = sc.nextLine();
                                                    boolean ada = false;
                                                    for (int i = 0; i < jmkn; i++) {
                                                        if(mkn[i].getNama().equalsIgnoreCase(nama)){
                                                            ada=true;
                                                            System.out.print("    Jumlah = ");
                                                            jumlah = sc.nextInt();
                                                            Jumlah[jpb]=beli.getJumlah(jpb, jumlah); //array jumlah pesanan
                                                            harga = mkn[i].getHarga();
                                                            pmsknMKN[i]=pmsknMKN[i]+(harga*jumlah);
                                                            hargapb[jpb]=harga;
                                                            menuPb = mkn[i].getNama();
                                                            menupb[jpb]=menuPb;
                                                            indeks=i;
                                                            break;
                                                        }
                                                    }
                                                    if(ada==true){
                                                        beli.tambahMenu(mkn[indeks]);
                                                        jpb++;
                                                        totalbiaya[idxpbl]=(harga*jumlah)+totalbiaya[idxpbl];
                                                        System.out.println("    Total Biaya = "+totalbiaya[idxpbl]);
                                                    }
                                                    else{
                                                        System.out.println("    Makanan Tidak Ada!");
                                                    }
                                                    System.out.println("      Apakah ingin tambah pesanan?");
                                                    System.out.println("      1.Ya");
                                                    System.out.println("      2.Tidak");
                                                    System.out.print("      Pilih = ");
                                                    selesai = sc.nextInt();
                                                }while(selesai!=2);
                                                break;
                                            case 2:
                                                selesai=0; harga=0;
                                                Menu(2);
                                                System.out.println("\n    -----Pilih Menu-----");
                                                do{
                                                    int indeks=0;
                                                    System.out.print("    Nama Minuman = ");
                                                    sc = new Scanner(System.in);
                                                    nama = sc.nextLine();
                                                    boolean ada = false;
                                                    for (int i = 0; i < jmnm; i++) {
                                                        if(mnm[i].getNama().equalsIgnoreCase(nama)){
                                                            ada=true;
                                                            System.out.print("    Jumlah = ");
                                                            jumlah = sc.nextInt();
                                                            Jumlah[jpb]=beli.getJumlah(jpb, jumlah); //array jumlah pesanan
                                                            harga = mnm[i].getHarga();
                                                            pmsknMNM[i]=pmsknMNM[i]+(harga*jumlah);
                                                            hargapb[jpb]=harga;
                                                            menuPb = mnm[i].getNama();
                                                            menupb[jpb]=menuPb;
                                                            indeks=i;
                                                            break;
                                                        }
                                                    }
                                                    if(ada==true){
                                                        beli.tambahMenu(mnm[indeks]);
                                                        jpb++;
                                                        totalbiaya[idxpbl]=(harga*jumlah)+totalbiaya[idxpbl];
                                                        System.out.println("    Total Biaya = "+totalbiaya[idxpbl]);
                                                    }
                                                    else{
                                                        System.out.println("    Minuman Tidak Ada!");
                                                    }
                                                    System.out.println("      Apakah ingin tambah pesanan?");
                                                    System.out.println("      1.Ya");
                                                    System.out.println("      2.Tidak");
                                                    System.out.print("      Pilih = ");
                                                    selesai = sc.nextInt();
                                                }while(selesai!=2);
                                                break;
                                            case 3:
                                                System.out.println("\n    Kembali ke Menu Transaksi...");
                                                break;
                                        }
                                    }while (pilihMenu!=3);
                                }
                                break;
                            case 3:
                                int idx=0;
                                boolean ketemu=false;
                                System.out.println("\n    -----Hapus Pesanan-----");
                                if(jpb<=0){
                                    System.out.println("    Belum ada pesanan!");
                                }
                                else{
                                    System.out.println("\n    -----Daftar Pesanan-----");
                                    beli.lihatMenu();
                                    System.out.print("    Nama Menu = ");
                                    sc = new Scanner(System.in);
                                    String namaMenu = sc.nextLine();
                                    boolean ada=false;
                                    for (int i = 0; i < jpb; i++) {
                                        if(menupb[i].equalsIgnoreCase(namaMenu)){
                                            idx=i;
                                            ada=true;
                                            break;
                                        }
                                    }
                                    if(ada==true){
                                        System.out.print("    Jumlah = ");
                                        jumlah = sc.nextInt();
                                        Jumlah[idx]=Jumlah[idx]-jumlah;
                                        if(Jumlah[idx]>0){
                                            Jumlah[idx]=beli.getJumlah(idx, Jumlah[idx]); //array jumlah pesanan
                                            System.out.println("    Penghapusan berhasil...");
                                        }
                                        else{
                                            beli.hapusMenu(namaMenu);
                                            jpb--;
                                        }
                                        double total = hargapb[idx]*jumlah;
                                        for (int i = 0; i < jmkn; i++) {
                                            if(mkn[i].getNama().equalsIgnoreCase(menupb[idx])){
                                                pmsknMKN[i]=pmsknMKN[i]-total;
                                            }
                                        }
                                        for (int i = 0; i < jmnm; i++) {
                                            if(mnm[i].getNama().equalsIgnoreCase(menupb[idx])){
                                                pmsknMNM[i]=pmsknMNM[i]-total;
                                            }
                                        }
                                        totalbiaya[idxpbl]=totalbiaya[idxpbl]-(hargapb[idx]*jumlah); 
                                        System.out.println("    Total Biaya = Rp."+totalbiaya[idxpbl]);
                                    }
                                    else
                                        System.out.println("    Pesanan Tidak Ada!");
                                }
                                break;
                            case 4:
                                System.out.println("\n    -----Daftar Pesanan-----");
                                beli.lihatMenu();
                                System.out.println("    Total Biaya = Rp."+totalbiaya[idxpbl]);
                                break;
                            case 5:
                                jml[idxpbl]=0;  
                                for (int i = 0; i < jpb; i++) {
                                    jml[idxpbl]=jml[idxpbl]+Jumlah[i];
                                }
                                System.out.println("\n    -----Struk Pembelian-----");
                                beli.lihatMenu();
                                boolean ada=false;
                                for (int i = 0; i < jmbr; i++) {
                                    if(member[i].getMember().equalsIgnoreCase(nmPembeli[idxpbl])){
                                        ada=true;
                                        idx2=i;
                                        break;
                                    }
                                }
                                if(ada==true){
                                    for (int i = 0; i < jpb; i++) {
                                        jmlpb = jmlpb+Jumlah[i];
                                    }
                                    double diskon = totalbiaya[idxpbl]*0.1;
                                    double d2 = diskon/jmlpb;
                                    for (int i = 0; i < jmkn; i++) {
                                        for (int j = 0; j < jpb; j++) {
                                            if(mkn[i].getNama().equalsIgnoreCase(menupb[j])){
                                                pmsknMKN[i]=pmsknMKN[i]-d2;
                                            }
                                        }
                                    }
                                    for (int i = 0; i < jmnm; i++) {
                                        for (int j = 0; j < jpb; j++) {
                                            if(mnm[i].getNama().equalsIgnoreCase(menupb[j])){
                                                pmsknMNM[i]=pmsknMNM[i]-d2;
                                            }
                                        }
                                    }
                                    System.out.println("    Diskon 10% = "+diskon);
                                    totalbiaya[idxpbl]=totalbiaya[idxpbl]-diskon;
                                    belanjaMember[idx2] = belanjaMember[idx2]+totalbiaya[idxpbl];
                                }
                                System.out.println("    Total Biaya = Rp."+totalbiaya[idxpbl]);
                                idxpbl++;
                                System.out.println("    Terima Kasih...");
                                break;
                        }
                    }while(pilih4!=5);
                    break;
                    
                case 4:
                    double pemasukkan=0,h=0,totalPemasukkanMKN=0,totalPemasukkanMNM=0;
                    if(idxpbl>0){
                        System.out.println("\n  -------------------------------------------------");
                        System.out.println("  ------------DAFTAR TRANSAKSI HARI INI------------"
                                + "");
                        System.out.println("  Kode  NamaPembeli\tTotal Biaya\tJumlah Prosi");
                        for (int i = 0; i < idxpbl; i++) {
                            System.out.println("   "+(i+1)+"\t"+nmPembeli[i]+"\t\tRp."+totalbiaya[i]+"\t"+jml[i]+" porsi");
                            pemasukkan=pemasukkan+totalbiaya[i];
                        }
                        System.out.println("\n  -------------------------------------------------");
                        System.out.println("  Total Pemasukan = Rp."+pemasukkan);
                        System.out.println("\n  -------------------------------------------------");
                        System.out.println("  ----------DAFTAR PEMASUKKAN MENU MAKANAN---------");
                        sort(mkn,pmsknMKN,jmkn);
                        System.out.println("  NO Nama Makanan\tTotal Pemasukkan");
                        for (int i = 0; i < jmkn; i++) {
                            System.out.println("  "+(i+1)+"."+mkn[i].getNama()+"\t\tRp."+pmsknMKN[i]);
                            totalPemasukkanMKN = totalPemasukkanMKN + pmsknMKN[i];
                        }
                        System.out.println("  Total Pemasukkan Untuk Menu Makanan = Rp."+totalPemasukkanMKN);
                        System.out.println("\n  -------------------------------------------------");
                        System.out.println("  ----------DAFTAR PEMASUKKAN MENU MINUMAN---------");
                        sort(mnm,pmsknMNM,jmnm);
                        System.out.println("  NO Nama Minuman\tTotal Pemasukkan");
                        for (int i = 0; i < jmnm; i++) {
                            System.out.println("  "+(i+1)+"."+mnm[i].getNama()+"\t\tRp."+pmsknMNM[i]);
                            totalPemasukkanMNM = totalPemasukkanMNM + pmsknMNM[i];
                        }
                        System.out.println("  Total Pemasukkan Untuk Menu Makanan = Rp."+totalPemasukkanMNM);
                    }
                    else{
                        System.out.println("  Terima Kasih...");
                    }
                    break;
            }
        }while(pilih!=4);
    }
}
