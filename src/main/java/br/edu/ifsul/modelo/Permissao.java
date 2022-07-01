
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author bruno
 */
@Entity
@Table(name = "permissao")
public class Permissao implements Serializable {

    @Id
    @NotBlank(message = "O nome da permissão deve ser informado")
    @Length(max = 20, message = "O nome da permissão não deve ter mais que {max} caracteres")
    @Column(name = "nome", length = 20, nullable = false)
    private String nome;
    @NotBlank(message = "A descrição da permissão deve ser informada")
    @Length(max = 50, message = "A descrição da permissão não deve ter mais que {max} caracteres")
    @Column(name = "descricao", length = 50, nullable = false)
    private String descricao;
    
    @ManyToMany
    @JoinTable(name = "permissao_corretor",
            joinColumns = 
                    @JoinColumn(name = "nome_permissao", referencedColumnName = "nome", nullable = false),
            inverseJoinColumns = 
                    @JoinColumn(name = "nome_usuario", referencedColumnName = "nome_usuario", nullable = false)
            )
    private Set<Corretor> corretores = new HashSet<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Permissao other = (Permissao) obj;
        return Objects.equals(this.nome, other.nome);
    }

    public Set<Corretor> getCorretores() {
        return corretores;
    }

    public void setCorretores(Set<Corretor> corretores) {
        this.corretores = corretores;
    }
}
