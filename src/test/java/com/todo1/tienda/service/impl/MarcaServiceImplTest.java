package com.todo1.tienda.service.impl;

import static org.junit.Assert.assertTrue;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.todo1.tienda.entity.Marca;
import com.todo1.tienda.repository.MarcaRepository;


@RunWith(MockitoJUnitRunner.class)
class MarcaServiceImplTest {

	@Mock
	MarcaRepository marcaRepository;

	@InjectMocks
	MarcaServiceImpl proceso;

	@BeforeEach
	void setUp() throws Exception {
		initMocks(this);
	}

	@Test
	void testListarDisponibles() {
		Mockito.when(marcaRepository.listByEstado(Mockito.anyInt())).thenReturn(obtenerListaMarcas());
		List<Marca> marcas = proceso.listarDisponibles();
		assertTrue(!marcas.isEmpty());
	}
	
	private List<Marca> obtenerListaMarcas() {
		List<Marca> marcas = new ArrayList<Marca>();
		
		Marca m1 = new Marca();
		m1.setId(new Long(1));
		m1.setNombre("MARVEL");
		m1.setDescripcion("MARVEL");
		m1.setEstado(1);
		marcas.add(m1);
		
		Marca m2 = new Marca();
		m2.setId(new Long(1));
		m2.setNombre("MARVEL");
		m2.setDescripcion("MARVEL");
		m2.setEstado(1);
		marcas.add(m2);

		return marcas;
	}

}
