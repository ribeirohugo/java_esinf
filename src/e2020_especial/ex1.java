/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2020_especial;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author hugo.ribeiro
 */
public class ex1 {
    
    public static Map<Integer, List<String>> converteValorEmMoedas(Double valor) {
        Map<Integer, List<String>> map = new TreeMap<>();
        
        valor=valor*100;
        int valorCents = valor.intValue();
        int moedas, divisor;
        String coin;
        
        while(valorCents != 0) {
            if(valorCents>=200) {
                divisor = 200;
                coin = "2eur";
                
            } else {
                if(valorCents>=100) {
                    divisor = 100;
                    coin = "1eur";
                    
                } else {
                    if(valorCents>=20) {
                        divisor = 20;
                        coin = "20cent";

                    } else {
                        if(valorCents>=5) {
                            divisor = 5;
                            coin = "5cent";
                            
                        } else {
                            divisor = 1;
                            coin = "1cent";
                        }
                    }
                }
            }
            
            moedas = valorCents / divisor;
            valorCents%=divisor;
            
            if(map.containsKey(moedas)) {
               List<String> lista = map.get(moedas);
               lista.add(coin);
               map.put(moedas, lista);
               
            } else {
                List<String> lista = new ArrayList<>();
                lista.add(coin);
                map.put(moedas, lista);
            }
        }
        return map;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Double valor = 50.73;
        System.out.println("Valor = €"+valor);
        Map<Integer, List<String>> map = converteValorEmMoedas(valor);
        System.out.println(map);
    }
}
