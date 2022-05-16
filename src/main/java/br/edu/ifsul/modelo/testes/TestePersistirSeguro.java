/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.modelo.testes;

import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Corretor;
import br.edu.ifsul.modelo.Seguro;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bruno
 */
public class TestePersistirSeguro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PWSeguradora-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Seguro s = new Seguro();
        s.setData(Calendar.getInstance());
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Calendar dataI = Calendar.getInstance();
        dataI.set(Calendar.YEAR, 2022);
        dataI.set(Calendar.MONTH, 6);
        dataI.set(Calendar.DAY_OF_MONTH, 16);
        s.setInicioVigencia(dataI);
        
        Calendar dataF = Calendar.getInstance();
        dataF.set(Calendar.YEAR, 2022);
        dataF.set(Calendar.MONTH, 6);
        dataF.set(Calendar.DAY_OF_MONTH, 28);
        s.setFimVigencia(dataF);
        
        s.setValorTotal(1200.0);
        s.setValorFipe(1000.0);
        
        s.setCorretor(em.find(Corretor.class, 4));
        s.setCarro(em.find(Carro.class, 1));
        
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
       
    }
    
}
