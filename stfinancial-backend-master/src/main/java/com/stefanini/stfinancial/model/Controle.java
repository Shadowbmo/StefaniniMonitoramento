package com.stefanini.stfinancial.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;

@Entity(name = "controle")
@Table(name = "controle")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Controle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long idControle;
    @Column(name = "codigo_do_controle")
    @NotNull
    private String codigoDoControle;
    @Column(name = "descricao_controle")
    private String descricaoControle;
    @Column(name = "data_de_entrega_do_patrimonio")
    private Date dataDeEntregaDoPatrimonio;
    @Column(name = "data_de_devolucao_do_patrimonio")
    private Date dataDeDevolucaoDoPatrimonio;
    @Column(name = "observacoes")
    private String observacoes;
    @Column(name = "data_da_manutencao")
    private Date dataDaManutencao;
    @Column(name = "tipo_de_manutencao")
    private String tipoDeManutencao;
    @Column(name = "profissional_da_manutencao")
    private String profissionalDaManutencao;
    @Column(name = "dias_utilizado")
    private Integer diasUtilizado;
    @Column(name = "motivo_da_devolucao")
    private String motivoDaDevolucao;
    @Column(name = "devolvido")
    private Boolean devolvido;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "mesComp", insertable = false, updatable = false),
            @JoinColumn(name = "matricula", insertable = false, updatable = false)
    })
    private Profissional profissionalId;
    @Columns(columns = {@Column(name = "mesComp"),@Column(name = "matricula")})
    private ProfissionalId profissional;
    @Column (name = "contrato_ativo")
    private Boolean contratoAtivo;

;    @MapsId("patrimonio")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPatrimonio")
    private Patrimonio patrimonio;

    public String getFormatedDate(Date date) {
        return new SimpleDateFormat("yyyy-MM").format(date);
    }

    public String getFrontFormatedDate(Date date) {
        return new SimpleDateFormat("MM/yyyy").format(date);
    }


}