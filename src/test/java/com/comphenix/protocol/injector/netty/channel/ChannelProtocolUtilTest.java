package com.comphenix.protocol.injector.netty.channel;

import com.comphenix.protocol.BukkitInitialization;

import org.junit.jupiter.api.BeforeAll;

public class ChannelProtocolUtilTest {

    @BeforeAll
    public static void beforeClass() {
        BukkitInitialization.initializeAll();
    }

	/*
    @Test
    public void testProtocolResolving() {
        Channel channel = new LocalServerChannel();
        channel.attr(NetworkManager.e).set(EnumProtocol.e.b(EnumProtocolDirection.a)); // ATTRIBUTE_SERVERBOUND_PROTOCOL -> Protocol.CONFIG.codec(SERVERBOUND)
        channel.attr(NetworkManager.f).set(EnumProtocol.b.b(EnumProtocolDirection.b)); // ATTRIBUTE_CLIENTBOUND_PROTOCOL -> Protocol.PLAY.codec(CLIENTBOUND)

        PacketType.Protocol serverBoundProtocol = ChannelProtocolUtil.PROTOCOL_RESOLVER.apply(channel, PacketType.Sender.CLIENT);
        Assertions.assertEquals(PacketType.Protocol.CONFIGURATION, serverBoundProtocol);

        PacketType.Protocol clientBoundProtocol = ChannelProtocolUtil.PROTOCOL_RESOLVER.apply(channel, PacketType.Sender.SERVER);
        Assertions.assertEquals(PacketType.Protocol.PLAY, clientBoundProtocol);
    }
	 */
}
