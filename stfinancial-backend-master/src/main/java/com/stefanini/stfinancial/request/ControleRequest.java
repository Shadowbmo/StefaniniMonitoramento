package com.stefanini.stfinancial.request;

import com.stefanini.stfinancial.model.Patrimonio;
import com.stefanini.stfinancial.model.Profissional;
import com.stefanini.stfinancial.model.ProfissionalId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ControleRequest implements Serializable {
    private Long idControle;
    private Long fkPatrimonio;
    private Date mesComp;
    private Long matricula;
    private String codigoDoControle;
    private Date dataDaManutencao;
    private Date dataDeDevolucaoDoPatrimonio;
    private Date dataDeEntregaDoPatrimonio;
    private String descricaoControle;
    private Boolean devolvido;
    private String diasUtilizado;
    private ProfissionalId idProfissional;
    private String motivoDaDevolucao;
    private String observacoes;
    private String profissionalDaManutencao;
    private String status;
    private String tipoDeManutencao;
    private Long idPatrimonio;
    private Profissional profissional;
    private Boolean contratoAtivo = true;
    private Patrimonio patrimonio;

}
