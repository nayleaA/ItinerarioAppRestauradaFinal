package com.example.itinerarioapp.Objetos;

/* Esta clase se encarga de funcionar como una clase objeto que permite rescatar y trabajar con los datos que
* recibira de la BD, con los metodos get and Set permite rescatarlos y devlverlos como un string para poner trabajarlo
* en la tarjeta del fragento.*/
public class Tarjeta {
    //variables
    int id;
    String Area, Fecha, HoraI,HoraF,Tel,Nom, Act;

    //constructor incializador de variables
    public Tarjeta(int id, String area, String fecha, String horaI, String horaF, String tel, String nom, String act) {
        this.id = id;
        this.Area = area;
        this.Fecha = fecha;
        this.HoraI = horaI;
        this.HoraF = horaF;
        this.Tel = tel;
        this.Nom = nom;
        this.Act = act;
    }

    //metodos get and set de las variables
    public Tarjeta(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getHoraI() {
        return HoraI;
    }

    public void setHoraI(String horaI) {
        HoraI = horaI;
    }

    public String getHoraF() {
        return HoraF;
    }

    public void setHoraF(String horaF) {
        HoraF = horaF;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getAct() {
        return Act;
    }


    public void setAct(String act) {
        Act = act;
    }

    //Retorno de los datos a traves de un string tipo arreglo de objetos
    @Override
    public String toString() {
        return "Tarjeta{" +
                "id=" + id +
                ", Area='" + Area + '\'' +
                ", Fecha='" + Fecha + '\'' +
                ", HoraI='" + HoraI + '\'' +
                ", HoraF='" + HoraF + '\'' +
                ", Tel='" + Tel + '\'' +
                ", Nom='" + Nom + '\'' +
                ", Act='" + Act + '\'' +
                '}';
    }
}
