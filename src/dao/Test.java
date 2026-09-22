package dao;
import java.util.ArrayList;
import java.util.Iterator;

import entidad.Categoria;
import entidad.Producto;

public class Test {

	public static void main(String[] args) {
		
		DaoProducto daoP = new DaoProducto();
		Producto p1= new Producto(9, "Peras", 111.10, 2, 1);

		DaoCategoria daoC = new DaoCategoria();
		Categoria c1= new Categoria(1, "Fruta");

		daoC.agregarCategoria(c1);
		daoP.agregarProducto(p1);

		ArrayList<Categoria> Categorias = daoC.obtenerTodasLasCategorias();
		Iterator<Categoria> it = Categorias.iterator();
		while (it.hasNext()) {
		    System.out.println(it.next());
		}
		
		ArrayList<Producto> Productos= daoP.obtenerTodosLosProductos();
		Iterator<Producto> it2 = Productos.iterator();
		while (it2.hasNext()) {
		    System.out.println(it2.next());
		}

	}

}
