package io.myhealth.fitbit.transform;

import com.fitbit.api.heart.ActivitiesHeart;
import com.fitbit.api.heart.ActivitiesHeartList;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Function;

public class ActivitiesHeartListTransformer implements Function<Mono<ActivitiesHeartList>, Mono<List<ActivitiesHeart>>> {

    @Override
    public Mono<List<ActivitiesHeart>> apply(Mono<ActivitiesHeartList> activitiesHeartList) {
        return activitiesHeartList.map(ActivitiesHeartList::getActivitiesHeart);
    }
}
