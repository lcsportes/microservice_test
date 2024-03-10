package com.example.recommendations.domain.service;

import com.example.recommendations.domain.model.Recomendacao;
import com.example.recommendations.domain.repository.RecomendacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecomendacaoService {

    private final RecomendacaoRepository recomendacaoRepository;

    public RecomendacaoService(RecomendacaoRepository recomendacaoRepository) {
        this.recomendacaoRepository = recomendacaoRepository;
    }

    public List<Recomendacao> listarTodasRecomendacoes() {
        return recomendacaoRepository.findAll();
    }

    public Recomendacao buscarRecomendacaoPorId(Long id) {
        return recomendacaoRepository.findById(id).orElse(null);
    }

    public Recomendacao salvarRecomendacao(Recomendacao recomendacao) {
        // Aqui poderiam ser adicionadas lógicas adicionais antes de salvar a recomendação
        return recomendacaoRepository.save(recomendacao);
    }

    public void deletarRecomendacao(Long id) {
        // Aqui poderiam ser adicionadas lógicas adicionais antes de deletar a recomendação
        recomendacaoRepository.deleteById(id);
    }
}
