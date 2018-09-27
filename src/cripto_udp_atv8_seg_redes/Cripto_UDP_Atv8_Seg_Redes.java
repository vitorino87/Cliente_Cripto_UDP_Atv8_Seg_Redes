/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cripto_udp_atv8_seg_redes;

/**
 *
 * @author tiago.lucas
 */
public class Cripto_UDP_Atv8_Seg_Redes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UDPClient udp = new UDPClient();
        try{
           udp.iniciarComunicacao(); 
        }catch(Exception ex){
            System.out.println("Deu ruim! Erro: "+ex);
        }
        
    }
    
}
