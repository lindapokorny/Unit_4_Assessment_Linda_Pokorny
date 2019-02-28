package com.pursuit.unit_04_assessment.network;

import com.pursuit.unit_04_assessment.model.EchinodermsList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EchinodermService {
    @GET("JDVila/storybook/master/echinoderms.json")
    Call<EchinodermsList> getEchinoderm();
}
