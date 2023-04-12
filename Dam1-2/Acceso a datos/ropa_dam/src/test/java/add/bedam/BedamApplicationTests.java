package add.bedam;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import add.bedam.dto.CompraDto;
import add.bedam.dto.PrendaDTOsinLista;
import add.bedam.entidades.Categoria;
import add.bedam.repositorios.CategoriaRepository;
import add.bedam.repositorios.PrendaRepository;
import add.bedam.servicios.PrendaService;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Execution(ExecutionMode.SAME_THREAD)
class BedamApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private PrendaRepository prendaRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private PrendaService prendaService;

	private Long ID_PRENDA_CREADA = 24L;

	@Test
	@Order(1)
	public void testObtenerPrenda() throws IOException, URISyntaxException, InterruptedException {
		// Given
		PrendaDTOsinLista prenda = new PrendaDTOsinLista();
		prenda.setIdPrenda(1L);
		prenda.setNombre("Camisa Azul");
		prenda.setDescripcion("Camisa formal de manga larga para hombres");
		prenda.setPrecio(50.99f);
		prenda.setIdCategoria(1L);

		// When
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(new URI("http://localhost:9090/prenda/" + prenda.getIdPrenda())).build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		// Then
		assertEquals(HttpStatus.OK.value(), response.statusCode());

		ObjectMapper objectMapper = new ObjectMapper();
		PrendaDTOsinLista prendaDTO = objectMapper.readValue(response.body(), PrendaDTOsinLista.class);

		assertEquals(prenda.getIdPrenda(), prendaDTO.getIdPrenda());
		assertEquals(prenda.getNombre(), prendaDTO.getNombre());
		assertEquals(prenda.getDescripcion(), prendaDTO.getDescripcion());
		assertEquals(prenda.getPrecio(), prendaDTO.getPrecio());
		assertEquals(prenda.getIdCategoria(), prendaDTO.getIdCategoria());
	}

	@Test
	@Order(2)
	public void obtenerPrendasPaginadasTest_2priemras() {
		String url = "http://localhost:9090/prenda/lista?index=0&count=2";

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<PrendaDTOsinLista>> response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<PrendaDTOsinLista>>() {
				});

		List<PrendaDTOsinLista> prendas = response.getBody();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(2, prendas.size());

		// Comprobar que las prendas obtenidas son las esperadas
		assertEquals(1, prendas.get(0).getIdPrenda());
		assertEquals("Camisa Azul", prendas.get(0).getNombre());
		assertEquals("Camisa formal de manga larga para hombres", prendas.get(0).getDescripcion());
		assertEquals(50.99, prendas.get(0).getPrecio(), 0.001);
		assertEquals(1, prendas.get(0).getIdCategoria());

		assertEquals(2, prendas.get(1).getIdPrenda());
		assertEquals("Camisa Blanca", prendas.get(1).getNombre());
		assertEquals("Camisa informal de manga corta para hombres", prendas.get(1).getDescripcion());
		assertEquals(29.99, prendas.get(1).getPrecio(), 0.001);
		assertEquals(1, prendas.get(1).getIdCategoria());
	}

	@Test
	@Order(3)
	public void obtenerPrendasPaginadasTest_2segunas() {
		String url = "http://localhost:9090/prenda/lista?index=1&count=2";

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<PrendaDTOsinLista>> response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<PrendaDTOsinLista>>() {
				});

		List<PrendaDTOsinLista> prendas = response.getBody();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(2, prendas.size());

		// Comprobar que las prendas obtenidas son las esperadas
		assertEquals(3, prendas.get(0).getIdPrenda());
		assertEquals("Pantalón Negro", prendas.get(0).getNombre());
		assertEquals("Pantalón de vestir para hombres", prendas.get(0).getDescripcion());
		assertEquals(69.99, prendas.get(0).getPrecio(), 0.001);
		assertEquals(2, prendas.get(0).getIdCategoria());

		assertEquals(4, prendas.get(1).getIdPrenda());
		assertEquals("Jeans Azul", prendas.get(1).getNombre());
		assertEquals("Pantalón casual para hombres", prendas.get(1).getDescripcion());
		assertEquals(39.99, prendas.get(1).getPrecio(), 0.001);
		assertEquals(2, prendas.get(1).getIdCategoria());
	}

	@Test
	@Order(4)
	public void testCrearPrenda() throws IOException, URISyntaxException, InterruptedException {
		// Given
		PrendaDTOsinLista prendaDTO = new PrendaDTOsinLista();
		prendaDTO.setNombre("Camisa Blanca");
		prendaDTO.setDescripcion("Camisa formal de manga larga para hombres");
		prendaDTO.setPrecio(39.99f);
		prendaDTO.setIdCategoria(1L);

		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = objectMapper.writeValueAsString(prendaDTO);

		// When
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(new URI("http://localhost:9090/prenda/crear"))
				.header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(requestBody))
				.build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		// Then
		assertEquals(HttpStatus.OK.value(), response.statusCode());

		PrendaDTOsinLista createdPrendaDTO = objectMapper.readValue(response.body(), PrendaDTOsinLista.class);
		assertNotNull(createdPrendaDTO.getIdPrenda());

		ID_PRENDA_CREADA = createdPrendaDTO.getIdPrenda();

		assertEquals(prendaDTO.getNombre(), createdPrendaDTO.getNombre());
		assertEquals(prendaDTO.getDescripcion(), createdPrendaDTO.getDescripcion());
		assertEquals(prendaDTO.getPrecio(), createdPrendaDTO.getPrecio());
		assertEquals(prendaDTO.getIdCategoria(), createdPrendaDTO.getIdCategoria());
	}

	@Test
	@Order(5)
	public void editarPrendaTest() {
		int ID_PRENDA_EXISTENTE = 1;
		String url = "http://localhost:9090/prenda/" + ID_PRENDA_CREADA;

		// Preparar la nueva información de la prenda
		PrendaDTOsinLista editarPrenda = new PrendaDTOsinLista();
		editarPrenda.setNombre("Nueva Camisa Roja");
		editarPrenda.setDescripcion("Camisa informal de manga corta para hombres");
		editarPrenda.setPrecio(39.99f);
		editarPrenda.setIdCategoria(1L);
		editarPrenda.setIdPrenda(ID_PRENDA_CREADA);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<PrendaDTOsinLista> request = new HttpEntity<>(editarPrenda, headers);
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<PrendaDTOsinLista> response = restTemplate.exchange(url, HttpMethod.PUT, request,
				PrendaDTOsinLista.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());

		PrendaDTOsinLista prendaActualizada = response.getBody();

		assertEquals(ID_PRENDA_CREADA, prendaActualizada.getIdPrenda());
		assertEquals(editarPrenda.getNombre(), prendaActualizada.getNombre());
		assertEquals(editarPrenda.getDescripcion(), prendaActualizada.getDescripcion());
		assertEquals(editarPrenda.getPrecio(), prendaActualizada.getPrecio(), 0.001);
		assertEquals(editarPrenda.getIdCategoria(), prendaActualizada.getIdCategoria());

	}

	@Test
	@Order(6)
	public void testObtenerPrendaModificada() throws IOException, URISyntaxException, InterruptedException {

		// Given
		PrendaDTOsinLista nuevaPrenda = new PrendaDTOsinLista();
		nuevaPrenda.setNombre("Nueva Camisa Roja");
		nuevaPrenda.setDescripcion("Camisa informal de manga corta para hombres");
		nuevaPrenda.setPrecio(39.99f);
		nuevaPrenda.setIdCategoria(1L);

		// When
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(new URI("http://localhost:9090/prenda/" + ID_PRENDA_CREADA))
				.build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		// Then
		assertEquals(HttpStatus.OK.value(), response.statusCode());

		ObjectMapper objectMapper = new ObjectMapper();
		PrendaDTOsinLista prendaDTO = objectMapper.readValue(response.body(), PrendaDTOsinLista.class);

		assertEquals(ID_PRENDA_CREADA, prendaDTO.getIdPrenda());
		assertEquals(nuevaPrenda.getNombre(), prendaDTO.getNombre());
		assertEquals(nuevaPrenda.getDescripcion(), prendaDTO.getDescripcion());
		assertEquals(nuevaPrenda.getPrecio(), prendaDTO.getPrecio());
		assertEquals(nuevaPrenda.getIdCategoria(), prendaDTO.getIdCategoria());
	}

	@Test
	@Order(8)
	void testCrearCompra() {
	    // Given
	    CompraDto compraDto = new CompraDto();
	    compraDto.setFechaCompra(new Date());
	    compraDto.setPrecioTotal(80.98f);
	    compraDto.setUsuario("Juan Perez");
	    compraDto.setPrendas(Arrays.asList(1L, 2L));
		RestTemplate restTemplate = new RestTemplate();

	    // When
	    ResponseEntity<CompraDto> response = restTemplate.postForEntity("http://localhost:9090/compra/crear", compraDto, CompraDto.class);

	    // Then
	    assertEquals(HttpStatus.OK, response.getStatusCode());
	    assertNotNull(response.getBody());
	    assertNotNull(response.getBody().getIdCompra());
	    assertEquals(compraDto.getUsuario(), response.getBody().getUsuario());
	    assertEquals(compraDto.getPrecioTotal(), response.getBody().getPrecioTotal());
	    assertEquals(compraDto.getPrendas(), response.getBody().getPrendas());
	}

	@Test
	@Order(9)
	public void testBorrarCategoriaExitosa() throws IOException, URISyntaxException, InterruptedException {
	    // Given
	    Long idCategoria = 14L;

	    // When
	    HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(new URI("http://localhost:9090/categoria/" + idCategoria))
	            .DELETE()
	            .build();
	    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

	    // Then
	    assertEquals(HttpStatus.OK.value(), response.statusCode());

	    // Verify that the category was deleted
	    Optional<Categoria> categoriaOptional = categoriaRepository.findById(idCategoria);
	    assertFalse(categoriaOptional.isPresent());
	}

	@Test
	@Order(10)
	public void testBorrarCategoriaNoSeEncuntra() throws IOException, URISyntaxException, InterruptedException {
	    // Given
	    Long idCategoria = 60L;

	    // When
	    HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(new URI("http://localhost:9090/categoria/" + idCategoria))
	            .DELETE()
	            .build();
	    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

	    // Then
	    assertEquals(HttpStatus.NOT_FOUND.value(), response.statusCode());

	    // Verify that the category was deleted
	    Optional<Categoria> categoriaOptional = categoriaRepository.findById(idCategoria);
	    assertFalse(categoriaOptional.isPresent());
	}

	@Test
	@Order(11)
	public void testBorrarCategoriaConflictos() throws IOException, URISyntaxException, InterruptedException {
	    // Given
	    Long idCategoria = 1L;

	    // When
	    HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(new URI("http://localhost:9090/categoria/" + idCategoria))
	            .DELETE()
	            .build();
	    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

	    // Then
	    assertEquals(HttpStatus.CONFLICT.value(), response.statusCode());

	    // Verify that the category was deleted
	    Optional<Categoria> categoriaOptional = categoriaRepository.findById(idCategoria);
	    assertTrue(categoriaOptional.isPresent());
	}
	
	@Test
	@Order(12)
	public void buscarPrendasPaginadasTest_2priemras() {
		String url = "http://localhost:9090/prenda/buscar?cadena=Camisa&index=0&count=2";

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<List<PrendaDTOsinLista>> response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<PrendaDTOsinLista>>() {
				});

		List<PrendaDTOsinLista> prendas = response.getBody();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(2, prendas.size());

		// Comprobar que las prendas obtenidas son las esperadas
		assertEquals(1, prendas.get(0).getIdPrenda());
		assertEquals("Camisa Azul", prendas.get(0).getNombre());
		assertEquals("Camisa formal de manga larga para hombres", prendas.get(0).getDescripcion());
		assertEquals(50.99, prendas.get(0).getPrecio(), 0.001);
		assertEquals(1, prendas.get(0).getIdCategoria());

		assertEquals(2, prendas.get(1).getIdPrenda());
		assertEquals("Camisa Blanca", prendas.get(1).getNombre());
		assertEquals("Camisa informal de manga corta para hombres", prendas.get(1).getDescripcion());
		assertEquals(29.99, prendas.get(1).getPrecio(), 0.001);
		assertEquals(1, prendas.get(1).getIdCategoria());
	}

}
