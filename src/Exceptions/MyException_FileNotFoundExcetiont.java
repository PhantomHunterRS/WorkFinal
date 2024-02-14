package Exceptions;

import java.io.IOException;

public class MyException_FileNotFoundExcetiont extends IOException {
    public MyException_FileNotFoundExcetiont(String e){
        super(e);
    }
    public MyException_FileNotFoundExcetiont(){
        super("File not exist");
    }
}
