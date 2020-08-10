package br.com.qualirede.procedimentos.controllers;

import br.com.qualirede.procedimentos.entities.Dto.ProcedimentoDto;
import br.com.qualirede.procedimentos.services.ProcedimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/autorizador")
@ResponseBody
public class ProcedimentoController {
    private final ProcedimentoService procedimentoService;

    @Autowired
    public ProcedimentoController(ProcedimentoService procedimentoService) {
        this.procedimentoService = procedimentoService;
    }

    @RequestMapping(method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity get() {
        return ResponseEntity.ok(procedimentoService.getAll());
    }

    @RequestMapping(path="/cadastro/procedimento/{id}/idade/{idade}/sexo/{sexo}/autoriza/{autoriza}",
            method = RequestMethod.POST,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity save(@PathVariable("id")Integer idProcedimento,
                               @PathVariable("idade")Integer idade,
                               @PathVariable("sexo")String sexo,
                               @PathVariable("autoriza")String autoriza) {

        long id = procedimentoService.save(new ProcedimentoDto(idProcedimento, idade, sexo, autoriza));

        if(id != 0)
            return ResponseEntity.ok("Procedimento cadastrado com sucesso!");
        else
            return ResponseEntity.ok("Procedimento informado já cadastrado!");
    }

    @RequestMapping(path="/procedimento/{id}/idade/{idade}/sexo/{sexo}",
            method = RequestMethod.POST,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity resquetProceedtAuthorization(@PathVariable("id")Integer idProcedimento,
                                                       @PathVariable("idade")Integer idade,
                                                       @PathVariable("sexo")String sexo) {

        try {
            String autorizado = procedimentoService.requestProceed(new ProcedimentoDto(idProcedimento, idade, sexo)).getAutoriza();
            return ResponseEntity.ok(autorizado);
        }
        catch(Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
