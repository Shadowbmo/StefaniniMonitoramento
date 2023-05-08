package com.stefanini.stfinancial.model;

import lombok.*;
import org.hibernate.annotations.Columns;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Embeddable
public class AlocacaoProfissionaisId implements Serializable {

    @Column(name = "IdContrato")
    private Long contrato;
    @Columns(columns = {@Column(name = "mesComp"),@Column(name = "matricula")})
    private ProfissionalId profissional;

}
