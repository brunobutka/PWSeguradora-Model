/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.modelo.testes;

import br.edu.ifsul.modelo.Permissao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bruno
 */
public class TestePersistirPermissao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PWSeguradora-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Permissao p1 = new Permissao();
        p1.setNome("INCLUIR");
        p1.setDescricao("Permissão para incluir");
        
        Permissao p2 = new Permissao();
        p2.setNome("ALTERAR");
        p2.setDescricao("Permissão para alterar");
        
        Permissao p3 = new Permissao();
        p3.setNome("EXCLUIR");
        p3.setDescricao("Permissão para excluir");
        
        Permissao p4 = new Permissao();
        p4.setNome("COMUM");
        p4.setDescricao("Permissão comum");
        
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.persist(p4);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
}
