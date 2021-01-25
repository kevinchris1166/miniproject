package com.example.demo.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String namaBarang;
    @Column
    private String keterangan;
    @Column
    private int qty;
    @Column
    private String alamatPemesan;
    @Column
    private String namaPemesan;
    @Column
    private Timestamp tanggal;

    public Orders() {
    }

    public Orders(String namaBarang, String keterangan, int qty, String alamatPemesan, String namaPemesan, Timestamp tanggal) {
        this.namaBarang = namaBarang;
        this.keterangan = keterangan;
        this.qty = qty;
        this.alamatPemesan = alamatPemesan;
        this.namaPemesan = namaPemesan;
        this.tanggal = tanggal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getAlamatPemesan() {
        return alamatPemesan;
    }

    public void setAlamatPemesan(String alamatPemesan) {
        this.alamatPemesan = alamatPemesan;
    }

    public Timestamp getTanggal() {
        return tanggal;
    }

    public void setTanggal(Timestamp tanggal) {
        this.tanggal = tanggal;
    }
}
