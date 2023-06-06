package Project;

abstract class ticket {

    private String id;
    private String nama;
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getId() {
        return id;
    }
    
    public String getNama() {
        return nama;
    }

}