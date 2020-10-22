package com.indeas.brewer.thymeleaf;

import com.indeas.brewer.thymeleaf.processor.ClassForErrorAttributeTagProcessor;
import com.indeas.brewer.thymeleaf.processor.MessageElementTagProcessor;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import java.util.HashSet;
import java.util.Set;

public class BrewerDialect extends AbstractProcessorDialect {

    public BrewerDialect() {
        super("indeas Brewer", "brewer", StandardDialect.PROCESSOR_PRECEDENCE);
    }

    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix) {
        final Set<IProcessor> processadores = new HashSet<>();
        processadores.add(new ClassForErrorAttributeTagProcessor(dialectPrefix));
        processadores.add(new MessageElementTagProcessor(dialectPrefix));
        return processadores;
    }
}
