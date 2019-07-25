package home.telegrambot.beans;

import home.telegrambot.properties.AppProperties;
import home.telegrambot.service.DictionaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DictionaryInitialization {

    public DictionaryInitialization(AppProperties appProperties, DictionaryService dictionaryService) {
        Logger LOGGER = LoggerFactory.getLogger(DictionaryInitialization.class);
        LOGGER.info(new Date() + ": Dictionary initialization start.");

        dictionaryService.initDictionary(appProperties.getBotDictionaryFileName());

        LOGGER.info(new Date() + ": Dictionary initialization end.");

    }

}

