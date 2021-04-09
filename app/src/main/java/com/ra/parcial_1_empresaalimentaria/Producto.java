package com.ra.parcial_1_empresaalimentaria;

public class Producto {

    Integer Codigo;
    Integer Valor;
    boolean IVA;
    String Categoria;
    String Descripcion;

    public Producto(Integer codigo, Integer valor, boolean IVA, String categoria, String descripcion) {
        Codigo = codigo;
        Valor = valor;
        this.IVA = IVA;
        Categoria = categoria;
        Descripcion = descripcion;
    }

    public Integer getCodigo() {
        return Codigo;
    }

    public void setCodigo(Integer codigo) {
        Codigo = codigo;
    }

    public Integer getValor() {
        return Valor;
    }

    public void setValor(Integer valor) {
        Valor = valor;
    }

    public boolean isIVA() {
        return IVA;
    }

    public void setIVA(boolean IVA) {
        this.IVA = IVA;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "El producto que ingreso es: \n" +
                "Codigo: " + Codigo +"\n"+
                "Valor: " + Valor +"\n"+
                "IVA: " + IVA +"\n"+
                "Categoria: " + Categoria + "\n"+
                "Descripcion= " + Descripcion +"\n";
    }

    public String toString1(){
        return String.valueOf(Valor);
    }
}
