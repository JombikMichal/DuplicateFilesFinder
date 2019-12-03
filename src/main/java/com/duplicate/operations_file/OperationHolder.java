package com.duplicate.operations_file;

public class OperationHolder {

    private Operation operation;

    public OperationHolder(Operation operation) {
        this.operation = operation;
        initialize();
    }

    public Operations initialize() {
        switch (operation.getAction()) {
            case '0':
                return new Ignore();
            case '1':
                return new Delete();
            case '2':
                return new CreateSoftLink();
            case '3':
                return new CreateHardLink();
            default:
                throw new IllegalArgumentException("Unsupported operation");
        }
    }
}
