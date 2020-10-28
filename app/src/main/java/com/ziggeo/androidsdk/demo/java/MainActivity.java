package com.ziggeo.androidsdk.demo.java;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.ziggeo.androidsdk.IZiggeo;
import com.ziggeo.androidsdk.Ziggeo;
import com.ziggeo.androidsdk.callbacks.FileSelectorCallback;
import com.ziggeo.androidsdk.callbacks.PlayerCallback;
import com.ziggeo.androidsdk.callbacks.RecorderCallback;
import com.ziggeo.androidsdk.callbacks.UploadingCallback;
import com.ziggeo.androidsdk.log.ZLog;
import com.ziggeo.androidsdk.qr.QrScannerCallback;
import com.ziggeo.androidsdk.recorder.MicSoundLevel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String appToken = ""; //your app token here
        IZiggeo ziggeo = new Ziggeo(appToken, this);
        initRecorderCallback(ziggeo);
        initPlayerCallback(ziggeo);
        initUploaderCallback(ziggeo);
        initFileSelectorCallback(ziggeo);
        initQrScannerCallback(ziggeo);
        ziggeo.startCameraRecorder();
    }

    private void initRecorderCallback(@NonNull IZiggeo ziggeo) {
        ziggeo.getRecorderConfig().setCallback(new RecorderCallback() {
            @Override
            public void loaded() {
                super.loaded();
                ZLog.d("loaded");
            }

            @Override
            public void manuallySubmitted() {
                super.manuallySubmitted();
                ZLog.d("manuallySubmitted");
            }

            @Override
            public void recordingStarted() {
                super.recordingStarted();
                ZLog.d("recordingStarted");
            }

            @Override
            public void recordingStopped(@NonNull String path) {
                super.recordingStopped(path);
                ZLog.d("recordingStopped:%s", path);
            }

            @Override
            public void countdown(int secondsLeft) {
                super.countdown(secondsLeft);
                ZLog.d("countdown:%s", secondsLeft);
            }

            @Override
            public void recordingProgress(long millisPassed) {
                super.recordingProgress(millisPassed);
                ZLog.d("recordingProgress:%s", millisPassed);
            }

            @Override
            public void readyToRecord() {
                super.readyToRecord();
                ZLog.d("readyToRecord");
            }

            @Override
            public void accessForbidden(@NonNull List<String> permissions) {
                super.accessForbidden(permissions);
                ZLog.d("accessForbidden:%s", permissions);
            }

            @Override
            public void accessGranted() {
                super.accessGranted();
                ZLog.d("accessGranted");
            }

            @Override
            public void noCamera() {
                super.noCamera();
                ZLog.d("noCamera");
            }

            @Override
            public void noMicrophone() {
                super.noMicrophone();
                ZLog.d("noMicrophone");
            }

            @Override
            public void hasCamera() {
                super.hasCamera();
                ZLog.d("hasCamera");
            }

            @Override
            public void hasMicrophone() {
                super.hasMicrophone();
                ZLog.d("hasMicrophone");
            }

            @Override
            public void microphoneHealth(@NonNull MicSoundLevel micStatus) {
                super.microphoneHealth(micStatus);
                ZLog.d("microphoneHealth:%s", micStatus);
            }

            @Override
            public void canceledByUser() {
                super.canceledByUser();
                ZLog.d("canceledByUser");
            }

            @Override
            public void error(@NonNull Throwable throwable) {
                super.error(throwable);
                ZLog.d(throwable, "error");
            }

            @Override
            public void streamingStarted() {
                super.streamingStarted();
                ZLog.d("streamingStarted");
            }

            @Override
            public void streamingStopped() {
                super.streamingStopped();
                ZLog.d("streamingStopped");
            }

            @Override
            public void rerecord() {
                super.rerecord();
                ZLog.d("rerecord");
            }
        });
    }

    private void initPlayerCallback(@NonNull IZiggeo ziggeo) {
        ziggeo.getPlayerConfig().setCallback(new PlayerCallback() {
            @Override
            public void loaded() {
                super.loaded();
                ZLog.d("loaded");
            }

            @Override
            public void canceledByUser() {
                super.canceledByUser();
                ZLog.d("canceledByUser");
            }

            @Override
            public void error(@NonNull Throwable throwable) {
                super.error(throwable);
                ZLog.d(throwable, "error");
            }

            @Override
            public void playing() {
                super.playing();
                ZLog.d("playing");
            }

            @Override
            public void paused() {
                super.paused();
                ZLog.d("paused");
            }

            @Override
            public void ended() {
                super.ended();
                ZLog.d("ended");
            }

            @Override
            public void seek(long millis) {
                super.seek(millis);
                ZLog.d("seek:%s", millis);
            }

            @Override
            public void readyToPlay() {
                super.readyToPlay();
                ZLog.d("readyToPlay");
            }

            @Override
            public void accessForbidden(@NonNull List<String> permissions) {
                super.accessForbidden(permissions);
                ZLog.d("accessForbidden:%s", permissions);
            }

            @Override
            public void accessGranted() {
                super.accessGranted();
                ZLog.d("accessGranted");
            }
        });
    }

    private void initUploaderCallback(@NonNull IZiggeo ziggeo) {
        ziggeo.getUploadingConfig().setCallback(new UploadingCallback() {
            @Override
            public void uploadingStarted(@NonNull String videoToken) {
                super.uploadingStarted(videoToken);
                ZLog.d("uploadingStarted:%s", videoToken);
            }

            @Override
            public void uploadProgress(@NonNull String videoToken, @NonNull String path, long uploadedBytes, long totalBytes) {
                super.uploadProgress(videoToken, path, uploadedBytes, totalBytes);
                ZLog.d("uploadProgress. %s %s/%s", videoToken, uploadedBytes, totalBytes);
            }

            @Override
            public void uploaded(@NonNull String path, @NonNull String videoToken) {
                super.uploaded(path, videoToken);
                ZLog.d("uploaded:%s %s", videoToken, path);
            }

            @Override
            public void processing(@NonNull String videoToken) {
                super.processing(videoToken);
                ZLog.d("processing:%s", videoToken);
            }

            @Override
            public void processed(@NonNull String videoToken) {
                super.processed(videoToken);
                ZLog.d("processed:%s", videoToken);
            }

            @Override
            public void verified(@NonNull String videoToken) {
                super.verified(videoToken);
                ZLog.d("verified:%s", videoToken);
            }

            @Override
            public void error(@NonNull Throwable throwable) {
                super.error(throwable);
                ZLog.d(throwable, "error");
            }
        });
    }

    private void initFileSelectorCallback(@NonNull IZiggeo ziggeo) {
        ziggeo.getFileSelectorConfig().setCallback(new FileSelectorCallback() {
            @Override
            public void uploadSelected(@NonNull List<String> paths) {
                super.uploadSelected(paths);
                ZLog.d("uploadSelected:%s", paths);
            }

            @Override
            public void loaded() {
                super.loaded();
                ZLog.d("loaded");
            }

            @Override
            public void canceledByUser() {
                super.canceledByUser();
                ZLog.d("canceledByUser");
            }

            @Override
            public void error(@NonNull Throwable throwable) {
                super.error(throwable);
                ZLog.d(throwable, "error");
            }

            @Override
            public void accessForbidden(@NonNull List<String> permissions) {
                super.accessForbidden(permissions);
                ZLog.d("accessForbidden:%s", permissions);
            }

            @Override
            public void accessGranted() {
                super.accessGranted();
                ZLog.d("accessGranted");
            }
        });
    }

    private void initQrScannerCallback(@NonNull IZiggeo ziggeo) {
        ziggeo.getQrScannerConfig().setCallback(new QrScannerCallback() {
            @Override
            public void onQrDecoded(@NonNull String value) {
                super.onQrDecoded(value);
                ZLog.d("onQrDecoded:%s", value);
            }

            @Override
            public void loaded() {
                super.loaded();
                ZLog.d("loaded");
            }

            @Override
            public void canceledByUser() {
                super.canceledByUser();
                ZLog.d("canceledByUser");
            }

            @Override
            public void error(@NonNull Throwable throwable) {
                super.error(throwable);
                ZLog.d(throwable, "error");
            }

            @Override
            public void accessForbidden(@NonNull List<String> permissions) {
                super.accessForbidden(permissions);
                ZLog.d("accessForbidden:%S", permissions);
            }

            @Override
            public void accessGranted() {
                super.accessGranted();
                ZLog.d("accessGranted");
            }

            @Override
            public void noCamera() {
                super.noCamera();
                ZLog.d("noCamera");
            }

            @Override
            public void noMicrophone() {
                super.noMicrophone();
                ZLog.d("noMicrophone");
            }

            @Override
            public void hasCamera() {
                super.hasCamera();
                ZLog.d("hasCamera");
            }

            @Override
            public void hasMicrophone() {
                super.hasMicrophone();
                ZLog.d("hasMicrophone");
            }
        });
    }

}