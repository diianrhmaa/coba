package FinalProjectBP2;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class appToko {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //data makanan yang dijual
        cMakanan mkn1 = new cMakanan("Bakso Kotak",14000);
        cMakanan mkn2 = new cMakanan("Bakso Urat",18000);
        cMakanan mkn3 = new cMakanan("Bakso Jumbo",16000);
        cMakanan mkn4 = new cMakanan("Mie Ayam Ceker",12000);
        cMakanan mkn5 = new cMakanan("Mie Ayam",10000);
        
        //membuat date
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter mydate = DateTimeFormatter.ofPattern("MMdd");
        String formatdate = date.format(mydate);
        
        //data member toko
        int id1 = 10, pwd1 = 111;
        int id2 = 11, pwd2 = 222;
        int id3 = 12, pwd3 = 333;
        int id,pin;
        int pinbaru1, pinbaru2, pinbaru3;
        
        //data admin
        String pwdadmin = "admin123";
        String admin;
        
        //data pemilik
        String pwdpemilik = "pemilik123";
        String pemilik;
        
        //daftar antrian transaksi yang masuk ke toko
        cDaftarTransaksi jual = new cDaftarTransaksi();
        int pilih=0,pilih2=0,pilih3=0;
        int kode=0,jumlah;
        
        do {
            try{
                System.out.println("------------------------------------");
                System.out.println("|      APLIKASI WARUNG PAK MIN     |");
                System.out.println("------------------------------------");
                System.out.println("1. Pembeli");
                System.out.println("2. Anggota");
                System.out.println("3. Admin");
                System.out.println("4. Pemilik");
                System.out.println("5. Exit");
                System.out.print("Pilih = ");
                pilih = sc.nextInt();
            }catch(Exception e){
                System.out.println("INPUT HARUS ANGKA!");
                pilih=0;
                sc.nextLine();
            }
            
            switch(pilih){
                case 1:
                    //Pembeli
                    kode++;
                    String kd=formatdate+String.valueOf(kode);
                    cDaftarTransaksi beli = new cDaftarTransaksi();
                    System.out.print("Masukkan Nama = ");
                    String nama=sc.next();
                    do {
                        try{
                            System.out.println("");
                            System.out.println("=== AKUN PEMBELI ===");
                            System.out.println("1. Tambah");
                            System.out.println("2. Hapus");
                            System.out.println("3. Lihat");
                            System.out.println("4. Kembali");
                            System.out.print("Pilih = ");
                            pilih2=sc.nextInt();
                        }catch(Exception e){
                            System.out.println("INPUT HARUS ANGKA!");
                            pilih2=0;
                            sc.nextLine();
                        }
                        
                        switch(pilih2){
                            case 1:
                                cTransaksi mk=null;
                                System.out.println("Daftar Makanan : ");
                                System.out.println("1. Bakso Kotak");
                                System.out.println("2. Bakso Urat");
                                System.out.println("3. Bakso Jumbo");
                                System.out.println("4. Mie Ayam Ceker");
                                System.out.println("5. Mie Ayam");
                                System.out.print("Pilih = ");
                                pilih3=sc.nextInt();
                                System.out.print("Jumlah = ");
                                jumlah=sc.nextInt();
                                
                                if(pilih3==1){
                                    mk = new cTransaksi(kd,nama,mkn1,jumlah,0,1);
                                }else if(pilih3==2){
                                    mk = new cTransaksi(kd,nama,mkn2,jumlah,0,2);
                                }else if(pilih3==3){
                                    mk = new cTransaksi(kd,nama,mkn3,jumlah,0,3);
                                }else if(pilih3==4){
                                    mk = new cTransaksi(kd,nama,mkn4,jumlah,0,4);
                                }else if(pilih3==5){
                                    mk = new cTransaksi(kd,nama,mkn5,jumlah,0,5);
                                }
                                beli.tambahTransaksi(mk);
                                
                                break;
                            case 2:
                                //hapus transaksi
                                System.out.println("========================================================");
                                System.out.println("|                  DAFTAR TRANSAKSI                    |");
                                System.out.println("--------------------------------------------------------");
                                System.out.println("| No.\tKode\tPembeli\tMakanan\t\tJumlah\tStatus |");
                                System.out.println("--------------------------------------------------------");
                                beli.lihatTransaksi();
                                System.out.println("========================================================");
                                System.out.print("Hapus Nomor = ");
                                int hapus = sc.nextInt();
                                beli.hapusTransaksi(hapus);
                                break;
                            case 3:
                                System.out.println("========================================================");
                                System.out.println("|                  DAFTAR TRANSAKSI                    |");
                                System.out.println("--------------------------------------------------------");
                                System.out.println("| No.\tKode\tPembeli\tMakanan\t\tJumlah\tStatus |");
                                System.out.println("--------------------------------------------------------");
                                beli.lihatTransaksi();
                                System.out.println("========================================================");
                                break;
                            case 4:
                                //selesai. sambungkan transaksi pembeli
                                //ke antrian transaksi toko
                                jual.sambungTransaksi(beli.getFront(), beli.getRear());
                                System.out.println("Selamat Datang kembali...");
                                break;
                        }
                    } while (pilih2!=4);
                    
                    break;
                case 2:
                    //Anggota
                    do{
                        beli = new cDaftarTransaksi();
                        try{
                            System.out.println("Menu Member");
                            System.out.println("1. Lanjut");
                            System.out.println("2. Ubah Pin");
                            System.out.println("3. Exit");
                            System.out.print("Pilih = ");
                            pilih = sc.nextInt();
                        }catch(Exception e){
                            System.out.println("INPUT HARUS ANGKA!");
                            pilih=0;
                            sc.nextLine();
                        }
                    
                    switch(pilih){
                        case 1:
                           boolean valid=false;
                            do{
                                
                                    System.out.print("ID = ");
                                    id = sc.nextInt();
                                    System.out.print("PIN = ");
                                    pin = sc.nextInt();
                                
                                if(id==id1 && pin==pwd1){
                                    valid=true;
                                }else if(id==id2 && pin==pwd2){
                                    valid=true;
                                }else if(id==id3 && pin==pwd3){
                                    valid=true;
                                }

                                if(valid==false){
                                    System.out.println("ID/PIN Salah!");
                                }else{ 
                                    break;
                                }

                            }while(valid==false);  

                            if(valid==true){
                                System.out.println("Selamat Datang Member");
                                kode++;
                                kd=formatdate+String.valueOf(kode);
                               
                                do {
                                    try{
                                        System.out.println("");
                                        System.out.println("=== AKUN MEMBER ===");
                                        System.out.println("1. Tambah");
                                        System.out.println("2. Hapus");
                                        System.out.println("3. Lihat");
                                        System.out.println("4. Kembali");
                                        System.out.print("Pilih = ");
                                        pilih2 = sc.nextInt();
                                    }catch(Exception e){
                                        System.out.println("INPUT HARUS ANGKA!");
                                        pilih2=0;
                                        sc.nextLine();
                                    }
                                    
                                    switch(pilih2){
                                        case 1:
                                            cTransaksi mk=null;
                                            System.out.println("Daftar Barang : ");
                                            System.out.println("1. Bakso Kotak");
                                            System.out.println("2. Bakso Urat");
                                            System.out.println("3. Bakso Jumbo");
                                            System.out.println("4. Mie Ayam Ceker");
                                            System.out.println("5. Mie Ayam");
                                            System.out.print("Pilih = ");
                                            pilih3=sc.nextInt();
                                            System.out.print("Jumlah = ");
                                            jumlah=sc.nextInt();
                                            if(pilih3==1){
                                                mk = new cTransaksi(kd,String.valueOf(id),mkn1,jumlah,0,1);
                                            }else if(pilih3==2){
                                                mk = new cTransaksi(kd,String.valueOf(id),mkn2,jumlah,0,2);
                                            }else if(pilih3==3){
                                                mk = new cTransaksi(kd,String.valueOf(id),mkn3,jumlah,0,3);
                                            }else if(pilih3==4){
                                                mk = new cTransaksi(kd,String.valueOf(id),mkn4,jumlah,0,4);
                                            }else if(pilih3==5){
                                                mk = new cTransaksi(kd,String.valueOf(id),mkn5,jumlah,0,5);
                                            }
                                            beli.tambahTransaksi(mk);

                                            break;
                                        case 2:
                                            //hapus transaksi
                                            System.out.println("========================================================");
                                            System.out.println("|               DAFTAR TRANSAKSI MEMBER                |");
                                            System.out.println("--------------------------------------------------------");
                                            System.out.println("| No.\tKode\tPembeli\tMakanan\t\tJumlah\tStatus |");
                                            System.out.println("--------------------------------------------------------");
                                            beli.lihatTransaksi();
                                            System.out.println("========================================================");
                                            System.out.print("Hapus Nomor = ");
                                            int hapus = sc.nextInt();
                                            beli.hapusTransaksi(hapus);
                                            break;
                                        case 3:
                                            //menampilkan daftar belanja dan diskon
                                            System.out.println("========================================================");
                                            System.out.println("|               DAFTAR TRANSAKSI MEMBER                |");
                                            System.out.println("--------------------------------------------------------");
                                            System.out.println("| No.\tKode\tPembeli\tMakanan\t\tJumlah\tStatus |");
                                            System.out.println("--------------------------------------------------------");
                                            beli.lihatTransaksiMember();
                                            System.out.println("========================================================");
                                            break;
                                        case 4:
                                            //selesai. sambungkan transaksi pembeli
                                            //ke antrian transaksi toko
                                            jual.sambungTransaksi(beli.getFront(), beli.getRear());
                                            System.out.println("Selamat Datang kembali...");
                                            break;
                                    }
                                } while (pilih2!=4);
                                break;
                            }
                            break;
                            
                            case 2:
                            valid = false;
                            do {
                                
                                System.out.print("ID = ");
                                id = sc.nextInt();
                                System.out.print("PIN Lama = ");
                                pin = sc.nextInt();
                                if (id == id1 && pin == pwd1) {

                                    System.out.print("Pin baru : ");
                                    pinbaru1 = sc.nextInt();
                                    pwd1 = pinbaru1;

                                    valid = true;
                                } else if (id == id2 && pin == pwd2) {

                                    System.out.print("Pin baru : ");
                                    pinbaru2 = sc.nextInt();
                                    pwd2 = pinbaru2;

                                    valid = true;
                                } else if (id == id3 && pin == pwd3) {

                                    System.out.print("Pin baru : ");
                                    pinbaru3 = sc.nextInt();
                                    pwd3 = pinbaru3;
                                    valid = true;
                                }
                                if (valid == true) {
                                    System.out.println("Pin berhasil di perbarui");
                                } else {
                                    break;
                                }
                                break;
                            } while (valid == true);

                            break;
                        case 3:
                            System.out.println("Selamat Datang kembali...");
                            break;
                    }
                    }while(pilih!=3);
                    
                    break;
                  
                            
                case 3:
                    //Admin
                    boolean valid=false;
                    System.out.println("");
                    System.out.println("=== AKUN ADMIN ===");
                    
                    do{
                        try{
                                        
                        }catch(Exception e){
                                System.out.println("INPUT HARUS ANGKA!");
                                pilih=0;
                                sc.nextLine();
                        }
                        System.out.print("Masukkan Password : ");
                        admin = sc.next();
                        
                        if(admin.compareTo(pwdadmin)==0){
                            valid=true;
                        }

                        if(valid==false){
                            System.out.println("Password Salah!");
                        }else{ 
                            break;
                        }
                        
                    }while(valid==false);
                    
                    System.out.println("========================================================");
                    System.out.println("|         DAFTAR TRANSAKSI YANG BELUM DIPROSES         |");
                    System.out.println("--------------------------------------------------------");
                    System.out.println("| No.\tKode\tPembeli\tMakanan\t\tJumlah\tStatus |");
                    System.out.println("--------------------------------------------------------");
                    jual.lihatTransaksi();
                    System.out.println("========================================================");
                    //memproses setiap transasksi yang belum diproses
                    cTransaksi t=jual.getFront();
                    do{
                        try {

                        } catch (Exception e) {
                            System.out.println("INPUT HARUS ANGKA!");
                            pilih = 0;
                            sc.nextLine();
                        }
                        if(t.getStatus()==0){
                            System.out.println("Kode    : "+t.getKode());
                            System.out.println("Pembeli : "+t.getPembeli());
                            System.out.println("Barang  : "+t.getMakanan().getNama());
                            System.out.println("Jumlah  : "+t.getJumlah());
                            System.out.println("");
                            System.out.println("Jumlah Transaksi yang Belum Diproses    : " + jual.lihatBelumDiproses());
                            System.out.println("Total Transaksi yang Belum Diproses     : " + jual.lihatUnpemasukan());
                            System.out.println("");
                            System.out.println("-Pilih Aksi-");
                            System.out.println("1. Diproses");
                            System.out.println("2. Selesai");
                            System.out.print("Pilih = ");
                            int aksi=sc.nextInt();
                            if(aksi==1){
                                jual.prosesTransaksi(t);
                                System.out.println("Berhasil diproses..");
                            }else{
                                break;
                            }
                        }
                        t=t.next;
                    }while(t!=null);
                    break;
                case 4:
                    //Pemilik
                    valid=false;
                    System.out.println("=== AKUN PEMILIK ===");
                    
                    
                    do{
                        
                        System.out.print("Masukkan Password : ");
                        pemilik = sc.next();
                        
                        if(pemilik.compareTo(pwdpemilik)==0){
                            valid=true;
                        }

                        if(valid==false){
                            System.out.println("Password Salah!");
                        }else{ 
                            break;
                        }
                        
                    }while(valid==false);
                    
                    System.out.println("===========================================");
                    System.out.println("             LAPORAN PENJUALAN             ");
                    System.out.println("-------------------------------------------");
                    System.out.println("|              | Jumlah | Total Pemasukan |");
                    System.out.println("-------------------------------------------");
                    System.out.println("Sudah Diproses |    "+jual.lihatDiproses()+"   | "+jual.lihatPemasukan());
                    System.out.println("Belum Diproses |    "+jual.lihatBelumDiproses()+"   | "+jual.lihatUnpemasukan());
                    System.out.println("===========================================");
                    
                    do{
                        try {
                            System.out.println("1. Laporan Penjualan Harian");
                            System.out.println("2. Laporan Pembelian Member");
                            System.out.println("3. Grafik Penjualan");
                            System.out.println("4. Ubah Harga");
                            System.out.println("5. Exit");
                            System.out.print("Pilih = ");
                            pilih2 = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println("INPUT HARUS ANGKA!");
                            pilih = 0;
                            sc.nextLine();
                        }
                    
                    switch(pilih2){
                        
                        case 1 :
                            System.out.println("==================================================");
                            System.out.println("|            LAPORAN PENJUALAN HARIAN            |");
                            System.out.println("--------------------------------------------------");
                            System.out.println("Total Penjualan : " + jual.lihatPemasukan());
                            System.out.println("--------------------------------------------------");
                            System.out.println("1. Bakso Kotak      : " + jual.totalBaksoKotak());
                            System.out.println("2. Bakso Urat       : " + jual.totalBaksoUrat());
                            System.out.println("3. Bakso Jumbo      : " + jual.totalBaksoJumbo());
                            System.out.println("4. Mie Ayam Ceker   : " + jual.totalMieAyamCeker());
                            System.out.println("5. Mie Ayam         : " + jual.totalMieAyam());
                            System.out.println("==================================================");
                            break;
                        case 2 :
                            System.out.println("==================================================");
                            System.out.println("|             TOTAL PEMBELIAN MEMBER             |");
                            System.out.println("--------------------------------------------------");
                            System.out.println("Member id 10 : " + jual.totalmember10());
                            System.out.println("Member id 11 : " + jual.totalmember11());
                            System.out.println("Member id 12 : " + jual.totalmember12());
                            System.out.println("==================================================");
                            break;
                        case 3 :
                            System.out.println("==================================================");
                            System.out.println("|                GRAFIK PENJUALAN                |");
                            System.out.println("--------------------------------------------------");
                            System.out.print("1. Bakso Kotak    : ");
                            jual.grafikBaksoKotak();
                            System.out.print("2. Bakso Urat     : ");
                            jual.grafikBaksoUrat();
                            System.out.print("3. Bakso Jumbo    : ");
                            jual.grafikBaksoJumbo();
                            System.out.print("4. Mie Ayam Ceker : ");
                            jual.grafikAyamCeker();
                            System.out.print("5. Mie Ayam       : ");
                            jual.grafikAyam();
                            System.out.println("==================================================");
                            break;
                        case 4 :
                            System.out.println("Daftar Makanan : ");
                            System.out.println("1. Bakso Kotak");
                            System.out.println("2. Bakso Urat");
                            System.out.println("3. Bakso Jumbo");
                            System.out.println("4. Mie Ayam Ceker");
                            System.out.println("5. Mie Ayam");
                            System.out.print("Pilih = ");
                            pilih3=sc.nextInt();
                            boolean ada = false;
                            int hrgbaru = 0;
                            if (pilih3 == 1) {
                                ada = true;
                                System.out.print("Masukan Harga Baru : ");
                                hrgbaru = sc.nextInt();
                                mkn1.setharga(hrgbaru);
                            } else if (pilih3 == 2) {
                                ada = true;
                                System.out.print("Masukan Harga Baru : ");
                                hrgbaru = sc.nextInt();
                                mkn2.setharga(hrgbaru);
                                ada = true;
                            } else if (pilih3 == 3) {
                                ada = true;
                                System.out.print("Masukan Harga Baru : ");
                                hrgbaru = sc.nextInt();
                                mkn3.setharga(hrgbaru);
                                ada = true;
                            } else if (pilih3 == 4) {
                                ada = true;
                                System.out.print("Masukan Harga Baru : ");
                                hrgbaru = sc.nextInt();
                                mkn4.setharga(hrgbaru);
                                ada = true;
                            } else if (pilih3 == 5) {
                                ada = true;
                                System.out.print("Masukan Harga Baru : ");
                                hrgbaru = sc.nextInt();
                                mkn5.setharga(hrgbaru);
                                ada = true;
                            }
                            if (ada == false) {
                                System.out.println("Barang Tidak Ada");
                            }
                            break;
                        case 5 :
                            System.out.println("Terima Kasih");
                            break;
                    }
                    }while(pilih2!=5);
                    break;
                case 5:
                    System.out.println("Terima Kasih..");
                    break;         
            }
        } while (pilih!=5);
          
    }
    
}