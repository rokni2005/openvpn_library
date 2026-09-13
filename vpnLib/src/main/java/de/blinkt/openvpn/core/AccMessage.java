package de.blinkt.openvpn.core;

// Minimal Java stand-in for the Kotlin AccMessage data class in the official
// ics-openvpn source (de/blinkt/openvpn/core/AppCustomControl.kt). The
// OpenVPNManagement interface (also ported from official) references this
// type in its sendAccMessage signature, but the actual ACC control-channel
// feature itself isn't ported (would require adding Kotlin to the build for
// a feature this fork's servers don't use) — see OpenVpnManagementThread's
// processAccMessage, which just logs instead of parsing.
public class AccMessage {
    public final String protocol;
    public final boolean fragment;
    public final byte[] message;

    public AccMessage(String protocol, boolean fragment, byte[] message) {
        this.protocol = protocol;
        this.fragment = fragment;
        this.message = message;
    }

    public String getProtocol() {
        return protocol;
    }

    public byte[] getMessage() {
        return message;
    }
}
