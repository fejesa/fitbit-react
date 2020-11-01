package io.myhealth.fitbit.dao;

import com.fitbit.api.heart.ActivitiesHeartList;
import com.fitbit.api.heart.ActivitiesIntradayHeartList;
import io.myhealth.fitbit.api.FitbitException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.lang.invoke.MethodHandles;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class FitbitMeasurementDao implements MeasurementDao {

    private final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final WebClient webClient;

    private final TokenDao tokenDao;

    public FitbitMeasurementDao(@Value("${myhealth.fitbit.baseUri}") String uri, TokenDao tokenDao) {
        this.tokenDao = tokenDao;
        this.webClient = WebClient.create(uri);
    }

    private Mono<ActivitiesHeartList> getActivitiesHeartList(FitbitHeartListRequest request) {
        return tokenDao.getAccessToken()
            .flatMap(rt -> webClient
                .get()
                .uri(buildHeartListUri(request))
                .headers(h -> h.setBearerAuth(rt))
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, response -> Mono.error(new FitbitException("Client error during heart list fetch")))
                .onStatus(HttpStatus::is5xxServerError, response -> Mono.error(new FitbitException("Fitbit server error during heart list fetch")))
                .bodyToMono(ActivitiesHeartList.class)
                .doOnSuccess(t -> log.info("Activities heart list fetched from {} to {}", request.getFrom(), request.getTo()))
                .doOnError(e -> log.error("Error during the heart list fetch", e)));
    }

    private Mono<ActivitiesIntradayHeartList> getActivitiesIntradayHeartRate(FitbitHeartRateRequest request) {
        return tokenDao.getAccessToken()
                .flatMap(rt -> webClient
                        .get()
                        .uri(buildIntradayHeartRateUri(request))
                        .headers(h -> h.setBearerAuth(rt))
                        .retrieve()
                        .onStatus(HttpStatus::is4xxClientError, response -> Mono.error(new FitbitException("Client error during intraday heart rate fetch")))
                        .onStatus(HttpStatus::is5xxServerError, response -> Mono.error(new FitbitException("Fitbit server error during intraday heart rate fetch")))
                        .bodyToMono(ActivitiesIntradayHeartList.class)
                        .doOnSuccess(t -> log.info("Activities intraday heart list fetched at date {}", request.getDate()))
                        .doOnError(e -> log.error("Error during the heart list fetch", e)));
    }

    private String buildHeartListUri(FitbitHeartListRequest request) {
        return "/user/-/activities/heart/date/" +
                formatDate(request.getFrom()) +
                "/" +
                formatDate(request.getTo()) +
                ".json";
    }

    private String buildIntradayHeartRateUri(FitbitHeartRateRequest request) {
        return "/user/-/activities/heart/date/" + formatDate(request.getDate()) +
                "/1d/" +
                request.getDetailLevel() +
                "/time/" +
                formatTime(request.getStartTime()) +
                "/" +
                formatTime(request.getEndTime()) +
                ".json";
    }

    private String formatTime(LocalTime time) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        return time.format(dtf);
    }

    private String formatDate(LocalDate date) {return date.format(DateTimeFormatter.ISO_DATE); }
}
