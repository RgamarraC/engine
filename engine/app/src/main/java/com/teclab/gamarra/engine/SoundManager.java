package com.teclab.gamarra.engine;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Heat on 4/9/2017.
 */

public class SoundManager {

    private SoundPool mSoundPool;
    private HashMap mSoundPoolMap;
    private HashMap mStreamPoolMap;
    private AudioManager mAudioManager;
    private Context mContext;

    public SoundManager(Context theContext)
    {
        initSounds(theContext);
    }


    public void initSounds(Context theContext)
    {
        mContext = theContext;
        if(android.os.Build.VERSION.SDK_INT >= 21)
        {
            AudioAttributes attributes = (new android.media.AudioAttributes.Builder()).setContentType(AudioAttributes.CONTENT_TYPE_MUSIC).setUsage(AudioAttributes.USAGE_GAME).build();
            mSoundPool = (new android.media.SoundPool.Builder()).setMaxStreams(10).setAudioAttributes(attributes).build();
        } else
        {
            mSoundPool = new SoundPool(10, 3, 0);
        }
        mSoundPoolMap = new HashMap();
        mAudioManager = (AudioManager)mContext.getSystemService(Context.AUDIO_SERVICE);
    }

    public void addSound(String key, int SoundID)
    {
        if(!mSoundPoolMap.containsKey(key))
        {
            mSoundPoolMap.put(key, Integer.valueOf(mSoundPool.load(mContext, SoundID, 1)));
            mStreamPoolMap.put(key, Integer.valueOf(-1));
        }
    }

    public void removeSound(String key)
    {
        mSoundPool.unload(((Integer)mSoundPoolMap.get(key)).intValue());
        mSoundPoolMap.remove(key);
        mStreamPoolMap.remove(key);
    }

    public void playSound(String key)
    {
        int streamVolume = mAudioManager.getStreamVolume(3);
        mStreamPoolMap.put(key, Integer.valueOf(mSoundPool.play(((Integer)mSoundPoolMap.get(key)).intValue(), streamVolume, streamVolume, 1, 0, 1.0F)));
    }

    public void playSound(String key, int loop)
    {
        int streamVolume = mAudioManager.getStreamVolume(3);
        mStreamPoolMap.put(key, Integer.valueOf(mSoundPool.play(((Integer)mSoundPoolMap.get(key)).intValue(), streamVolume, streamVolume, 1, loop, 1.0F)));
    }

    public void stopSound(String key)
    {
        mSoundPool.stop(((Integer)mStreamPoolMap.get(key)).intValue());
    }

    public void pauseSound(String key)
    {
        mSoundPool.pause(((Integer)mStreamPoolMap.get(key)).intValue());
    }

    public void resumeSound(String key)
    {
        mSoundPool.resume(((Integer)mStreamPoolMap.get(key)).intValue());
    }

    public void setLoopSound(String key, int loop)
    {
        mSoundPool.setLoop(((Integer)mStreamPoolMap.get(key)).intValue(), loop);
    }

    public void setPitchSound(String key, float pitch)
    {
        mSoundPool.setRate(((Integer)mStreamPoolMap.get(key)).intValue(), pitch);
    }

    public void setVolumeSound(String key, float volume)
    {
        mSoundPool.setVolume(((Integer)mStreamPoolMap.get(key)).intValue(), volume, volume);
    }

    public void setVolumeSound(String key, float leftVolume, float rightVolume)
    {
        mSoundPool.setVolume(((Integer)mStreamPoolMap.get(key)).intValue(), leftVolume, rightVolume);
    }

    public void setmContext(Context mContext)
    {
        this.mContext = mContext;
    }

    public void pauseAllSounds()
    {
        mSoundPool.autoPause();
    }

    public void resumeAllSounds()
    {
        mSoundPool.autoResume();
    }

    public void clearPool()
    {
        String auxKey;
        for(Iterator iterator = mSoundPoolMap.keySet().iterator(); iterator.hasNext(); mSoundPool.unload(((Integer)mSoundPoolMap.get(auxKey)).intValue()))
            auxKey = (String)iterator.next();

        mSoundPoolMap.clear();
        mStreamPoolMap.clear();
    }

    public SoundPool getmSoundPool()
    {
        return mSoundPool;
    }

    public void dispose()
    {
        clearPool();
        mSoundPool.release();
    }


}