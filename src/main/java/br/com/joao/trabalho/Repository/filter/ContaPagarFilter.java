package br.com.joao.trabalho.Repository.filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class ContaPagarFilter {

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate data;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate datavencimento;
    private BigDecimal valor;

    private String nomecliente;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDate getDatavencimento() {
        return datavencimento;
    }

    public void setDatavencimento(LocalDate datavencimento) {
        this.datavencimento = datavencimento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

}
