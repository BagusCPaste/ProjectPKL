package com.bagus.projectpkl.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class DataUser {
    @SerializedName("id_user")
    @Expose
    private Integer id_user;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("first_name")
    @Expose
    private String first_name;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("kode_cab")
    @Expose
    private String kode_cab;

    @SerializedName("nama_cab")
    @Expose
    private String nama_cab;

    @SerializedName("alamat_cab")
    @Expose
    private String alamat_cab;

    @SerializedName("kode_ao")
    @Expose
    private String kode_ao;

    @SerializedName("nama_lembaga1")
    @Expose
    private String nama_lembaga1;

    @SerializedName("nama_lembaga2")
    @Expose
    private String nama_lembaga2;



    public Integer getId_User() {
       return id_user;
    }

    public void setIduser(Integer id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_Name() {
        return first_name;
    }

    public void setFirst_Name(String first_name) {
        this.first_name = first_name;
    }
    public String getNama_lembaga1() {
        return nama_lembaga1;
    }

    public void setNama_lembaga1(String nama_lembaga1) {
        this.nama_lembaga1 = nama_lembaga1 ;
    }
    public String getNama_lembaga2() {
        return nama_lembaga2;
    }

    public void setNama_lembaga2(String nama_lembaga2) {
        this.nama_lembaga2 = nama_lembaga2 ;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email ;
    }
    public String getKdCABANG() {
        return kode_cab;
    }
    public void setKode_cab(String kode_cab) {
        this.kode_cab = kode_cab ;
    }
    public String getNmCABANG() {
        return nama_cab;
    }
    public void setNama_cab(String nama_cab) {
        this.nama_cab = nama_cab ;
    }
    public String getAlamatCABANG() {
        return alamat_cab;
    }
    public void setAlamat_cab(String alamat_cab) {
        this.alamat_cab = alamat_cab ;
    }
    public String getKode_ao() {
        return kode_ao;
    }
    public void setKode_ao(String kode_ao) {
        this.kode_ao = kode_ao ;
    }
    @Override
    public String toString() {
        return "UserResponse{" +
                "id=" + id_user +
                ", username='" + username + '\'' +
                ", first_name='" + first_name + '\'' +
                ", kode_ao='" + kode_ao + '\'' +
                ", email='" + email + '\'' +
                ", nama_cab=" + nama_cab +
                ", kode_cab='" + alamat_cab + '\'' +
                ", nama_lembaga1='"+ nama_lembaga1+'\''+
                ", nama_lembaga2='"+ nama_lembaga2+'\''+
                '}';
    }
}

