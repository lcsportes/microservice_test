package com.example.recommendations.application.service;

import com.example.recommendations.application.dto.RecomendacaoDTO;
import com.example.recommendations.application.mapper.RecomendacaoMapper;
import com.example.recommendations.domain.model.Recomendacao;
import com.example.recommendations.domain.service.RecomendacaoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecomendacaoAppService {

    private final RecomendacaoService recomendacaoService;
    private final RecomendacaoMapper recomendacaoMapper;

    public RecomendacaoAppService(RecomendacaoService recomendacaoService, RecomendacaoMapper recomendacaoMapper) {
        this.recomendacaoService = recomendacaoService;
        this.recomendacaoMapper = recomendacaoMapper;
    }

    public List<RecomendacaoDTO> listarTodasRecomendacoes() {
        List<Recomendacao> recomendacoes = recomendacaoService.listarTodasRecomendacoes();
        return recomendacoes.stream()
                .map(recomendacaoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RecomendacaoDTO buscarRecomendacaoPorId(Long id) {
        Recomendacao recomendacao = recomendacaoService.buscarRecomendacaoPorId(id);
        return recomendacaoMapper.toDTO(recomendacao);
    }

    public RecomendacaoDTO salvarRecomendacao(RecomendacaoDTO recomendacaoDTO) {
        Recomendacao recomendacao = recomendacaoMapper.toEntity(recomendacaoDTO);
        Recomendacao savedRecomendacao = recomendacaoService.salvarRecomendacao(recomendacao);
        return recomendacaoMapper.toDTO(savedRecomendacao);
    }

    public void deletarRecomendacao(Long id) {
        recomendacaoService.deletarRecomendacao(id);
    }
}
