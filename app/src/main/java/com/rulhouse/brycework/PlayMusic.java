package com.rulhouse.brycework;

public class PlayMusic {
    Long time = 2000L;

    private MusicStateListener musicStateListener;

    interface MusicStateListener {
        void onStart();
        void onFinish();
    }

    void setMusicStateListener(MusicStateListener musicStateListener) {
        this.musicStateListener = musicStateListener;
    }

    void playMusic() {
        musicStateListener.onStart();
        Thread playMusicThread = new Thread(new MockPlayingTask());
        playMusicThread.start();
    }

    class MockPlayingTask implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(time);
                musicStateListener.onFinish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
