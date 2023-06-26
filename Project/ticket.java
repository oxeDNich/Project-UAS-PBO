package Project;

//Inheritance parent dan abstract class
abstract class ticket {

    private String id;
    private String nama;
    private String tujuan;
    private int jumlah;
    private int harga;

    //constructor ticket dari abtract
    public ticket (String id, String nama, String tujuan, int jumlah, int harga){
      this.id=id;
      this.nama=nama;
      this.tujuan=tujuan;
      this.jumlah=jumlah;
      this.harga=harga;
    }

    //encapsulation setter
    public void setId(String id) {
        this.id = id;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    //encapsulation getter
    public String getId() {
        return this.id;
    }
    
    public String getNama() {
        return this.nama;
    }

    public String getTujuan() {
        return this.tujuan;
    }

    public int getJumlah() {
        return this.jumlah;
    }

    public int getHarga() {
        return this.harga;
    }
    
    //Overriding sama addTicket di backside
    public abstract void addTicket(ticket ticket);

}