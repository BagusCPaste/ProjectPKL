package com.bagus.projectpkl;

import java.util.List;

public class UserModel {
    private List<data> data;

    public List<UserModel.data> getData() {
        return data;
    }

    public void setData(List<UserModel.data> data) {
        this.data = data;
    }

    public class data {
        private String id_user, first_name, username,password, email, kode_cab, nama_cab, nama_ao,
        nama_lembaga1, Nama_lembaga2;

        public String getId_user() {
            return id_user;
        }

        public void setId_user(String id_user) {
            this.id_user = id_user;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getKode_cab() {
            return kode_cab;
        }

        public void setKode_cab(String kode_cab) {
            this.kode_cab = kode_cab;
        }

        public String getNama_cab() {
            return nama_cab;
        }

        public void setNama_cab(String nama_cab) {
            this.nama_cab = nama_cab;
        }

        public String getNama_ao() {
            return nama_ao;
        }

        public void setNama_ao(String nama_ao) {
            this.nama_ao = nama_ao;
        }

        public String getNama_lembaga1() {
            return nama_lembaga1;
        }

        public void setNama_lembaga1(String nama_lembaga1) {
            this.nama_lembaga1 = nama_lembaga1;
        }

        public String getGetNama_lembaga2() {
            return Nama_lembaga2;
        }

        public void setGetNama_lembaga2(String getNama_lembaga2) {
            this.Nama_lembaga2 = getNama_lembaga2;
        }
    }
}