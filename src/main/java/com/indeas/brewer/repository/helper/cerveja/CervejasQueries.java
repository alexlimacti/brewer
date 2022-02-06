package com.indeas.brewer.repository.helper.cerveja;

import com.indeas.brewer.dto.CervejaDTO;
import com.indeas.brewer.model.Cerveja;
import com.indeas.brewer.repository.filter.CervejaFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CervejasQueries {

	public Page<Cerveja> filtrar(CervejaFilter filtro, Pageable pageable);

	public List<CervejaDTO> porSkuOuNome(String skuOuNome);
	
}
