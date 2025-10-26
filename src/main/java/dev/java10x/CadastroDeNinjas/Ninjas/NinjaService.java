package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import dev.java10x.CadastroDeNinjas.Missoes.MissoesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final MissoesRepository missoesRepository;

    public NinjaService(NinjaRepository ninjaRepository, MissoesRepository missoesRepository) {
        this.ninjaRepository = ninjaRepository;
        this.missoesRepository = missoesRepository;
    }

    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    public NinjaModel listarNinjasPorId(Long id) {
        return ninjaRepository.findById(id).orElse(null);
    }

    public NinjaModel criarNinja(NinjaModel ninja) {
        // 🔍 se vier missão no corpo, busca ela no banco
        if (ninja.getMissoes() != null && ninja.getMissoes().getId() != null) {
            MissoesModel missao = missoesRepository.findById(ninja.getMissoes().getId())
                    .orElseThrow(() -> new RuntimeException("Missão não encontrada"));
            ninja.setMissoes(missao);
        }

        return ninjaRepository.save(ninja);
    }

    public void deletarNinjaPorId(Long id) {
        ninjaRepository.deleteById(id);
    }

    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado) {
        if (ninjaRepository.existsById(id)) {
            ninjaAtualizado.setId(id);

            if (ninjaAtualizado.getMissoes() != null && ninjaAtualizado.getMissoes().getId() != null) {
                MissoesModel missao = missoesRepository.findById(ninjaAtualizado.getMissoes().getId())
                        .orElseThrow(() -> new RuntimeException("Missão não encontrada"));
                ninjaAtualizado.setMissoes(missao);
            }

            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }
}
