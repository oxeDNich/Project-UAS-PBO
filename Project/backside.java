package Project;
import java.util.ArrayList;
import java.util.Scanner;

//Inheritance child
public class backside extends ticket {
    
    public ArrayList<ticket> tickets = new ArrayList<>();

    static Scanner scan = new Scanner(System.in);

    //untuk mengisi object ticket melalui backside
    public backside (String id, String nama, String tujuan, int jumlah, int harga){
      //Super digunakan untuk memanggil constructor induk agar dapat mengirim nilai ke induk
      super(id, nama, tujuan, jumlah, harga);
    }

    //untuk mengisi object ticket melalui backside tanpa parameter
    public backside(){
      super(null, null, null, 0, 0);
    }

    //untuk menambahkan ticket
    @Override
    public void addTicket(ticket ticket) {
        if (!isTicketIdExist(ticket.getId())) {
            this.tickets.add(ticket);
            System.out.println("Ticket ID         : "+ticket.getId());
            System.out.println("Ticket atas nama  : "+ticket.getNama());
            System.out.println("Tujuan ticket     : "+ticket.getTujuan());
            System.out.println("Jumlah ticket     : "+ticket.getJumlah());
            System.out.println("Harga ticket      : "+ticket.getHarga());
            System.out.println("Terimakasih sudah membeli ticket.");
        } else {
            System.out.println("Ticket with ID " + ticket.getId() + " already exists.");
        }
      }

    //overloading ubahTicket
    //menghapus ticket/mengubah jummlah ticket yang dibeli
    public void ubahTicket(String id, int jumlah) {
      boolean foundTicket = false;
      //Melakukan forEach untuk pengecekan setiap ticket dengan id yang dikirim
        for (ticket ticket : this.tickets) {
          //jika ticket memiliki nilai yang sama akan
          if (ticket.getId().equals(id)) {
            foundTicket = true;
            //jika jumlah ticket setara maka akan menghapus arrayList
          if (jumlah == ticket.getJumlah()) {
              this.tickets.remove(ticket);
              System.out.println("Ticket dengan ID " + id + " telah dihapus.");
              return;
              //jika memiliki nilai dibawah angka
          } else if (jumlah < ticket.getJumlah()) { 
                ticket.setJumlah(ticket.getJumlah() - jumlah);
                ticket.setHarga(ticket.getJumlah()*75000);
                int harga = ticket.getHarga();
                if (ticket.getJumlah() > 5) {
                if( ticket.getJumlah() > 10){
                System.out.println("Anda mendapatkan diskon 10%");
                ticket.setJumlah(ticket.getJumlah());
                int diskon = harga - (harga*10/100);
                ticket.setHarga(diskon);
                System.out.println("Harga sebelumnya "+ harga + " Menjadi : " +diskon);
                } else {
                System.out.println("Anda mendapatkan diskon 5%");
                ticket.setJumlah(ticket.getJumlah());
                int diskon = harga - (harga*5/100);
                ticket.setHarga(diskon);
                System.out.println("Harga sebelumnya "+ harga + " Menjadi : " +diskon);
                } }
                else {
                ticket.setJumlah(ticket.getJumlah());
                ticket.setHarga(harga);
                }
          } else {
                System.out.println("Jumlah tiket yang dimasukkan melebihi jumlah tiket yang dibeli.");
                return;
            }
            break;
        }
        }
        if (foundTicket) {
            System.out.println("Ticket dengan ID " + id + " dan jumlah " + jumlah + " ticket telah dihapus.");
        } else {
            System.out.println("Ticket dengan ID " + id + " tidak ditemukan.");
        }
    }


    //overloading ubahTicket
    //Mengubah ticket
    public void ubahTicket(String id){
      boolean foundTicket = false;
        for (ticket ticket : this.tickets) {
          if (ticket.getId().equals(id)) {
            foundTicket = true;
            System.out.print("Masukkan nama : ");
            String nama = scan.nextLine();
            ticket.setNama(nama);
            System.out.println("Tujuan Keberangkatan : ");
            System.out.println("1. Nusa Penida");
            System.out.println("2. Nusa Lembongan");
            System.out.println("3. Lombok");
            int tujuan;
            do {
              System.out.print("Pilih Tujuan Keberangkatan diatas : ");
            tujuan = scan.nextInt();
            if (tujuan == 1){
              ticket.setTujuan("Nusa Penida");
            } else if(tujuan == 2){
              ticket.setTujuan("Nusa Lembongan");
            } else if (tujuan == 3){
              ticket.setTujuan("Lombok");
            } else {
              System.out.println("Tujuan tidak ditemukan");
            }
            scan.nextLine(); //Menangani karakter baru setelah nextInt()
            } while (tujuan != 1 && tujuan != 2 && tujuan != 3);

            System.out.print("Jumlah Ticket yang ingin dibeli : ");
            int jumlah = scan.nextInt();
            int harga = jumlah*75000;
            if (jumlah >= 5) {
            if( jumlah >= 10){
                System.out.println("Anda mendapatkan diskon 10%");
                ticket.setJumlah(jumlah);
                int diskon = harga - (harga*10/100);
                ticket.setHarga(diskon);
                System.out.println("Harga sebelumnya "+ harga + " Menjadi : " +diskon);
                } else {
                System.out.println("Anda mendapatkan diskon 5%");
                ticket.setJumlah(jumlah);
                int diskon = harga - (harga*5/100);
                ticket.setHarga(diskon);
                System.out.println("Harga sebelumnya "+ harga + " Menjadi : " +diskon);
                } }
                else {
                ticket.setJumlah(jumlah);
                ticket.setHarga(harga);
                }
              }
            }
      if (foundTicket){
        System.out.println("Ticket dengan ID "+ id + " berhasil diubah");
      } else{
        System.out.println("ID tidak ditemukan");
      }
    }

    //Mencetak berdasarkan tujuan
    void printTicket(ticket ticket) {
    System.out.printf("| %-10s | %-15s | %-15s | %-13s | %-10s |\n",
            ticket.getId(), ticket.getNama(), ticket.getTujuan(),
            ticket.getJumlah(), ticket.getHarga());
    }

    //pengecekan untuk duplicate ticket
    public Boolean isTicketIdExist(String id) {
        Boolean isExist = false;
        for (ticket ticket : this.tickets) {
          if (ticket.getId().equals(id)) {
            isExist = true;
          }
        }
        return isExist;
      }

}