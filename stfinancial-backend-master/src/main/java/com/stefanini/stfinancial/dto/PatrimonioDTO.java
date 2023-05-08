package com.stefanini.stfinancial.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stefanini.stfinancial.model.Contrato;
import com.stefanini.stfinancial.model.Profissional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatrimonioDTO implements Serializable {
    private static final long serialVersionUID = 6017547239678754027L;

    private Long idPatrimonio;
    private String codigoDoPatrimonio;
    private String descricaoPatrimonio;
    private String tipoDoPatrimonio;
    private Date dataDeCompra;
    private Double valor;
    private Date vidaUtilEstimada;
    private Boolean disponivel;
    private List<Profissional> profissional;
    private Integer quantidadeDeVezesUtilizado;
    private Integer diasUtilizado;
    private Boolean descartado;
    private Date validadeDoSeguro;

}
