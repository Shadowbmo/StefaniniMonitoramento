package com.stefanini.stfinancial.request;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HorasMesSaveRequest implements Serializable{
	
	private static final long serialVersionUID = 6017547239678754027L;
	
	private Long idHorasMes;
	private LocalDate mesComp;
	private Integer horasUtilMes;
	
}
