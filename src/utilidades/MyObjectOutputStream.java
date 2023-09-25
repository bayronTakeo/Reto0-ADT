/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author 2dam
 */
public class MyObjectOutputStream extends ObjectOutputStream{
    
    //SObrescribimos el metodo que crea la cabecera
        protected void writeStreamHeader() throws IOException {
            // No hacer nada.
            reset();
        }
        
        //Constructores
        public MyObjectOutputStream() throws IOException{
            super();
        }
        
        public MyObjectOutputStream(OutputStream out) throws IOException{
            super(out);
        }
}
