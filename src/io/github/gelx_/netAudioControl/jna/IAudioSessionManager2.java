package io.github.gelx_.netAudioControl.jna;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinNT;

/**
 * Created by Gelx on 20.12.2014.
 */
public interface IAudioSessionManager2 extends IAudioSessionManager {

    IAudioSessionManager2 INSTANCE = (IAudioSessionManager2) Native.loadLibrary("IAudioSessionManager2", IAudioSessionManager2.class);

    /**
     * The GetSessionEnumerator method gets a pointer to the audio session enumerator object.
     *
     * @param SessionList Receives a pointer to the IAudioSessionEnumerator interface of the session enumerator object
     *                    that the client can use to enumerate audio sessions on the audio device. Through this method,
     *                    the caller obtains a counted reference to the interface. The caller is responsible for releasing
     *                    the interface, when it is no longer needed, by calling the interface's Release method.
     *
     * @return If the method succeeds, it returns S_OK.
     */
    WinNT.HRESULT GetSessionEnumerator( Pointer SessionList);

    /**
     * The RegisterDuckNotification method registers the application with the session manager to receive ducking notifications.
     *
     * @param SessionID Pointer to a null-terminated string that contains a session instance identifier. Applications that
     *                  are playing a media stream and want to provide custom stream attenuation or ducking behavior, pass
     *                  their own session instance identifier. For more information, see Remarks.
     *
     *                  Other applications that do not want to alter their streams but want to get all the ducking
     *                  notifications must pass NULL.
     *
     * @param duckNotification Pointer to the application's implementation of the IAudioVolumeDuckNotification interface.
     *                         The implementation is called when ducking events are raised by the audio system and
     *                         notifications are sent to the registered applications.
     *
     * @return If the method succeeds, it returns S_OK. If it fails, possible return codes include, but are not limited
     *         to, the values shown in the following table.
     */
    WinNT.HRESULT RegisterDuckNotification( String SessionID, Pointer duckNotification);

    /**
     * The RegisterSessionNotification method registers the application to receive a notification when a session is created.
     *
     * @param SessionNotification A pointer to the application's implementation of the IAudioSessionNotification interface.
     *                            If the method call succeeds, it calls the AddRef method on the application's
     *                            IAudioSessionNotification interface.
     *
     * @return If the method succeeds, it returns S_OK. If it fails, possible return codes include, but are not limited
     *         to, the values shown in the following table.
     */
    WinNT.HRESULT RegisterSessionNotification( Pointer SessionNotification);

    /**
     * The UnregisterDuckNotification method deletes a previous registration by the application to receive notifications.
     *
     * @param duckNotification Pointer to the IAudioVolumeDuckNotification interface that is implemented by the
     *                         application. Pass the same interface pointer that was specified to the session manager in
     *                         a previous call to the IAudioSessionManager2::RegisterDuckNotification method. If the
     *                         UnregisterDuckNotification method succeeds, it calls the Release method on the
     *                         application's IAudioVolumeDuckNotification interface.
     *
     * @return If the method succeeds, it returns S_OK. If it fails, possible return codes include, but are not limited
     *         to, the values shown in the following table.
     */
    WinNT.HRESULT UnregisterDuckNotification( Pointer duckNotification);

    /**
     * The UnregisterSessionNotification method deletes the registration to receive a notification when a session is created.
     *
     * @param SessionNotification A pointer to the application's implementation of the IAudioSessionNotification
     *                            interface. Pass the same interface pointer that was specified to the session manager
     *                            in a previous call to IAudioSessionManager2::RegisterSessionNotification to register
     *                            for notification.
     *
     *                            If the UnregisterSessionNotification method succeeds, it calls the Release method on
     *                            the application's IAudioSessionNotification interface.
     *
     * @return If the method succeeds, it returns S_OK. If it fails, possible return codes include, but are not limited
     *         to, the values shown in the following table.
     */
    WinNT.HRESULT UnregisterSessionNotification( Pointer SessionNotification);
}
