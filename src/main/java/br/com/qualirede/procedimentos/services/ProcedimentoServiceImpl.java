package br.com.qualirede.procedimentos.services;

import br.com.qualirede.procedimentos.entities.Dto.ProcedimentoDto;
import br.com.qualirede.procedimentos.entities.Procedimento;
import br.com.qualirede.procedimentos.repository.ProcedimentoRepository;
import br.com.qualirede.procedimentos.services.Mappers.MapProcedimento;
import br.com.qualirede.procedimentos.services.Mappers.MapperEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@Repository
@Transactional
public class ProcedimentoServiceImpl implements ProcedimentoService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ProcedimentoRepository repository;

    private MapperEntity<Procedimento, ProcedimentoDto> mapper = new MapProcedimento();

    @Override
    public Long save(ProcedimentoDto procedimentoDto) {
        Procedimento procedimento = mapper.DtoToEntiy(procedimentoDto);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withMatcher("procedimento", exact());
        Example<Procedimento> example = Example.of(procedimento, matcher);
        boolean result = repository.exists(example);

        if (!result) {
            return repository.save(procedimento).getId();
        } else {
            return 0l;
        }
    }

    @Override
    public List<ProcedimentoDto> getAll() {
        List<ProcedimentoDto> procedimentos = new ArrayList<>();
        for (Procedimento procedimento :
                repository.findAll()) {
            procedimentos.add(mapper.EntityToDto(procedimento));
        }
        return procedimentos;
    }

    @Override
    public ProcedimentoDto requestProceed(ProcedimentoDto procedimentoDto) {
        Procedimento procedimento = mapper.DtoToEntiy(procedimentoDto);
        procedimento = repository.findByProceedAgeAndSex(procedimento.getProcedimento(), procedimento.getIdade(), procedimento.getSexo());

        if(procedimento != null) {
            procedimentoDto.setAutoriza(procedimento.isPermitido() ? "SIM" : "NÃO");
        } else { procedimentoDto.setAutoriza("NÃO"); }

        return procedimentoDto;
    }
}
