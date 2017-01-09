package net.texsoftware.adservelibrary.ads.interstitial;

import android.app.Activity;

import net.texsoftware.adservelibrary.data.InterstitialAdNetwork;

import java.util.List;

/**
 * Created by Jibola on 10/6/2015.
 */
public class InterstitialAerserv extends InterstitialAd implements com.aerserv.sdk.AerServEventListener {

    com.aerserv.sdk.AerServConfig config = null;
    com.aerserv.sdk.AerServInterstitial aerServInterstitial;

    public InterstitialAerserv(Activity activity, InterstitialAdNetwork interstitialAdNetwork) {
        this.adNetwork = interstitialAdNetwork;
        config = new com.aerserv.sdk.AerServConfig(activity, adNetwork.getAd_unit_id()).setEventListener(this).setPreload(true).setPrecache(true);
        config.enableBackButton(true);
    }

    public void initInterstitial(Activity activity) {
        aerServInterstitial = new com.aerserv.sdk.AerServInterstitial(config);

    }

    public void showInterstitial() {
        super.showInterstitial();

        if (aerServInterstitial != null && config.isPreload())
            aerServInterstitial.show();
    }

    public void loadInterstitial() {
        if (aerServInterstitial != null)
            aerServInterstitial.show();
    }

    @Override
    public void onPause() {
        if (aerServInterstitial != null) {
            aerServInterstitial.pause();
        }
    }

    @Override
    public void onResume() {
        if (aerServInterstitial != null) {
            aerServInterstitial.play();
        }
    }

    @Override
    public void onDestroy() {
        if (aerServInterstitial != null) {
            aerServInterstitial.kill();
        }
    }

    @Override
    public void onAerServEvent(com.aerserv.sdk.AerServEvent aerServEvent, List<Object> list) {
        switch (aerServEvent) {
            case AD_LOADED:
                break;
            case PRELOAD_READY:
                super.onRequestSuccess();
                break;
            case AD_FAILED:
                super.onRequestFailed();
                break;
            case AD_COMPLETED:
                break;
            case AD_IMPRESSION:
                super.onImpressionLogged();
                break;
            case AD_CLICKED:
                super.onClick();
                break;
        }
    }
}
