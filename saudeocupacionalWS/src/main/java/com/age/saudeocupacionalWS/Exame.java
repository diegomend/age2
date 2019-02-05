package com.age.saudeocupacionalWS;

import java.io.Serializable;
import java.util.Date;

public class Exame implements Serializable {
	private static final long serialVersionUID = -5577579081118070434L;
	private String tipoExame;
	private Funcionario funcionario;
	private Date dataExame;
	private String parecerMedico;
	private Date dataEmissaoAso;
	
	public String getTipoExame() {
		return tipoExame;
	}
	public void setTipoExame(String tipoExame) {
		this.tipoExame = tipoExame;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public Date getDataExame() {
		return dataExame;
	}
	public void setDataExame(Date dataExame) {
		this.dataExame = dataExame;
	}
	public String getParecerMedico() {
		return parecerMedico;
	}
	public void setParecerMedico(String parecerMedico) {
		this.parecerMedico = parecerMedico;
	}
	public Date getDataEmissaoAso() {
		return dataEmissaoAso;
	}
	public void setDataEmissaoAso(Date dataEmissaoAso) {
		this.dataEmissaoAso = dataEmissaoAso;
	}
	@Override
	public String toString(){
		return tipoExame+"::"+funcionario.getNome()+"::"+dataExame+"::"+parecerMedico;
	}
}
