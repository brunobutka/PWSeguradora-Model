/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.edu.ifsul.modelo.testes;

import br.edu.ifsul.modelo.Acessorios;
import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Corretor;
import br.edu.ifsul.modelo.Permissao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bruno
 */
public class TestePersistirPermissaoCorretor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PWSeguradora-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Corretor c = em.find(Corretor.class, 4);
        Permissao p = em.find(Permissao.class, "INCLUIR");
        
        c.getPermissoes().add(p);
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
}
