package FinalProjectBP2;

public class cDaftarTransaksi {
    cTransaksi front,rear;
    int jumlah;
    cDaftarTransaksi(){
        front=rear=null;
        jumlah=0;
    }
    
    public cTransaksi getFront(){
        return front;
    }
    
    public cTransaksi getRear(){
        return rear;
    }
    
    public void tambahTransaksi(cTransaksi baru){
        if(rear==null){
           front=rear=baru;
        }else{
           rear.next=baru;
           rear=baru;
        }
        System.out.println("Penambahan Sukses....");
    }
    
    public void lihatTransaksi(){
        int i=1;

        for(cTransaksi t=front; t!=null; t=t.next){
            System.out.print("  "+i+".\t");
            System.out.print(t.getKode()+"\t");
            System.out.print(t.getPembeli()+"\t");
            System.out.print(t.getMakanan().getNama()+"\t");
            System.out.print(t.getJumlah()+"\t");
            System.out.println(t.getStatus());
            i++;
        }
    }
    
    public void lihatTransaksiMember(){
        int i=1;
        double total=0,diskon;

        for(cTransaksi t=front; t!=null; t=t.next){
            System.out.print("  "+i+".\t");
            System.out.print(t.getKode()+"\t");
            System.out.print(t.getPembeli()+"\t");
            System.out.print(t.getMakanan().getNama()+"\t");
            System.out.print(t.getJumlah()+"\t");
            System.out.println(t.getStatus());
             
            i++;
            total=total+(t.getMakanan().getHarga()*t.getJumlah()); 
        }
        
        diskon = (0.05*total);
        System.out.println("--------------------------------------------------------");
        System.out.println("Total Belanja   : "+total);
        System.out.println("Diskon          : "+diskon);
        System.out.println("Jumlah Dibayar  : "+(total-(diskon)));
    }
    
    public void hapusTransaksi(int nomor){
        cTransaksi t=front;
        cTransaksi prev=null; 
        int i=1;
        if(nomor==1){ //hapus posisi terdepan
            if(t.next==null){
                front=rear=null;
            }else{
                front=front.next;
                t.next=null;
            }
            System.out.println("["+t.getMakanan().getNama()+"] dihapus");
        }else{
            for(; t!=null; t=t.next){
                if(i==nomor){
                    break;
                }
                i++;
                prev=t;
            }
            //yang dihapus diujung belakang
            if(t.next==null){
                rear=prev;
                rear.next=null;
            }else{
                prev.next=t.next;
                t.next=null;
            }
            System.out.println("["+t.getMakanan().getNama()+"] dihapus");
        }
    }
    
    public void sambungTransaksi(cTransaksi depan,cTransaksi belakang){
        //sambungkan transaksi
        if(rear==null){ //transaksi toko masih kosong
            front=depan;
            rear=belakang;
        }else{
        rear.next=depan;
        //update posisi rear 
        rear=belakang;
        }   
    }
    
    public void prosesTransaksi(cTransaksi t){
        //cek member
        t.setStatus(1);
    }
    
    public void prosesTransaksiMember(cTransaksi t){
        //mendapatkan diskon
    }
    
    public int lihatDiproses(){
        cTransaksi t=front;
        int proses=0;
        for(;t!=null; t=t.next){
            if(t.getStatus()==1){
                proses++;
            }
        }
        return proses;
    }
    
    public int lihatBelumDiproses(){
        cTransaksi t=front;
        int belumDiproses=0;
        for(; t!=null; t=t.next){
            if(t.getStatus()==0){
                belumDiproses++;
            }
        }
        return belumDiproses;
    }
    
    public double lihatPemasukan(){
       cTransaksi t=front;
        double nominal=0;
        double nominal2=0;
        double total = 0;
        for(;t!=null; t=t.next){
            if(t.getStatus()==1){
                //cek member berdasarkan data/kode pembeli
                nominal= t.getMakanan().getHarga()*t.getJumlah();
                total += nominal;
                if(t.getPembeli().equalsIgnoreCase("10") || t.getPembeli().equalsIgnoreCase("11") || t.getPembeli().equalsIgnoreCase("12")){
                    // Harga setelah diskon
                    total -= 0.05*nominal;
                }
            } 
        }
        return total; 
    }
    
    public double lihatUnpemasukan(){
       cTransaksi t=front;
        double nominal=0;
        double nominal2=0;
        double total = 0;
        for(;t!=null; t=t.next){
            if(t.getStatus()==0){
                //cek member berdasarkan data/kode pembeli
                nominal= t.getMakanan().getHarga()*t.getJumlah();
                total += nominal;
                if(t.getPembeli().equalsIgnoreCase("10") || t.getPembeli().equalsIgnoreCase("11") || t.getPembeli().equalsIgnoreCase("12")){
                    // Harga setelah diskon
                    total -= 0.05*nominal;
                }
            } 
        }
        return total;
    }
    
