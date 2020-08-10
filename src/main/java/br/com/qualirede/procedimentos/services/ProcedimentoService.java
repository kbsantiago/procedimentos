package br.com.qualirede.procedimentos.services;

import br.com.qualirede.procedimentos.entities.Dto.ProcedimentoDto;

import java.util.List;

public interface ProcedimentoService {
    Long save(ProcedimentoDto procedimentoDto);
    List<ProcedimentoDto> getAll();
    ProcedimentoDto requestProceed(ProcedimentoDto procedimentoDto);
}
