package com.example.recommendations.infrastructure.repository;

import com.example.recommendations.domain.model.Recomendacao;
import com.example.recommendations.domain.repository.RecomendacaoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecomendacaoRepositoryImpl extends JpaRepository<Recomendacao, Long>, RecomendacaoRepository {
    // Aqui você pode adicionar métodos adicionais se necessário
}

///

package com.example.recommendations.infrastructure.repository;

import com.example.recommendations.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Você pode adicionar métodos de consulta personalizados aqui, se necessário
}
