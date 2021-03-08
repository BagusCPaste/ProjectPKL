package com.bagus.projectpkl.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Collection;
import java.util.List;

public class DataMember {

    @SerializedName("no_pinjaman")
    @Expose
    private Integer no_pinjaman;

    @SerializedName("nama_anggota")
    @Expose
    private String nama_anggota ;

    @SerializedName("tgl_realisasi")
    @Expose
    private Integer tgl_realisasi;

    @SerializedName("jml_pinjaman")
    @Expose
    private Integer jml_pinjaman;

    @SerializedName("angs_pokok")
    @Expose
    private Integer angsuran_pokok;

    @SerializedName("angs_jasa")
    @Expose
    private Integer angsuran_jasa;

    @SerializedName("tunggakan_pokok")
    @Expose
    private Integer tunggakan_pokok;

    @SerializedName("saldo")
    @Expose
    private Integer saldo;

    @SerializedName("no_rekening")
    @Expose
    private Integer no_rekening;

    @SerializedName("produk")
    @Expose
    private String produk;

    @SerializedName("namalembaga")
    @Expose
    private Integer namalembaga;

    @SerializedName("kodelembaga")
    @Expose
    private Integer kodelembaga;

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public Integer getNo_rekening() {
        return no_rekening;
    }

    public void setNo_rekening(Integer no_rekening) {
        this.no_rekening = no_rekening;
    }

    public String getProduk() {
        return produk;
    }

    public void setProduk(String produk) {
        this.produk = produk;
    }

    public Integer getNamalembaga() {
        return namalembaga;
    }

    public void setNamalembaga(Integer namalembaga) {
        this.namalembaga = namalembaga;
    }

    public Integer getKodelembaga() {
        return kodelembaga;
    }

    public void setKodelembaga(Integer kodelembaga) {
        this.kodelembaga = kodelembaga;
    }

    public Integer getNo_pinjaman() {
        return no_pinjaman;
    }

    public void setNo_pinjaman(Integer no_pinjaman) {
        this.no_pinjaman = no_pinjaman;
    }

    public String getNama_anggota() {
        return nama_anggota;
    }

    public void setNama_anggota(String nama_anggota) {
        this.nama_anggota = nama_anggota;
    }

    public Integer getTgl_realisasi() {
        return tgl_realisasi;
    }

    public void setTgl_realisasi(Integer tgl_realisasi) {
        this.tgl_realisasi = tgl_realisasi;
    }

    public Integer getJml_pinjaman() {
        return jml_pinjaman;
    }

    public void setJml_pinjaman(Integer jml_pinjaman) {
        this.jml_pinjaman = jml_pinjaman;
    }

    public Integer getAngsuran_pokok() {
        return angsuran_pokok;
    }

    public void setAngsuran_pokok(Integer angsuran_pokok) {
        this.angsuran_pokok = angsuran_pokok;
    }

    public Integer getAngsuran_jasa() {
        return angsuran_jasa;
    }

    public void setAngsuran_jasa(Integer angsuran_jasa) {
        this.angsuran_jasa = angsuran_jasa;
    }

    public Integer getTunggakan_pokok() {
        return tunggakan_pokok;
    }

    public void setTunggakan_pokok(Integer tunggakan_pokok) {
        this.tunggakan_pokok = tunggakan_pokok;
    }
}
