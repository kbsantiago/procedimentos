package br.com.qualirede.procedimentos.entities;

import com.sun.org.apache.xpath.internal.objects.XString;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "procedimentos")
public class Procedimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "procedimento")
    private Integer procedimento;
    @Column(name = "idade")
    private Integer idade;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "permitido")
    private boolean isPermitido;

    public Procedimento() {};

    public Procedimento(Integer procedimento, Integer idade, String sexo, boolean isPermitido){
        this.procedimento = procedimento;
        this.idade = idade;
        this.sexo = sexo;
        this.isPermitido = isPermitido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Integer procedimento) {
        this.procedimento = procedimento;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isPermitido() {
        return isPermitido;
    }

    public void setIsPermitido(boolean isPermitido) {
        isPermitido = isPermitido;
    }
}
