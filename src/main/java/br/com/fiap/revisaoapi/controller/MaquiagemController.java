package br.com.fiap.revisaoapi.controller;

import br.com.fiap.revisaoapi.dto.MaquiagemDTO;
import br.com.fiap.revisaoapi.model.Maquiagem;
import br.com.fiap.revisaoapi.service.MaquiagemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/maquiagem", produces = {"aplication/json"})
@Tag(name = "maquiagem-api")
public class MaquiagemController {
    private final MaquiagemService maquiagemService;

    @Autowired
    public MaquiagemController(MaquiagemService maquiagemService) {
        this.maquiagemService = maquiagemService;
    }

    @Operation(summary = "Retorna todas as maquiagens em páginas de 2")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "204", description = "Nenhuma maquiagem encontrada", content = {
                    @Content(schema = @Schema())
            })
    })

    @GetMapping
    public ResponseEntity<Page<MaquiagemDTO>> findAll() {
        Page<MaquiagemDTO> maquiagensDTO = maquiagemService.findAll();
        if (maquiagensDTO.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            for (MaquiagemDTO maquiagemDTO : maquiagensDTO){
                Long id = maquiagemDTO.getId();
                maquiagemDTO.add(linkTo(methodOn(MaquiagemController.class).findById(id)).withSelfRel());
            }
        }
        return new ResponseEntity.ok(maquiagensDTO);
    }

    @Operation(summary = "Retorna uma maquiagem específica por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "204", description = "Nenhuma maquiagem encontrada com o id informado", content = {
                    @Content(schema = @Schema())
            })
    })

    @GetMapping("/{id}")
    public ResponseEntity<MaquiagemDTO> findById(@PathVariable Long id) {
        MaquiagemDTO maquiagemDTO = maquiagemService.findById(id);
        if (maquiagemDTO == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            maquiagemDTO.add(linkTo(methodOn(MaquiagemController.class).findAll()).withSelfRel());
        }
        return ResponseEntity.ok(maquiagemDTO);
    }

    @Operation(summary = "Salva uma maquiagem")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Maquiagem salva com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação dos dados", content = {
                    @Content(schema = @Schema())
            })
    })

    @PostMapping
    public ResponseEntity<Maquiagem> save(@Valid @RequestBody Maquiagem maquiagem) {
        Maquiagem maquiagemSalva = maquiagemService.save(maquiagem);
        return new ResponseEntity<>(maquiagemSalva, HttpStatus.CREATED);
    }

    @Operation(summary = "Atualiza uma maquiagem com base no id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Maquiagem atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de validação dos dados", content = {
                    @Content(schema = @Schema())
            })
    })

    @PutMapping ("/{id}")
    public ResponseEntity<Maquiagem> update(@PathVariable Long id, @Valid @RequestBody Maquiagem maquiagem) {
        Maquiagem maquiagemSalva = maquiagemService.update(id, maquiagem);
        return new ResponseEntity<>(maquiagemSalva, HttpStatus.CREATED);
    }

    @Operation(summary = "Exclui uma maquiagem com base no id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Maquiagem excluída com sucesso", content = {
                    @Content(schema = @Schema())
            })
    })

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        maquiagemService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
