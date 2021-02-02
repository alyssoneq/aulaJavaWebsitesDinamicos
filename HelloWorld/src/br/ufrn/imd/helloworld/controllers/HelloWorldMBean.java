package br.ufrn.imd.helloworld.controllers;

import javax.annotation.ManagedBean;

// ManagedBean para retornar a frase Hello World!

@ManagedBean
public class HelloWorldMBean {
	public String getWorld() {
		return "Hello World JSF!";
	}
}