    public double totalBaksoKotak(){
            cTransaksi t=front;
            double nominal=0;
            for (; t!=null; t=t.next) {
                if (t.getIdMkn()==1&&t.getStatus()==1) {
                     nominal=nominal+t.getMakanan().getHarga()*t.getJumlah();
                    if (t.getPembeli().equalsIgnoreCase("10")|t.getPembeli().equalsIgnoreCase("11")||t.getPembeli().equalsIgnoreCase("12")) {
                        nominal=nominal-(0.05*nominal);
                    }                                       
                }                
            }
            
            return nominal;                        
        }
    
    public double totalBaksoUrat(){
            cTransaksi t=front;
            double nominal=0;
            for (; t!=null; t=t.next) {
                if (t.getIdMkn()==2&&t.getStatus()==1) {
                     nominal=nominal+t.getMakanan().getHarga()*t.getJumlah();
                    if (t.getPembeli().equalsIgnoreCase("10")|t.getPembeli().equalsIgnoreCase("11")||t.getPembeli().equalsIgnoreCase("12")) {
                        nominal=nominal-(0.05*nominal);
                    }                                       
                }                
            }
            
            return nominal;                        
        }
    
    public double totalBaksoJumbo(){
            cTransaksi t=front;
            double nominal=0;
            for (; t!=null; t=t.next) {
                if (t.getIdMkn()==3&&t.getStatus()==1) {
                     nominal=nominal+t.getMakanan().getHarga()*t.getJumlah();
                    if (t.getPembeli().equalsIgnoreCase("10")|t.getPembeli().equalsIgnoreCase("11")||t.getPembeli().equalsIgnoreCase("12")) {
                        nominal=nominal-(0.05*nominal);
                    }                                       
                }                
            }
            
            return nominal;                        
        }
    
    public double totalMieAyamCeker(){
            cTransaksi t=front;
            double nominal=0;
            for (; t!=null; t=t.next) {
                if (t.getIdMkn()==4&&t.getStatus()==1) {
                     nominal=nominal+t.getMakanan().getHarga()*t.getJumlah();
                    if (t.getPembeli().equalsIgnoreCase("10")|t.getPembeli().equalsIgnoreCase("11")||t.getPembeli().equalsIgnoreCase("12")) {
                        nominal=nominal-(0.05*nominal);
                    }                                       
                }                
            }
            
            return nominal;                        
        }
    
    public double totalMieAyam(){
            cTransaksi t=front;
            double nominal=0;
            for (; t!=null; t=t.next) {
                if (t.getIdMkn()==5&&t.getStatus()==1) {
                     nominal=nominal+t.getMakanan().getHarga()*t.getJumlah();
                    if (t.getPembeli().equalsIgnoreCase("10")|t.getPembeli().equalsIgnoreCase("11")||t.getPembeli().equalsIgnoreCase("12")) {
                        nominal=nominal-(0.05*nominal);
                    }                                       
                }                
            }
            
            return nominal;                        
        }
    
    public double totalmember10(){
        cTransaksi t=front;
        double nominal=0;
        double nominal2=0;
        double total = 0;
        for(;t!=null; t=t.next){
            if(t.getStatus()==1&&t.getPembeli().equalsIgnoreCase("10")){
                //cek member berdasarkan data/kode pembeli
                nominal= t.getMakanan().getHarga()*t.getJumlah();
                total += nominal;
                if(t.getPembeli().equalsIgnoreCase("10")){
                    // Harga setelah diskon
                    total -= 0.05*nominal;
                }
            } 
        }
        return total;
        } 
    
    public double totalmember11(){
        cTransaksi t=front;
        double nominal=0;
        double nominal2=0;
        double total = 0;
        for(;t!=null; t=t.next){
            if(t.getStatus()==1&&t.getPembeli().equalsIgnoreCase("11")){
                //cek member berdasarkan data/kode pembeli
                nominal= t.getMakanan().getHarga()*t.getJumlah();
                total += nominal;
                if(t.getPembeli().equalsIgnoreCase("11")){
                    // Harga setelah diskon
                    total -= 0.05*nominal;
                }
            } 
        }
        return total;   
        } 
    
