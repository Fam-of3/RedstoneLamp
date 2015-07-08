package redstonelamp.network.packet;

import redstonelamp.network.NetworkChannel;
import redstonelamp.utils.DynamicByteBuffer;

/**
 * Base class for all packets.
 */
public abstract class DataPacket {
    private NetworkChannel channel = NetworkChannel.CHANNEL_NONE;
    private byte[] buffer;
    private int offset;

    /**
     * Get's this packet's Packet ID.
     * @return The Packet ID (byte).
     */
    public abstract byte getPID();

    /**
     * Encode this packet into  bytes.
     * @return The packet's bytes.
     */
    public final byte[] encode(){
        DynamicByteBuffer bb = DynamicByteBuffer.newInstance();
        bb.putByte(getPID());
        _encode(bb);
        return bb.toArray();
    }

    /**
     * Decodes the raw bytes of this packet into the child class.
     * @param buffer The packet's raw bytes.
     */
    public final void decode(byte[] buffer){
        this.buffer = buffer;
        DynamicByteBuffer bb = DynamicByteBuffer.newInstance(buffer);
        bb.getByte(); //PID
        _decode(bb);
        offset = bb.getPosition();
        bb = null;
    }

    /**
     * Decodes the raw bytes of this packet into the child class. Will start at <code>offset</code> position.
     * @param buffer The packet's raw bytes.
     * @param offset The position to start at.
     */
    public final void decode(byte[] buffer, int offset){
        this.buffer = buffer;
        DynamicByteBuffer bb = DynamicByteBuffer.newInstance(buffer);
        bb.setPosition(offset);
        bb.getByte(); //PID
        _decode(bb);
        offset = bb.getPosition();
        bb = null;
    }

    protected abstract void _encode(DynamicByteBuffer bb);
    protected abstract void _decode(DynamicByteBuffer bb);

    public NetworkChannel getChannel() {
        return channel;
    }

    public void setChannel(NetworkChannel channel) {
        this.channel = channel;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
