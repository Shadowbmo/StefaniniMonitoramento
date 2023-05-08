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
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Patrimonio implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatrimonio;
    @Column (name = "codigo_do_patrimonio")
    private String codigoDoPatrimonio;
    @Column (name = "descricao_patrimonio")
    private String descricaoPatrimonio;
    @Column(name = "quantidade_de_vezes_utilizado")
    private Integer quantidadeDeVezesUtilizado;
    @Column(name = "dias_utilizado")
    private Integer diasUtilizado;
    @Column (name = "data_de_compra")
    private Date dataDeCompra;
    @Column (name = "valor")
    private Double valor;
    @Column (name = "vida_util_estimada")
    private Date vidaUtilEstimada;
    @Column (name = "disponivel")
    private Boolean disponivel;
    @Column(name = "descartado")
    private Boolean descartado;
    @Column(name = "validade_do_seguro")
    private Date validadeDoSeguro;
    @OneToMany
    @JsonIgnore
    private List<Controle> controles;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "controle",
//            joinColumns = {
//                    @JoinColumn(name = "idPatrimonio", referencedColumnName = "idPatrimonio")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "mesComp", referencedColumnName = "mesComp"),
//                    @JoinColumn(name = "matricula", referencedColumnName = "matricula")
//            }
//    )
//    private List<Profissional> profissional;



    public String getFormatedDate(Date date){
        return new SimpleDateFormat("yyyy-MM").format(date);
    }

    public String getFrontFormatedDate(Date date) {
        return new SimpleDateFormat("MM/yyyy").format(date);
    }

    public void setIdPatrimonio() {
    }
}