    public double totalmember12(){
        cTransaksi t=front;
        double nominal=0;
        double nominal2=0;
        double total = 0;
        for(;t!=null; t=t.next){
            if(t.getStatus()==1&&t.getPembeli().equalsIgnoreCase("12")){
                //cek member berdasarkan data/kode pembeli
                nominal= t.getMakanan().getHarga()*t.getJumlah();
                total += nominal;
                if(t.getPembeli().equalsIgnoreCase("12")){
                    // Harga setelah diskon
                    total -= 0.05*nominal;
                }
            } 
        }
        return total; 
        } 
    
    public void grafikBaksoKotak(){
       cTransaksi t=front;
      double nominal=0;
      for (; t!=null; t=t.next) {
        if (t.getIdMkn()==1&&t.getStatus()==1) {
            nominal=nominal+t.getMakanan().getHarga()*t.getJumlah();
            if (t.getPembeli().equalsIgnoreCase("10")|t.getPembeli().equalsIgnoreCase("11")||t.getPembeli().equalsIgnoreCase("12")) {
                nominal=nominal-(0.05*nominal);
            }               
        }                                 
    }

    double nominalgraf = nominal*0.0001;
    double nominalgrafx = nominal*0.001;
    for (int i = 0; i < nominalgraf-1; i++) {
        System.out.print("X"); 
    }
    System.out.println(" / "+Math.floor(nominalgrafx)+"00");                                                         
    }
    
    public void grafikBaksoUrat(){
       cTransaksi t=front;
      double nominal=0;
      for (; t!=null; t=t.next) {
        if (t.getIdMkn()==2&&t.getStatus()==1) {
            nominal=nominal+t.getMakanan().getHarga()*t.getJumlah();
            if (t.getPembeli().equalsIgnoreCase("10")|t.getPembeli().equalsIgnoreCase("11")||t.getPembeli().equalsIgnoreCase("12")) {
                nominal=nominal-(0.1*nominal);
            }               
        }                                 
    }

    double nominalgraf = nominal*0.0001;
    double nominalgrafx = nominal*0.001;
    for (int i = 0; i < nominalgraf-1; i++) {
        System.out.print("X"); 
    }
    System.out.println(" / "+Math.floor(nominalgrafx)+"00");                                                         
    }
    
    public void grafikBaksoJumbo(){
       cTransaksi t=front;
      double nominal=0;
      for (; t!=null; t=t.next) {
        if (t.getIdMkn()==3&&t.getStatus()==1) {
            nominal=nominal+t.getMakanan().getHarga()*t.getJumlah();
            if (t.getPembeli().equalsIgnoreCase("10")|t.getPembeli().equalsIgnoreCase("11")||t.getPembeli().equalsIgnoreCase("12")) {
                nominal=nominal-(0.05*nominal);
            }               
        }                                 
    }

    double nominalgraf = nominal*0.0001;
    double nominalgrafx = nominal*0.001;
    for (int i = 0; i < nominalgraf-1; i++) {
        System.out.print("X"); 
    }
    System.out.println(" / "+Math.floor(nominalgrafx)+"00");                                                         
    }
    
    public void grafikAyamCeker(){
       cTransaksi t=front;
      double nominal=0;
      for (; t!=null; t=t.next) {
        if (t.getIdMkn()==4&&t.getStatus()==1) {
            nominal=nominal+t.getMakanan().getHarga()*t.getJumlah();
            if (t.getPembeli().equalsIgnoreCase("10")|t.getPembeli().equalsIgnoreCase("11")||t.getPembeli().equalsIgnoreCase("12")) {
                nominal=nominal-(0.05*nominal);
            }               
        }                                 
    }

    double nominalgraf = nominal*0.0001;
    double nominalgrafx = nominal*0.001;
    for (int i = 0; i < nominalgraf-1; i++) {
        System.out.print("X"); 
    }
    System.out.println(" / "+Math.floor(nominalgrafx)+"00");                                                         
    }
    
    public void grafikAyam(){
       cTransaksi t=front;
      double nominal=0;
      for (; t!=null; t=t.next) {
        if (t.getIdMkn()==5&&t.getStatus()==1) {
            nominal=nominal+t.getMakanan().getHarga()*t.getJumlah();
            if (t.getPembeli().equalsIgnoreCase("10")|t.getPembeli().equalsIgnoreCase("11")||t.getPembeli().equalsIgnoreCase("12")) {
                nominal=nominal-(0.1*nominal);
            }               
        }                                 
    }

    double nominalgraf = nominal*0.0001;
    double nominalgrafx = nominal*0.001;
    for (int i = 0; i < nominalgraf-1; i++) {
        System.out.print("X"); 
    }
    System.out.println(" / "+Math.floor(nominalgrafx)+"00");                                                         
    }
}
