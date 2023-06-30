package com.example.perguntaroleta;

public class Pergunta {

    private String Q;
    private String a;
    private String b;
    private String c;
    private String certa;
    private String Texto;

    public Pergunta(String q, String a, String b, String c, String certa,String Texto) {
        this.Q = q;
        this.a = a;
        this.b = b;
        this.c = c;
        this.certa = certa;
        this.Texto = Texto;
    }

    public String getTexto(){ return Texto;}
    public String getQ() {
        return Q;
    }

    public void setQ(String q) {
        Q = q;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getCerta() {
        return certa;
    }

    public void setCerta(String certa) {
        this.certa = certa;
    }
}
