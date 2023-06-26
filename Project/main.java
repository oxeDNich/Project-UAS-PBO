package Project;
import java.util.Scanner;

public class Main {
  
  static Scanner scan = new Scanner(System.in);
  static backside backside = new backside();
  
  public static void main (String[] args) {
    String isContinue= "y";

    initTicket();  

    while (isContinue.equals("y")) {
        showMenu();

        int selectedMenu = chooseMenu();
          try {
            if (selectedMenu == 1) {
              showTicket(); //    || Bagian dari Read
            } else if (selectedMenu == 2) {
              addTicket(); //     || Bagian dari Create
            } else if (selectedMenu == 3) {
              removeTicket(); //  || Bagian dari Delete(masuk ke update juga sih(?))
            } else if (selectedMenu == 4) {
              ubahTicket(); //    || Bagian dari Update
            } else if (selectedMenu == 5) {
              tujuanTicket(); //  || Melihat ticket berdasarkan tujuan
            } else if (selectedMenu == 6){
              break;
            } else {
              throw new IllegalArgumentException("wrong input");
            }
        } catch (Exception e){
          System.out.println("Error "+ e.getMessage());
        }
        System.out.print("continue ? ");
        isContinue = scan.next();
        }
    }

    public static void initTicket(){
      
      //objek
        ticket ticket1 = new backside("1","wahyudi","Nusa Lembongan",2,150000);
        backside.tickets.add(ticket1);

        ticket ticket2 = new backside("2","sudia","Nusa Lembongan",1,75000);
        backside.tickets.add(ticket2);

        ticket ticket3 = new backside("3","RaviEL","Nusa Penida",4,300000);
        backside.tickets.add(ticket3);
      
    }

    public static void showMenu(){
        System.out.println("-----------------------------");
        System.out.println("| 1. Show Ticket");
        System.out.println("| 2. Add Ticket");
        System.out.println("| 3. Remove Ticket");
        System.out.println("| 4. Ubah Ticket");
        System.out.println("| 5. Tujuan Ticket");
        System.out.println("| 6. Exit Program");
        System.out.println("-----------------------------");
    }

    //untuk inputan pilihan Menu (While diatas)
  public static int chooseMenu() {
    System.out.print("choose menu : ");
    int pilihan = scan.nextInt();
    scan.nextLine();
    return pilihan;
  }

  public static void showTicket(){
    System.out.println("-------------------------------------------------------------");
    System.out.printf("| %-10s | %-15s | %-15s | %-13s | %-10s |\n",
            "Ticket ID", "Nama", "Tujuan", "Jumlah Ticket", "Harga");
    System.out.println("-------------------------------------------------------------");

    for (ticket ticket : backside.tickets) {
        System.out.printf("| %-10s | %-15s | %-15s | %-13s | %-10s |\n",
                ticket.getId(), ticket.getNama(), ticket.getTujuan(),
                ticket.getJumlah(), ticket.getHarga());
    }

    System.out.println("-------------------------------------------------------------");
  }

  //melakukan inputan untuk menambahkan ticket
  public static void addTicket(){
    ticket ticket = new backside();

    System.out.print("Id : ");
    String id = scan.nextLine();
    ticket.setId(id);

    System.out.print("Nama : ");
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

    //inputan dikirim ke addTicket
    backside.addTicket(ticket);
  }

  public static void removeTicket(){
    System.out.print("Masukan id Ticket : ");
    String id = scan.nextLine();

    System.out.print("Masukan jumlah ticket yang ingin dihapus : ");
    int jumlah = scan.nextInt();

    backside.ubahTicket(id,jumlah);
  }

  public static void ubahTicket(){
    System.out.println("Masukan ID yang ingin diubah : ");
    String id = scan.nextLine();
    backside.ubahTicket(id);
  }

  public static void tujuanTicket(){
    System.out.println("Pilih tujuan keberangkatan yang ingin dilihat : ");
    System.out.println("1. Nusa Penida");
    System.out.println("2. Nusa Lembongan");
    System.out.println("3. Lombok");
    int tujuan;
    do {
      System.out.print("Pilih Tujuan Keberangkatan diatas : ");
    tujuan = scan.nextInt();
    //akan melakukan forEach untuk setiap data ArrayList, dan yang memiliki nilai setara akan dicetak
    for (ticket ticket : backside.tickets) {
        if (tujuan == 1 && ticket.getTujuan().equals("Nusa Penida")) {
            backside.printTicket(ticket);
        } else if (tujuan == 2 && ticket.getTujuan().equals("Nusa Lembongan")) {
            backside.printTicket(ticket);
        } else if (tujuan == 3 && ticket.getTujuan().equals("Lombok")) {
            backside.printTicket(ticket);
        }
    }
    scan.nextLine(); //Menangani karakter baru setelah membaca inputan int
    } while (tujuan != 1 && tujuan != 2 && tujuan != 3);

  }
    
}


