package br.com.qualirede.procedimentos.repository;

import br.com.qualirede.procedimentos.entities.Procedimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface ProcedimentoRepository extends JpaRepository<Procedimento, Long> {
    @Query("SELECT p FROM Procedimento p WHERE p.procedimento = :procedimento AND p.idade = :age AND p.sexo = upper(:sex)")
    Procedimento findByProceedAgeAndSex(Integer procedimento, int age, String sex);
}
