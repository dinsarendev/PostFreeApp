package com.dinsarenkh.postfreeapp.presenters;

import com.dinsarenkh.postfreeapp.api.APIClient;
import com.dinsarenkh.postfreeapp.api.ApiInterface;
import com.dinsarenkh.postfreeapp.models.request.RegiserRequest;
import com.dinsarenkh.postfreeapp.models.response.BaseResponse;
import com.dinsarenkh.postfreeapp.views.RegisterView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter {
    private RegisterView view;
    private ApiInterface apiInterface;

    public RegisterPresenter(RegisterView view){
        this.view = view;
        apiInterface = APIClient.getClient().create(ApiInterface.class);
    }

    public void register(RegiserRequest req){
        view.onLoading();
        apiInterface.registerUser(req).enqueue(new Callback<BaseResponse<String>>() {
            @Override
            public void onResponse(Call<BaseResponse<String>> call, Response<BaseResponse<String>> response) {
                view.onHidingLoading();
                if(response.isSuccessful()){
                    view.onSuccess(response.body());
                }else{
                    view.onError("Invalid input ");
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<String>> call, Throwable throwable) {
                view.onHidingLoading();
                view.onError("Internal server error");
            }
        });
    }
}
