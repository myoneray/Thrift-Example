/**
 * Autogenerated by Thrift Compiler (0.9.0)注意版本一致
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.demo.thrift.example;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoService {

    public interface Iface {

        public String getNameById(int id) throws org.apache.thrift.TException;

    }

    public interface AsyncIface {

        public void getNameById(int id,
                org.apache.thrift.async.AsyncMethodCallback<AsyncClient.getNameById_call> resultHandler)
                throws org.apache.thrift.TException;

    }

    public static class Client extends org.apache.thrift.TServiceClient implements Iface {
        public static class Factory implements org.apache.thrift.TServiceClientFactory<Client> {
            public Factory() {
            }

            public Client getClient(org.apache.thrift.protocol.TProtocol prot) {
                return new Client(prot);
            }

            public Client getClient(org.apache.thrift.protocol.TProtocol iprot,
                    org.apache.thrift.protocol.TProtocol oprot) {
                return new Client(iprot, oprot);
            }
        }

        public Client(org.apache.thrift.protocol.TProtocol prot) {
            super(prot, prot);
        }

        public Client(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
            super(iprot, oprot);
        }

        public String getNameById(int id) throws org.apache.thrift.TException {
            send_getNameById(id);
            return recv_getNameById();
        }

        public void send_getNameById(int id) throws org.apache.thrift.TException {
            getNameById_args args = new getNameById_args();
            args.setId(id);
            sendBase("getNameById", args);
        }

        public String recv_getNameById() throws org.apache.thrift.TException {
            getNameById_result result = new getNameById_result();
            receiveBase(result, "getNameById");
            if (result.isSetSuccess()) {
                return result.success;
            }
            throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT,
                    "getNameById failed: unknown result");
        }

    }

    public static class AsyncClient extends org.apache.thrift.async.TAsyncClient implements AsyncIface {
        public static class Factory implements org.apache.thrift.async.TAsyncClientFactory<AsyncClient> {
            private org.apache.thrift.async.TAsyncClientManager clientManager;
            private org.apache.thrift.protocol.TProtocolFactory protocolFactory;

            public Factory(org.apache.thrift.async.TAsyncClientManager clientManager,
                    org.apache.thrift.protocol.TProtocolFactory protocolFactory) {
                this.clientManager = clientManager;
                this.protocolFactory = protocolFactory;
            }

            public AsyncClient getAsyncClient(org.apache.thrift.transport.TNonblockingTransport transport) {
                return new AsyncClient(protocolFactory, clientManager, transport);
            }
        }

        public AsyncClient(org.apache.thrift.protocol.TProtocolFactory protocolFactory,
                org.apache.thrift.async.TAsyncClientManager clientManager,
                org.apache.thrift.transport.TNonblockingTransport transport) {
            super(protocolFactory, clientManager, transport);
        }

        public void getNameById(int id, org.apache.thrift.async.AsyncMethodCallback<getNameById_call> resultHandler)
                throws org.apache.thrift.TException {
            checkReady();
            getNameById_call method_call = new getNameById_call(id, resultHandler, this, ___protocolFactory,
                    ___transport);
            this.___currentMethod = method_call;
            ___manager.call(method_call);
        }

        public static class getNameById_call extends org.apache.thrift.async.TAsyncMethodCall {
            private int id;

            public getNameById_call(int id,
                    org.apache.thrift.async.AsyncMethodCallback<getNameById_call> resultHandler,
                    org.apache.thrift.async.TAsyncClient client,
                    org.apache.thrift.protocol.TProtocolFactory protocolFactory,
                    org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
                super(client, protocolFactory, transport, resultHandler, false);
                this.id = id;
            }

            public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
                prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("getNameById",
                        org.apache.thrift.protocol.TMessageType.CALL, 0));
                getNameById_args args = new getNameById_args();
                args.setId(id);
                args.write(prot);
                prot.writeMessageEnd();
            }

            public String getResult() throws org.apache.thrift.TException {
                if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
                    throw new IllegalStateException("Method call not finished!");
                }
                org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(
                        getFrameBuffer().array());
                org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
                return (new Client(prot)).recv_getNameById();
            }
        }

    }

    public static class Processor<I extends Iface> extends org.apache.thrift.TBaseProcessor<I> implements
            org.apache.thrift.TProcessor {
        private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class.getName());

        public Processor(I iface) {
            super(
                    iface,
                    getProcessMap(new HashMap<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>>()));
        }

        protected Processor(I iface,
                Map<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>> processMap) {
            super(iface, getProcessMap(processMap));
        }

        private static <I extends Iface> Map<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>> getProcessMap(
                Map<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>> processMap) {
            processMap.put("getNameById", new getNameById());
            return processMap;
        }

        public static class getNameById<I extends Iface> extends org.apache.thrift.ProcessFunction<I, getNameById_args> {
            public getNameById() {
                super("getNameById");
            }

            public getNameById_args getEmptyArgsInstance() {
                return new getNameById_args();
            }

            protected boolean isOneway() {
                return false;
            }

            public getNameById_result getResult(I iface, getNameById_args args) throws org.apache.thrift.TException {
                getNameById_result result = new getNameById_result();
                result.success = iface.getNameById(args.id);
                return result;
            }
        }

    }

    public static class getNameById_args implements
            org.apache.thrift.TBase<getNameById_args, getNameById_args._Fields>, java.io.Serializable, Cloneable {
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct(
                "getNameById_args");

        private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField(
                "id", org.apache.thrift.protocol.TType.I32, (short) 1);

        private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
        static {
            schemes.put(StandardScheme.class, new getNameById_argsStandardSchemeFactory());
            schemes.put(TupleScheme.class, new getNameById_argsTupleSchemeFactory());
        }

        public int id; // required

        /**
         * The set of fields this struct contains, along with convenience
         * methods for finding and manipulating them.
         */
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {
            ID((short) 1, "id");

            private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

            static {
                for (_Fields field : EnumSet.allOf(_Fields.class)) {
                    byName.put(field.getFieldName(), field);
                }
            }

            /**
             * Find the _Fields constant that matches fieldId, or null if its
             * not found.
             */
            public static _Fields findByThriftId(int fieldId) {
                switch (fieldId) {
                case 1: // ID
                    return ID;
                default:
                    return null;
                }
            }

            /**
             * Find the _Fields constant that matches fieldId, throwing an
             * exception if it is not found.
             */
            public static _Fields findByThriftIdOrThrow(int fieldId) {
                _Fields fields = findByThriftId(fieldId);
                if (fields == null)
                    throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
                return fields;
            }

            /**
             * Find the _Fields constant that matches name, or null if its not
             * found.
             */
            public static _Fields findByName(String name) {
                return byName.get(name);
            }

            private final short _thriftId;
            private final String _fieldName;

            _Fields(short thriftId, String fieldName) {
                _thriftId = thriftId;
                _fieldName = fieldName;
            }

            public short getThriftFieldId() {
                return _thriftId;
            }

            public String getFieldName() {
                return _fieldName;
            }
        }

        // isset id assignments
        private static final int __ID_ISSET_ID = 0;
        private byte __isset_bitfield = 0;
        public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
        static {
            Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(
                    _Fields.class);
            tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("id",
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
            metaDataMap = Collections.unmodifiableMap(tmpMap);
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(getNameById_args.class, metaDataMap);
        }

        public getNameById_args() {
        }

        public getNameById_args(int id) {
            this();
            this.id = id;
            setIdIsSet(true);
        }

        /**
         * Performs a deep copy on <i>other</i>.
         */
        public getNameById_args(getNameById_args other) {
            __isset_bitfield = other.__isset_bitfield;
            this.id = other.id;
        }

        public getNameById_args deepCopy() {
            return new getNameById_args(this);
        }

        public void clear() {
            setIdIsSet(false);
            this.id = 0;
        }

        public int getId() {
            return this.id;
        }

        public getNameById_args setId(int id) {
            this.id = id;
            setIdIsSet(true);
            return this;
        }

        public void unsetId() {
            __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __ID_ISSET_ID);
        }

        /**
         * Returns true if field id is set (has been assigned a value) and false
         * otherwise
         */
        public boolean isSetId() {
            return EncodingUtils.testBit(__isset_bitfield, __ID_ISSET_ID);
        }

        public void setIdIsSet(boolean value) {
            __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __ID_ISSET_ID, value);
        }

        public void setFieldValue(_Fields field, Object value) {
            switch (field) {
            case ID:
                if (value == null) {
                    unsetId();
                } else {
                    setId((Integer) value);
                }
                break;

            }
        }

        public Object getFieldValue(_Fields field) {
            switch (field) {
            case ID:
                return Integer.valueOf(getId());

            }
            throw new IllegalStateException();
        }

        /**
         * Returns true if field corresponding to fieldID is set (has been
         * assigned a value) and false otherwise
         */
        public boolean isSet(_Fields field) {
            if (field == null) {
                throw new IllegalArgumentException();
            }

            switch (field) {
            case ID:
                return isSetId();
            }
            throw new IllegalStateException();
        }

        public boolean equals(Object that) {
            if (that == null)
                return false;
            if (that instanceof getNameById_args)
                return this.equals((getNameById_args) that);
            return false;
        }

        public boolean equals(getNameById_args that) {
            if (that == null)
                return false;

            boolean this_present_id = true;
            boolean that_present_id = true;
            if (this_present_id || that_present_id) {
                if (!(this_present_id && that_present_id))
                    return false;
                if (this.id != that.id)
                    return false;
            }

            return true;
        }

        public int hashCode() {
            return 0;
        }

        public int compareTo(getNameById_args other) {
            if (!getClass().equals(other.getClass())) {
                return getClass().getName().compareTo(other.getClass().getName());
            }

            int lastComparison = 0;
            getNameById_args typedOther = (getNameById_args) other;

            lastComparison = Boolean.valueOf(isSetId()).compareTo(typedOther.isSetId());
            if (lastComparison != 0) {
                return lastComparison;
            }
            if (isSetId()) {
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.id, typedOther.id);
                if (lastComparison != 0) {
                    return lastComparison;
                }
            }
            return 0;
        }

        public _Fields fieldForId(int fieldId) {
            return _Fields.findByThriftId(fieldId);
        }

        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
            schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
        }

        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
            schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("getNameById_args(");
            boolean first = true;

            sb.append("id:");
            sb.append(this.id);
            first = false;
            sb.append(")");
            return sb.toString();
        }

        public void validate() throws org.apache.thrift.TException {
            // check for required fields
            // check for sub-struct validity
        }

        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
            try {
                write(new org.apache.thrift.protocol.TCompactProtocol(
                        new org.apache.thrift.transport.TIOStreamTransport(out)));
            } catch (org.apache.thrift.TException te) {
                throw new java.io.IOException(te);
            }
        }

        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
            try {
                // it doesn't seem like you should have to do this, but java
                // serialization is wacky, and doesn't call the default
                // constructor.
                __isset_bitfield = 0;
                read(new org.apache.thrift.protocol.TCompactProtocol(
                        new org.apache.thrift.transport.TIOStreamTransport(in)));
            } catch (org.apache.thrift.TException te) {
                throw new java.io.IOException(te);
            }
        }

        private static class getNameById_argsStandardSchemeFactory implements SchemeFactory {
            public getNameById_argsStandardScheme getScheme() {
                return new getNameById_argsStandardScheme();
            }
        }

        private static class getNameById_argsStandardScheme extends StandardScheme<getNameById_args> {

            public void read(org.apache.thrift.protocol.TProtocol iprot, getNameById_args struct)
                    throws org.apache.thrift.TException {
                org.apache.thrift.protocol.TField schemeField;
                iprot.readStructBegin();
                while (true) {
                    schemeField = iprot.readFieldBegin();
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                        break;
                    }
                    switch (schemeField.id) {
                    case 1: // ID
                        if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                            struct.id = iprot.readI32();
                            struct.setIdIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    default:
                        org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    iprot.readFieldEnd();
                }
                iprot.readStructEnd();

                // check for required fields of primitive type, which can't be
                // checked in the validate method
                struct.validate();
            }

            public void write(org.apache.thrift.protocol.TProtocol oprot, getNameById_args struct)
                    throws org.apache.thrift.TException {
                struct.validate();

                oprot.writeStructBegin(STRUCT_DESC);
                oprot.writeFieldBegin(ID_FIELD_DESC);
                oprot.writeI32(struct.id);
                oprot.writeFieldEnd();
                oprot.writeFieldStop();
                oprot.writeStructEnd();
            }

        }

        private static class getNameById_argsTupleSchemeFactory implements SchemeFactory {
            public getNameById_argsTupleScheme getScheme() {
                return new getNameById_argsTupleScheme();
            }
        }

        private static class getNameById_argsTupleScheme extends TupleScheme<getNameById_args> {

            public void write(org.apache.thrift.protocol.TProtocol prot, getNameById_args struct)
                    throws org.apache.thrift.TException {
                TTupleProtocol oprot = (TTupleProtocol) prot;
                BitSet optionals = new BitSet();
                if (struct.isSetId()) {
                    optionals.set(0);
                }
                oprot.writeBitSet(optionals, 1);
                if (struct.isSetId()) {
                    oprot.writeI32(struct.id);
                }
            }

            public void read(org.apache.thrift.protocol.TProtocol prot, getNameById_args struct)
                    throws org.apache.thrift.TException {
                TTupleProtocol iprot = (TTupleProtocol) prot;
                BitSet incoming = iprot.readBitSet(1);
                if (incoming.get(0)) {
                    struct.id = iprot.readI32();
                    struct.setIdIsSet(true);
                }
            }
        }

    }

    public static class getNameById_result implements
            org.apache.thrift.TBase<getNameById_result, getNameById_result._Fields>, java.io.Serializable, Cloneable {
        private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct(
                "getNameById_result");

        private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField(
                "success", org.apache.thrift.protocol.TType.STRING, (short) 0);

        private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
        static {
            schemes.put(StandardScheme.class, new getNameById_resultStandardSchemeFactory());
            schemes.put(TupleScheme.class, new getNameById_resultTupleSchemeFactory());
        }

        public String success; // required

        /**
         * The set of fields this struct contains, along with convenience
         * methods for finding and manipulating them.
         */
        public enum _Fields implements org.apache.thrift.TFieldIdEnum {
            SUCCESS((short) 0, "success");

            private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

            static {
                for (_Fields field : EnumSet.allOf(_Fields.class)) {
                    byName.put(field.getFieldName(), field);
                }
            }

            /**
             * Find the _Fields constant that matches fieldId, or null if its
             * not found.
             */
            public static _Fields findByThriftId(int fieldId) {
                switch (fieldId) {
                case 0: // SUCCESS
                    return SUCCESS;
                default:
                    return null;
                }
            }

            /**
             * Find the _Fields constant that matches fieldId, throwing an
             * exception if it is not found.
             */
            public static _Fields findByThriftIdOrThrow(int fieldId) {
                _Fields fields = findByThriftId(fieldId);
                if (fields == null)
                    throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
                return fields;
            }

            /**
             * Find the _Fields constant that matches name, or null if its not
             * found.
             */
            public static _Fields findByName(String name) {
                return byName.get(name);
            }

            private final short _thriftId;
            private final String _fieldName;

            _Fields(short thriftId, String fieldName) {
                _thriftId = thriftId;
                _fieldName = fieldName;
            }

            public short getThriftFieldId() {
                return _thriftId;
            }

            public String getFieldName() {
                return _fieldName;
            }
        }

        // isset id assignments
        public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
        static {
            Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(
                    _Fields.class);
            tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success",
                    org.apache.thrift.TFieldRequirementType.DEFAULT,
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
            metaDataMap = Collections.unmodifiableMap(tmpMap);
            org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(getNameById_result.class, metaDataMap);
        }

        public getNameById_result() {
        }

        public getNameById_result(String success) {
            this();
            this.success = success;
        }

        /**
         * Performs a deep copy on <i>other</i>.
         */
        public getNameById_result(getNameById_result other) {
            if (other.isSetSuccess()) {
                this.success = other.success;
            }
        }

        public getNameById_result deepCopy() {
            return new getNameById_result(this);
        }

        public void clear() {
            this.success = null;
        }

        public String getSuccess() {
            return this.success;
        }

        public getNameById_result setSuccess(String success) {
            this.success = success;
            return this;
        }

        public void unsetSuccess() {
            this.success = null;
        }

        /**
         * Returns true if field success is set (has been assigned a value) and
         * false otherwise
         */
        public boolean isSetSuccess() {
            return this.success != null;
        }

        public void setSuccessIsSet(boolean value) {
            if (!value) {
                this.success = null;
            }
        }

        public void setFieldValue(_Fields field, Object value) {
            switch (field) {
            case SUCCESS:
                if (value == null) {
                    unsetSuccess();
                } else {
                    setSuccess((String) value);
                }
                break;

            }
        }

        public Object getFieldValue(_Fields field) {
            switch (field) {
            case SUCCESS:
                return getSuccess();

            }
            throw new IllegalStateException();
        }

        /**
         * Returns true if field corresponding to fieldID is set (has been
         * assigned a value) and false otherwise
         */
        public boolean isSet(_Fields field) {
            if (field == null) {
                throw new IllegalArgumentException();
            }

            switch (field) {
            case SUCCESS:
                return isSetSuccess();
            }
            throw new IllegalStateException();
        }

        public boolean equals(Object that) {
            if (that == null)
                return false;
            if (that instanceof getNameById_result)
                return this.equals((getNameById_result) that);
            return false;
        }

        public boolean equals(getNameById_result that) {
            if (that == null)
                return false;

            boolean this_present_success = true && this.isSetSuccess();
            boolean that_present_success = true && that.isSetSuccess();
            if (this_present_success || that_present_success) {
                if (!(this_present_success && that_present_success))
                    return false;
                if (!this.success.equals(that.success))
                    return false;
            }

            return true;
        }

        public int hashCode() {
            return 0;
        }

        public int compareTo(getNameById_result other) {
            if (!getClass().equals(other.getClass())) {
                return getClass().getName().compareTo(other.getClass().getName());
            }

            int lastComparison = 0;
            getNameById_result typedOther = (getNameById_result) other;

            lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(typedOther.isSetSuccess());
            if (lastComparison != 0) {
                return lastComparison;
            }
            if (isSetSuccess()) {
                lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, typedOther.success);
                if (lastComparison != 0) {
                    return lastComparison;
                }
            }
            return 0;
        }

        public _Fields fieldForId(int fieldId) {
            return _Fields.findByThriftId(fieldId);
        }

        public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
            schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
        }

        public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
            schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("getNameById_result(");
            boolean first = true;

            sb.append("success:");
            if (this.success == null) {
                sb.append("null");
            } else {
                sb.append(this.success);
            }
            first = false;
            sb.append(")");
            return sb.toString();
        }

        public void validate() throws org.apache.thrift.TException {
            // check for required fields
            // check for sub-struct validity
        }

        private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
            try {
                write(new org.apache.thrift.protocol.TCompactProtocol(
                        new org.apache.thrift.transport.TIOStreamTransport(out)));
            } catch (org.apache.thrift.TException te) {
                throw new java.io.IOException(te);
            }
        }

        private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
            try {
                read(new org.apache.thrift.protocol.TCompactProtocol(
                        new org.apache.thrift.transport.TIOStreamTransport(in)));
            } catch (org.apache.thrift.TException te) {
                throw new java.io.IOException(te);
            }
        }

        private static class getNameById_resultStandardSchemeFactory implements SchemeFactory {
            public getNameById_resultStandardScheme getScheme() {
                return new getNameById_resultStandardScheme();
            }
        }

        private static class getNameById_resultStandardScheme extends StandardScheme<getNameById_result> {

            public void read(org.apache.thrift.protocol.TProtocol iprot, getNameById_result struct)
                    throws org.apache.thrift.TException {
                org.apache.thrift.protocol.TField schemeField;
                iprot.readStructBegin();
                while (true) {
                    schemeField = iprot.readFieldBegin();
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                        break;
                    }
                    switch (schemeField.id) {
                    case 0: // SUCCESS
                        if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            struct.success = iprot.readString();
                            struct.setSuccessIsSet(true);
                        } else {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                        break;
                    default:
                        org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                    }
                    iprot.readFieldEnd();
                }
                iprot.readStructEnd();

                // check for required fields of primitive type, which can't be
                // checked in the validate method
                struct.validate();
            }

            public void write(org.apache.thrift.protocol.TProtocol oprot, getNameById_result struct)
                    throws org.apache.thrift.TException {
                struct.validate();

                oprot.writeStructBegin(STRUCT_DESC);
                if (struct.success != null) {
                    oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
                    oprot.writeString(struct.success);
                    oprot.writeFieldEnd();
                }
                oprot.writeFieldStop();
                oprot.writeStructEnd();
            }

        }

        private static class getNameById_resultTupleSchemeFactory implements SchemeFactory {
            public getNameById_resultTupleScheme getScheme() {
                return new getNameById_resultTupleScheme();
            }
        }

        private static class getNameById_resultTupleScheme extends TupleScheme<getNameById_result> {

            public void write(org.apache.thrift.protocol.TProtocol prot, getNameById_result struct)
                    throws org.apache.thrift.TException {
                TTupleProtocol oprot = (TTupleProtocol) prot;
                BitSet optionals = new BitSet();
                if (struct.isSetSuccess()) {
                    optionals.set(0);
                }
                oprot.writeBitSet(optionals, 1);
                if (struct.isSetSuccess()) {
                    oprot.writeString(struct.success);
                }
            }

            public void read(org.apache.thrift.protocol.TProtocol prot, getNameById_result struct)
                    throws org.apache.thrift.TException {
                TTupleProtocol iprot = (TTupleProtocol) prot;
                BitSet incoming = iprot.readBitSet(1);
                if (incoming.get(0)) {
                    struct.success = iprot.readString();
                    struct.setSuccessIsSet(true);
                }
            }
        }

    }

}
