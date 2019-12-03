package com.duplicate;


import com.duplicate.operations_file.Operation;
import com.duplicate.operations_file.OperationHolder;
import com.duplicate.operations_file.Operations;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        CollisionSHA collisionSHA = new CollisionSHA(args[0]);
        collisionSHA.diplay();
        char action = scanner.next().charAt(0);
        Operations operations = new OperationHolder(new Operation(action)).initialize();
        operations.performOperation();

    }
}
