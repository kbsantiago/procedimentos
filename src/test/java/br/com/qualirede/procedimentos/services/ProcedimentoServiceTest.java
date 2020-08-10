package br.com.qualirede.procedimentos.services;

import br.com.qualirede.procedimentos.entities.Dto.ProcedimentoDto;
import br.com.qualirede.procedimentos.entities.Procedimento;
import br.com.qualirede.procedimentos.repository.ProcedimentoRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ProcedimentoServiceTest {

    @Mock
    private final ProcedimentoServiceImpl procedimentoService = new ProcedimentoServiceImpl();
    @Mock
    private ProcedimentoRepository procedimentoRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void try_insert_existent_proceed_test() {
        long result = procedimentoService.save(new ProcedimentoDto(1234, 10, "M", "SIM"));
        assertEquals(0l, result);
    }

    @Test
    public void insert_new_proceed_test() {
        long result = 0l;
        ProcedimentoDto procedimentoDto = new ProcedimentoDto(4444, 15, "F", "SIM");
        when(procedimentoService.save(procedimentoDto)).thenReturn(result);
        assertEquals(0l, result);
    }

    @Test
    public void try_authorize_invalid_proceed_test() {
        Procedimento procedimento = new Procedimento();
        when(procedimentoRepository.findByProceedAgeAndSex(5600, 10, "M")).thenReturn(procedimento);
        assertEquals(String.valueOf(false), procedimento.isPermitido(), false);
    }

    @Test
    public void try_authorize_valid_proceed_test() {
        Procedimento procedimento = new Procedimento();
        when(procedimentoRepository.findByProceedAgeAndSex(1234, 10, "M")).thenReturn(procedimento);
        assertEquals(String.valueOf(true), procedimento.isPermitido(), false);
    }
}
