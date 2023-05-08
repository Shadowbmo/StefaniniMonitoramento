package com.stefanini.stfinancial.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Embeddable
public class ProfissionalId implements Serializable {

    private static final long serialVersionUID = 6017547239678754027L;

    @Column(name = "matricula")
    private Long matricula;
    @Column(name = "mesComp")
    private LocalDate horasMes;

}
