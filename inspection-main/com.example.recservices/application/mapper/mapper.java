package com.example.recommendations.application.mapper;

import com.example.recommendations.application.dto.RecomendacaoDTO;
import com.example.recommendations.domain.model.Recomendacao;
import org.springframework.stereotype.Component;

@Component
public class RecomendacaoMapper {

    public RecomendacaoDTO toDTO(Recomendacao recomendacao) {
        return new RecomendacaoDTO(
                recomendacao.getId(),
                recomendacao.getServicoRecomendado(),
                recomendacao.getDetalhes().getCriterios(),
                recomendacao.getDetalhes().getFeedback()
        );
    }

    public Recomendacao toEntity(RecomendacaoDTO recomendacaoDTO) {
        Recomendacao recomendacao = new Recomendacao();
        recomendacao.setId(recomendacaoDTO.getId());
        recomendacao.setServicoRecomendado(recomendacaoDTO.getServicoRecomendado());

        // Preencher os detalhes da recomendação, se necessário

        return recomendacao;
    }
}

///

package com.example.recommendations.application.mapper;

import com.example.recommendations.application.dto.RecomendacaoDTO;
import com.example.recommendations.domain.model.Recomendacao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecomendacaoMapper {

    RecomendacaoMapper INSTANCE = Mappers.getMapper(RecomendacaoMapper.class);

    @Mapping(target = "id", ignore = true) // Ignorar o mapeamento do id, pois será gerado automaticamente
    Recomendacao toEntity(RecomendacaoDTO recomendacaoDTO);

    RecomendacaoDTO toDTO(Recomendacao recomendacao);
}


////


package com.example.recommendations.application.service;

import com.example.recommendations.domain.model.Produto;
import com.example.recommendations.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
    }

    public Produto salvarProduto(Produto produto) {
        // Aqui você pode adicionar lógica de validação ou processamento adicional antes de salvar o produto
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}


//


// Em seu ProdutoService.java
@Autowired
public ProdutoService(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
    this.produtoRepository = produtoRepository;
    this.produtoMapper = produtoMapper;
}


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProdutoServiceTest {

    @Autowired
    private ProdutoService produtoService;

    // Aqui você deve implementar os testes para os métodos do serviço
    // Exemplo de teste:
    @Test
    public void testListarProdutos() {
        // Implemente o teste aqui
    }
}
