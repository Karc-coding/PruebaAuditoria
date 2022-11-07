package com.example.auditoria.configuration;

import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.AuditorAware;

import org.springframework.http.HttpHeaders;
import org.springframework.web.server.ServerWebExchange;
import java.util.Optional;

//@Log4j2
public class AuditorAwareImpl implements AuditorAware<String> {

//    private ServerWebExchange exchange;

//    @Override
//    public Optional<String> getCurrentAuditor() {
//        log.info("Log!!!");
//        String tokenHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
//        String [] chunks = tokenHeader.split(" ");
//        String user = chunks[1];
//        log.info("Log2!!!");
//        return Optional.ofNullable(user);
//    }


    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.empty();
    }
}
