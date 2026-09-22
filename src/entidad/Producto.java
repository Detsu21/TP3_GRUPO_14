package entidad;

public class Producto {
    
    private int codigo;
    private String nombre;
    private double precio;
    private int stock;
    private int idCategoria;

    public Producto() {
    }

    public Producto(int codigo, String nombre, double precio, int stock, int idCategoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.idCategoria = idCategoria;
    }

    public int getCodigo() { 
        return codigo; 
    }
    
    public void setCodigo(int i) { 
        this.codigo = i; 
    }

    public String getNombre() { 
        return nombre; 
    }
    
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public double getPrecio() { 
        return precio; 
    }
    
    public void setPrecio(double precio) { 
        this.precio = precio; 
    }

    public int getStock() { 
        return stock; 
    }
    
    public void setStock(int stock) { 
        this.stock = stock; 
    }

    public int getIdCategoria() { 
        return idCategoria; 
    }
    
    public void setIdCategoria(int idCategoria) { 
        this.idCategoria = idCategoria; 
    }

    @Override
    public String toString() {
        return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + ", idCategoria=" + idCategoria + "]";
    }
}