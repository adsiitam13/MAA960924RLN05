package a.b.c.d.e.f;

public class Solucion {
    class Node{
        private String data;
        private Node next;
        

        public Node(String data) {
            this.data = data;
        }
        
        /** Metodo para invertir la lista. 
         *  Por ejemplo, si la lista es de la forma 
         *      A----B----C----D----E----  
         *  y el nodo actual es "A", entonces la invocacion de este metodo devuelve la siguiente lista
         *      E----D----C----B----A----
         *
         *  @return Regresa la lista invertida a partir del nodo actual
         */
        public Node invertir() {
            Node sig=this.next;
            Node aux=sig.invertir();

            if(next == null){
                return this;
            }

            this.next = null;
            sig.setNext(this);

            return aux;
        }
        /**
         *Método para modificar el siguiente nodo del nodo actual.
         *
         * @param Node recibe un nodo que se quiere asignar como siguiente al nodo actual. 
         */
        public void setNext(Node n){
            this.next=n;
        }

        /** Metodo para obtener el siguiente nodo.
         * Ejemplo: Si la lista es de la forma
         *          X---Y---Z
         *  y se manda a llamar getnext() desde el nodo "Y" 
         *  entonces devuelve el nodo Z
         *
         *  @return regresa el siguiente nodo
         */
        public Node getNext(){
            return next;
        }
        
        /**
         * Metodo para obtener los datos del nodo.
         * 
         * @return regresa un String con los datos del nodo.
         */
        public String getData(){
            return data;
        }
      
        /**
         * Imprime en la consola la secuencia de Nodos que 
         * componen a esta lista. Por ejemplo, para la lista
         * que devuelve el metodo "build", la invocacion de
         * este metodo escribe en la consola: 
         * 
         * A--B--C--D--E--F--
         * 
         * Lo anterior sera lo que se visualiza en la consola 
         * justo despues de ejecutar las siguintes dos lineas:
         * 
         *         Node a = build();
         *         a.printList();
         *         
         */
        public void printList() {
            Node aux=this.next;
            String lista=this.data+"---->";

            while(aux!=null){
                lista+=aux.getData()+"---->";
                aux=aux.getNext();
            }
        }
        
    }// ends Node class
    
    /**
     * 
     * Metodo que crea una lista con 6 nodos.
     * Al nodo n_i le asigna como siguiente el nodo n_{i+1}
     * @return Node regresa el primer nodo de la lista
     */
    private Node build() {
        Node n1 = new Node("A");
        Node n2 = new Node("B");
        Node n3 = new Node("C");
        Node n4 = new Node("D");
        Node n5 = new Node("E");
        Node n6 = new Node("F");
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        return n1;
    }

    /**
     * Prueba la funcionalidad de el metodo "invertir" con distintos casos de prueba.
     */
    public void ok() {
        Node a = build();
        a.printList();
        a = a.invertir();
        a.printList();
        a = a.invertir();
        a.printList();
        
        Node b = new Node("X");
        b = b.invertir();
        b.printList();
        
        Node c = new Node("X");
        Node d = new Node("Y");
        c.next = d;
        c = c.invertir();
        c.printList();   
    }
    
    /**
     * Prueba el metodo ok de la clase Node.
     */
    public static void main(String...argv) {
        new Solucion().ok();
    }

}
