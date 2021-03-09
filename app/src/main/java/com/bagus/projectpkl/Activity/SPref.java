package com.bagus.projectpkl.Activity;

import org.json.JSONArray;

public class SPref {

    private static String NoImei="noimei";
    private static String UserName="username";
    private static String Alamat="alamat";
    private static String Pekerjaan="pekerjaan";
    private static String NIK="nik";
    private static String WhatsApp="whatsapp";
    private static String MyStatus="mystatus";
    private static String MyVersi="myversi";
    private static String TglPengajuan="tglpengajuan";

    private static String jsonArray = "";

    public static String getJSONOrder() { return jsonArray; }
    public static String getUSERNAME() { return UserName; }
    public static String getAlamat() { return Alamat; }
    public static String getPekerjaan() { return Pekerjaan; }
    public static String getNIK() { return NIK; }
    public static String getIMEI() { return NoImei; }
    public static String getWhatsApp() { return WhatsApp; }
    public static String getMyStatus() { return MyStatus;  }
    public static String getMyVersi() { return MyVersi;  }
    public static String getTglPengajuan() { return TglPengajuan;  }
}
