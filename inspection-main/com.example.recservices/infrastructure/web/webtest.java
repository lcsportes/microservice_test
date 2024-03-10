package com.example.recommendations.infrastructure.web;

import com.example.recommendations.application.dto.RecomendacaoDTO;
import com.example.recommendations.application.service.RecomendacaoAppService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recomendacoes")
public class RecomendacaoController {

    private final RecomendacaoAppService recomendacaoAppService;

    public RecomendacaoController(RecomendacaoAppService recomendacaoAppService) {
        this.recomendacaoAppService = recomendacaoAppService;
    }

    @GetMapping
    public ResponseEntity<List<RecomendacaoDTO>> listarTodasRecomendacoes() {
        List<RecomendacaoDTO> recomendacoes = recomendacaoAppService.listarTodasRecomendacoes();
        return ResponseEntity.ok(recomendacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecomendacaoDTO> buscarRecomendacaoPorId(@PathVariable Long id) {
        RecomendacaoDTO recomendacao = recomendacaoAppService.buscarRecomendacaoPorId(id);
        if (recomendacao != null) {
            return ResponseEntity.ok(recomendacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<RecomendacaoDTO> salvarRecomendacao(@RequestBody RecomendacaoDTO recomendacaoDTO) {
        RecomendacaoDTO savedRecomendacao = recomendacaoAppService.salvarRecomendacao(recomendacaoDTO);
        return new ResponseEntity<>(savedRecomendacao, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRecomendacao(@PathVariable Long id) {
        recomendacaoAppService.deletarRecomendacao(id);
        return ResponseEntity.noContent().build();
    }
}


///

package com.example.recommendations.infrastructure.web;

import com.example.recommendations.application.dto.ProdutoDTO;
import com.example.recommendations.application.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarProdutos() {
        List<ProdutoDTO> produtos = produtoService.listarProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> buscarProdutoPorId(@PathVariable Long id) {
        ProdutoDTO produto = produtoService.buscarProdutoPorId(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> salvarProduto(@RequestBody ProdutoDTO produtoDTO) {
        ProdutoDTO produtoSalvo = produtoService.salvarProduto(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
