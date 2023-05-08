package com.stefanini.stfinancial.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stefanini.stfinancial.model.Profissional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatrimonioRequest {

    private static final long serialVersionUID = 6017547239678754027L;
    private Long idPatrimonio;
    @NotNull
    @NotBlank
    private String codigoDoPatrimonio;
    @NotNull
    @NotBlank
    private String descricaoPatrimonio;
    @NotNull
    @NotBlank
    private String tipoDoPatrimonio;
    @NotNull
    private Date dataDeCompra;
    @NotNull
    private Double valor;
    private Date vidaUtilEstimada;
    private Boolean disponivel;
    private List<Profissional> profissional;
    @NotNull
    private Integer quantidadeDeVezesUtilizado;
    @NotNull
    private Integer diasUtilizado;
    private Boolean descartado;

    private Date validadeDoSeguro;

}
