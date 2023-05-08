package com.stefanini.stfinancial.dto;

import com.stefanini.stfinancial.model.ControlePK;
import com.stefanini.stfinancial.model.Patrimonio;
import com.stefanini.stfinancial.model.Profissional;
import com.stefanini.stfinancial.model.ProfissionalId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ControleDTO implements Serializable {
    private static final long serialVersionUID = 6017547239678754027L;

    private Long idControle;
    private Long fkPatrimonio;
    private Date mesComp;
    private Long matricula;
    private Date dataDaManutencao;
    private Date dataDeDevolucaoDoPatrimonio;
    private Date dataDeEntregaDoPatrimonio;
    private String descricaoControle;
    private Boolean devolvido;
    private String diasUtilizado;
    private String motivoDaDevolucao;
    private ProfissionalId idProfissional;
    private String observacoes;
    private String profissionalDaManutencao;
    private String status;
    private String tipoDeManutencao;
    private Long idPatrimonio;
    private Profissional profissional;
    private Patrimonio patrimonio;
}