package net.texsoftware.adservelibrary.ads.video;

import android.app.Activity;

import net.texsoftware.adservelibrary.data.VideoInterstitialAdNetwork;

/**
 * Created by Jibola on 11/16/2016.
 */

public class VideoInterstitialFlurry extends VideoInterstitialAd implements  com.flurry.android.ads.FlurryAdInterstitialListener {
    private  com.flurry.android.ads.FlurryAdInterstitial mFlurryAdInterstitial = null;

    public VideoInterstitialFlurry(Activity activity, VideoInterstitialAdNetwork videoInterstitialAdNetwork) {
        this.adNetwork = videoInterstitialAdNetwork;
    }

    public void initInterstitial(Activity activity) {
        mFlurryAdInterstitial = new  com.flurry.android.ads.FlurryAdInterstitial(activity, adNetwork.getAd_unit_id());
        mFlurryAdInterstitial.setListener(this);
        mFlurryAdInterstitial.fetchAd();
    }

    public void showInterstitial() {
        super.showInterstitial();

        if (mFlurryAdInterstitial != null && mFlurryAdInterstitial.isReady())
            mFlurryAdInterstitial.displayAd();
    }

    public void loadInterstitial() {
        if (mFlurryAdInterstitial != null)
            mFlurryAdInterstitial.fetchAd();
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {
        if (mFlurryAdInterstitial != null) {
            mFlurryAdInterstitial.destroy();
        }
    }

    @Override
    public void onFetched(com.flurry.android.ads.FlurryAdInterstitial flurryAdInterstitial) {
        super.onRequestSuccess();
        isLoaded = true;
    }

    @Override
    public void onRendered( com.flurry.android.ads.FlurryAdInterstitial flurryAdInterstitial) {
        super.onStarted();
    }

    @Override
    public void onDisplay(com.flurry.android.ads.FlurryAdInterstitial flurryAdInterstitial) {
        super.onImpressionLogged();
    }

    @Override
    public void onClose(com.flurry.android.ads.FlurryAdInterstitial flurryAdInterstitial) {

    }

    @Override
    public void onAppExit(com.flurry.android.ads.FlurryAdInterstitial flurryAdInterstitial) {

    }

    @Override
    public void onClicked(com.flurry.android.ads.FlurryAdInterstitial flurryAdInterstitial) {
        super.onClick();
    }

    @Override
    public void onVideoCompleted(com.flurry.android.ads.FlurryAdInterstitial flurryAdInterstitial) {
        super.onCompleted();
    }

    @Override
    public void onError(com.flurry.android.ads.FlurryAdInterstitial flurryAdInterstitial, com.flurry.android.ads.FlurryAdErrorType flurryAdErrorType, int i) {
        super.onRequestFailed();
        isLoaded = false;
    }
}
