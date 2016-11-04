package com.gaguena.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
/**
 * Classe base para atributos defaults.
 * @author gaguena
 *
 */
public abstract class BaseEntity implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar register;
	
	@Version
	private int version;

	public Calendar getRegister() {
		return register;
	}

	public void setRegister(Calendar register) {
		this.register = register;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
}
