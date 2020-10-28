package com.indeas.brewer.controller;

import com.indeas.brewer.dto.FotoDTO;
import com.indeas.brewer.storage.FotoStorage;
import com.indeas.brewer.storage.FotoStorageRunnable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/fotos")
public class FotosController {

	@Autowired
	private FotoStorage fotoStorage;

	@PostMapping
	public DeferredResult<FotoDTO> upload(@RequestParam("files[]") MultipartFile[] files) {
		DeferredResult<FotoDTO> resultado = new DeferredResult<>();
		Thread thread = new Thread(new FotoStorageRunnable(files, resultado, fotoStorage));
		thread.start();
		return resultado;
	}

	@GetMapping("/temp/{nome:.*}")
	public byte[] recuperarFotoTemporaria(@PathVariable String nome) {
		return fotoStorage.recuperarFotoTemporaria(nome);
	}

	@GetMapping("/{nome:.*}")
	public byte[] recuperar(@PathVariable String nome) {
		return fotoStorage.recuperar(nome);
	}

}