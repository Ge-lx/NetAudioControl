package io.github.gelx_.netAudioControl.jna;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;

/**
 * Created by Gelx on 20.12.2014.
 */
public interface IAudioSessionManager extends IUnknown {

    IAudioSessionManager INSTANCE = (IAudioSessionManager) Native.loadLibrary("IAudioSessionManager", IAudioSessionManager.class);

    /**
     * The GetAudioSessionControl method retrieves an audio session control.
     *
     * @param AudioSessionGuid Pointer to a session GUID. If the GUID does not identify a session that has been previously opened,
     *                         the call opens a new but empty session. The Sndvol program does not display a volume-level control
     *                         for a session unless it contains one or more active streams. If this parameter is NULL or points to
     *                         the value GUID_NULL, the method assigns the stream to the default session.
     *
     * @param StreamFlags Specifies the status of the flags for the audio stream.
     *
     * @param SessionControl Pointer to a pointer variable into which the method writes a pointer to the IAudioSessionControl
     *                       interface of the audio session control object. The caller is responsible for releasing the interface,
     *                       when it is no longer needed, by calling the interface's Release method. If the call fails, *SessionControl is NULL.
     *
     * @return If the method succeeds, it returns S_OK. If it fails, possible return codes include, but are not limited to, the values shown in the following table.
     */
    WinNT.HRESULT GetAudioSessionControl(Guid.GUID AudioSessionGuid, WinDef.DWORD StreamFlags, Pointer SessionControl);

    /**
     * The GetSimpleAudioVolume method retrieves a simple audio volume control.
     *
     * @param AudioSessionGuid Pointer to a session GUID. If the GUID does not identify a session that has been previously opened,
     *                         the call opens a new but empty session. The Sndvol program does not display a volume-level control
     *                         for a session unless it contains one or more active streams. If this parameter is NULL or points to
     *                         the value GUID_NULL, the method assigns the stream to the default session.
     *
     * @param CrossProcessSession Specifies whether the request is for a cross-process session. Set to TRUE if the session is
     *                            cross-process. Set to FALSE if the session is not cross-process.
     *
     * @param AudioVolume Pointer to a pointer variable into which the method writes a pointer to the ISimpleAudioVolume interface
     *                    of the audio volume control object. This interface represents the simple audio volume control for the current
     *                    process. The caller is responsible for releasing the interface, when it is no longer needed, by calling the
     *                    interface's Release method. If the Activate call fails, *AudioVolume is NULL.
     *
     * @return If the method succeeds, it returns S_OK. If it fails, possible return codes include, but are not limited to, the values shown in the following table.
     */
    WinNT.HRESULT GetSimpleAudioVolume(Guid.GUID AudioSessionGuid, WinDef.DWORD CrossProcessSession, Pointer AudioVolume);


}
