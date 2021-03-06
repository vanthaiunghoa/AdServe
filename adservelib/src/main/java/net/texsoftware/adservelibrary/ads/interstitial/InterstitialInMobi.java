package net.texsoftware.adservelibrary.ads.interstitial;

import android.app.Activity;

import net.texsoftware.adservelibrary.data.InterstitialAdNetwork;

import java.util.Map;

/**
 * Created by Jibola on 10/6/2015.
 */
public class InterstitialInMobi extends InterstitialAd implements com.inmobi.ads.InMobiInterstitial.InterstitialAdListener {

    private com.inmobi.ads.InMobiInterstitial inMobiInterstitial = null;

    public InterstitialInMobi(Activity activity, InterstitialAdNetwork interstitialAdNetwork) {
        this.adNetwork = interstitialAdNetwork;
    }

    public void initInterstitial(Activity activity) {
        inMobiInterstitial = new com.inmobi.ads.InMobiInterstitial(activity, Long.parseLong(adNetwork.getAd_unit_id()), this);
        inMobiInterstitial.load();
    }

    public void showInterstitial() {
        super.showInterstitial();

        if (inMobiInterstitial != null && inMobiInterstitial.isReady())
            inMobiInterstitial.show();
    }

    public void loadInterstitial() {
        if (inMobiInterstitial != null)
            inMobiInterstitial.load();
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {
        if (inMobiInterstitial != null) {
        }
    }

    @Override
    public void onAdRewardActionCompleted(com.inmobi.ads.InMobiInterstitial inMobiInterstitial, Map<Object, Object> map) {

    }

    @Override
    public void onAdDisplayed(com.inmobi.ads.InMobiInterstitial inMobiInterstitial) {
        super.onImpressionLogged();
    }

    @Override
    public void onAdDismissed(com.inmobi.ads.InMobiInterstitial inMobiInterstitial) {

    }

    @Override
    public void onAdInteraction(com.inmobi.ads.InMobiInterstitial inMobiInterstitial, Map<Object, Object> map) {
        super.onClick();
    }

    @Override
    public void onAdLoadSucceeded(com.inmobi.ads.InMobiInterstitial inMobiInterstitial) {
        super.onRequestSuccess();
        isLoaded = true;
    }

    @Override
    public void onAdLoadFailed(com.inmobi.ads.InMobiInterstitial inMobiInterstitial, com.inmobi.ads.InMobiAdRequestStatus inMobiAdRequestStatus) {
        super.onRequestFailed();
        isLoaded = false;
    }

    @Override
    public void onUserLeftApplication(com.inmobi.ads.InMobiInterstitial inMobiInterstitial) {

    }
}
