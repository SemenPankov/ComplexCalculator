package org.example.Interface;

public interface iCalculable {
    iCalculable complexSum(int real, int imaginary);

    iCalculable complexMulti(int real, int imaginary);

    iCalculable complexDivision(int real, int imaginary);

    int getRealPart();

    int getImaginaryPart();

    String getResult();
}
