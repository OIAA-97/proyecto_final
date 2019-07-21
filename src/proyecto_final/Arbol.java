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
    
    
    public void insertar(int dato)
    {
        Nodo nuevo;
        nuevo= new Nodo();
        
        nuevo.dato=dato;
        nuevo.iz=null;
        nuevo.Dr=null;
        if(raiz==null)
        {
            raiz=nuevo;
        }
        else
        {
            Nodo anterior =null,reco;
            reco=raiz;
            while(reco !=null)
            {
                anterior=reco;
                if(dato<reco.dato)
                {
                    reco=reco.iz;
                }
                else
                {
                    reco=reco.Dr;
                }
                if(dato<anterior.dato)
                {
                    anterior.iz=nuevo;
                }
                else
                {
                    anterior.Dr=nuevo;
                }
                
            }
            
            
        }
    }

    private void imprimirPre (Nodo reco)
      {
          if (reco != null)
          {
              System.out.print(reco.dato + " ");
              imprimirPre (reco.iz);
              imprimirPre (reco.Dr);
          }
      }

      public void imprimirPre ()
      {
          imprimirPre (raiz);
          System.out.println();
      }

      private void imprimirEntre (Nodo reco)
      {
          if (reco != null)
          {    
              imprimirEntre (reco.iz);
              System.out.print(reco.dato + " ");
              imprimirEntre (reco.Dr);
          }
      }

      public void imprimirEntre ()
      {
          imprimirEntre (raiz);
          System.out.println();
      }


      private void imprimirPost (Nodo reco)
      {
          if (reco != null)
          {
              imprimirPost (reco.iz);
              imprimirPost (reco.Dr);
              System.out.print(reco.dato + " ");
          }
      }


      public void imprimirPost ()
      {
          imprimirPost (raiz);
          System.out.println();
      }
      
      
      public boolean  eliminarnodo( int d)
      {
          Nodo aux=raiz;
          Nodo padre=raiz;
          boolean hijoiz=true;
          while(aux.dato !=d)
          {
              padre=aux;
              
              if(d<aux.dato)
              {
                  hijoiz=true;
                  aux=aux.iz;
              }
              else
              {
                  hijoiz=false;
                  aux=aux.Dr;
              }
              if(aux==null)
              {
                  return false;
              }
          }
          if(aux.iz==null&&aux.Dr==null)
          {
           if(aux==raiz)
           {
               raiz=null;
           }
           else if(hijoiz)
           {
               padre.iz=null;
           }
           else
           {
            padre.Dr=null;   
           }
           
          }
          else if(aux.Dr==null) 
           {
            if(aux==raiz)
           {
             raiz=aux.iz;
           }
           else if(hijoiz)
           {
               padre.iz=aux.iz;
           }
           else
           {
            padre.Dr=aux.iz;   
           }   
           }
           else if(aux.iz==null)
           {
               if(aux==raiz)
              {
               raiz=aux.Dr;
               }
               else if(hijoiz)
               {
               padre.iz=aux.Dr;
               }
               else
               {
                padre.Dr=aux.iz;   
                }   
           }
          else
           {
               Nodo remplazo=obtener(aux);
               if(aux==raiz)
               {
                   raiz=remplazo;
               }else if(hijoiz)
               {
                   padre.iz=remplazo;
               }
               else
               {
                   padre.iz=remplazo;
               }
               remplazo.iz=aux.iz;
               
           }
          return true; 
      }
      
      
      public Nodo obtener(Nodo nodoremplazo)
      {
         Nodo remplazarpadre= nodoremplazo;
         Nodo remplazo=nodoremplazo;
         Nodo aux=nodoremplazo.iz;
         while(aux!=null)
         {
             remplazarpadre=remplazo;
             remplazo=aux;
             aux=aux.iz;
         }
         if(remplazarpadre!=nodoremplazo.iz)
         {
             remplazarpadre.iz= remplazo.iz;
             remplazo.Dr=nodoremplazo.Dr;
         }
          System.out.println("el nodo remplazo es "+remplazo);
        return remplazo;
      }
      
      
      public Nodo buscarnodo(int d)
      {
          Nodo aux=raiz;
          
          while (aux.dato !=d)
          {
              if(d<aux.dato)
              {
                  aux=aux.iz;
              }
              else
              {
                  aux=aux.Dr;
              }
              if(aux==null)
              {
                  return null;
              }
             
          }
           return aux;
      }
      
      
      
      

       
}
