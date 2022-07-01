/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.util;

import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Corretor;
import br.edu.ifsul.modelo.Seguro;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author bruno
 */
public class UtilRelatorios {
    
    public static List<Seguro> carregaSeguros() {
        List<Seguro> lista = new ArrayList<>();
        
        Seguro s1 = new Seguro();
        s1.setId(1);
        s1.setData(Calendar.getInstance());
        s1.setInicioVigencia(Calendar.getInstance());
        s1.setFimVigencia(Calendar.getInstance());
        s1.setValorTotal(1000.0);
        s1.setValorFipe(1000.0);
        
        Carro c1 = new Carro();
        c1.setId(1);
        c1.setPlaca("a1b2c3d");
        c1.setModelo("SUV");
        
        s1.setCarro(c1);
        
        Corretor co1 = new Corretor();
        co1.setId(1);
        co1.setNome("Joao Augusto");
        co1.setNomeUsuario("joaoaugusto");
        co1.setSenha("12345");
        
        s1.setCorretor(co1);
        
        lista.add(s1);
        
        return lista;
    }
}
