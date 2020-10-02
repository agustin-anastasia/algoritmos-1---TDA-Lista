
public class UT3_TA5 {

    public static void main(String[] args) {

        Almacen geant = new Almacen("Parque Roosevelt", "26345784", "GEANT");
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("altas.txt");
        System.out.println(lineas.length);

        for (String linea : lineas) {
            String[] aux = linea.split(",");
            Integer etiqueta = Integer.parseInt(aux[0]);
            Integer precio = Integer.parseInt(aux[2]);
            Integer stock = Integer.parseInt(aux[3]);
            String nombre = aux[1];
            Producto unProducto = new Producto(etiqueta, precio, stock, nombre);            
            geant.insertarProducto(unProducto);
        }
        System.out.print(geant.cantidadProductos());

        geant.getListaProductos().imprimir("-");
        // System.out.print(geant.buscarPorCodigo("1000147").getNombre());
        // geant.listarOrdenadoPorNombre();

        // geant.agregarStock(1000073, 1000);
        // System.out.println(geant.buscarPorCodigo(1000073).getStock());
        // geant.restarStock(1000073, 500);
        // System.out.println(geant.buscarPorCodigo(1000073).getStock());
        // System.out.println(geant.cantidadProductos());

    }

}