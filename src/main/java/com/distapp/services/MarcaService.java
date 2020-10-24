package com.distapp.services;

import com.distapp.model.Marca;

public interface MarcaService extends BaseServices<Marca> {
	//aqui solo se declaran los metodos, NO se hace la "programacion" de ninguno de ellos.
	//En este caso, esta interface "hereda" de "BaseServices".
	
	//esta interface ya posee los metodos generales que estan en BaseService(crear,actulizar,...)
	//si se quieren agregar mas metodos se deben agregar aqui.
	
	Marca findById(long id);
}
