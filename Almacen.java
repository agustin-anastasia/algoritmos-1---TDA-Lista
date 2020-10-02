
public class Almacen implements IAlmacen {

    private String direccion;
    private String telefono;
    private String nombre;
    private Lista<Producto> listaProductos;

    public Almacen(String direccion, String telefono, String nombre){
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombre = nombre;
        listaProductos = new Lista<>();
    }

    @Override
    public String getDireccion() {
        return this.direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;

    }

    @Override
    public String getTelefono() {
        return this.telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public Lista<Producto> getListaProductos() {
        return this.listaProductos;
    }

    @Override
    public void insertarProducto(Producto unProducto) {
        Nodo<Producto> nodoProducto = new Nodo<>(unProducto.getEtiqueta(), unProducto);
        this.listaProductos.insertar(nodoProducto);
    }

    @Override
    public boolean eliminar(Comparable clave) {
        return this.listaProductos.eliminar(clave);
    }

    @Override
    public String imprimirProductos() {
        return this.listaProductos.imprimir();
    }

    @Override
    public String imprimirSeparador(String separador) {
        return this.listaProductos.imprimir(separador);
    }

    @Override
    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        Nodo<Producto> aux = this.listaProductos.buscar(clave);
        if(aux != null){
            Producto unProducto = aux.getDato();
            Integer stockActual = unProducto.getStock();
            unProducto.setStock(stockActual + cantidad);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Integer restarStock(Comparable clave, Integer cantidad) {
        Nodo<Producto> unProducto = this.listaProductos.buscar(clave);
        if(unProducto != null){
            Integer stockActual = unProducto.getDato().getStock();
            if((stockActual - cantidad) > 0){
                unProducto.getDato().setStock(stockActual - cantidad);
                unProducto.getDato().getStock();
            }else{
                System.out.println("no es posible restar una cantidad mayor a la actual.");
                return -1;
            }
        }
        return -1;
    }

    @Override
    public IProducto buscarPorCodigo(Comparable clave) {
        Nodo<Producto> unProducto = this.listaProductos.buscar(clave);
        if (unProducto != null){
            return unProducto.getDato();
        }else{
            return null;
        }
    }

    @Override
    public void listarOrdenadoPorNombre() {
        ListaOrdenada<Producto> listaOrdenada = new ListaOrdenada<>();
        Nodo<Producto> aux = this.listaProductos.getPrimero();
        while (aux != null){
            Nodo<Producto> productoAInsertar = new Nodo<>(aux.getDato().getNombre(), aux.getDato());
            listaOrdenada.insertar(productoAInsertar);
            aux = aux.getSiguiente();
        }
        System.out.println(listaOrdenada.imprimir());
        System.out.println(listaOrdenada.cantElementos());
    }

    @Override
    public Producto buscarPorDescripcion(String descripcion) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int cantidadProductos() {
        return this.listaProductos.cantElementos();
    }

    public Integer calcularStock(){
        Integer monto = 0;
        Integer stock = 0;
        Nodo<Producto> aux = listaProductos.getPrimero();
        while (aux != null){
            stock = aux.getDato().getStock();
            monto = aux.getDato().getPrecio() * stock;
            aux = aux.getSiguiente();
        }
        return monto;
    }

}