package Project;

abstract class ticket {

    private String id;
    private String nama;
    private String tujuan;
    private int jumlah;
    private int harga;
    
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

    public String getId() {
        return id;
    }
    
    public String getNama() {
        return nama;
    }

    public String getTujuan() {
        return tujuan;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getHarga() {
        return harga;
    }
        
    public abstract void addTicket(ticket ticket);

}