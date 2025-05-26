package com.synaptech.service;

import com.synaptech.domain.vaga.Vaga;
import com.synaptech.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VagasService {

    @Autowired
    private VagaRepository vagaRepository;

    public Vaga criar(Vaga vaga) {
        return vagaRepository.save(vaga);
    }

    public List<Vaga> listarTodas() {
        return vagaRepository.findAll();
    }

    public Optional<Vaga> buscarPorId(Long id) {
        return vagaRepository.findById(id);
    }

    public Vaga atualizar(Long id, Vaga vagaAtualizada) {
        return vagaRepository.findById(id).map(vaga -> {
            vaga.setTitulo(vagaAtualizada.getTitulo());
            vaga.setDescrição(vagaAtualizada.getDescrição());
            vaga.setSalario(vagaAtualizada.getSalario());
            vaga.setPeriodo(vagaAtualizada.getPeriodo());
            vaga.setLocal(vagaAtualizada.getLocal());
            vaga.setQuantidade(vagaAtualizada.getQuantidade());
            vaga.setPais(vagaAtualizada.getPais());
            vaga.setProvincia(vagaAtualizada.getProvincia());
            vaga.setCidade(vagaAtualizada.getCidade());
            vaga.setCargaHoraria(vagaAtualizada.getCargaHoraria());
            return vagaRepository.save(vaga);
        }).orElseThrow(() -> new RuntimeException("Vaga não encontrada"));
    }

    public void deletar(Long id) {
        vagaRepository.deleteById(id);
    }
}
