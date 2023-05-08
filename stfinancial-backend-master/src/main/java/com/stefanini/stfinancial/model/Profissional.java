package com.stefanini.stfinancial.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@IdClass(ProfissionalId.class)
public class Profissional implements Serializable {

    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @EmbeddedId
    private ProfissionalId idProfissional;
    @MapsId("horasMes")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mesComp")
    private HorasMes horasMes;
    @Column
    @NotNull
    private String nomeProfissional;
    @Column
    @NotNull
    private Date dataAdmissao;
    @Column
    @NotNull
    private BigDecimal salario;
    @Column
    @NotNull
    private BigDecimal encargos;
    @Column
    @NotNull
    private BigDecimal beneficioComplementar;
    @Column
    @NotNull
    private BigDecimal beneficioEmpresa;
    @Column
    @NotNull
    private BigDecimal custoEquipamento;
    @Column
    private BigDecimal custoLicencas;
    @Column
    @NotNull
    private BigDecimal custoPessoal;
    @Column
    @NotNull
    private Double custoEfetivoTotalHora;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idOperacaoPadrao", referencedColumnName = "idOperacao")
    private Operacao operacaoPadrao;

    @OneToMany
    @JsonIgnore
    private List<Controle> controles;
//    @ManyToMany
//    @JoinTable(
//            name = "controle",
//            joinColumns = {
//                    @JoinColumn(name = "mesComp", referencedColumnName = "mesComp"),
//                    @JoinColumn(name = "matricula", referencedColumnName = "matricula")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "idPatrimonio", referencedColumnName = "idPatrimonio")
//            }
//    )
//    private List<Patrimonio> patrimonios;

    public String getFormatedDate(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public String getFrontFormatedDate() {
        return new SimpleDateFormat("dd/MM/yyyy").format(dataAdmissao);
    }

    public String getFrontFormatedCurrency(BigDecimal value) {
        return "R$" + String.format("%,.2f", value);
    }

}
