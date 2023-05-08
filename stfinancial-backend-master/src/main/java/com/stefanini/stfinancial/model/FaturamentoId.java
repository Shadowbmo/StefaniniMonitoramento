package com.stefanini.stfinancial.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Embeddable
public class FaturamentoId implements Serializable {

    @Column(name = "idContrato")
    private Long contrato;
    @Column(name = "mesComp")
    private LocalDate horasMes;
}
