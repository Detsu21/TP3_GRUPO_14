package main;

import dao.DaoCategoria;
import dao.DaoProducto;

public class Principal {
    public static void main(String[] args) {
        DaoCategoria daoCategoria = new DaoCategoria();
        DaoProducto daoProducto = new DaoProducto();

        System.out.println("--- Iniciando Pruebas del TP3 ---");
        
        System.out.println("Pruebas finalizadas.");
    }
}