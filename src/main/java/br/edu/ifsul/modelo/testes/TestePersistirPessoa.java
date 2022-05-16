/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.modelo.testes;

import br.edu.ifsul.modelo.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bruno
 */
public class TestePersistirPessoa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PWSeguradora-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Pessoa p = new Pessoa();
        
        p.setNome("Bruno Butka");
        p.setCpf("123.345.897-61");
        p.setRg("1234567891");
        p.setEmail("brunobutka@gmail.com");
        p.setTelefone("(54)99186-0059");
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
        
    }
    
}
