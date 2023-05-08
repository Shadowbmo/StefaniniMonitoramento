package com.stefanini.stfinancial.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ControlePK implements Serializable {
    @Column(name = "idControle")
    private Long idControle;

    @Columns(columns = {@Column(name = "mesComp"),@Column(name = "matricula")})
    private ProfissionalId profissional;

    @MapsId("patrimonio")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPatrimonio")
    private Patrimonio patrimonio;

}