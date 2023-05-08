package com.stefanini.stfinancial.model;

import java.io.Serializable;
import java.time.LocalDate;
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
public class HorasMes implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long idHorasMes;
//	@Column(unique = true)
//	@NotNull
	private LocalDate mesComp;
	@Column
	@NotNull
	private Integer horasUtilMes;
	
	@OneToMany(fetch = FetchType.EAGER , mappedBy = "horasMes")
	@JsonIgnore
	private List<Profissional> profissionais;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "horasMes")
	@JsonIgnore
	private List<Faturamento> faturamentos;

	public Integer getProfissionaisLength(){
		if(this.profissionais != null) return this.profissionais.size();
		return null;
	}
}
