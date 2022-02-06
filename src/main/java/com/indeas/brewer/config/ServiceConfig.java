package com.indeas.brewer.config;

import com.indeas.brewer.service.CadastroCervejaService;
import com.indeas.brewer.storage.FotoStorage;
import com.indeas.brewer.storage.local.FotoStorageLocal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = CadastroCervejaService.class)
public class ServiceConfig {

    @Bean
    public FotoStorage fotoStorage() {
        return new FotoStorageLocal();
    }

}
