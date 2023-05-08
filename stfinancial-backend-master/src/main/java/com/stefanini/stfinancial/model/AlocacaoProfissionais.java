package com.stefanini.stfinancial.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AlocacaoProfissionais implements Serializable {
	
	private static final long  serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@EmbeddedId
	private AlocacaoProfissionaisId id;

	@MapsId("contrato")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idContrato")
	private Contrato contrato;

//	@MapsId("profissional")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({
			@JoinColumn(name="mesComp", insertable = false, updatable = false),
			@JoinColumn(name="matricula", insertable = false, updatable = false)
	})
	private Profissional profissional;
	
	@Column
	@NotNull
	private Integer horasAlocacaoPrevista;
	
	@Column
	@NotNull
	private Integer horasAlocacaoRealizada;
	
}
