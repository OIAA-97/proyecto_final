/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_final;

/**
 *
 * @author Haru
 */
public class Arbol {
    private Nodo raiz;

    public Arbol() {
    }
    
    
    public boolean isempty()
    {
        return raiz== null;
    }
    
    public boolean esroot(Nodo nodo)
    {
        return raiz == nodo;
    }
    
    public boolean eshoja(Nodo nodo )
    {
        return nodo.getDr()==null&&nodo.getIz()==null;
    }
    
    public boolean esinterno(Nodo nodo)
    {
        return !eshoja(nodo);
    }

}
