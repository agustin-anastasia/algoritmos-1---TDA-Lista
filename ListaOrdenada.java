/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernesto
 * @param <T>
 */
public class ListaOrdenada<T> extends Lista<T> {

    Nodo<T> primero;

    @Override
    public void insertar(Nodo<T> nodo) {
        Nodo<T> actual;
        Nodo<T> siguiente;

        // si la lista es vacia, lo defino como primero
        if (esVacia()) {
            this.primero = nodo;
        } else {
            // verifico que no exista ya el nodo
            if (this.buscar(nodo.getEtiqueta()) == null) {
                actual = this.getPrimero();
                siguiente = actual.getSiguiente();

                // primer elemento ya es mayor
                if (actual.compareTo(nodo.getEtiqueta()) > 0) {
                    // lo agrego primero a lista
                    nodo.setSiguiente(actual);
                    this.primero = nodo;
                }
                // caso de un solo elemento y es menor
                else if (siguiente == null) {
                    // lo agrego como siguiente y ultimo (null)
                    actual.setSiguiente(nodo);
                    nodo.setSiguiente(null);
                }
                // caso de dos elementos y estoy entre medio
                else if (actual.compareTo(nodo.getEtiqueta()) < 0 && siguiente.compareTo(nodo.getEtiqueta()) > 0) {
                    actual.setSiguiente(nodo);
                    nodo.setSiguiente(siguiente);
                } else {
                    // recorro la lista y voy comparando
                    while (actual.getSiguiente() != null) {
                        actual = actual.getSiguiente();
                        siguiente = actual.getSiguiente();
                        // llego al final de la lista y lo inserto al final
                        if (siguiente == null) {
                            actual.setSiguiente(nodo);
                            nodo.setSiguiente(null);
                            break;
                        } else if (actual.compareTo(nodo.getEtiqueta()) < 0 && siguiente.compareTo(nodo.getEtiqueta()) > 0) {
                            // inserto en este lugar y dejo de recorrer la lista
                            actual.setSiguiente(nodo);
                            nodo.setSiguiente(siguiente);
                            break;
                        }
                    }
                }
            }
        }
    }
}
