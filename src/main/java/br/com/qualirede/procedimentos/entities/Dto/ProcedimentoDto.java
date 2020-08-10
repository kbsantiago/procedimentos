package br.com.qualirede.procedimentos.entities.Dto;

public class ProcedimentoDto {
    private Integer procedimento;
    private Integer idade;
    private String sexo;
    private String autoriza;

    public ProcedimentoDto(Integer procedimento, Integer idade, String sexo) {
        this.procedimento = procedimento;
        this.idade = idade;
        this.sexo = sexo;
    }

    public ProcedimentoDto(Integer procedimento, Integer idade, String sexo, String autoriza) {
        this.procedimento = procedimento;
        this.idade = idade;
        this.sexo = sexo;
        this.autoriza = autoriza;
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

    public String getAutoriza() {
        return autoriza;
    }

    public void setAutoriza(String autoriza) {
        this.autoriza = autoriza;
    }
}
