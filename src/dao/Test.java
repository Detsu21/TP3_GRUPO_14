package dao;
import java.util.ArrayList;
import java.util.Iterator;

import entidad.Producto;

public class Test {

	public static void main(String[] args) {
		
		DaoProducto daoP = new DaoProducto();
		Producto p1= new Producto(9, "Peras", 111.10, 2, 1);
		
		System.out.println(p1.toString());
		
		daoP.agregarProducto(p1);
		ArrayList<Producto> Productos= daoP.obtenerTodosLosProductos();
		Iterator<Producto> it = Productos.iterator();
		while (it.hasNext()) {
		    System.out.println(it.next());
		}
	}

}
