

// Entidade Recomendação
import java.time.LocalDateTime;

public class Recomendacao {
    private Long id;
    private ServicoRecomendado servicoRecomendado; // ServicoRecomendado é uma referência ao serviço que está sendo recomendado.
    private DetalhesRecomendacao detalhes; // DetalhesRecomendacao encapsula os detalhes específicos da recomendação.
    private LocalDateTime dataHora; ///  LocalDateTime dataHora armazena a data e hora em que a recomendação foi feita.
    
    // Construtor, Getters e Setters
}

// Objeto de Valor: Detalhes da Recomendação
public class DetalhesRecomendacao {
    private Critérios criterios;
    private Feedback feedback;
    
    // Construtor, Getters e Setters
}

// Objeto de Valor: Critérios
public class Critérios {
    private String historicoInteracoes;
    private String preferenciasUsuario;
    private String tendenciasMercado;
    
    // Construtor, Getters e Setters
}

// Objeto de Valor: Feedback
public class Feedback {
    private String comentario;
    private int avaliacao;
    
    // Construtor, Getters e Setters
}

/////

package com.example.recommendations.domain.model;

public class Recomendacao {
    private Long id;
    private String servicoRecomendado;
    private String criterios;
    private String feedback;

    // Construtor, Getters e Setters

    public Recomendacao(Long id, String servicoRecomendado, String criterios, String feedback) {
        this.id = id;
        this.servicoRecomendado = servicoRecomendado;
        this.criterios = criterios;
        this.feedback = feedback;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServicoRecomendado() {
        return servicoRecomendado;
    }

    public void setServicoRecomendado(String servicoRecomendado) {
        this.servicoRecomendado = servicoRecomendado;
    }

    public String getCriterios() {
        return criterios;
    }

    public void setCriterios(String criterios) {
        this.criterios = criterios;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        // Verifica se o feedback está vazio e lança uma exceção
        if (feedback == null || feedback.trim().isEmpty()) {
            throw new IllegalArgumentException("Feedback não pode ser vazio");
        }
        this.feedback = feedback;
    }
}
