package mx.com.cristian.mascotas;



public class Mascota {
    private int img;
    private String nombre;
    private String cali;

    public  Mascota(int img, String nombre, String cali){
        this.img=img;
        this.nombre=nombre;
        this.cali=cali;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCali() {
        return cali;
    }

    public void setCali(String cali) {
        this.cali = cali;
    }
}
