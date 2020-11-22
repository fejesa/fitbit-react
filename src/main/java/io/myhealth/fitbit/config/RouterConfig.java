package io.myhealth.fitbit.config;

import io.myhealth.fitbit.service.FitbitHeartService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {

    @Bean
    RouterFunction<ServerResponse> routes(FitbitHeartService heartHandler) {
        return route()
                .GET("/activities", heartHandler::getUserActivities)
                .GET("/detailed-activities", heartHandler::getUserIntradayActivities)
                .build();
    }
}
