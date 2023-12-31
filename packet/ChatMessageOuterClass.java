// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ChatMessage.proto

package packet;

public final class ChatMessageOuterClass {
  private ChatMessageOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ChatMessageOrBuilder extends
      // @@protoc_insertion_point(interface_extends:packet.ChatMessage)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 packetId = 1;</code>
     * @return Whether the packetId field is set.
     */
    boolean hasPacketId();
    /**
     * <code>int32 packetId = 1;</code>
     * @return The packetId.
     */
    int getPacketId();

    /**
     * <code>int32 playerId = 2;</code>
     * @return Whether the playerId field is set.
     */
    boolean hasPlayerId();
    /**
     * <code>int32 playerId = 2;</code>
     * @return The playerId.
     */
    int getPlayerId();

    /**
     * <code>string message = 3;</code>
     * @return Whether the message field is set.
     */
    boolean hasMessage();
    /**
     * <code>string message = 3;</code>
     * @return The message.
     */
    java.lang.String getMessage();
    /**
     * <code>string message = 3;</code>
     * @return The bytes for message.
     */
    com.google.protobuf.ByteString
        getMessageBytes();
  }
  /**
   * Protobuf type {@code packet.ChatMessage}
   */
  public static final class ChatMessage extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:packet.ChatMessage)
      ChatMessageOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use ChatMessage.newBuilder() to construct.
    private ChatMessage(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private ChatMessage() {
      message_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new ChatMessage();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private ChatMessage(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              bitField0_ |= 0x00000001;
              packetId_ = input.readInt32();
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              playerId_ = input.readInt32();
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();
              bitField0_ |= 0x00000004;
              message_ = s;
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return packet.ChatMessageOuterClass.internal_static_packet_ChatMessage_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return packet.ChatMessageOuterClass.internal_static_packet_ChatMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              packet.ChatMessageOuterClass.ChatMessage.class, packet.ChatMessageOuterClass.ChatMessage.Builder.class);
    }

    private int bitField0_;
    public static final int PACKETID_FIELD_NUMBER = 1;
    private int packetId_;
    /**
     * <code>int32 packetId = 1;</code>
     * @return Whether the packetId field is set.
     */
    @java.lang.Override
    public boolean hasPacketId() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>int32 packetId = 1;</code>
     * @return The packetId.
     */
    @java.lang.Override
    public int getPacketId() {
      return packetId_;
    }

    public static final int PLAYERID_FIELD_NUMBER = 2;
    private int playerId_;
    /**
     * <code>int32 playerId = 2;</code>
     * @return Whether the playerId field is set.
     */
    @java.lang.Override
    public boolean hasPlayerId() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>int32 playerId = 2;</code>
     * @return The playerId.
     */
    @java.lang.Override
    public int getPlayerId() {
      return playerId_;
    }

    public static final int MESSAGE_FIELD_NUMBER = 3;
    private volatile java.lang.Object message_;
    /**
     * <code>string message = 3;</code>
     * @return Whether the message field is set.
     */
    @java.lang.Override
    public boolean hasMessage() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>string message = 3;</code>
     * @return The message.
     */
    @java.lang.Override
    public java.lang.String getMessage() {
      java.lang.Object ref = message_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        message_ = s;
        return s;
      }
    }
    /**
     * <code>string message = 3;</code>
     * @return The bytes for message.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getMessageBytes() {
      java.lang.Object ref = message_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        message_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (((bitField0_ & 0x00000001) != 0)) {
        output.writeInt32(1, packetId_);
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        output.writeInt32(2, playerId_);
      }
      if (((bitField0_ & 0x00000004) != 0)) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, message_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, packetId_);
      }
      if (((bitField0_ & 0x00000002) != 0)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, playerId_);
      }
      if (((bitField0_ & 0x00000004) != 0)) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, message_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof packet.ChatMessageOuterClass.ChatMessage)) {
        return super.equals(obj);
      }
      packet.ChatMessageOuterClass.ChatMessage other = (packet.ChatMessageOuterClass.ChatMessage) obj;

      if (hasPacketId() != other.hasPacketId()) return false;
      if (hasPacketId()) {
        if (getPacketId()
            != other.getPacketId()) return false;
      }
      if (hasPlayerId() != other.hasPlayerId()) return false;
      if (hasPlayerId()) {
        if (getPlayerId()
            != other.getPlayerId()) return false;
      }
      if (hasMessage() != other.hasMessage()) return false;
      if (hasMessage()) {
        if (!getMessage()
            .equals(other.getMessage())) return false;
      }
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (hasPacketId()) {
        hash = (37 * hash) + PACKETID_FIELD_NUMBER;
        hash = (53 * hash) + getPacketId();
      }
      if (hasPlayerId()) {
        hash = (37 * hash) + PLAYERID_FIELD_NUMBER;
        hash = (53 * hash) + getPlayerId();
      }
      if (hasMessage()) {
        hash = (37 * hash) + MESSAGE_FIELD_NUMBER;
        hash = (53 * hash) + getMessage().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static packet.ChatMessageOuterClass.ChatMessage parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static packet.ChatMessageOuterClass.ChatMessage parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static packet.ChatMessageOuterClass.ChatMessage parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static packet.ChatMessageOuterClass.ChatMessage parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static packet.ChatMessageOuterClass.ChatMessage parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static packet.ChatMessageOuterClass.ChatMessage parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static packet.ChatMessageOuterClass.ChatMessage parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static packet.ChatMessageOuterClass.ChatMessage parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static packet.ChatMessageOuterClass.ChatMessage parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static packet.ChatMessageOuterClass.ChatMessage parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static packet.ChatMessageOuterClass.ChatMessage parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static packet.ChatMessageOuterClass.ChatMessage parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(packet.ChatMessageOuterClass.ChatMessage prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code packet.ChatMessage}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:packet.ChatMessage)
        packet.ChatMessageOuterClass.ChatMessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return packet.ChatMessageOuterClass.internal_static_packet_ChatMessage_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return packet.ChatMessageOuterClass.internal_static_packet_ChatMessage_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                packet.ChatMessageOuterClass.ChatMessage.class, packet.ChatMessageOuterClass.ChatMessage.Builder.class);
      }

      // Construct using packet.ChatMessageOuterClass.ChatMessage.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        packetId_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        playerId_ = 0;
        bitField0_ = (bitField0_ & ~0x00000002);
        message_ = "";
        bitField0_ = (bitField0_ & ~0x00000004);
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return packet.ChatMessageOuterClass.internal_static_packet_ChatMessage_descriptor;
      }

      @java.lang.Override
      public packet.ChatMessageOuterClass.ChatMessage getDefaultInstanceForType() {
        return packet.ChatMessageOuterClass.ChatMessage.getDefaultInstance();
      }

      @java.lang.Override
      public packet.ChatMessageOuterClass.ChatMessage build() {
        packet.ChatMessageOuterClass.ChatMessage result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public packet.ChatMessageOuterClass.ChatMessage buildPartial() {
        packet.ChatMessageOuterClass.ChatMessage result = new packet.ChatMessageOuterClass.ChatMessage(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) != 0)) {
          result.packetId_ = packetId_;
          to_bitField0_ |= 0x00000001;
        }
        if (((from_bitField0_ & 0x00000002) != 0)) {
          result.playerId_ = playerId_;
          to_bitField0_ |= 0x00000002;
        }
        if (((from_bitField0_ & 0x00000004) != 0)) {
          to_bitField0_ |= 0x00000004;
        }
        result.message_ = message_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof packet.ChatMessageOuterClass.ChatMessage) {
          return mergeFrom((packet.ChatMessageOuterClass.ChatMessage)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(packet.ChatMessageOuterClass.ChatMessage other) {
        if (other == packet.ChatMessageOuterClass.ChatMessage.getDefaultInstance()) return this;
        if (other.hasPacketId()) {
          setPacketId(other.getPacketId());
        }
        if (other.hasPlayerId()) {
          setPlayerId(other.getPlayerId());
        }
        if (other.hasMessage()) {
          bitField0_ |= 0x00000004;
          message_ = other.message_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        packet.ChatMessageOuterClass.ChatMessage parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (packet.ChatMessageOuterClass.ChatMessage) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int packetId_ ;
      /**
       * <code>int32 packetId = 1;</code>
       * @return Whether the packetId field is set.
       */
      @java.lang.Override
      public boolean hasPacketId() {
        return ((bitField0_ & 0x00000001) != 0);
      }
      /**
       * <code>int32 packetId = 1;</code>
       * @return The packetId.
       */
      @java.lang.Override
      public int getPacketId() {
        return packetId_;
      }
      /**
       * <code>int32 packetId = 1;</code>
       * @param value The packetId to set.
       * @return This builder for chaining.
       */
      public Builder setPacketId(int value) {
        bitField0_ |= 0x00000001;
        packetId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 packetId = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearPacketId() {
        bitField0_ = (bitField0_ & ~0x00000001);
        packetId_ = 0;
        onChanged();
        return this;
      }

      private int playerId_ ;
      /**
       * <code>int32 playerId = 2;</code>
       * @return Whether the playerId field is set.
       */
      @java.lang.Override
      public boolean hasPlayerId() {
        return ((bitField0_ & 0x00000002) != 0);
      }
      /**
       * <code>int32 playerId = 2;</code>
       * @return The playerId.
       */
      @java.lang.Override
      public int getPlayerId() {
        return playerId_;
      }
      /**
       * <code>int32 playerId = 2;</code>
       * @param value The playerId to set.
       * @return This builder for chaining.
       */
      public Builder setPlayerId(int value) {
        bitField0_ |= 0x00000002;
        playerId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 playerId = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearPlayerId() {
        bitField0_ = (bitField0_ & ~0x00000002);
        playerId_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object message_ = "";
      /**
       * <code>string message = 3;</code>
       * @return Whether the message field is set.
       */
      public boolean hasMessage() {
        return ((bitField0_ & 0x00000004) != 0);
      }
      /**
       * <code>string message = 3;</code>
       * @return The message.
       */
      public java.lang.String getMessage() {
        java.lang.Object ref = message_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          message_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string message = 3;</code>
       * @return The bytes for message.
       */
      public com.google.protobuf.ByteString
          getMessageBytes() {
        java.lang.Object ref = message_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          message_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string message = 3;</code>
       * @param value The message to set.
       * @return This builder for chaining.
       */
      public Builder setMessage(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        message_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string message = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearMessage() {
        bitField0_ = (bitField0_ & ~0x00000004);
        message_ = getDefaultInstance().getMessage();
        onChanged();
        return this;
      }
      /**
       * <code>string message = 3;</code>
       * @param value The bytes for message to set.
       * @return This builder for chaining.
       */
      public Builder setMessageBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        bitField0_ |= 0x00000004;
        message_ = value;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:packet.ChatMessage)
    }

    // @@protoc_insertion_point(class_scope:packet.ChatMessage)
    private static final packet.ChatMessageOuterClass.ChatMessage DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new packet.ChatMessageOuterClass.ChatMessage();
    }

    public static packet.ChatMessageOuterClass.ChatMessage getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ChatMessage>
        PARSER = new com.google.protobuf.AbstractParser<ChatMessage>() {
      @java.lang.Override
      public ChatMessage parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new ChatMessage(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<ChatMessage> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ChatMessage> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public packet.ChatMessageOuterClass.ChatMessage getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_packet_ChatMessage_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_packet_ChatMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021ChatMessage.proto\022\006packet\"w\n\013ChatMessa" +
      "ge\022\025\n\010packetId\030\001 \001(\005H\000\210\001\001\022\025\n\010playerId\030\002 " +
      "\001(\005H\001\210\001\001\022\024\n\007message\030\003 \001(\tH\002\210\001\001B\013\n\t_packe" +
      "tIdB\013\n\t_playerIdB\n\n\010_messageb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_packet_ChatMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_packet_ChatMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_packet_ChatMessage_descriptor,
        new java.lang.String[] { "PacketId", "PlayerId", "Message", "PacketId", "PlayerId", "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
