package com.example.recommendations.application.dto;

public class RecomendacaoDTO {
    private Long id;
    private String servicoRecomendado;
    private String criterios;
    private String feedback;

    // Construtor, Getters e Setters

    public RecomendacaoDTO(Long id, String servicoRecomendado, String criterios, String feedback) {
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

    public void s

    ////

    package com.example.recommendations.application.dto;

public class RecomendacaoDTO {
    private Long id;
    private String servicoRecomendado;
    private String criterios;
    private String feedback;

    public RecomendacaoDTO(Long id, String servicoRecomendado, String criterios, String feedback) {
        this.id = id;
        this.servicoRecomendado = servicoRecomendado;
        this.criterios = criterios;
        this.feedback = feedback;
    }

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
