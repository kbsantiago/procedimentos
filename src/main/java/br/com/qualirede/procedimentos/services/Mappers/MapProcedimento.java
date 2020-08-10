package br.com.qualirede.procedimentos.services.Mappers;

import br.com.qualirede.procedimentos.entities.Dto.ProcedimentoDto;
import br.com.qualirede.procedimentos.entities.Procedimento;

public class MapProcedimento implements MapperEntity<Procedimento, ProcedimentoDto> {

    @Override
    public Procedimento DtoToEntiy(ProcedimentoDto procedimentoDto) {

        boolean isPermitido = false;
        if(procedimentoDto.getAutoriza() != null)
             isPermitido = procedimentoDto.getAutoriza().toUpperCase().equals("SIM") ? true : false;


        return new Procedimento(procedimentoDto.getProcedimento(),
                procedimentoDto.getIdade(),
                procedimentoDto.getSexo(),
                isPermitido);
    }

    @Override
    public ProcedimentoDto EntityToDto(Procedimento procedimento) {

        String autoriza = procedimento.isPermitido() == true ? "Sim" : "Não";

        return new ProcedimentoDto(procedimento.getProcedimento(),
                procedimento.getIdade(),
                procedimento.getSexo(),
                autoriza);
    }
}
