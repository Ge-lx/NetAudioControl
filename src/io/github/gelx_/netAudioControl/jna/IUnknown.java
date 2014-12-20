package io.github.gelx_.netAudioControl.jna;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.win32.StdCallLibrary;

/**
 * Created by Gelx on 20.12.2014.
 */
public interface IUnknown extends StdCallLibrary {

    IUnknown INSTANCE = (IUnknown) Native.loadLibrary("IUnknown", IUnknown.class);

    /**
     * Increments the reference count for an interface on an object. This method should be called for every new copy of a pointer to an interface on an object.
     * @return The method returns the new reference count. This value is intended to be used only for test purposes.
     */
    WinDef.ULONG AddRef();

    /**
     * Retrieves pointers to the supported interfaces on an object.
     This method calls IUnknown::AddRef on the pointer it returns.
     *
     * @param riid [in] The identifier of the interface being requested.
     * @param ppvObject [out] The address of a pointer variable that receives the interface pointer requested in the riid parameter.
     *                  Upon successful return, *ppvObject contains the requested interface pointer to the object.
     *                  If the object does not support the interface, *ppvObject is set to NULL.
     * @return This method returns S_OK if the interface is supported, and E_NOINTERFACE otherwise. If ppvObject is NULL, this method returns E_POINTER.
     */
    WinNT.HRESULT QueryInterface( Guid.REFIID riid, Void ppvObject);

    /**
     * Decrements the reference count for an interface on an object.
     * @return The method returns the new reference count. This value is intended to be used only for test purposes.
     */
    WinDef.ULONG Release();
}
