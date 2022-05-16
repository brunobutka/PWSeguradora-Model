/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.modelo.testes;

import br.edu.ifsul.modelo.Corretor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bruno
 */
public class TestePersistirCorretor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PWSeguradora-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Corretor c = new Corretor();
        
        c.setNome("Brener Augusto");
        c.setCpf("111.222.333-12");
        c.setRg("1122334455");
        c.setEmail("breneraugusto@gmail.com");
        c.setTelefone("(54)99100-2233");
        c.setPercentualComissao(15.0);
        c.setNomeUsuario("brener");
        c.setSenha("12345");
        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
}
