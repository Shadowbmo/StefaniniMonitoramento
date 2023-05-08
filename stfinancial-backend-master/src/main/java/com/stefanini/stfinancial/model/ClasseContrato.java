package com.stefanini.stfinancial.model;

import java.io.Serializable;
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
public class ClasseContrato implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cdClasseContrato;
	@Column
	@NotNull
	private String nomeClasseContrato;
	@Column
	@NotNull
	private String descricaoClasseContrato;
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "classeContrato")
	@JsonIgnore
	private List<Contrato> contratos;
}
