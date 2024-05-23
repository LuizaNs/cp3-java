package br.com.fiap.revisaoapi.service;

import br.com.fiap.revisaoapi.dto.MaquiagemDTO;
import br.com.fiap.revisaoapi.model.Maquiagem;
import br.com.fiap.revisaoapi.repository.MaquiagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Optional;

@Service
public class MaquiagemService {
    private final MaquiagemRepository maquiagemRepository;
    private static final Pageable customPageable = (Pageable) PageRequest.of(0,2, Sort.by("marca").ascending());

    @Autowired
    public MaquiagemService(MaquiagemRepository maquiagemRepository) {
        this.maquiagemRepository = maquiagemRepository;
    }

    public Page<MaquiagemDTO> findAll() {
        return maquiagemRepository.findAll((Sort) customPageable).map(this::toDTO);
    }

    public MaquiagemDTO findById(Long id) {
        Optional<Maquiagem> maquiagem = maquiagemRepository.findById(id);
        return maquiagem.map(this::toDTO).orElse(null);
    }

    public Maquiagem save(Maquiagem maquiagem){
        return maquiagemRepository.save(maquiagem);
    }

    public Maquiagem update(Long id, Maquiagem maquiagem) {
        Optional<Maquiagem> maquiagemOptional = maquiagemRepository.findById(id);
        if (maquiagemOptional.isPresent()) {
            Maquiagem maquiagemUpdate = maquiagemOptional.get();
            maquiagemUpdate.setNome(maquiagemUpdate.getNome());
            maquiagemUpdate.setMarca(maquiagem.getMarca());
            maquiagemUpdate.setCategoria(maquiagem.getCategoria());
            maquiagemUpdate.setCrueltyFree(maquiagem.getCrueltyFree());
            maquiagemUpdate.setPreco(maquiagem.getPreco());
            maquiagem = maquiagemRepository.save(maquiagemUpdate);
            return maquiagem;
        }
        return null;
    }

    public void delete(Long id) {
        Optional<Maquiagem> maquiagemOptional = maquiagemRepository.findById(id);
        maquiagemOptional.ifPresent(maquiagemRepository::delete);
    }

    private MaquiagemDTO toDTO(Maquiagem maquiagem) {
        MaquiagemDTO maquiagemDTO = new MaquiagemDTO();
        maquiagemDTO.setId(maquiagem.getId());
        maquiagemDTO.setNome(maquiagem.getNome());
        maquiagemDTO.setMarca(maquiagem.getMarca());
        maquiagemDTO.setCategoria(maquiagem.getCategoria());
        maquiagemDTO.setPreco(maquiagemDTO.getPreco());
        return maquiagemDTO;
    }
}
